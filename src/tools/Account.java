package tools;

import java.util.ArrayList;

public class Account {
    private String error;
    private ArrayList<Movie> currentMovieList;
    private User currentUser;

    /** se returneaza un string ce reprezinta daca este eroare sau nu**/
    public String getError() {
        return error;
    }
    /** se seteaza un string ce reprezinta daca este eroare sau nu**/
    public void setError(final String error) {
        this.error = error;
    }
    /** se returneaza lista curenta de filme**/
    public ArrayList<Movie> getCurrentMovieList() {
        return currentMovieList;
    }
    /** se returneaza user-ul curent**/
    public User getCurrentUser() {
        return currentUser;
    }
    /** se seteaza user-ul curent**/
    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    /** constructor **/
    public Account() { }
    /** constructor **/
    public Account(final String error, final User user) {
        this.error = error;
        this.currentMovieList = new ArrayList<>();
        this.currentUser = user;
    }
    /** copyConstructor**/
    public Account(final Account account) {
        this.error = account.getError();
        this.currentMovieList = new ArrayList<Movie>(account.getCurrentMovieList());
        this.currentUser = new User(account.getCurrentUser().getCredentials());
    }

}
