package input;

import java.util.ArrayList;

public final class MoviesData {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    /** se returneaza numele filmului**/
    public String getName() {
        return name;
    }
    /** se seteaza numele filmului**/
    public void setName(final String name) {
        this.name = name;
    }
    /** se returneaza anul in care a aparut filmul**/
    public int getYear() {
        return year;
    }
    /** se seteaza anul in care a aparut filmul**/
    public void setYear(final int year) {
        this.year = year;
    }
    /** se returneaza durata filmului**/
    public int getDuration() {
        return duration;
    }
    /** se seteaza durata filmului**/
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
    /** se returneaza actorii filmului **/
    public ArrayList<String> getActors() {
        return actors;
    }
    /** se seteaza actorii filmului**/
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /** se returneaza tarile in care este bannat filmul**/
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }
    /** se seteaza tarile in care este bannat filmul**/
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
}
