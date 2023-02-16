package tools;

import input.*;

import java.util.ArrayList;

public class User {
    private CredentialsInput credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;

    /** se returneaza datele user-ului**/
    public CredentialsInput getCredentials() {
        return credentials;
    }
    /** se seteaza datele user-ului**/
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }
    /** se returneaza numarul de token-uri**/
    public int getTokensCount() {
        return tokensCount;
    }
    /** se seteaza numarul de token-uri**/
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }
    /** se returneaza numarul de filme gratuite**/
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }
    /** se seteaza numarul de filme gratuite**/
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }
    /**se returneaza filmele cumparate **/
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }
    /** se seteaza filmele cumparate**/
    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }
    /** se returneaza filmele vizionate**/
    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }
    /** se seteaza filmele vizionatee**/
    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
    /** se returneaza filmele apreciate**/
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }
    /** se seteaza filmele apreciate**/
    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
    /**se returneaza filmele carora li s-a dat rating **/
    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }
    /** se seteaza filmele carora li s-a dat rating**/
    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    /** constructor**/
    public User() {}

    /** constructor ce initializeaza fiecare camp cu datele din input**/
    public User(final CredentialsInput credentialsInput) {
        this.credentials = credentialsInput;
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
    }

    /** copyConstructor**/
    public User(final User user) {
        this.credentials = new CredentialsInput(user.getCredentials());
        this.tokensCount = user.getTokensCount();
        this.numFreePremiumMovies = user.getNumFreePremiumMovies();
        this.purchasedMovies = new ArrayList<>(user.getPurchasedMovies());
        this.watchedMovies = new ArrayList<>(user.getWatchedMovies());
        this.likedMovies = new ArrayList<>(user.getLikedMovies());
        this.ratedMovies = new ArrayList<>(user.getRatedMovies());
    }

}
