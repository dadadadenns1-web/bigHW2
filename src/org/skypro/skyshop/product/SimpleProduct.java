package org.skypro.skyshop.product;

//сделайте класc SimpleProduct, который наследуется от Product
// и принимает в свой конструктор (кроме имени) обычную цену товара, а переопределенный метод getPrice возвращает эту цену.
public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name,int price){
        super(name);
        this.price = price;

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName()+": "+getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
