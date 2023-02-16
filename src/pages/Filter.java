package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.CreateApp;

public class Filter extends Actions {
    /** **/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {
        createApp.setFilteredMovies(createApp.getAccount().getCurrentMovieList());
    }
}
