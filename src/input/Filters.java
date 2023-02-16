package input;

public final class Filters {
    private Sort sort;
    private Contains contains;

    /** se returneaza filtrul de tip sort**/
    public Sort getSort() {
        return sort;
    }
    /** se seteaza filtrul de tip sort**/
    public void setSort(final Sort sort) {
        this.sort = sort;
    }
    /** se returneaza filtrul de continut**/
    public Contains getContains() {
        return contains;
    }
    /** se seteaza filtrul de continut**/
    public void setContains(final Contains contains) {
        this.contains = contains;
    }
}
