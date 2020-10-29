package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            out.println("Item with id " + id + " updated.");
        } else {
            out.println("Operation failed. There is no item with id " + id + ".");
        }
        return true;
    }
}
