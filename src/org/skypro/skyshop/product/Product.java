package org.skypro.skyshop.product;

import org.skypro.skyshop.product.searchEngine.Searchable;

//Класс Product станет новым корнем иерархии, от него будем наследовать специфические классы товаров.
//Product объявлен как abstract
public abstract class Product implements Searchable {

    private final String name;
    //В классе Product нет поля price

    //В конструкторе класса Product реализуйте проверку. Название продукта не может быть пустой строкой или null
    public Product(String name) {
        if(name == null || name.isBlank()){//Использовано условие name == null || name.isBlank()
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");//выброшено IllegalArgumentException
        }
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
