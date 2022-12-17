package tools;

import input.*;

import java.util.ArrayList;

public class CreateApp {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<ActionsData> actions = new ArrayList<>();
    private ArrayList<Movie> filteredMovies;
    private ArrayList<Movie> searchedMovies;
    private Movie seeMovie;
    private Account account;
    private  String currentPage;
    private String lastAction;

    /** **/
    public ArrayList<User> getUsers() {
        return users;
    }
    /** **/
    public void setUsers(final ArrayList<User> users) {
        this.users = users;
    }
    /** **/
    public String getCurrentPage() {
        return currentPage;
    }
    /** **/
    public void setCurrentPage(final String currentPage) {
        this.currentPage = currentPage;
    }
    /** **/
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    /** **/
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }
    /** **/
    public ArrayList<ActionsData> getActions() {
        return actions;
    }
    /** **/
    public void setActions(final ArrayList<ActionsData> actions) {
        this.actions = actions;
    }
    /** **/
    public Account getAccount() {
        return account;
    }
    /** **/
    public void setAccount(final Account account) {
        this.account = account;
    }
    /** **/
    public ArrayList<Movie> getFilteredMovies() {
        return filteredMovies;
    }
    /** **/
    public void setFilteredMovies(final ArrayList<Movie> filteredMovies) {
        this.filteredMovies = filteredMovies;
    }
    /** **/
    public ArrayList<Movie> getSearchedMovies() {
        return searchedMovies;
    }
    /** **/
    public void setSearchedMovies(final ArrayList<Movie> searchedMovies) {
        this.searchedMovies = searchedMovies;
    }
    /** **/
    public Movie getSeeMovie() {
        return seeMovie;
    }
    /** **/
    public void setSeeMovie(final Movie seeMovie) {
        this.seeMovie = seeMovie;
    }
    /** **/
    public String getLastAction() {
        return lastAction;
    }
    /** **/
    public void setLastAction(final String lastAction) {
        this.lastAction = lastAction;
    }

    /** **/
    public CreateApp(final InputData inputData) {
        for (int i = 0; i < inputData.getUsers().size(); i++) {
           users.add(new User(inputData.getUsers().get(i).getCredentials()));
           movies.add(new Movie(inputData.getMovies().get(i)));
        }
        for (int i = 0; i < inputData.getUsers().size(); i++) {
            users.get(i).setCredentials(inputData.getUsers().get(i).getCredentials());
        }

        account = new Account();
        actions = inputData.getActions();
        currentPage = "unlogged";
        filteredMovies = new ArrayList<>();
        searchedMovies = new ArrayList<>();
        lastAction = "none";
    }

}
