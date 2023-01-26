package com.isil.appservice.model;

public class Results {
    public int id;
    public String name;

    @Override
    public String toString() {
        return  name + " "+id;
    }
}
