package tools;

import input.*;

import java.util.ArrayList;

public class CreateApp {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<ActionsData> actions;
    private ArrayList<Movie> filteredMovies;
    private ArrayList<Movie> searchedMovies;
    private Movie seeMovie;
    private Account account;
    private  String currentPage;

    /** se returneaza lista utilizatorilor**/
    public ArrayList<User> getUsers() {
        return users;
    }
    /** se seteaza lista utilizatorilor**/
    public void setUsers(final ArrayList<User> users) {
        this.users = users;
    }
    /** se returneaza pagina curenta**/
    public String getCurrentPage() {
        return currentPage;
    }
    /** se seteaza pagina curenta**/
    public void setCurrentPage(final String currentPage) {
        this.currentPage = currentPage;
    }
    /** se returneaza lista filmelor**/
    public ArrayList<Movie> getMovies() {
        return movies;
    }
    /** se seteaza lista filmelor**/
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }
    /** se returneaza lista actiunilor**/
    public ArrayList<ActionsData> getActions() {
        return actions;
    }
    /** se seteaza lista actiunilor**/
    public void setActions(final ArrayList<ActionsData> actions) {
        this.actions = actions;
    }
    /** se returneaza contul activ**/
    public Account getAccount() {
        return account;
    }
    /** se seteaza contul activ**/
    public void setAccount(final Account account) {
        this.account = account;
    }
    /** se retunreaza filmele filtrate**/
    public ArrayList<Movie> getFilteredMovies() {
        return filteredMovies;
    }
    /** se seteaza filmele filtrate**/
    public void setFilteredMovies(final ArrayList<Movie> filteredMovies) {
        this.filteredMovies = filteredMovies;
    }
    /** se returneaza filmele cautate dupa inceputul numelui**/
    public ArrayList<Movie> getSearchedMovies() {
        return searchedMovies;
    }
    /** se returneaza filmul caruia i se cer detaliile**/
    public Movie getSeeMovie() {
        return seeMovie;
    }
    /** se seteaza filmul caruia i se cer detaliile**/
    public void setSeeMovie(final Movie seeMovie) {
        this.seeMovie = seeMovie;
    }

    /** constructor ce initializeaza campurile ce formeaza platforma**/
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
    }

}
