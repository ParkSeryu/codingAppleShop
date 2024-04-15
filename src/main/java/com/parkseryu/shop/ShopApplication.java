package com.parkseryu.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);

        var a = new Friend().age;

    }
}

class Friend {
    String name = "kim";
    int age = 20;

    Friend() {
        this.
    }
}
