package com.geekbrains.spring.context.app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> list;

    @PostConstruct
    public void init(){
        list = new ArrayList<>(Arrays.asList(new Product(1, "Bread", 1),
                                             new Product(2, "Milk", 2),
                                             new Product(3, "Cheese", 3),
                                             new Product(4, "Orange", 4),
                                             new Product(5, "Fruit", 5)));
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(list);
    }

    public Product findProduct(int id){
        for (Product p : list){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
