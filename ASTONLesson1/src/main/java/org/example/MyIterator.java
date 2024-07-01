package org.example;

import java.util.Iterator;
/**
 * MyIterator<E> реализует Iterator<E> способный перемещаться по элементам с помощью методов hasNext() и next(),
 *  и, к тому же, предлагающий возможность удалять элементы с помощью метода remove().
 */

public class MyIterator<E> implements Iterator<E> {
    /**
     * Индекс, который указывает на то какой элемент нам нужен
     */
    private int index = 0;
    /**
     *  Массив элементов
     */

    E[] values;

    /**Конструктор для массива
     *
     * @param values-массив элементов
     */
    public MyIterator(E[] values) {
        this.values = values;
    }
/**
Метод смотрит есть ли что нам возвращать, есть ли еще место
 */
    @Override
    public boolean hasNext() {
        return index<values.length;
    }
    /**
Возвращает эллемент по индексу, "++"- после того как операция выполнится индекс увеличивается на 1
     */
    @Override
    public E next() {
        return values[index++];
    }


}
