package com.iba.task2.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Astronauts {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;


    public Astronauts getRandomAstronaut(List<Astronauts> astronautsList){
        return astronautsList.get(new Random().nextInt(astronautsList.size()));
    }
}
