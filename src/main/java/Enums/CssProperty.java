package Enums;

public enum CssProperty {
    COLOR("color"),
    BACKGROUND_COLOR("background-color");

    CssProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    private final String propertyName;

    public String getPropertyName() {
        return propertyName;
    }
}


