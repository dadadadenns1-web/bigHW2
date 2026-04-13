package org.skypro.skyshop.basket;

import org.skypro.skyshop.productAndArticle.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket;//прямой доступ к этому массиву должен быть невозможен.

    public ProductBasket() {
        basket = new Product[5];//В качестве хранилища для объектов product используйте массив из пяти элементов
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                continue;//Добавляет продукт в первую свободную ячейку
            }
            basket[i] = product;
            return;
        }
        System.out.println("Невозможно добавить продукт");
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int calculateTotalPrice() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    //Количество специальных товаров, подсчет идет через выделенный метод
    public int calculateSpecialProducts() {
        int total = 0;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            if (product.isSpecial()) {
                total += 1;
            }
        }
        return total;
    }

    public void printProducts() {
        boolean productsExist = false;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            productsExist = true;
            System.out.println(product);//Все товары выводятся через toString()
        }
        if (productsExist) {
            System.out.println("Итого: " + calculateTotalPrice());
            System.out.println("Специальных товаров: " + calculateSpecialProducts());
        } else {
            System.out.println("в корзине пусто");//Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
        }
        //КАК ДОЛЖНО ВЫВОДИТЬСЯ
        //<имя продукта>: <стоимость>
        //<имя продукта со скидкой>: <стоимость> (<скидка>%)
        //<имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
        //Итого: <общая стоимость корзины>
        //Специальных товаров: <Количество специальных товаров>
    }


    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени
    //и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean findProduct(String nameForSearch) {
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            if (product.getName().equalsIgnoreCase(nameForSearch)) {
                return true;
            }
        }
        return false;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null.
    public void cleanBasket() {
        Arrays.fill(basket, null);
    }
}
