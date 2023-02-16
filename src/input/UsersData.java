package input;

import java.util.ArrayList;

public final class UsersData {
    private CredentialsInput credentials;

    /** se returneaza datele utilizatorului**/
    public CredentialsInput getCredentials() {
        return credentials;
    }
    /** se seteaza datele utilizatorului**/
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

}
