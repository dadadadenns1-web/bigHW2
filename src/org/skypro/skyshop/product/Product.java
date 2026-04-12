package org.skypro.skyshop.product;

//Класс Product станет новым корнем иерархии, от него будем наследовать специфические классы товаров.
//Product объявлен как abstract
public abstract class Product {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //метод getPrice() должен стать абстрактным.
    public abstract int getPrice();

    // В этом задании нельзя использовать оператор instanceof или другие методы, которые определяют класс товара.
    // Используйте переопределение методов или вводите новые методы.
    public abstract boolean isSpecial();

}
