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

import java.util.List;

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
        for (Product product : productList) {//Добавление продукта в корзину
            basket.addProduct(product);
        }//Добавление продукта в заполненную корзину, в которой нет свободного места


        ProductBasket basketTwo = new ProductBasket();//Для демонстрации классов можно создать несколько корзин.
        basketTwo.addProduct(productList[5]);
        basketTwo.addProduct(productList[3]);
        basketTwo.addProduct(productList[1]);

        System.out.println("Проверка простых методов корзины");
        System.out.println("Печать содержимого с несколькими товарами");
        basketTwo.printBasket();//Печать содержимого корзины с несколькими товарами.
        printLittleSeparator();


        System.out.println("Получение стоимости корзины");
        int totalPrice = basketTwo.calculateTotalPrice();//Получение стоимости корзины с несколькими товарами.
        System.out.println("totalPrice = " + totalPrice);
        printLittleSeparator();


        System.out.println("Поиск товара findProduct true/false");
        System.out.println(basketTwo.findProduct("Подушка"));//Поиск товара, который есть в корзине.
        System.out.println(basketTwo.findProduct("Матрас"));//Поиск товара, которого нет в корзине.
        printLittleSeparator();


        basket.cleanBasket();//Очистка корзины.
        System.out.println("Печать содержимого пустой корзины");
        basket.printBasket();//Печать содержимого пустой корзины.
        printLittleSeparator();


        System.out.println("Получение стоимости пустой корзины");
        totalPrice = basket.calculateTotalPrice();//Получение стоимости пустой корзины.
        System.out.println("totalPrice = " + totalPrice);
        printLittleSeparator();


        System.out.println("Поиск товара в пустой корзине");
        System.out.println(basket.findProduct("Подушка"));//Поиск товара по имени в пустой корзине.
        printSeparator();


        //Создайте один объект типа SearchEngine и добавьте в него все товары, которые создаются для проверки других методов.
        SearchEngine searchList = new SearchEngine();

        //Создайте несколько объектов типа Article и добавьте их в Search Engine.
        Article[] articleList = {
                new Article("Твердотельный накопитель", "Твердотельный накопитель (англ. solid-state drive, SSD)" +
                        " — компьютерное энергонезависимое не механическое запоминающее устройство на основе микросхем памяти," +
                        " альтернатива жёстким дискам (HDD). Наиболее распространённый вид твердотельных накопителей использует" +
                        " для хранения данных флеш-память типа NAND, однако существуют варианты, в которых накопитель создаётся" +
                        " на базе DRAM-памяти, снабжённой дополнительным источником питания — аккумулятором[1]. Помимо собственно" +
                        " микросхем памяти, подобный накопитель содержит управляющую микросхему — контроллер."),
                new Article("Телефон", "Телефо́н (от др.-греч. τῆλε «далеко» + φωνή «голос», «звук») — аппарат," +
                        " имеющий трубку и сигнальное устройство для вызова[1], предназначенный для передачи речи с" +
                        " помощью электрических сигналов. Термин «телефон» используется как для обозначения такого" +
                        " аппарата, так и в качестве названия вида электросвязи[2]."),
                new Article("Микрофон", "Микрофо́н (от греч. μικρός — маленький, φωνη — голос) — электроакустический прибор," +
                        " преобразующий звуковые колебания в электрический сигнал."),
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

        System.out.println("Часть с проверкой search в листе с searchable");
        printSearch("ст", searchList);
        printLittleSeparator();
        printSearch("а", searchList);
        printLittleSeparator();
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
        System.out.println("Часть с проверкой setBasePrice, setDiscountInPercentage");
        basket.printBasket();
        printSeparator();
        //ДЕЙСТВИЯ ДЛЯ КОМПИЛЯЦИЙ БЕЗ WARNING is never used.


        //Проверка exception
        //В качестве обработки можно просто выводить сообщение из исключения.
        //Создайте несколько продуктов и нарочно заполните их поля неправильно.
        //Затем обработайте IllegalArgumentException в блоках try и catch.
        System.out.println("Часть с проверкой конструкторов продуктов на неверные цены");
        try {
            Product productExc1 = new DiscountedProduct("Компьютерная мышка", 2500, 10);
            System.out.println(productExc1.getName() + " - товар со скидкой создан");
            Product productExc2 = new DiscountedProduct("Клавиатура", -5000, 20);
            System.out.println(productExc2.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printLittleSeparator();
        try {
            Product productExc3 = new DiscountedProduct("Телефон", 50000, -50);
            System.out.println(productExc3.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printLittleSeparator();
        try {
            Product productExc4 = new SimpleProduct("         ", 10000);
            System.out.println(productExc4.getName() + " - товар со скидкой создан");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        printSeparator();


        //Поиск наиболее повторяющегося фрагмента текста
        //Текст компьютерной клавиатуры содержит 5 повторений по, текст про мебель - 2 повторений по
        System.out.println("Часть с поиском повторяющегося фрагмента текста в листе с searchable");
        try {
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"по\") = " + searchList.getSearchableWithMaxRepetitionOf("по").getSearchTerm());
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        printLittleSeparator();
        //Поиск несуществующего фрагмента текста
        try {
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"вапвап\") = " + searchList.getSearchableWithMaxRepetitionOf("вапвап").getSearchTerm());
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        printLittleSeparator();
        //Поиск с пустой строкой
        try {
            System.out.println("searchList.getSearchableWithMaxRepetitionOf(\"   \") = " + searchList.getSearchableWithMaxRepetitionOf("   ").getSearchTerm());
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        printSeparator();


        //Тест удаления продуктов
        System.out.println("Часть с удалением продуктов");
        basket.printBasket();
        printLittleSeparator();

        deleteAndPrintProduct("диван", basket);//Удалить существующий продукт из корзины.
        basket.printBasket();//Вывести содержимое корзины с помощью метода printBasket.
        printLittleSeparator();

        deleteAndPrintProduct("телефон", basket);//Удалить несуществующий продукт.
        basket.printBasket();//Вывести содержимое корзины на экран.
        printLittleSeparator();

        System.out.println("Теперь добавим 3 стола");
        basket.addProduct(productList[2]);
        basket.addProduct(productList[2]);
        basket.addProduct(productList[2]);
        basket.printBasket();
        printLittleSeparator();

        deleteAndPrintProduct("стол", basket);
        basket.printBasket();
        printSeparator();

    }


    public static void deleteAndPrintProduct(String name, ProductBasket basket) {
        List<Product> deletedProducts = basket.deleteProductByName(name);
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");//Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.
        } else {
            System.out.println("deletedProducts = " + deletedProducts);//Вывести удаленные продукты на экран.
        }
    }

    public static void printLittleSeparator() {
        System.out.println("----------");
    }

    public static void printSeparator() {
        System.out.println("============================================================================================================================================");
    }

    public static void printSearch(String stringForSearch, SearchEngine searchList) {
        System.out.println("<<Использование метода search с параметром \"" + stringForSearch + "\">>");
        List<Searchable> resultsOfSearch = searchList.search(stringForSearch);
        boolean resultExist = false;
        for (Searchable result : resultsOfSearch) {
            if (result != null) {
                System.out.println("----------");
                result.printStringRepresentation();
                resultExist = true;
            }
        }
        if (!resultExist) {
            System.out.println("Ничего не найдено");
        }
    }
}
