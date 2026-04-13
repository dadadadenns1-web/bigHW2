package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

//Класс Product станет новым корнем иерархии, от него будем наследовать специфические классы товаров.
//Product объявлен как abstract
public abstract class Product implements Searchable {

    private final String name;
    //В классе Product нет поля price

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

    //В классе товаров нужно имплементировать интерфейс Searchable в родительском классе товаров
    // и в качестве search term — «возвращать имя товара», а в качестве типа — возвращать строку PRODUCT.
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContent() {
        return "PRODUCT";
    }
}
