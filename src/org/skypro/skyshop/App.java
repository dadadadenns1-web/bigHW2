package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        //Создание продуктов
        Product productOne = new SimpleProduct("Кресло",5000);
        Product productTwo = new DiscountedProduct("Диван",10000,20);
        Product productThree = new DiscountedProduct("Стол",8000,50);
        Product productFour = new FixPriceProduct("Табурет");
        Product productFive = new SimpleProduct("Матрас",15000);
        Product productSix = new SimpleProduct("Подушка",3000);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(productOne);//Добавление продукта в корзину
        basket.addProduct(productTwo);
        basket.addProduct(productThree);
        basket.addProduct(productFour);
        basket.addProduct(productFive);
        basket.addProduct(productSix);//Добавление продукта в заполненную корзину, в которой нет свободного места

        ProductBasket basketTwo = new ProductBasket();//Для демонстрации классов можно создать несколько корзин.
        basketTwo.addProduct(productSix);
        basketTwo.addProduct(productFour);
        basketTwo.addProduct(productTwo);
        basketTwo.printProducts();//Печать содержимого корзины с несколькими товарами.
        int totalPrice = basketTwo.calculateTotalPrice();//Получение стоимости корзины с несколькими товарами.
        System.out.println("totalPrice = " + totalPrice);
        System.out.println(basketTwo.findProduct("Подушка"));//Поиск товара, который есть в корзине.
        System.out.println(basketTwo.findProduct("Матрас"));//Поиск товара, которого нет в корзине.


        basket.cleanBasket();//Очистка корзины.
        basket.printProducts();//Печать содержимого пустой корзины.
        totalPrice = basket.calculateTotalPrice();//Получение стоимости пустой корзины.
        System.out.println("totalPrice = " + totalPrice);
        System.out.println(basket.findProduct("Подушка"));//Поиск товара по имени в пустой корзине.
    }
}
