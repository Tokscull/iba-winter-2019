package com.iba.task2.entity;


import com.iba.task2.configuration.ContextConfiguration;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Spacecraft {
    @Getter
    @Setter
    private String shuttleName;
    @Getter
    @Setter
    private int maxCapacity;
    @Getter
    @Setter
    private int countFlight;



    public Spacecraft getRandomShuttle(List<Spacecraft> spacecraftList){
        return spacecraftList.get(new Random().nextInt(spacecraftList.size()));
    }

    public Spacecraft getShuttleByName(String shuttleName){
        List<Spacecraft> spacecraftList =  new ContextConfiguration().getAllSpacecraft();

        for (Spacecraft spacecraft : spacecraftList) {
            if (spacecraft.getShuttleName().equals(shuttleName)) {
                return spacecraft;
            }
        }
        System.out.println("Oops! This shuttle not found,but we will give you a random shuttle.");
        return  getRandomShuttle(spacecraftList);
    }
}
