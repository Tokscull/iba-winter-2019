package com.iba.task1.entity;

public class Trip {
    private Spacecraft  shuttle;
    private Astronauts astronaut;

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

    @Override
    public String toString() {
        return "Trip{" +
                "shuttle= '" + shuttle + '\'' +
                ", astronaut= " + astronaut +
                '}';
    }

}
