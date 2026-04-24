package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.searchEngine.Searchable;

import java.util.Objects;

//Объектная модель статьи о товарах.
//Для этого создайте класс Article
//который будет не модифицируемым, как и класс товара, и будет содержать такой набор полей:
public final class Article implements Searchable {
    private final String title;//название статьи в виде строки
    private final String text;//текст статьи в виде строки

    public Article(String title, String text) {
        if (title == null || text == null) {
            throw new IllegalArgumentException("Заголовок или текст не может быть null");
        }
        if (title.isBlank() || text.isBlank()) {
            throw new IllegalArgumentException("Заголовок или текст не может быть пустым или состоять из пробелов");
        }
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

    //написать реализацию методов equals и hashCode для классов, которые добавляются в SearchEngine — абстрактного класса Product и класса Article.
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Article)){
            return false;
        }
        return Objects.equals(getName().toLowerCase(),((Article) obj).getName().toLowerCase());//через Objects.equals(name1, name2)
    }
    @Override
    public int hashCode() {
        return getName().toLowerCase().hashCode();
    }

}
