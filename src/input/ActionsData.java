package input;

public final class ActionsData {
    private String type;
    private String page;
    private String feature;
    private CredentialsInput credentials;
    private String movie;
    private String startsWith;
    private Filters filters;
    private String count;
    private int rate;

    /** se returneaza tipul actiunii **/
    public String getType() {
        return type;
    }
    /** se seteaza tipul actiunii **/
    public void setType(final String type) {
        this.type = type;
    }
    /** se seteaza tipul paginii **/
    public String getPage() {
        return page;
    }
    /** se seteaza tipul paginii **/
    public void setPage(final String page) {
        this.page = page;
    }
    /** se returneaza numele actiunii **/
    public String getFeature() {
        return feature;
    }
    /** se seteaza tipul actiunii **/
    public void setFeature(final String feature) {
        this.feature = feature;
    }
    /** se returneaza datele utilizatorului **/
    public CredentialsInput getCredentials() {
        return credentials;
    }
    /** se seteaza datele utilizatorului **/
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }
    /**se returneaza numele filmului **/
    public String getMovie() {
        return movie;
    }
    /**se seteaza numele filmului **/
    public void setMovie(final String movie) {
        this.movie = movie;
    }
    /** se returneaza inceputul titlului **/
    public String getStartsWith() {
        return startsWith;
    }
    /** se seteaza inceputul titlului **/
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }
    /** se returneaza filtrele**/
    public Filters getFilters() {
        return filters;
    }
    /**se seteaza filtrele **/
    public void setFilters(final Filters filters) {
        this.filters = filters;
    }
    /** se returneaza numarul cu care vor creste sau scadea anumite campuri**/
    public String getCount() {
        return count;
    }
    /** se seteaza numarul cu care vor creste sau scadea anumite campuri**/
    public void setCount(final String count) {
        this.count = count;
    }
    /** se returneaza rating-ul**/
    public int getRate() {
        return rate;
    }
    /**se seteaza rateing-ul **/
    public void setRate(final int rate) {
        this.rate = rate;
    }
}
