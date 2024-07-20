package org.example;

/**
 * LinkList - это пользовательский интерфейс списка.
 * Он предоставляет методы для добавления, получения, удаления элементов, очистки списка .
 *
 * @param <E> тип элементов в этом списке
 */
public interface LinkList<E> extends Iterable<E> {
    /**
     * Добавляет элемент в начало или конец списка.
     *
     * @param e элемент для добавления в список
     **/
    void add(E e);

    /**
     * Удаляет по индексу элемент.
     *
     * @param index индекс для удаления
     **/

    void delete(int index);

    void sort();

    /**
     * Удаляет весь список
     */
    void deleteAll();

    /**
     * Получает элемент по индексу
     *
     * @param index - индекс
     * @return вернет элемент
     */

    E getElementByIndex(int index);

    /**
     * @return Вернет размер списка
     */
    int size();

}
