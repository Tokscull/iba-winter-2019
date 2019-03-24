package com.iba.task2.configuration;


import com.iba.task2.entity.Astronauts;
import com.iba.task2.entity.Spacecraft;
import com.iba.task2.entity.Trip;
import com.iba.task2.service.Emulation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;

@Configuration
public class ContextConfiguration {


    // Spacecraft
    @Bean
    public Spacecraft SpaceXShuttle() {
        return new Spacecraft("SpaceX", (int) (Math.random() * 100.0),(int) (Math.random() * 1000.0));
    }

    @Bean
    public Spacecraft nasaShuttle() {
        return new Spacecraft("NASAShuttle", (int) (Math.random() * 100.0),(int) (Math.random() * 1000.0));
    }

    @Bean
    public Spacecraft paraconeShuttle() {
        return new Spacecraft("Paracone", (int) (Math.random() * 100.0),(int) (Math.random() * 1000.0));
    }

    @Bean
    public List<Spacecraft> getAllSpacecraft(){
        List <Spacecraft> spacecraftList = new ArrayList<>();
        spacecraftList.add(SpaceXShuttle());
        spacecraftList.add(nasaShuttle());
        spacecraftList.add(paraconeShuttle());

        return  spacecraftList;
    }



    //Astronauts
    @Bean
    public Astronauts elonMuskAstronauts() {
        return new Astronauts("Elon Musk", (int) (Math.random() * 100.0));
    }

    @Bean
    public Astronauts pewdiepieAstronauts() {
        return new Astronauts("Pewdiepie", (int) (Math.random() * 100.0));
    }

    @Bean
    public Astronauts ricardoMilosAstronauts() {
        return new Astronauts("Ricardo Milos", (int) (Math.random() * 100.0));
    }


    @Bean
    public List<Astronauts> getAllAstronauts(){
        List <Astronauts> astronautsList = new ArrayList<>();
        astronautsList.add(elonMuskAstronauts());
        astronautsList.add(pewdiepieAstronauts());
        astronautsList.add(ricardoMilosAstronauts());

        return  astronautsList;
    }




    //cosmoTripService
    @Bean
    public Trip cosmoTripService() {
        return new Trip(new Spacecraft().getRandomShuttle(getAllSpacecraft()), new Astronauts().getRandomAstronaut(getAllAstronauts()));
    }




    //Emulation
    @Bean
    @Scope("prototype")
    public Emulation emulationService(Spacecraft spacecraft,Astronauts astronauts, int leftDistance) {
        return new Emulation(spacecraft,astronauts,
                           "Earth", "Moon", 384400,leftDistance);
    }




}
