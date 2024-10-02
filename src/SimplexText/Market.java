package SimplexText;

public enum Market {
    Prime("PRIME"),
    Growth("GROWS"),
    Standard("STANDARD"),
    N("---");

    private final String code;

    Market(String code) {
        this.code = code;

    }

    public static Market fromCode(String code) {
        return switch (code) {
            case "P" -> Prime;
            case "S" -> Standard;
            case "G" -> Growth;
            default -> N;
        };
    }
}
