package com.igt.control.sort;

public enum Direction {

    ASCENDING(-1), DESCENDING(1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

}