package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.CreateApp;

public class Upgrades extends Actions {
    /** metoda ce realizeaza cele doua actiuni ce pot fi facute pe pagina "uppgrades"**/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {
            if (actionsData.getFeature().equals("buy tokens")) {
                int oldTokens = createApp.getAccount().getCurrentUser().getTokensCount();
                int newTokens = Integer.parseInt(actionsData.getCount());
                int balance = Integer.parseInt(createApp.getAccount().getCurrentUser().
                        getCredentials().getBalance());

                createApp.getAccount().getCurrentUser().setTokensCount(oldTokens + newTokens);
                int newBalance = balance - newTokens;
                createApp.getAccount().getCurrentUser().getCredentials().setBalance(Integer.
                        toString(newBalance));

            } else if (actionsData.getFeature().equals("buy premium account")) {
                createApp.getAccount().getCurrentUser().getCredentials().setAccountType("premium");
                int oldTokens = createApp.getAccount().getCurrentUser().getTokensCount();
                createApp.getAccount().getCurrentUser().setTokensCount(oldTokens - 10);
            }
    }
}
