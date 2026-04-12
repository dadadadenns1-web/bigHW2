package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] basket;//прямой доступ к этому массиву должен быть невозможен.

    public ProductBasket() {
        basket = new Product[5];//В качестве хранилища для объектов product используйте массив из пяти элементов
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает
    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                continue;//Добавляет продукт в первую свободную ячейку
            }
            basket[i] = product;//
            return;
        }
        System.out.println("Невозможно добавить продукт");
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int calculateTotalPrice() {
        int total = 0;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            total += product.getPrice();
        }
        return total;
    }

    //Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    public void printProducts() {
        boolean productsExist = false;
        for (Product product : basket) {
            if (product == null) {
                continue;
            }
            productsExist = true;
            System.out.println(product.getName() + ": " + product.getPrice());
        }
        if (productsExist) {
            System.out.println("Итого: " + calculateTotalPrice());
        } else {
            System.out.println("в корзине пусто");//Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».
        }
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
    public void cleanBasket(){
        Arrays.fill(basket, null);
    }
}
