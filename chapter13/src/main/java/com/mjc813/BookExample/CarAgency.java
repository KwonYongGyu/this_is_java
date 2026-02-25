package com.mjc813.BookExample;

public class CarAgency extends Rentable<Car> {
    @Override
    public Car rent() {
        return new Car();
    }
}
