package com.javarush.entities;

import org.springframework.stereotype.Component;

/**
 * Created by RUSLAN77 on  12.06.2018 in Ukraine
 */
@Component("parrot1")
public class Parrot {
    private String name = "Кеша";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}