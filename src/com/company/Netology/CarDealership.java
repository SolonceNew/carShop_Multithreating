package com.company.Netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CarDealership {

    private final static int BUY_TIME = 1000;
    private final static int PRODUCE_TIME = 2000;
    final List<Car> cars = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void buyCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while(cars.size() == 0) {
                System.out.println("Машин нет!");
                condition.await();
            }
            Thread.sleep(BUY_TIME);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            cars.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void produceCar() {
        try {
            Thread.sleep(PRODUCE_TIME);
            cars.add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            lock.lock();
            condition.signal();
        } catch (InterruptedException e) {
                e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}






