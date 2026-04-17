package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.List;

public class ProductBasket {
    //Поменяйте используемую структуру данных в классе ProductBasket с массива на список
    //Учитывайте, что мы не обращаемся к элементам корзины по индексам, а только добавляем и удаляем элементы, не используя их индексы.
    private final List<Product> basket;//прямой доступ к этому массиву должен быть невозможен.

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    //Без кода, который выводит сообщение “Невозможно добавить продукт” и не использует индекс.
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Невозможно добавить null в корзину");
        }
        basket.add(product);
    }

    //Теперь добавьте метод, который по переданному имени продукта удаляет все продукты с таким именем из корзины:
    //Метод должен принимать строку name и возвращать список (List) удаленных продуктов, и метод не использует индекс.
    //Если продукта нет в корзине, то возвращаемый список должен быть пустым.
    public List<Product> deleteProductByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        List<Product> deletedProducts = new LinkedList<>();
        for (Iterator<Product> iterator = basket.iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int calculateTotalPrice() {
        int total = 0;
        for (Product product : basket) {
            total += product.getPrice();
        }
        return total;
    }

    //Количество специальных товаров, подсчет идет через выделенный метод
    public int calculateSpecialProducts() {
        int total = 0;
        for (Product product : basket) {
            if (product.isSpecial()) {
                total += 1;
            }
        }
        return total;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");//Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
            return;
        }
        for (Product product : basket) {
            System.out.println(product);//Все товары выводятся через toString()
        }
        System.out.println("Итого: " + calculateTotalPrice());
        System.out.println("Специальных товаров: " + calculateSpecialProducts());
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
        for (Product product : basket) {
            if (product.getName().equalsIgnoreCase(nameForSearch)) {
                return true;
            }
        }
        return false;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив. Теперь null не проставляет, так как не допускает null в списке
    public void cleanBasket() {
        basket.clear();
    }
}
