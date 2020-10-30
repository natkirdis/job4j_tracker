package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        Input input = new ValidateInput(out, in);
        int selected = input.askInt("Enter number");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"test", "1"}
        );
        Input input = new ValidateInput(out, in);
        int selected = input.askInt("Enter number");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"test", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter number");
        String expected = "Please enter validate data again." + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }
}
