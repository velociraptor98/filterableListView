package com.example.kunal.myapplication;

public class data {
    private String name,desig,contact;
    public data(String name,String desig,String contact)
    {
        this.name=name;
        this.desig=desig;
        this.contact=contact;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDesig()
    {
        return this.desig;
    }
    public String getContact()
    {
        return this.contact;
    }
}
