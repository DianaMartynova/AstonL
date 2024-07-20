package org.example.impl;

import org.example.ArList;
import org.example.MyIterator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


/**
 * MyArrayList - реализация пользовательского списка на основе массива.
 * Этот класс предоставляет методы для добавления, получения, удаления элементов, очистки.
 *
 * @param <E> тип элементов в этом списке
 */
public class MyArrayList<E> implements ArList<E> {

    /**
     * Массив элементов
     */
    private E[] values;
    /**
     * Переменная счетчик размера
     */
    private int size = 0;
    /**
     * Размер массива
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Создание списка
     */
    MyIterator myIterator = new MyIterator<>(null);

    public MyArrayList() {//работает корректно
        values = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        ;
    }

    private void arrSize(E e) {

    }

    /**
     * Добавляет элементы в коллекцию, копирует старый список, добавляет элемент в новый массив и копию
     *
     * @param e - элемент
     * @return Возвращает true если элемент добавлен и false если нет
     */
    @Override
    public boolean add(E e) { //работает корректно
        try {
            E[] myList = values;
            values = (E[]) new Object[myList.length + 1];
            System.arraycopy(myList, 0, values, 0, myList.length);
            values[values.length - 11] = e;
            size++;
            return true;
        } catch (ClassCastException cl) {
            cl.printStackTrace();
        }

        return false;
    }

    /**
     * Возвращает размер списка
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Достает элемент по индексу
     *
     * @param index индекс элемента
     * @return Возвращает элемент
     */

    @Override
    public E get(int index) {//ok
        return values[index];
    }

    /**
     * Сортирует список
     */
    @Override
    public void sort() {
        Arrays.sort((E[]) values, 0, size, comparator());

    }


    /**
     * Возвращает компаратор для сравнения объектов
     *
     * @return компаратор для сравнения объектов
     */
    private Comparator<E> comparator() {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return ((Comparable<E>) o1).compareTo(o2);
        };
    }

    /**
     * Создает новый список увеличивая размер на 1, через цикл перекладывает элементы до индекса,
     * вставляет элемент с нужным индексом и добавляет через цикл остаток
     *
     * @param index индекс элемента
     * @param e     элемент
     */
    @Override
    public void add(int index, E e) {//ок
        try {
            E[] myList = values;
            values = (E[]) new Object[myList.length + 1];
            for (int i = 0; i < index; i++)
                values[i] = myList[i];
            values[index] = e;
            size++;
            for (int i = index + 1; i < values.length; i++)
                values[i] = myList[i - 1];
        } catch (ClassCastException cl) {
            cl.printStackTrace();
        }

    }


    /**
     * Создает новый список копирую туда все элементы кроме элемента удаляемого по индексу
     *
     * @param index-индекс удаляемого элемента
     */
    @Override
    public void delete(int index) {//работает корректно
        try {
            E[] myList = values;
            values = (E[]) new Object[myList.length - 1];
            System.arraycopy(myList, 0, values, 0, index);
            int elementAfterIndex = myList.length - index - 1;
            System.arraycopy(myList, index + 1,
                    values, index, elementAfterIndex);
            size--;

        } catch (ClassCastException cl) {
            cl.printStackTrace();
        }

    }


    /**
     * Создает новый пустой список
     */
    @Override
    public void deleteAll() {//работает корректно
        this.values = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(values);
    }


}
