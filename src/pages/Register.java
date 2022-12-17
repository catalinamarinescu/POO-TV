package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.Account;
import tools.CreateApp;
import tools.User;

public class Register extends Actions {
    /** **/
    @Override
    public void action(final ActionsData actionsData, final CreateApp createApp,
                       final ArrayNode output) {
            String newName = actionsData.getCredentials().getName();
            String newPassword = actionsData.getCredentials().getPassword();
            int checkExistence = 0;

            for (int i = 0; i < createApp.getUsers().size(); i++) {
                String name = createApp.getUsers().get(i).getCredentials().getName();
                String password = createApp.getUsers().get(i).getCredentials().getPassword();
                if (newName.equals(name) && newPassword.equals(password)) {
                    checkExistence = 1;
                    break;
                }
            }
            if (checkExistence == 0) {
                User newUser = new User(actionsData.getCredentials());
                createApp.getUsers().add(newUser);

                createApp.setAccount(new Account(null, newUser));
                createApp.setCurrentPage("logged");
            }

    }
}
