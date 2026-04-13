package org.skypro.skyshop.article;

import org.skypro.skyshop.searchEngine.Searchable;

//Объектная модель статьи о товарах.
//Для этого создайте класс Article
//который будет не модифицируемым, как и класс товара, и будет содержать такой набор полей:
public class Article implements Searchable {
    private final String title;//название статьи в виде строки
    private final String text;//текст статьи в виде строки

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getName() {
        return title;
    }

    //Добавьте в класс метод toString который будет преобразовывать статью в строку такого вида:
    //Название статьи
    //Текст статьи
    @Override
    public String toString() {
        return title + "\n" + text;
    }

    //В классе статей нужно имплементировать интерфейс Searchable
    //search term нужно вернуть строку, состоящую из названия и текста статьи. Можно просто возвращать строку из toString
    @Override
    public String getSearchTerm() {
        return toString();
    }

    //в качестве типа возвращаем строку ARTICLE.
    @Override
    public String getContent() {
        return "ARTICLE";
    }


}
