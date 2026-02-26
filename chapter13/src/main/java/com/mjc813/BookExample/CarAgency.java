package com.mjc813.bookExample;

public class CarAgency extends Rentable<Car> {
    @Override
    public Car rent() {
        return new Car();
    }
}
