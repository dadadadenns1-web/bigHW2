package org.skypro.skyshop.product;

// сделайте класс товара со скидкой DiscountedProduct Этот класс нужно унаследовать от Product.
public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountInPercentage; //Скидка может быть только положительным целым числом от 0 до 100.
    //Проверку на это не нужно делать, достаточно просто учитывать при написании методов.

    // Правила для базовой цены — такие же, как для цены в классе SimpleProduct
    //Правила для процента скидки — процент должен быть числом в диапазоне от 0 до 100 включительно
    public DiscountedProduct(String name, int basePrice, int discountInPercentage) {
        super(name);
        setBasePrice(basePrice);
        setDiscountInPercentage(discountInPercentage);//Проверка basePrice <= 0 и (discount < 0 || discount > 100)
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
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");//выброшено IllegalArgumentException
        }
        this.basePrice = basePrice;
    }

    public void setDiscountInPercentage(int discountInPercentage) {
        if (discountInPercentage > 100 || discountInPercentage < 0) {
            throw new IllegalArgumentException("Правила для процента скидки — процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
        this.discountInPercentage = discountInPercentage;
    }
}



