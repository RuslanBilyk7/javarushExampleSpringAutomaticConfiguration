package com.javarush.weekday;

import com.javarush.configs.MyConfig;
import com.javarush.entities.Cat;
import com.javarush.entities.Dog;
import com.javarush.entities.Parrot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);

        WeekDay weekDay = context.getBean(WeekDay.class);
        System.out.println("It's " + weekDay.getWeekDayName() + " today!");

        Cat cat = context.getBean(Cat.class);// по имени класса
        Dog dog = (Dog) context.getBean("dog"); // по имени бина
        Parrot parrot = context.getBean("parrot1", Parrot.class);// по имени бина и имени класса

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
    }
}




