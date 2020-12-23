package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SortByNameItemTest {

    @Test
    public void sortAscByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("9"),
                new Item("5"),
                new Item("7")
        );
        List<Item> check = Arrays.asList(
                items.get(1),
                items.get(2),
                items.get(0)
        );
        Collections.sort(items, new SortAscByNameItem());
        assertThat(items, is(check));
    }

    @Test
    public void SortDescByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("9"),
                new Item("5"),
                new Item("7")
        );
        List<Item> check = Arrays.asList(
                items.get(0),
                items.get(2),
                items.get(1)
        );
        Collections.sort(items, new SortDescByNameItem());
        assertThat(items, is(check));
    }
}