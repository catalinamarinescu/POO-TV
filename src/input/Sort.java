package input;

public final class Sort {
    private String rating;
    private String duration;

    /** se returneaza tipul de sortare al rating-ului**/
    public String getRating() {
        return rating;
    }
    /** se seteaza tipul de sortare al rating-ului**/
    public void setRating(final String rating) {
        this.rating = rating;
    }
    /** se returneaza tipul de sortare al lungimii**/
    public String getDuration() {
        return duration;
    }
    /** se seteaza tipul de sortare al lungimii**/
    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
