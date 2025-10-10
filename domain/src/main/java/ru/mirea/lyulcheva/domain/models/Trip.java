package ru.mirea.lyulcheva.domain.models;

public class Trip {
    private int id;
    private String name;
    private boolean isFavourite;

    public Trip(int id, String name) {
        this.id = id;
        this.name = name;
        this.isFavourite = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}