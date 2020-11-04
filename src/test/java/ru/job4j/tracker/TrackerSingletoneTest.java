package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingletoneTest {

    @Test
    public void whenStaticClassLazy() {
        Tracker trackerOne = TrackerStaticClass.getInstance();
        Tracker trackerTwo = TrackerStaticClass.getInstance();
        assertSame(trackerOne, trackerTwo);
    }

    @Test
    public void whenStaticFieldEager() {
        Tracker trackerOne = TrackerEagerLoading.getInstance();
        Tracker trackerTwo = TrackerEagerLoading.getInstance();
        assertSame(trackerOne, trackerTwo);
    }

    @Test
    public void whenStaticFieldLazy() {
        Tracker trackerOne = TrackerLazyLoading.getInstance();
        Tracker trackerTwo = TrackerLazyLoading.getInstance();
        assertSame(trackerOne, trackerTwo);
    }

    @Test
    public void whenEnum() {
        Tracker trackerOne = TrackerEnum.INSTANCE.getTracker();
        Tracker trackerTwo = TrackerEnum.INSTANCE.getTracker();
        assertSame(trackerOne, trackerTwo);
    }
}