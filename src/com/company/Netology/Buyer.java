package com.company.Netology;

public class Buyer extends Thread{

    private final CarDealership carDealership;
    private final static int NUMBER_BUYERS = 10;


    public Buyer(String name, CarDealership carDealership) {
        super(name);
        this.carDealership = carDealership;

    }

    @Override
    public void run() {
        carDealership.buyCar();

    }


}
