package ro.hubs.ing.springbootproject.classes;

import ro.hubs.ing.springbootproject.exceptions.NegativePriceException;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product() {
        this.name = "Unknown product";
        this.quantity = 0;
    }

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = Math.max(quantity, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public double calculateTotalValue() throws NegativePriceException {
        if (price < 0) {
            throw new NegativePriceException();
        }
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
