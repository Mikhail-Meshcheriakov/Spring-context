package ru.geekbrains.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Молоко", 45));
        products.add(new Product(2, "Хлеб", 30));
        products.add(new Product(3, "Макароны", 39));
        products.add(new Product(4, "Кетчуп", 58));
        products.add(new Product(5, "Яйца", 55));
    }
}
