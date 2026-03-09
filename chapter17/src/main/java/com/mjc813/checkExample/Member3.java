package com.mjc813.checkExample;

public class Member3 {
    private String name;
    private String job;

    public Member3(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "{name:" + name + ", job:" + job + "}";
    }
}
