package com.example.sqlitedb;

public class Employee {
    private int srno;
    private String name;
    private  double increment;

    public Employee(int srno, String name, double increment) {
        this.srno = srno;
        this.name = name;
        this.increment = increment;
    }



    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }
}
