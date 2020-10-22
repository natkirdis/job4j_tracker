package ru.job4j.tracker;

import javax.print.attribute.standard.NumberUp;
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
        return Arrays.copyOf(items, size);
    }

    /**
     * Метод ищет заявку с заданным id
     * @param id для поиска заявки
     * @return возвращает заявку, id которой равен значению параметра
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < this.size; index++) {
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
        Item[] itemsResult = new Item[this.size];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemsResult[size] = item;
                size++;
            }
        }
        itemsResult = Arrays.copyOf(itemsResult, size);
        return itemsResult;
    }

    /**
     * Метод редактироует название заявки с указанным id
     * @param id - id заявки, которую необходимо отредактировать
     * @param item - объект с новым именем
     */
    public boolean replace(int id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.size; index++) {
            if (items[index].getId() == id) {
                items[index].setName(item.getName());
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
        for (int index = 0; index < this.size; index++) {
            if (items[index].getId() == id) {
                for (int i = id - 1; i < this.size - 1; i++) {
                    items[i].setName(items[i + 1].getName());
                    items[i].setId(items[i + 1].getId());
                }
                size--;
                result = true;
                break;
            }
        }
        return result;
    }
}