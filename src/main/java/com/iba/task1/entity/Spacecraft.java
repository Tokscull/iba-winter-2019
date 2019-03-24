package com.iba.task1.entity;


import com.iba.task1.Task1Application;

import java.util.List;
import java.util.Random;

public class Spacecraft {
    private String shuttleName;
    private int maxCapacity;
    private int countFlight;


    public String getShuttleName() {
        return shuttleName;
    }
    public void setShuttleName(String shuttleName) {
        this.shuttleName = shuttleName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCountFlight() {
        return countFlight;
    }
    public void setCountFlight(int countFlight) {
        this.countFlight = countFlight;
    }

    @Override
    public String toString() {
        return "Spacecraft{" +
                "shuttleName='" + shuttleName + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", countFlight=" + countFlight +
                '}';
    }


    public Spacecraft getRandomShuttle(List<Spacecraft> spacecraftList){
        return spacecraftList.get(new Random().nextInt(spacecraftList.size()));
    }

    public Spacecraft getShuttleByName(String shuttleName){
        List<Spacecraft> spacecraftList = (List<Spacecraft>) Task1Application.getContext().getBean("shuttles");

        for (Spacecraft spacecraft : spacecraftList) {
            if (spacecraft.getShuttleName().equals(shuttleName)) {
                return spacecraft;
            }
        }
        System.out.println("Oops! This shuttle not found,but we will give you a random shuttle.");
        return  getRandomShuttle(spacecraftList);
    }
}

