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
    /** se returneaza titlul filmului**/
    public String getName() {
        return name;
    }
    /** se seteaza titlul filmului**/
    public void setName(final String name) {
        this.name = name;
    }
    /** se returneaza anul aparitiei**/
    public int getYear() {
        return year;
    }
    /** se seteaza anul aparitiei**/
    public void setYear(final int year) {
        this.year = year;
    }
    /** se returneaza durata **/
    public int getDuration() {
        return duration;
    }
    /** se seteaza durata**/
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    /** se returneaza genurile filmului**/
    public ArrayList<String> getGenres() {
        return genres;
    }
    /** se seteaza genurile filmului**/
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }
    /** se returneaza actorii**/
    public ArrayList<String> getActors() {
        return actors;
    }
    /** se seteaza actorii**/
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /** se returneaza tarile banate**/
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    /** se seteaza tarile banate**/
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
    /** se returneaza numarul de like-uri**/
    public int getNumLikes() {
        return numLikes;
    }
    /** se seteaza numarul de like-uri**/
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }
    /** se returneaza rating-ul**/
    public Double getRating() {
        return rating;
    }
    /** se seteaza rating-ul**/
    public void setRating(final Double rating) {
        this.rating = rating;
    }
    /** se returneaza numarul de rating-uri**/
    public int getNumRatings() {
        return numRatings;
    }
    /** se seteaza numarul de rating-uri**/
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }
    /** constructor ce initializeaza fiecare camp**/
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

    /** copyConstructor**/
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
