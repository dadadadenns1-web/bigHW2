package org.skypro.skyshop.product.searchEngine;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    //нужно применить Set
    private final Set<Searchable> searchables;//массив всех элементов, по которым можно искать.
    //final по совету компилятора

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    //Метод search не должен использовать циклы — перепишите его одним стримом
    // с использованием промежуточной операции filter и терминальной операции collect.
    public Set<Searchable> search(String stringForSearch) {
        if (stringForSearch == null || stringForSearch.isBlank()) {
            throw new IllegalArgumentException("Невозможно найти по null строке или пустой строке");
        }
        final String finalStringForSearch = stringForSearch.toLowerCase(Locale.ROOT);
        return searchables.stream() //На этот раз будем выдавать отсортированный Set из Searchable-элементов.
                .filter(m -> m.getSearchTerm().toLowerCase(Locale.ROOT).contains(finalStringForSearch))
                .collect(Collectors.toCollection(() -> new TreeSet<Searchable>(new ComparatorForSearchEngine())));//Использован Collectors.toCollection(() → new TreeSet<>(компаратор))
        //Метод search реализован одним стримом с filter и collect, циклы отсутствуют
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
