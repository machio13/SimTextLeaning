package SimplexText;

public enum Market {
    Prime("Prime", "P"),
    Growth("Growth", "G"),
    Standard("Standard", "S"),
    Non("Nnnn", "nonon");

    private String code;
    private String oneChar;

    Market(String code, String oneChar) {
        this.code = code;
        this.oneChar = oneChar;
    }

    public String getCode() {
        return this.code;
    }

    public String getOneChar() {
        return this.oneChar;
    }

    public static Market fromCode(String code) {
        return switch (code) {
            case "P" -> Prime;
            case "S" -> Standard;
            case "G" -> Growth;
            default -> Non;
        };
    }

}