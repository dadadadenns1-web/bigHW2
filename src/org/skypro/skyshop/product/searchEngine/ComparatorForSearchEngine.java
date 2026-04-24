package org.skypro.skyshop.product.searchEngine;

import java.util.Comparator;

//Код компаратора описан в отдельном классе или передан лямбдой. Результаты сортируются в соответствии с заданием
public class ComparatorForSearchEngine implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        //Статьи в результатах поиска должны выводиться, начиная от статьи с самым длинным именем и заканчивая статьей с самым коротким именем.
        String o1Name = o1.getName().toLowerCase();
        String o2Name = o2.getName().toLowerCase();
        int nameLengthDiff = Integer.compare(o2Name.length(), o1Name.length());
        if(nameLengthDiff == 0){//Если значение, которое вернул Integer.compare == 0, тогда нужно сравнивать имена, используя методы compareTo.
            return o1Name.compareTo(o2Name);
        }
        return nameLengthDiff;
    }
}
