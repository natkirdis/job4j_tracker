package ru.job4j.tracker;

public class TrackerEagerLoading {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerEagerLoading() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerEagerLoading.getInstance();
    }
}