package com.bpf.xml.autowired;

public class SIMCard {

    private String name;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SIMCard{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
