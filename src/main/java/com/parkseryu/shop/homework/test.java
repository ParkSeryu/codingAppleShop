package com.parkseryu.shop.homework;

import lombok.ToString;

@ToString
public class test {
    private final String name = "parkseryu";
    private int age = 28;

    public void addAge() {
        this.age += 1;
    }

    public void changeAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
