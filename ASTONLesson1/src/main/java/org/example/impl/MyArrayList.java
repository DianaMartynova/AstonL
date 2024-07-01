package org.example.impl;

import org.example.ArList;
import org.example.MyIterator;
import java.util.Iterator;

/**
 * MyArrayList - реализация пользовательского списка на основе массива.
 * Этот класс предоставляет методы для добавления, получения, удаления элементов, очистки.
 *
 * @param <E> тип элементов в этом списке
 */
public class MyArrayList<E> implements ArList<E> {
    /**
     *  Массив элементов
     */
    private E[] values;
    /**
     *  Размер массива
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Создание списка
     */
    public MyArrayList() {//работает корректно
        values = (E[]) new Object[DEFAULT_CAPACITY];
        ;
    }

    /**
     * Добавляет элементы в коллекцию, копирует старый список, добавляет элемент в новый массив и копию
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
            return true;
        } catch (ClassCastException cl) {
            cl.printStackTrace();
        }

        return false;
    }

    /**
     * Достает элемент по индексу
     * @param index индекс элемента
     * @return Возвращает элемент
     */

    @Override
    public E get(int index) {//ok
        return values[index];
    }

    /**
     * Создает новый список увеличивая размер на 1, через цикл перекладывает элементы до индекса,
     * вставляет элемент с нужным индексом и добавляет через цикл остаток
     * @param index индекс элемента
     * @param e элемент
     */
    @Override
    public void add(int index, E e) {//ок
        try {
            E[] myList = values;
            values = (E[]) new Object[myList.length + 1];
            for (int i = 0; i < index; i++)
                values[i] = myList[i];
            values[index] = e;
            for (int i = index + 1; i < values.length; i++)
                values[i] = myList[i - 1];
        }catch (ClassCastException cl) {
            cl.printStackTrace();
        }

    }

    /**Создает новый список копирую туда все элементы кроме элемента удаляемого по индексу
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
    }




    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(values);
    }
}
