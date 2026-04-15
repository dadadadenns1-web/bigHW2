package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.searchEngine.BestResultNotFound;
import org.skypro.skyshop.product.searchEngine.SearchEngine;
import org.skypro.skyshop.product.searchEngine.Searchable;

public class App {
    public static void main(String[] args) {
        //Создание продуктов.
        //Создайте в методе main несколько товаров специальных типов вместо SimpleProduct
        DiscountedProduct discounted = new DiscountedProduct("Диван", 10000, 20);
        SimpleProduct simpleProduct = new SimpleProduct("Кресло", 5000);
        Product[] productList = {
                simpleProduct,
                discounted,
                new DiscountedProduct("Стол", 8000, 50),
                new FixPriceProduct("Табурет"),
                new SimpleProduct("Матрас", 15000),
                new SimpleProduct("Подушка", 3000),
        };
        ProductBasket basket = new ProductBasket();
        System.out.println("Добавление продуктов в корзину:");
        for (Product product : productList) {//Добавление продукта в корзину
            basket.addProduct(product);
        }//Добавление продукта в заполненную корзину, в которой нет свободного места
        printSeparator();


        ProductBasket basketTwo = new ProductBasket();//Для демонстрации классов можно создать несколько корзин.
        basketTwo.addProduct(productList[5]);
        basketTwo.addProduct(productList[3]);
        basketTwo.addProduct(productList[1]);

        System.out.println("Печать содержимого с несколькими товарами");
        basketTwo.printProducts();//Печать содержимого корзины с несколькими товарами.
        printSeparator();


        System.out.println("Получение стоимости корзины");
        int totalPrice = basketTwo.calculateTotalPrice();//Получение стоимости корзины с несколькими товарами.
        System.out.println("totalPrice = " + totalPrice);
        printSeparator();


        System.out.println("Поиск товара findProduct true/false");
        System.out.println(basketTwo.findProduct("Подушка"));//Поиск товара, который есть в корзине.
        System.out.println(basketTwo.findProduct("Матрас"));//Поиск товара, которого нет в корзине.
        printSeparator();


        basket.cleanBasket();//Очистка корзины.
        System.out.println("Печать содержимого пустой корзины");
        basket.printProducts();//Печать содержимого пустой корзины.
        printSeparator();


        System.out.println("Получение стоимости пустой корзины");
        totalPrice = basket.calculateTotalPrice();//Получение стоимости пустой корзины.
        System.out.println("totalPrice = " + totalPrice);
        printSeparator();


        System.out.println("Поиск товара в пустой корзине");
        System.out.println(basket.findProduct("Подушка"));//Поиск товара по имени в пустой корзине.
        printSeparator();


        //Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
        SearchEngine searchList = new SearchEngine(15);

        //Создайте несколько объектов типа Article и добавьте их в Search Engine.
        Article[] articleList = {
                new Article("Title", "Text"),
                new Article("Второй заголовок", "Текст второго заголовка"),
                new Article("Компьютерная клавиатура", "Компью́терная клавиату́ра — устройство ввода информации," +
                        " представляющее собой набор клавиш (кнопок), расположенных в определённом порядке. " +
                        "Может быть как отдельным устройством, подключаемым по интерфейсу USB или PS/2, так и встроенной" +
                        " (например, в ноутбук или терминал). Бывает совмещена в одно устройство с тачпадом," +
                        " тензометрическим джойстиком или трекболом."),
                new Article("Мебель", "Ме́бель (фр. meuble, от лат. mobile — движимый, подвижный)" +
                        " — совокупность передвижных или встроенных изделий для обстановки жилых и" +
                        " общественных помещений и различных зон пребывания человека[1].")
        };
        for (Article article : articleList) {
            searchList.add(article);
        }
        //Добавление не включенное в условие, но предусмотренное для класса Product
        for (Product product : productList) {
            searchList.add(product);
        }

        printSearch("ст", searchList);
        printSeparator();
        printSearch("", searchList);
        printSeparator();
        printSearch("абвгд", searchList);
        printSeparator();


        //Проверка toString у класса Article
        System.out.println("Проверка toString у класса Article");
        System.out.println(articleList[2]);
        printSeparator();


        //ДЕЙСТВИЯ ДЛЯ КОМПИЛЯЦИЙ БЕЗ WARNING is never used
        basket.addProduct(discounted);
        basket.addProduct(simpleProduct);
        discounted.setBasePrice(20000);
        discounted.setDiscountInPercentage(50);
        simpleProduct.setPrice(6000);
        System.out.println("Проверка изменений");
        basket.printProducts();
        printSeparator();
        //ДЕЙСТВИЯ ДЛЯ КОМПИЛЯЦИЙ БЕЗ WARNING is never used.


        //Проверка exception
        //В качестве обработки можно просто выводить сообщение из исключения.
        //Создайте несколько продуктов и нарочно заполните их поля неправильно.
        //Затем обработайте IllegalArgumentException в блоках try и catch.
        try {
            Product productExc1 = new DiscountedProduct("Компьютерная мышка", 2500, 10);
            System.out.println(productExc1.getName() + " - товар со скидкой создан");
            Product productExc2 = new DiscountedProduct("Клавиатура", -5000, 20);
            System.out.println(productExc2.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printSeparator();

        try {
            Product productExc3 = new DiscountedProduct("Телефон", 50000, -50);
            System.out.println(productExc3.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printSeparator();

        try {
            Product productExc4 = new SimpleProduct("         ", 10000);
            System.out.println(productExc4.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printSeparator();


        //Поиск наиболее повторяющегося фрагмента текста
        //Текст компьютерной клавиатуры содержит 5 повторений по, текст про мебель - 2 повторений по
        try {
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"по\") = " + searchList.getSearchableWithMaxRepetitionOf("по").getSearchTerm());
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        printSeparator();

        //Поиск несуществующего фрагмента текста
        try {
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"вапвап\") = " + searchList.getSearchableWithMaxRepetitionOf("вапвап").getSearchTerm());
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        printSeparator();

        //Поиск с пустой строкой
        try{
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"   \") = " + searchList.getSearchableWithMaxRepetitionOf("   ").getSearchTerm());
        }catch(BestResultNotFound b){
            System.out.println(b.getMessage());
        }
        printSeparator();
    }






        public static void printSeparator(){
            System.out.println("==========");
        }

        public static void printSearch (String stringForSearch, SearchEngine searchList) {
            System.out.println("Использование метода search с параметром \"" + stringForSearch + "\"");
            Searchable[] resultsOfSearch = searchList.search(stringForSearch);
            boolean resultExist = false;
            for (Searchable result : resultsOfSearch) {
                if (result != null) {
                    System.out.println("----------");
                    result.getStringRepresentation();
                    resultExist = true;
                }
            }
            if (!resultExist) {
                System.out.println("Ничего не найдено");
            }
        }
    }
