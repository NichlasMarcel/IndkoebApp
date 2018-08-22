package com.example.myapplication.Common;

public class Grocery {
    String name;
    boolean found = false;

    public Grocery(String name, boolean found) {
        this.name = name;
        this.found = found;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
