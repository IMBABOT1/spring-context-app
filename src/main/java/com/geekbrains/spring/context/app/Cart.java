package com.geekbrains.spring.context.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope("prototype")
public class Cart implements CartRepository  {

    private ProductRepository productRepository;
    private List<Product> list = new ArrayList<>();

    @Autowired
    public Cart(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public String toString() {
       StringBuilder sb  = new StringBuilder();
       for (Product p : list){
           sb.append(p);
       }

       return sb.toString();
    }

    public List findAll(){
        return list;
    }

    @Override
    public void add(int id) {
        list.add(productRepository.findProduct(id));
    }

    @Override
    public void delete(int id) {
        int count = 0;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId() == id){
                list.remove(productRepository.findProduct(id));
                count++;
                if (count == 1){
                    break;
                }
                i++;
            }
        }
    }
}
