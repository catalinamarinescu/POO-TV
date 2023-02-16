package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.ActionsData;
import tools.CreateApp;
import tools.Movie;
import tools.User;

public class SeeDetails extends Actions {
    /** metoda ce implementeaza actiunile ce pot fi realizate pe pagina de "see details"**/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {
        if (actionsData.getFeature().equals("purchase")) {
               Movie movie = createApp.getSeeMovie();
               createApp.getAccount().getCurrentUser().getPurchasedMovies().add(movie);
               int num = createApp.getAccount().getCurrentUser().getNumFreePremiumMovies();
               createApp.getAccount().getCurrentUser().setNumFreePremiumMovies(num - 1);
        } else if (actionsData.getFeature().equals("watch")) {
            Movie movie = createApp.getSeeMovie();
            if (createApp.getAccount().getCurrentUser().getPurchasedMovies().contains(movie)) {
                createApp.getAccount().getCurrentUser().getWatchedMovies().add(movie);
            }
        } else if (actionsData.getFeature().equals("like")) {
            if (createApp.getAccount().getCurrentUser().getWatchedMovies().
                    contains(createApp.getSeeMovie())) {
                User user = createApp.getAccount().getCurrentUser();
                Movie movie = createApp.getSeeMovie();
                movie.setNumLikes(movie.getNumLikes() + 1);
                user.getLikedMovies().add(movie);

            }
        } else if (actionsData.getFeature().equals("rate")) {
            Movie movie = createApp.getSeeMovie();
            if (createApp.getAccount().getCurrentUser().getWatchedMovies().contains(movie)){

            }
        }
    }
}
