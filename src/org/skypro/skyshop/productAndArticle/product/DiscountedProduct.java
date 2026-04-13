package org.skypro.skyshop.productAndArticle.product;

// сделайте класс товара со скидкой DiscountedProduct Этот класс нужно унаследовать от Product.
public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountInPercentage; //Скидка может быть только положительным целым числом от 0 до 100.
    //Проверку на это не нужно делать, достаточно просто учитывать при написании методов.

    public DiscountedProduct(String name, int basePrice, int discountInPercentage) {
        super(name);
        this.basePrice = basePrice;
        this.discountInPercentage = discountInPercentage;
    }

    //Переопределите метод getPrice так, чтобы он учитывал скидку, которую вы применили к товару.
    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountInPercentage) / 100;
    }


    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountInPercentage + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    //Сеттеры чтоб компилятор не жаловался на отсутствие final. По идее должны быть изменяемы
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
    public void setDiscountInPercentage(int discountInPercentage) {
        this.discountInPercentage = discountInPercentage;
    }
}



