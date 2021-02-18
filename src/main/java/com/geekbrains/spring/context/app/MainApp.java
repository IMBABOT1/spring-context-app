package com.geekbrains.spring.context.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static String next = "";
    private static String add = "/add";
    private static String delete = "/dell";

    public static void main(String[] args) {
        shop();
    }

    private static void shop(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean("cart", Cart.class);

        System.out.println("Enter /add id to add product");
        System.out.println("Enter /dell id to delete product");
        System.out.println("Enter /end to exit");

        String s = "";

        while (!s.equals("/end")){
        s = scanner.nextLine();

        while (!next.equals("/end")) {
            if (s.equals(add + " " + "1")) {
                cart.add(1);
                System.out.println(cart);
                break;
            }
            if (s.equals(add + " " + "2")) {
                cart.add(2);
                System.out.println(cart);
                break;
            }
            if (s.equals(add + " " + "3")) {
                cart.add(3);
                System.out.println(cart);
                break;
            }
            if (s.equals(add + " " + "4")) {
                cart.add(4);
                System.out.println(cart);
                break;
            }
            if (s.equals(add + " " + "5")) {
                cart.add(5);
                System.out.println(cart);
                break;
            }
            if (s.equals(delete + " " + "1")) {
                cart.delete(1);
                System.out.println(cart);
                break;
            }
            if (s.equals(delete + " " + "2")) {
                cart.delete(2);
                System.out.println(cart);
                break;
            }
            if (s.equals(delete + " " + "3")) {
                cart.delete(3);
                System.out.println(cart);
                break;
            }
            if (s.equals(delete + " " + "4")) {
                cart.delete(4);
                System.out.println(cart);
                break;
            }
            if (s.equals(delete + " " + "5")) {
                cart.delete(5);
                System.out.println(cart);
                break;
            } else if (s.equals("/end")) {
                break;
            }
        }

        }
    }

}
