package net.cnam.inf330;

import javafx.beans.Observable;

/**
 * Class for implementing the planes operated by the simulation system.
 */
// TODO 3.a) Make Plane an abstract class that implements the IPlane interface
// TODO 6.a) Make Plane an Observable object
// FIXME Wrong Observable interface
abstract class Plane implements IPlane, Observable {

    public static final int MAX_FUEL_CAPACITY = 5;

    private int creationTick;
    private String name;
    private boolean isFlying;
    public int fuelCapacity;

    public Plane(int tick, String name, boolean isFlying, int fuelCapacity) {
        this.creationTick = tick;
        this.name = name;
        this.isFlying = isFlying;
        this.fuelCapacity = fuelCapacity;
        // FIXME Add Observer
    }

    public void fly() {this.fuelCapacity--; }

    public void takeOff(int runway) {
        this.isFlying = true;
        System.out.println("Plane taking off from runway " + runway + " : " + this.name);
        // FIXME update observer
    }

    public void land(int runway) {
        this.isFlying = false;
        if (this.fuelCapacity == 0)
            System.out.println("Plane landing (emergency) on runway " + runway + " : " + this.name);
        else
            System.out.println("Plane landing on runway " + runway + " : " + this.name);
        // FIXME update observer
    }

    public void crash() {
        this.isFlying = false;
        System.out.println("Plane crashing : " + this.name);
        // FIXME update observer
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCreationTick() {
        return creationTick;
    }

    public void setCreationTick(int creationTick) {
        this.creationTick = creationTick;
    }
}