package model;

public class Product {
    private int id;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productManufacture;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, String productDescription, String productManufacture) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productManufacture = productManufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductManufacture() {
        return productManufacture;
    }

    public void setProductManufacture(String productManufacture) {
        this.productManufacture = productManufacture;
    }
}
