package tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.ActionsData;
import pages.ActionsFactory;
import java.util.ArrayList;

public class Commands {
    private CreateApp createApp;

    /** se returneaza instanta platformei**/
    public CreateApp getCreateApp() {
        return createApp;
    }

    /** se seteaza instanta platformei**/
    public void setCreateApp(final CreateApp createApp) {
        this.createApp = createApp;
    }

    /** constructor**/
    public Commands(final CreateApp createApp) {
        this.createApp = createApp;
    }

    /** metoda ce realizeaza actiunea de navigare prin platforma
     * schimband pagina in functie de pagina curenta**/
    public void changePage(final ActionsData actionsData, final ArrayNode output) {
        if (actionsData.getPage().equals("login")
                && (createApp.getCurrentPage().equals("unlogged")
            || createApp.getCurrentPage().equals("logout"))) {
            createApp.setCurrentPage("login");
        } else if (actionsData.getPage().equals("register")
                && createApp.getCurrentPage().equals("unlogged")) {
            createApp.setCurrentPage("register");
        } else if (actionsData.getPage().equals("movies")
                && (createApp.getCurrentPage().equals("logged")
                || createApp.getCurrentPage().equals("see details")
                || createApp.getCurrentPage().equals("upgrades")
                || createApp.getCurrentPage().equals("login"))) {
            createApp.setCurrentPage("movies");
        } else if (actionsData.getPage().equals("upgrades")
                && (createApp.getCurrentPage().equals("logged")
                || createApp.getCurrentPage().equals("see details"))) {
            createApp.setCurrentPage("upgrades");
        } else if (actionsData.getPage().equals("logout")
                && (createApp.getCurrentPage().equals("logged")
                || createApp.getCurrentPage().equals("see details")
                || createApp.getCurrentPage().equals("movies")
                || createApp.getCurrentPage().equals("upgrades")
                || createApp.getCurrentPage().equals("unlogged"))) {
            createApp.setCurrentPage("logout");
        } else if (actionsData.getPage().equals("see details")
                && (createApp.getCurrentPage().equals("movies")
                || createApp.getCurrentPage().equals("see details"))) {
            createApp.setCurrentPage("see details");
        } else if (createApp.getCurrentPage().equals("logged")
                && actionsData.getPage().equals("login")) {
            createApp.setCurrentPage("logged");
            error(output);
        }
    }
    /** metoda prin intermdeiul careia se apeleaza fiecare actiune**/
    public void onPageAction(final ActionsData actionsData, final ArrayNode output) {
        String type = actionsData.getFeature();
        ActionsFactory.create(type).action(actionsData, createApp, output);
    }
    /** metoda ce implementeaza formatul erorii**/
    public void error(final ArrayNode outputData) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        ArrayList<Movie> emptyArray = new ArrayList<>();
        node.put("error", "Error");
        node.putPOJO("currentMoviesList", emptyArray);
        node.putPOJO("currentUser", null);
        outputData.add(node);
    }

    /** metoda ce verifica daca actiunile se pot realiza**/
    public int checkPage(final ActionsData actionsData, final CreateApp createApp) {
        int check = 0;
        if (actionsData.getFeature().equals(createApp.getCurrentPage())
                || (createApp.getCurrentPage().equals("movies")
                && (actionsData.getFeature().equals("filter")
                || actionsData.getFeature().equals("search")))
                || (createApp.getCurrentPage().equals("upgrades")
                && (actionsData.getFeature().equals("buy tokens")
                || actionsData.getFeature().equals("buy premium account")))
                || (createApp.getCurrentPage().equals("see details")
                && (actionsData.getFeature().equals("purchase")
                || actionsData.getFeature().equals("watch")
                || actionsData.getFeature().equals("like")
                || actionsData.getFeature().equals("rate")))) {
            check = 1;
        } else if ((!createApp.getCurrentPage().equals("login")
                && actionsData.getFeature().equals("login"))
                || (!createApp.getCurrentPage().equals("register")
                && actionsData.getFeature().equals("register"))) {
            check = 2;
        } else if ((!createApp.getCurrentPage().equals("movies")
                && (actionsData.getFeature().equals("filter")
                || actionsData.getFeature().equals("search")))
                || (!createApp.getCurrentPage().equals("upgrades")
                && (actionsData.getFeature().equals("buy tokens")
                || actionsData.getFeature().equals("buy premium account")))
                || (!createApp.getCurrentPage().equals("see details")
                && (actionsData.getFeature().equals("purchase")
                || actionsData.getFeature().equals("watch")
                || actionsData.getFeature().equals("like")
                || actionsData.getFeature().equals("rate")))) {
            check = 3;
        }
        return check;
    }

    /** metoda care rezolva efectiv actiunile date din input**/
    public void resolveCommands(final ArrayNode outputData) throws
            JsonProcessingException {
        for (ActionsData actionsData : createApp.getActions()) {

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            if (actionsData.getType().equals("change page")) {
                changePage(actionsData, outputData);
                if (createApp.getCurrentPage().equals("movies")) {
                    ArrayList<Movie> copy = new ArrayList<>();

                    //se verifica daca filmele sunt bannate in tara utilizatorului curent
                    String bannedCountry = createApp.getAccount().getCurrentUser()
                            .getCredentials().getCountry();
                    for (int i = 0; i < createApp.getMovies().size(); i++) {
                        Movie movie = createApp.getMovies().get(i);
                        if (!movie.getCountriesBanned().contains(bannedCountry)) {
                            copy.add(movie);
                        }
                    }
                    createApp.getAccount().getCurrentMovieList().clear();
                    createApp.getAccount().getCurrentMovieList().addAll(copy);

                    ArrayList<Movie> movies = new ArrayList<>();

                    for (int i = 0; i < copy.size(); i++) {
                        movies.add(new Movie(copy.get(i)));
                    }

                    //deep copy pentru user-ul curent ce va fi afisat la output
                    User user = new User(createApp.getAccount().getCurrentUser());

                    node.putPOJO("error", createApp.getAccount().getError());
                    node.putPOJO("currentMoviesList", movies);
                    node.putPOJO("currentUser", user);
                    outputData.add(node);
                } else if (createApp.getCurrentPage().equals("see details")) {
                    int check = 0;
                    ArrayList<Movie> theMovie = new ArrayList<>();
                    for (int i = 0; i < createApp.getAccount().getCurrentMovieList().size(); i++) {
                        Movie movie = createApp.getAccount().getCurrentMovieList().get(i);

                        //se verifica daca exista filmul caruia i se cere afisarea detaliilor
                        if (actionsData.getMovie().equals(movie.getName())) {
                            check = 1;
                            theMovie.add(new Movie(movie));
                            createApp.setSeeMovie(movie);

                            User user = new User(createApp.getAccount().getCurrentUser());
                            node.putPOJO("error", createApp.getAccount().getError());
                            node.putPOJO("currentMoviesList", theMovie);
                            node.putPOJO("currentUser", user);
                            outputData.add(node);
                        }
                    }
                    if (check == 0) {
                        error(outputData);
                    }
                }
            } else if (actionsData.getType().equals("on page")) {
                int check = checkPage(actionsData, createApp);
                if (check == 1) {
                    onPageAction(actionsData, outputData);
                    if (actionsData.getFeature().equals("search")) {
                        ArrayList<Movie> copy = new ArrayList<>();

                        for (int i = 0; i < createApp.getSearchedMovies().size(); i++) {
                            copy.add(new Movie(createApp.getSearchedMovies().get(i)));
                        }

                        User user = new User(createApp.getAccount().getCurrentUser());

                        node.putPOJO("error", null);
                        node.putPOJO("currentMoviesList", copy);
                        node.putPOJO("currentUser", user);
                        outputData.add(node);
                    } else if (actionsData.getFeature().equals("login")) {
                        ArrayList<Movie> movies = new ArrayList<>();
                        if (createApp.getAccount().getCurrentUser() != null) {
                            User user = new User(createApp.getAccount().getCurrentUser());
                            node.putPOJO("error", createApp.getAccount().getError());
                            node.putPOJO("currentMoviesList", movies);
                            node.putPOJO("currentUser", user);
                            outputData.add(node);
                        } else {
                            error(outputData);
                        }
                    } else if (actionsData.getFeature().equals("buy tokens")
                            || actionsData.getFeature().equals("buy premium account")) {
                        continue;
                    } else if (actionsData.getFeature().equals("purchase")
                            && createApp.getSeeMovie() != null) {
                        User user = new User(createApp.getAccount().getCurrentUser().
                                getCredentials());
                        user.setTokensCount(createApp.getAccount().getCurrentUser().
                                getTokensCount());
                        user.setNumFreePremiumMovies(createApp.getAccount().getCurrentUser().
                                getNumFreePremiumMovies());
                        user.getPurchasedMovies().add(new Movie(createApp.getSeeMovie()));
                        ArrayList<Movie> movie = new ArrayList<>();
                        movie.add(new Movie(createApp.getSeeMovie()));
                        node.putPOJO("error", createApp.getAccount().getError());
                        node.putPOJO("currentMoviesList", movie);
                        node.putPOJO("currentUser", user);
                        outputData.add(node);
                    } else if (actionsData.getFeature().equals("watch")
                            && createApp.getSeeMovie() != null) {
                        Movie movie = createApp.getSeeMovie();
                        if (createApp.getAccount().getCurrentUser().getPurchasedMovies().
                                contains(movie)) {
                            ArrayList<Movie> newMovie = new ArrayList<>();
                            newMovie.add(new Movie(createApp.getSeeMovie()));
                            User user = new User(createApp.getAccount().getCurrentUser().
                                    getCredentials());
                            user.setTokensCount(createApp.getAccount().getCurrentUser().
                                    getTokensCount());
                            user.setNumFreePremiumMovies(createApp.getAccount().getCurrentUser().
                                    getNumFreePremiumMovies());
                            user.getPurchasedMovies().add(new Movie(createApp.getSeeMovie()));
                            user.getWatchedMovies().add(new Movie(createApp.getSeeMovie()));
                            node.putPOJO("error", createApp.getAccount().getError());
                            node.putPOJO("currentMoviesList", newMovie);
                            node.putPOJO("currentUser", user);
                            outputData.add(node);
                        } else {
                           error(outputData);
                        }
                    } else if (actionsData.getFeature().equals("like")) {
                        Movie movie = createApp.getSeeMovie();
                        for (int i = 0; i < createApp.getAccount().getCurrentUser().
                                getWatchedMovies().size(); i++) {
                            if (createApp.getAccount().getCurrentUser().getWatchedMovies().get(i).
                                    getName().equals(movie.getName())) {
                                ArrayList<Movie> newMovie = new ArrayList<>();
                                User user = createApp.getAccount().getCurrentUser();
                                newMovie.add(movie);
                                node.putPOJO("error", createApp.getAccount().getError());
                                node.putPOJO("currentMoviesList", newMovie);
                                node.putPOJO("currentUser", user);
                                outputData.add(node);
                            } else {
                                error(outputData);
                            }
                        }
                    } else if (actionsData.getFeature().equals("rate")) {
                        Movie movie = createApp.getSeeMovie();
                        if (createApp.getAccount().getCurrentUser().getWatchedMovies().
                                contains(movie)) {
                            ArrayList<Movie> newMovie = new ArrayList<>();
                            newMovie.add(new Movie(createApp.getSeeMovie()));
                            User user = createApp.getAccount().getCurrentUser();
                            node.putPOJO("error", createApp.getAccount().getError());
                            node.putPOJO("currentMoviesList", newMovie);
                            node.putPOJO("currentUser", user);
                            outputData.add(node);
                        } else {
                            error(outputData);
                        }
                    } else {
                        ArrayList<Movie> movies = new ArrayList<>();
                        for (int i = 0; i < createApp.getFilteredMovies().size(); i++) {
                            movies.add(new Movie(createApp.getFilteredMovies().get(i)));
                        }

                        User user = new User(createApp.getAccount().getCurrentUser());
                        node.putPOJO("error", createApp.getAccount().getError());
                        node.putPOJO("currentMoviesList", movies);
                        node.putPOJO("currentUser", user);
                        outputData.add(node);
                    }
                } else if (check == 2) {
                    createApp.setCurrentPage("logged");
                    error(outputData);
                } else if (check == 3) {
                    error(outputData);
                }
            }
        }
    }
}
