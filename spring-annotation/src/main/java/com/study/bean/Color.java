package com.study.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
