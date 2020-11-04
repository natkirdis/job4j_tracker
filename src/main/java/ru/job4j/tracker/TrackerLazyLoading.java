package ru.job4j.tracker;

public class TrackerLazyLoading {

    private static Tracker instance = new Tracker();

    private TrackerLazyLoading() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerLazyLoading.getInstance();
    }
}