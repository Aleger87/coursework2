package Enum;

public enum Type {
    PERSONAL("Личная"),
    WORKER("Рабочая");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
