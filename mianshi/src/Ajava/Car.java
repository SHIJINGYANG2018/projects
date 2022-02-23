package Ajava;

import java.util.Comparator;

public  class Car implements Comparator<Car> {
    private String brand;
    private String color;
    private int maxSpeed;

    public void sss(){
        System.out.println(brand+color+maxSpeed);
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public int compare(Car o1, Car o2) {
        return 0;
    }
}