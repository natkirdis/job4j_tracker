package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item with id " + id + " deleted.");
        } else {
            System.out.println("Operation failed. There is no item with id " + id + ".");
        }
        return true;
    }
}
