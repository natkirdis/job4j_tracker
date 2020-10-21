package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test");
        tracker.add(item);
        Item result = tracker.findById(1);
        System.out.println("id: " + result.getId() + ", name: " + result.getName());
    }
}
