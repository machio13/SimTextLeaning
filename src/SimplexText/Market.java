package SimplexText;

public enum Market {
    P("PRIME"),
    G("GROWS"),
    S("STANDARD"),
    N("---");

    private final String code;

    Market(String code) {
        this.code = code;

    }

    public static Market fromCode(String code) {
        return switch (code) {
            case "Prime" -> P;
            case "Standard" -> S;
            case "Grows" -> G;
            default -> N;
        };
    }
}
