package input;

import java.util.ArrayList;

public final class Contains {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    /**se returneaza actorii **/
    public ArrayList<String> getActors() {
        return actors;
    }
    /** se seteaza actorii**/
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }
    /** se returneaza genurile unui film **/
    public ArrayList<String> getGenre() {
        return genre;
    }
    /** se seteaza genurile unui film **/
    public void setGenre(final ArrayList<String> genre) {
        this.genre = genre;
    }
}
