package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

//В классах корзины вам нужно заменить циклы на StreamAPI

public class ProductBasket {
    //Поменяйте используемую структуру данных в классе ProductBasket с массива на список
    //Учитывайте, что мы не обращаемся к элементам корзины по индексам, а только добавляем и удаляем элементы, не используя их индексы.
    private final Map<String, List<Product>> basket;//прямой доступ к этому массиву должен быть невозможен.

    public ProductBasket() {
        basket = new HashMap<>();
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    //Без кода, который выводит сообщение “Невозможно добавить продукт” и не использует индекс.
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Невозможно добавить null в корзину");
        }
        basket.computeIfAbsent(product.getName().toLowerCase(), k -> new LinkedList<>()).add(product);//ключ приводится к lowerCase, в случае отсутствия список создается через computeIfAbsent
    }

    //Теперь добавьте метод, который по переданному имени продукта удаляет все продукты с таким именем из корзины:
    //Метод должен принимать строку name и возвращать список (List) удаленных продуктов, и метод не использует индекс.
    //Если продукта нет в корзине, то возвращаемый список должен быть пустым.
    public List<Product> deleteProductsByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        List<Product> deletedProducts = basket.remove(name.toLowerCase());//При удалении продукта из корзины происходит вызов метода remove по ключу
        if (deletedProducts == null) {
            deletedProducts = new LinkedList<>();
        }
        return deletedProducts;
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int calculateTotalPrice() {
        return basket.values().stream()
                .flatMap(List::stream)//Используется flatMap для преобразования потока.
                .mapToInt(Product::getPrice)// Для подсчета суммы используется mapToInt и sum
                .sum();
    }

    //Количество специальных товаров, подсчет идет через выделенный метод
    //Подсчет выделен в метод: private long getSpecialCount() { return ...filter(...).count(); }
    private long getSpecialCount() {
        return basket.values().stream()
                .flatMap(list -> list.stream().filter(Product::isSpecial))
                .count();
    }


    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");//Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
            return;
        }//Вывод корзины реализован через flatMap и forEach, циклы отсутствуют
        basket.values().stream().flatMap(List::stream).forEach(System.out::println);

        System.out.println("Итого: " + calculateTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }
    //КАК ДОЛЖНО ВЫВОДИТЬСЯ
    //<имя продукта>: <стоимость>
    //<имя продукта со скидкой>: <стоимость> (<скидка>%)
    //<имя продукта с фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
    //Итого: <общая стоимость корзины>
    //Специальных товаров: <Количество специальных товаров>


    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени
    //и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean findProduct(String nameForSearch) {
        if (nameForSearch == null) {
            throw new IllegalArgumentException("Имя находимого продукта не может быть null");
        }
        return basket.get(nameForSearch.toLowerCase()) != null;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив. Теперь null не проставляет, так как не допускает null в списке
    public void cleanBasket() {
        basket.clear();
    }
}
