package com.javarush;

import com.javarush.entities.Cat;
import com.javarush.entities.Dog;
import com.javarush.entities.Parrot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by RUSLAN77 on  12.06.2018 in Ukraine
 */
public class Main {
    public static void main(String[] args) {
        // создаем пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        /*Сначала мы создаем объект контекста, и в конструкторе указываем ему имя пакета, которое надо сканировать на наличие в нем бинов. То-есть, спринг пройдется по этому пакету и попробует найти такие классы, которые отмечены специальными аннотациями, дающими спрингу понять, что это - бин. После чего он создает объекты этих классов и помещает их себе в контекст.*/
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext("com.javarush.entities");


        ApplicationContext context = new AnnotationConfigApplicationContext("com.javarush.configs");

        Cat cat = context.getBean(Cat.class);// по имени класса
        Dog dog = (Dog) context.getBean("dog"); // по имени бина
        Parrot parrot = context.getBean("parrot1", Parrot.class);// по имени бина и имени класса

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
    }
}
/* После чего мы получаем из этого контекста котика. Обращаясь к объекту контекста - мы просим его дать нам бин (объект), и указываем, какого класса объект нам нужен (тут, кстати, можно указывать не только классы, но и интерфейсы). После чего нам спринг возвращает объект этого класса, который мы уже и сохраняем в переменную.

Далее мы просим спринг достать нам бин, который называется "dog". Когда спринг будет создавать объект класса Dog - то он даст ему стандартное имя (если явно не указано имя создаваемого бина), которое является названием класса объекта, только с маленькой буквы. Поэтому, поскольку класс у нас называется Dog, то имя такого бина будет "dog". Если бы у нас там был объект BufferedReader - то ему спринг дал бы имя по умолчанию "bufferedReader". И поскольку в данном случае (у джавы) нет точной уверенности какого именно класса будет такой объект - то возвращается просто некий Object, который мы уже потом ручками кастим к нужному нам типу Dog. Вариант с явным указанием класса удобнее.

Ну и в третьем случае мы получаем бин по классу и по имени. Просто может быть такая ситуация, что в контексте окажется несколько бинов какого-то одного класса, и для того, чтобы указать какой именно бин нам нужен - указываем его имя. Поскольку мы тут тоже явно указали класс - то и кастить нам уже не приходится.
В этом вся суть автоматической конфигурации. Вы пишете ваши классы, отмечаете их нужными аннотациями, и указываете спрингу пакет с вашими классами, по которому он идет, ищет аннотации и создает объекты таких классов.*/