package com.iba.task1.service;

import com.iba.task1.Task1Application;
import com.iba.task1.entity.Astronauts;
import com.iba.task1.entity.Spacecraft;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emulation {
    private Spacecraft shuttle;
    private Astronauts astronaut;
    private String startPoint;
    private String destination;
    private int totalDistance;
    private int leftDistance;

    public Spacecraft getShuttle() {
        return shuttle;
    }
    public void setShuttle(Spacecraft shuttle) {
        this.shuttle = shuttle;
    }

    public Astronauts getAstronaut() {
        return astronaut;
    }
    public void setAstronaut(Astronauts astronaut) {
        this.astronaut = astronaut;
    }

    public String getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalDistance() {
        return totalDistance;
    }
    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getLeftDistance() {
        return leftDistance;
    }
    public void setLeftDistance(int leftDistance) {
        this.leftDistance = leftDistance;
    }

    @Override
    public String toString() {
        return "Emulation{" +
                "shuttle='" + shuttle.getShuttleName() + '\'' +
                ", astronaut='" + astronaut.getName() + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", totalDistance=" + totalDistance +
                ", leftDistance=" + leftDistance +
                '}';
    }

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
        System.out.println("Emulation starts , Time is: " + new Date());

        Emulation emulation = (Emulation) Task1Application.getContext().getBean("emulationService");
        emulation.setShuttle(spacecraft);
        for(int i = 0 ; i <= 10 ; i++) {
            System.out.println(Task1Application.getContext().getBean("emulationService"));

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