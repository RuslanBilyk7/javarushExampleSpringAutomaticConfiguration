package com.javarush.configs;

import com.javarush.weekday.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*При создании контекста спринг будет искать те классы, которые помечены аннотацией @Configuration, и создаст объекты этих классов у себя. После чего он попытается вызывать методы в этих классах, которые помечены аннотацией @Bean, что значит, что такие методы будут возвращать бины (объекты), которые он уже поместит себе в контекст.*/
@Configuration
@ComponentScan("com.javarush.entities")

public class MyConfig {
    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return new Monday();
            case TUESDAY: return new Tuesday();
            case WEDNESDAY: return new Wednesday();
            case THURSDAY: return new Thursday();
            case FRIDAY: return new Friday();
            case SATURDAY: return new Saturday();
            default: return new Sunday();
        }
    }
}




//public class MyConfig {
//
//    @Bean
//    public Cat getCat() {
//        return new Cat();
//    }

    /*Тепер рассмотрим ситуацию, когда для создания одного бина нам нужно использовать другой бин.
Например, мы хотим чтобы имя кота в бине кота состояло из имени попугайчика и строки "-killer".
    Тут спринг увидит, что перед тем, как создавать этот бин - ему понадобится сюда передать уже созданный бин попугайчика. Поэтому он выстроит цепочку вызовов наших методов так, чтобы сначала вызвался метод по созданию попугайчика, а потом уже передаст этого попугайчика в метод по созданию кота. Тут сработала та штука, которая называется dependency injection: спринг сам передал нужный бин попугайчика в наш метод. Если идея будет ругаться на переменную parrot - не забудьте изменить тип возвращаемого значения в методе по созданию попугайчика с Object на Parrot.
     */
//    @Bean
//    public Cat getCat(Parrot parrot) {
//        Cat cat = new Cat();
//        cat.setName(parrot.getName() + "-killer");
//        return cat;
//    }
//
//    @Bean ("dog")
//    public Dog getDog() {
//        return new Dog();
//    }
//
//    @Bean("parrot1")
//    public Parrot weNeedMoreParrots() {
//        return new Parrot();
//    }
//}
/*Получается, что мы тут сами вручную создали нашего котика и дали спрингу, а он уже поместил этот наш объект к себе в контекст. Поскольку мы явно не указывали имя нашего бина - то спринг даст бину такое же имя, как и название метода. В нашем случает, бин кота будет иметь имя "getCat". Но так как в main-е мы все-равно получаем кота не по имени,  а по классу - то в данном случае нам имя этого бина не важно.*/