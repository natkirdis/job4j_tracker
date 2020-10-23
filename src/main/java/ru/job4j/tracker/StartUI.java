package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println("id: " + item.getId() + ", name: " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                String name = input.askStr("Enter new name: ");
                Item item = new Item(name);
                item.setId(id);
                if (tracker.replace(id, item)) {
                    System.out.println("Item with id " + id + " updated.");
                } else {
                    System.out.println("Operation failed. There is no item with id " + id + ".");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                if (tracker.delete(id)) {
                    System.out.println("Item with id " + id + " deleted.");
                } else {
                    System.out.println("Operation failed. There is no item with id " + id + ".");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Item with id " + item.getId() + ": " + item.getName());
                } else {
                    System.out.println("There is no item with id " + id + ".");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println("id: " + item.getId() + ", name: " + item.getName());
                    }
                } else {
                    System.out.println(("There is no item with name " + name + "."));
                }
            } else if (select == 6) {
                System.out.println("=== Quit ====");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}