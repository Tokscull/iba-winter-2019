package com.iba.task2;

import com.iba.task2.configuration.ContextConfiguration;
import com.iba.task2.entity.Spacecraft;
import com.iba.task2.service.Emulation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Task2Application {

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);


        ContextConfiguration contextConfiguration = new ContextConfiguration();

        System.out.println("Information about upcoming trip:");
        System.out.println(contextConfiguration.cosmoTripService());


        Scanner in = new Scanner(System.in);
        System.out.print("Input a shuttle name: ");
        String shuttleName = in.nextLine();
        in.close();
        Spacecraft shuttle = new Spacecraft().getShuttleByName(shuttleName);
        System.out.println("You shuttle: " + shuttle);


        Emulation emulation = new Emulation();
        emulation.tripPreparation();
        emulation.tripEmulation(shuttle);
    }

}
