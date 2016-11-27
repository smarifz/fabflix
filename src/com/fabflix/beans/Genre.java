package com.fabflix.beans;

/**
 * Created by arifzaidi on 10/1/16.
 */
public class Genre {

    public int id;
    public String name;


    public Genre(int id, String name){
        this.id = id;
        this.name = name;

    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

}