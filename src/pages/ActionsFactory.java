package pages;

public final class ActionsFactory {
    /** metoda ce creeaza instante ale claselor ce mostenesc
     * clasa parinte in functie de numele actiunii**/
    public static Actions create(final String type) {
        return switch (type) {
            case "register" -> new Register();
            case "login" -> new Login();
            case "search" -> new Search();
            case "filter" -> new Filter();
            case "buy tokens", "buy premium account" -> new Upgrades();
            case "purchase", "watch", "like", "rate" -> new SeeDetails();
            case "logout" -> new Logout();
            default -> null;
        };
    }
}
