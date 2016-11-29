package com.fabflix.beans;

import java.util.List;

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
    public List<Star> stars;
    public List<Genre> genres;


    public Movie(int id, int year, String title, String director, String banner_url, String trailer_url, List<Star> stars, List<Genre> genres) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.director = director;
        this.banner_url = banner_url;
        this.trailer_url = trailer_url;
        this.stars = stars;
        this.genres = genres;

    }

    public int getId() {
        return this.id;
    }

    public int getYear() {
        return this.year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public String getBanner_url() {
        return this.banner_url;
    }

    public String getTrailer_url() {
        return this.trailer_url;
    }

    public List<Star> getStars() {
        return this.stars;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }
}