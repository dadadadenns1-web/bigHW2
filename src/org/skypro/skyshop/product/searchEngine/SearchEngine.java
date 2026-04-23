package org.skypro.skyshop.product.searchEngine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;//массив всех элементов, по которым можно искать.
    //final по совету компилятора

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    //В классе SearchEngine поменяйте структуру данных с массива на список.
    //Измените метод поиска: он должен возвращать *все* подходящие результаты (а не 5 результатов, как раньше).
    //В классе поискового движка вам нужно модифицировать метод поиска таким образом, чтобы он возвращал отсортированную по именам мапу:
    //с ключом — именем Searchable-объекта и значением — самим Searchable-объектом.
    public Map<String,Searchable> search(String stringForSearch) {
        if (stringForSearch == null) {
            throw new IllegalArgumentException("Невозможно найти по null строке");
        }
        stringForSearch = stringForSearch.toLowerCase();

        Map<String,Searchable> result = new TreeMap<>();  //Метод возвращает TreeMap, где каждый ключ соответствует уникальному имени объекта
        for (Searchable searchable : searchables) {
            //брать у каждого элемента SearchTerm и искать по нему, используя встроенный метод строки contains
            if (searchable.getSearchTerm().toLowerCase().contains(stringForSearch)) {
                result.put(searchable.getName(),searchable);
            }
        }
        return result;
    }

    //Метод add() — добавляет новый объект типа Searchable в массив поискового движка.
    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Невозможно добавить null в список объекта SearchEngine");
        }
        searchables.add(searchable);
    }

    //Реализуйте в классе SearchEngine метод, который находит среди объектов Searchable наиболее подходящий к поисковой строке и возвращает его.
    //Метод должен принимать строку search, а возвращать объект Searchable
    public Searchable getSearchableWithMaxRepetitionOf(String search) throws BestResultNotFound {
        if (search == null) {
            throw new IllegalArgumentException("Невозможно найти по null строке");
        }
        if (search.isBlank()) {
            throw new BestResultNotFound("Поисковый запрос состоит из пробелов или пуст");
        }
        String subString = search.toLowerCase();
        int maxSubstringRepeatCounter = 0;//Максимальное количество повторений
        Searchable theBestResult = null;
        for (Searchable searchable : searchables) {
            String searchableTerm = searchable.getSearchTerm().toLowerCase();
            int subStringRepeatCounter = 0;
            int foundIndex = searchableTerm.indexOf(subString);
            while (foundIndex != -1) {
                subStringRepeatCounter++;
                int nextSearchIndex = foundIndex + subString.length();
                foundIndex = searchableTerm.indexOf(subString, nextSearchIndex);
            }
            if (subStringRepeatCounter > maxSubstringRepeatCounter) {
                theBestResult = searchable;
                maxSubstringRepeatCounter = subStringRepeatCounter;
            }
        }
        if (theBestResult == null) {
            throw new BestResultNotFound("По запросу <<" + search + ">> не нашлось наиболее подходящей статьи");//сообщение включает переданный search
        }
        return theBestResult;
    }
}
