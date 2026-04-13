package org.skypro.skyshop.productAndArticle.searchEngine;

public class SearchEngine {
private final Searchable[] searchables;//массив всех элементов, по которым можно искать.
    //final по совету компилятора

public SearchEngine(int size){//Размерность массива нужно передавать через конструктор класса
    searchables = new Searchable[size];
}

//Метод search — принимает в себя строку для поиска.
//Возвращает результат поиска по массиву Searchable в виде массива из 5 элементов.
    public Searchable[] search(String stringForSearch){
    stringForSearch = stringForSearch.toLowerCase();
    final int resultSize = 5;
    Searchable[] result = new Searchable[resultSize];
    int counter = 0;
    //Чтобы реализовать поиск по массиву Searchable, нужно перебрать весь массив:
    for (Searchable searchable:searchables){
        if(searchable == null){
            continue;
        }
        //брать у каждого элемента SearchTerm и искать по нему, используя встроенный метод строки contains
        if(searchable.getSearchTerm().toLowerCase().contains(stringForSearch)){
            result[counter++] = searchable;
            if(counter == resultSize){//нужно прерывать цикл поиска с помощью break
                break;
            }
        }
    }
    return result;//возвращает 5 результатов или 5 null, если не найдены
    }

    //Метод add() — добавляет новый объект типа Searchable в массив поискового движка.
    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null) {
                continue;//Добавляет продукт в первую свободную ячейку
            }
            searchables[i] = searchable;
            return;
        }
        System.out.println("Невозможно добавить в массив");
    }
}
