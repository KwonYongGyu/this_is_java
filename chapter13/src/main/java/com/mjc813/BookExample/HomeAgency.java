package com.mjc813.bookExample;

public class HomeAgency extends Rentable<Home> {
    @Override
    public Home rent() {
        return new Home();
    }
}
