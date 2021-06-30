package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private String band;
    private double year_of_birth;

    public Beer(String band, int year_of_birth){

    }

    public Beer() {

    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public double getSize() {
        return year_of_birth;
    }

    public void setYear_of_birth(double year) {
        this.year_of_birth = year;
    }

    public List<Beer> getBrands(String color) {
        List<Beer> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add(new Beer("Jack Amber",100));
            brands.add(new Beer("Red Moose",200));
        } else {
            brands.add(new Beer("Jali Pale Ale",300));
            brands.add(new Beer("Gout Stout",400));
        }
        return brands;
    }


    public String toString(){
        return "Beer【band="+band+"\'"+",Birth year="+year_of_birth+"】";
    }
}
