package com.example.supriya.myapplication;

/**
 * Created by Supriya on 02-08-2016.
 */
public class LattLng {
    int id;
    double lattitude,longitude;
    public LattLng(){}
    public LattLng(int id,double lattitude, double longitude){
        this.id=id;
        this.lattitude=lattitude;
        this.longitude=longitude;
    }
    public LattLng(double lattitude, double longitude){
        this.lattitude=lattitude;
        this.longitude=longitude;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public double getlat(){
        return this.lattitude;
    }
    public double getlng(){
        return this.longitude;
    }
    public void setlat(double lattitude)
    {
        this.lattitude=lattitude;
    }
    public void setlng(double longitude)
    {
        this.longitude=longitude;
    }

}
