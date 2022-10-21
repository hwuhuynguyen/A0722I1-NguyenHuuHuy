package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();

    void addNewProduct(Product product);

    Product findProductById(int id);

    List<Product> searchProductByName(String name);

    void updateProduct(int id, Product product);

    void removeProduct(int id);

}
