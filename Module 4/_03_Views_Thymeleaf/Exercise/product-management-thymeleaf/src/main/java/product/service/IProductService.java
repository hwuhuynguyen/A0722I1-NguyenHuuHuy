package product.service;

import product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();

    Product findById(int id);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);
}
