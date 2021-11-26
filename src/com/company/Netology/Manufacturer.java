package com.company.Netology;

public class Manufacturer extends Thread {
    private final CarDealership carDealership;


    public Manufacturer(String name, CarDealership carDealership) {
        super(name);
        this.carDealership = carDealership;

    }

    @Override
    public void run() {
        carDealership.produceCar();
    }
}
