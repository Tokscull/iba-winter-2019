package com.iba.task2.entity;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Getter
    @Setter
    private Spacecraft  shuttle;
    @Getter
    @Setter
    private Astronauts astronaut;
}
