package ru.job4j.tracker;

public enum TrackerEnum {
    INSTANCE;
    Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}