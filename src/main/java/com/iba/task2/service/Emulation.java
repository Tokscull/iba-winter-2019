package com.iba.task2.service;

import com.iba.task2.configuration.ContextConfiguration;
import com.iba.task2.entity.Astronauts;
import com.iba.task2.entity.Spacecraft;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emulation {
    @Getter
    @Setter
    private Spacecraft shuttle;
    @Getter
    @Setter
    private Astronauts astronaut;
    @Getter
    @Setter
    private String startPoint;
    @Getter
    @Setter
    private String destination;
    @Getter
    @Setter
    private int totalDistance;
    @Getter
    @Setter
    private int leftDistance;


    public void tripPreparation(){

        System.out.println("Start 10 second preparation before emulation , Time is: " + new Date());
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void tripEmulation(Spacecraft spacecraft){
        ContextConfiguration contextConfiguration = new ContextConfiguration();
        System.out.println("Emulation starts , Time is: " + new Date());


        Emulation emulation = contextConfiguration.emulationService(spacecraft,
                new Astronauts().getRandomAstronaut(contextConfiguration.getAllAstronauts()), 384400);
        for(int i = 0 ; i <= 10 ; i++) {
            System.out.println(contextConfiguration.emulationService(spacecraft,emulation.getAstronaut(), emulation.getLeftDistance()));
            emulation.setLeftDistance(emulation.getLeftDistance() - emulation.getTotalDistance()/10);


            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The shuttle successfully got to the "+ emulation.getDestination() + "! , Time is: " + new Date());
    }
}
