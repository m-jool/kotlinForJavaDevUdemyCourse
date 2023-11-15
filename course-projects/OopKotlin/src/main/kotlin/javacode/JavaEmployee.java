package javacode;

public class JavaEmployee {
    private final String name;
    private final boolean fullTime;

    public JavaEmployee(String name) {
        this.name = name;
        this.fullTime = true;
    }

    public JavaEmployee(String name, boolean fullTime) {
        this.name = name;
        this.fullTime = fullTime;
    }
}
