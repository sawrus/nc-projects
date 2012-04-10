package com.games.time;

public enum TimeConstants {
    TIME("time"),
    EVENT("event"),
    DEFINITION("definition"),
    X("x"),
    Y("y"),
    VIEW_MODE("view_mode"),
    DIRECTION("direction")
    ;

    private String name;

    private TimeConstants(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum ViewMode {
        R,
        W,
        RW
    }

    public enum Direction {
        LEFT,
        RIGHT,
        TOP,
        DOWN
    }
}
