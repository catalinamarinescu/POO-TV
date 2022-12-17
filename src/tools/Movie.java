package tools;

import input.MoviesData;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private Double rating;
    private int numRatings;

    private final static NumberFormat df = new DecimalFormat("#.00");
    /** **/
    public String getName() {
        return name;
    }
    /** **/
    public void setName(final String name) {
        this.name = name;
    }
    /** **/
    public int getYear() {
        return year;
    }
    /** **/
    public void setYear(final int year) {
        this.year = year;
    }
    /** **/
    public int getDuration() {
        return duration;
    }
    /** **/
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    /** **/
    public ArrayList<String> getGenres() {
        return genres;
    }
    /** **/
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }
    /** **/
    public ArrayList<String> getActors() {
        return actors;
    }
    /** **/
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /** **/
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    /** **/
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    /** **/
    public int getNumLikes() {
        return numLikes;
    }
    /** **/
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }
    /** **/
    public Double getRating() {
        return rating;
    }
    /** **/
    public void setRating(final Double rating) {
        this.rating = rating;
    }
    /** **/
    public int getNumRatings() {
        return numRatings;
    }
    /** **/
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /** **/
    private Movie() { }
    /** **/
    public Movie(final MoviesData moviesData) {

        this.name = moviesData.getName();
        this.year = moviesData.getYear();
        this.duration = moviesData.getDuration();
        this.genres = moviesData.getGenres();
        this.actors = moviesData.getActors();
        this.countriesBanned = moviesData.getCountriesBanned();
        this.numLikes = 0;
        this.rating = Double.parseDouble(df.format(0.00d));
        this.numRatings = 0;
    }

    /** **/
    public Movie(final Movie movie) {
        this.name = new String(movie.getName());
        this.year = movie.getYear();
        this.duration = movie.getDuration();
        this.genres = new ArrayList<>(movie.getGenres());
        this.actors = new ArrayList<>(movie.getActors());
        this.countriesBanned = new ArrayList<>(movie.countriesBanned);
        this.numLikes = movie.getNumLikes();
        this.rating = movie.getRating();
        this.numRatings = movie.numRatings;
    }
}
