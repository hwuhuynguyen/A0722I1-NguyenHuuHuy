package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImplement implements IProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 14", 1200, "Smartphone", "Apple"));
        products.put(2, new Product(2, "Galaxy Z Ford", 1000, "Smartphone", "Samsung"));
        products.put(3, new Product(3, "VivBook", 1500, "Laptop", "ASUS"));
        products.put(4, new Product(4, "Macbook Air", 2200, "Laptop", "Apple Laptop"));
        products.put(5, new Product(5, "VinFast", 20000, "Electric car", "VinGroup"));
    }
    @Override
    public List<Product> findAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void addNewProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findProductById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = findAllProducts();
        List<Product> resultList = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().equals(name))
                resultList.add(p);
        }
        return resultList;
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void removeProduct(int id) {
        products.remove(id);
    }
}
