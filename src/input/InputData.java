package input;

import java.util.ArrayList;

public final class InputData {
    private ArrayList<UsersData> users;
    private ArrayList<MoviesData> movies;
    private ArrayList<ActionsData> actions;

    /** se returneaza lista de utilizatori din sistem**/
    public ArrayList<UsersData> getUsers() {
        return users;
    }
    /** se seteaza lista de utilizatori din sistem **/
    public void setUsers(final ArrayList<UsersData> users) {
        this.users = users;
    }
    /** se returneaza lista de filme din sistem**/
    public ArrayList<MoviesData> getMovies() {
        return movies;
    }
    /** se seteaza lista de filme din sistem **/
    public void setMovies(final ArrayList<MoviesData> movies) {
        this.movies = movies;
    }
    /** se returneaza lista de actiuni ce vor fi efectuate**/
    public ArrayList<ActionsData> getActions() {
        return actions;
    }
    /** se seteaza lista de actiuni ce vor fi efectuate**/
    public void setActions(final ArrayList<ActionsData> actions) {
        this.actions = actions;
    }
}

