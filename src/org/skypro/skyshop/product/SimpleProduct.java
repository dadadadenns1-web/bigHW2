package org.skypro.skyshop.product;

//сделайте класс SimpleProduct, который наследуется от Product
// и принимает в свой конструктор (кроме имени) обычную цену товара, а переопределенный метод getPrice возвращает эту цену.
public class SimpleProduct extends Product {

    private int price;

    //В конструкторе класса SimpleProduct реализуйте проверку передаваемой цены продукта, цена должна быть строго больше 0
    public SimpleProduct(String name, int price) {
        super(name);
        setPrice(price);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    //Сеттер чтоб не жаловался компилятор. По идее цена должна быть изменяемой
    public void setPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть строго больше 0");//выброшено IllegalArgumentException
        }
        this.price = price;
    }
}
