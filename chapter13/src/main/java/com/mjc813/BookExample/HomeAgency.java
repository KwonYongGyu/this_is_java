package com.mjc813.BookExample;

public class HomeAgency extends Rentable<Home> {
    @Override
    public Home rent() {
        return new Home();
    }
}
