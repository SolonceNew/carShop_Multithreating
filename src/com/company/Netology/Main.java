package com.company.Netology;

public class Main {
    private final static int BUYERS = 10;

    public static void main(String[] args) {
        final CarDealership carDealership = new CarDealership();
        for(int i = 1; i <= Car.getNumberCars(); i++) {
            new Buyer("Покупатель " + i, carDealership).start();
        }
        new Manufacturer("Производитель TOYTA", carDealership).start();



    }

}
