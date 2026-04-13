package org.skypro.skyshop.productAndArticle.searchEngine;

public interface Searchable {

    //Метод получения термина поиска. Возвращает текст, по которому будет поиск.
    String getSearchTerm();
    //Метод получения типа контента, который мы нашли. Метод должен возвращать строку с названием типа контента.
    String getContent();
    //Метод получения имени Searchable объекта.
    String getName();

    //Метод преобразования Searchable объекта в строку.
    //toString мы используем для вывода товаров в корзине.
    //Стоит сделать этот метод интерфейса default и добавить реализацию, которая будет выводить строку вида:
    //«имя Searchable-объекта — тип Searchable-объекта».
    default void getStringRepresentation(){
        System.out.println(getName()+" - "+getContent());
    }

}
