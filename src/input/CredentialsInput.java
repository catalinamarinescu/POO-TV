package input;

public final class CredentialsInput {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    /** se returneaza numele utilizatorului **/
    public String getName() {
        return name;
    }
    /** se seteaza numele utilizatorului **/
    public void setName(final String name) {
        this.name = name;
    }
    /** se returneaza parola**/
    public String getPassword() {
        return password;
    }
    /** se seteaza parola**/
    public void setPassword(final String password) {
        this.password = password;
    }
    /** se returneaza tippul contului**/
    public String getAccountType() {
        return accountType;
    }
    /** se seteaza tipul contului**/
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
    /** se returneaza tara de provenienta a utilizatorului**/
    public String getCountry() {
        return country;
    }
    /** se seteaza tara de provenienta a utilizatorului**/
    public void setCountry(final String country) {
        this.country = country;
    }
    /** se returneaza balanta curenta**/
    public String getBalance() {
        return balance;
    }
    /** se seteaza balanta curenta **/
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    /** constructor **/
    public CredentialsInput() {}

    /** copyConstructor **/
    public CredentialsInput(final CredentialsInput credentialsInput) {
        this.name = credentialsInput.getName();
        this.password = credentialsInput.getPassword();
        this.balance = credentialsInput.getBalance();
        this.country = credentialsInput.getCountry();
        this.accountType = credentialsInput.getAccountType();
    }
}
