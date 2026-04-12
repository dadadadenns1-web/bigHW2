package org.skypro.skyshop.product;

public class Product {
    //Поля name и price объявлены как private final
    private final String name;
    private final int price;

    //Конструктор с параметрами в классе Product принимает name и price и инициализирует поля
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Геттеры есть, сеттеры отсутствуют
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }


}
