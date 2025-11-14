package ru.mirea.lyulcheva.fragmentapp.model;

public class Task {

    private String title;
    private boolean done;

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean value) {
        this.done = value;
    }
}
