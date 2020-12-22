package ru.job4j.tracker;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    /**
     * Массив для хранение заявок
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод для добавление заявки в хранилище
     * @param item новая заявка
     * @return Item добавленная заявка
     */
    public Item add(Item item) {
        item.setId(items.size() + 1);
        items.add(item);
        return item;
    }

    /**
     * Метод находит все заявки с заданным именем заявки
     * @return возвращает массив заявок с заданным именем без null элементов
     */
    public List<Item> findAll(){
        return items;
    }

    /**
     * Метод ищет заявку с заданным id
     * @param id для поиска заявки
     * @return возвращает заявку, id которой равен значению параметра
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
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
    public List<Item> findByName(String key) {
        List<Item> itemsResult = new ArrayList<>();
        int size = 0;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                itemsResult.add(item);
            }
        }
        return itemsResult;
    }

    /**
     * Метод редактироует название заявки с указанным id
     * @param id - id заявки, которую необходимо отредактировать
     * @param item - объект с новым именем
     */
    public boolean replace(int id, Item item) {
        boolean result = false;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                items.get(index).setName(item.getName());
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку с указанным id
     * @param id - id заявки, которую необходимо удалить
     */
    public boolean delete(int id) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index > -1) {
            this.items.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * Поиск индекса заявки по id.
     * @param id Id заявки.
     * @return Индекс заявки в трекере. -1 означает отсутствие заявки в трекере.
     */
    private int findIndex(int id) {
        boolean result = false;
        int index = 0;
        for (Item item : this.items) {
            if (item != null && id == item.getId()) {
                result = true;
                break;
            }
            index++;
        }
        return result ? index : -1;
    }
}