package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.CreateApp;
public class Search extends Actions {
    /** metoda ce implementeaza actiunea de search**/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {
        for (int i = 0; i < createApp.getAccount().getCurrentMovieList().size(); i++) {
            if (actionsData.getStartsWith().startsWith(createApp.getAccount().
                    getCurrentMovieList().get(i).getName())) {
                createApp.getSearchedMovies().add(createApp.getAccount().
                        getCurrentMovieList().get(i));
            }
        }
    }
}
