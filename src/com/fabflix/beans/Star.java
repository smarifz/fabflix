package com.fabflix.beans;

import java.util.ArrayList;

/**
 * Created by arifzaidi on 10/1/16.
 */
public class Star {

    public String first_name;
    public String last_name;
    public int dob;
    public int id;
    public String photo_url;
    public ArrayList<Movie> movies;


    public Star(String first_name, String last_name, int dob, int id, String photo_url, ArrayList movies){
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.id = id;
        this.photo_url = photo_url;
        this.movies = movies;

    }

    public int getId(){
        return this.id;
    }

    public int getDob(){
        return this.dob;
    }

    public String getName(){
        return this.first_name+" "+this.last_name;
    }

    public String getPhotoUrl(){
        return this.photo_url;
    }

    public ArrayList<Movie> getMovies(){ return this.movies;}


}