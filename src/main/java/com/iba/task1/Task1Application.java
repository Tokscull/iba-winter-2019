package com.iba.task1;

import com.iba.task1.entity.Spacecraft;
import com.iba.task1.service.Emulation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Task1Application {
    private final static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");


    public static void main(String[] args) {

        System.out.println("Information about upcoming trip:");
        System.out.println(context.getBean("cosmoTripService"));


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

    public static ApplicationContext getContext() {
        return context;
    }
}
