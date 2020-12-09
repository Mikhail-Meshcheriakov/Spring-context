package ru.geekbrains.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository products;
    private List<Product> productsInCart;

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public Cart(ProductRepository products) {
        this.products = products;
    }

    public boolean addProduct(int id) {
        for (Product product : products.getProducts()) {
            if (product.getId() == id) {
                productsInCart.add(product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        for (Product product : productsInCart) {
            if (product.getId() == id) {
                productsInCart.remove(product);
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    private void init() {
        productsInCart = new ArrayList<>();
    }
}
