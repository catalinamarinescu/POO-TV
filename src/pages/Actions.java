package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionsData;
import tools.CreateApp;

public abstract class Actions {
    /** metoda ce implementeaza actiunile ce va fi suprascrisa de celelalte clase**/
    public abstract void action(ActionsData actionsData, CreateApp createApp,
                                ArrayNode output);
}
