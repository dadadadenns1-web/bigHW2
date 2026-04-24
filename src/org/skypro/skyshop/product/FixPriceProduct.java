package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    //Цена назначается один раз в год, поэтому в данный момент ее выгоднее установить в коде, используя константу.
    //Саму фиксированную цену нужно оформить в виде приватной константы в классе FixPriceProduct.
    private static final int PRICE = 3000;

    // конструктор которого принимает только имя продукта
    public FixPriceProduct(String name) {
        super(name);
    }

    //getPrice возвращает некоторую фиксированную цену.
    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": " + "Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
