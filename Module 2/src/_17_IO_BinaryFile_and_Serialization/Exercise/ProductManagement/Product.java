package _17_IO_BinaryFile_and_Serialization.Exercise.ProductManagement;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String manufacturer;
    private double price;

    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.manufacturer = product.manufacturer;
        this.price = product.price;
    }
    public Product(int id, String name, String manufacturer, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return "Product{" + "id = " + id + ", name = '" + name + '\'' + ", manufacturer = '"
                + manufacturer + ", price = '" + price + '\'' + '}';
    }
}
