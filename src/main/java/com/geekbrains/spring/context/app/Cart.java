package com.geekbrains.spring.context.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart  {

    private ProductRepository productRepository;
    private List<Product> list = new ArrayList<>();

    @Autowired
    public Cart(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    void add(int id){
        list.add(productRepository.findProduct(id));
    }

    void delete(int id){
        list.remove(productRepository.findProduct(id));
    }

    @Override
    public String toString() {
       StringBuilder sb  = new StringBuilder();
       for (Product p : list){
           sb.append(p);
       }

       return sb.toString();
    }
}
