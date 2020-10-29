package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("Item with id " + item.getId() + ": " + item.getName());
        } else {
            out.println("There is no item with id " + id + ".");
        }
        return true;
    }
}
