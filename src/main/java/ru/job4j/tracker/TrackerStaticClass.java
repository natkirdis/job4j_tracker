package ru.job4j.tracker;

public class TrackerStaticClass {
    private TrackerStaticClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerStaticClass.getInstance();
    }

}