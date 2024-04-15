package com.parkseryu.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);

        final String lover = "parkseryu";
        System.out.println("Hello, " + lover + "!");
        int age = 18;
        System.out.println("I'm " + age + " years old.");

    }

}
