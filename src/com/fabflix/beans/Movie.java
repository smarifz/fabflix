package com.fabflix.beans;

/**
 * Created by arifzaidi on 10/1/16.
 */
public class Movie {

    public int id;
    public String title;
    public int year;
    public String director;
    public String banner_url;
    public String trailer_url;


    public Movie(int id, int year, String title, String director, String banner_url, String trailer_url){
        this.id = id;
        this.year = year;
        this.title = title;
        this.director = director;
        this.banner_url = banner_url;
        this.trailer_url = trailer_url;

    }

    public int getId(){
        return this.id;
    }

    public int getYear(){
        return this.year;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDirector(){
        return this.director;
    }

    public String getBanner_url(){
        return this.banner_url;
    }

    public String getTrailer_url(){
        return this.trailer_url;
    }



}