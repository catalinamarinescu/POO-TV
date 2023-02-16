package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.Account;
import tools.CreateApp;
public class Login extends Actions {
    /** metoda ce realizeaza actiunea de login**/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {

        String userName = actionsData.getCredentials().getName();
        String userPassword = actionsData.getCredentials().getPassword();
        int checkExistence = 0;
        for (int i = 0; i < createApp.getUsers().size(); i++) {
            String checkName = createApp.getUsers().get(i).getCredentials().getName();
            String checkPassword = createApp.getUsers().get(i).getCredentials().getPassword();
            if (userName.equals(checkName) && userPassword.equals(checkPassword)) {
                createApp.setCurrentPage("logged");
                createApp.setAccount(new Account(null, createApp.getUsers().get(i)));
                checkExistence = 1;
            }
        }
        if (checkExistence == 0) {
            createApp.setCurrentPage("unlogged");
            createApp.setAccount(new Account("Error", null));
        }
    }
}
