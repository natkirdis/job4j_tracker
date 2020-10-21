package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    /**
     * Массив для хранение заявок
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки
     */
    private int ids = 1;

    /**
     * Счетчик для присваивания уникального id при добавлении заявки
     */
    private int size = 0;

    /**
     * Метод для добавление заявки в хранилище
     * @param item новая заявка
     * @return Item добавленная заявка
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод находит все заявки с заданным именем заявки
     * @return возвращает массив заявок с заданным именем без null элементов
     */
    public Item[] findAll(){
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    /**
     * Метод ищет заявку с заданным id
     * @param id для поиска заявки
     * @return возвращает заявку, id которой равен значению параметра
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит все заявки с заданным именем заявки
     * @param key имя заявки
     * @return возвращает массив заявок с заданным именем без null элементов
     */
    public Item[] findByName(String key) {
        Item[] itemsResult = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if ((item != null) && (item.getName().equals(key))) {
                itemsResult[size] = item;
                size++;
            }
        }
        itemsResult = Arrays.copyOf(itemsResult, size);
        return itemsResult;
    }
}