package ru.mirea.lyulcheva.domain.models;

public class Trip {
    private int id;
    private String name;
    private String description;
    private String imageName;

    private boolean favourite = false;

    public Trip(int id, String name, String description, String imageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageName = imageName;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getImageName() { return imageName; }
    public boolean isFavourite() { return favourite; }
    public void setFavourite(boolean favourite) { this.favourite = favourite; }
}