package com.javarush.configs;

import com.javarush.weekday.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*если автоматическая конфиграция нам по каким-то причинам не подходит - используем java-конфигурирование
- в таком случае создаем обычный джава класс, методы которого будут возвращать нужные нам объекты, и помечаем такой класс аннотацией @Configuration на случай, если будем сканировать весь пакет целиком, а не указывать конкретный класс с конфигурацией при создании контекста
- методы этого класса, которые возвращают бины - помечаем аннотацией @Bean*/

@Configuration

public class WeekConfig {

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
