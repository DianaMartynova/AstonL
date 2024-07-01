package org.example;
/**
 * ArList -.
 * Интерфейс предоставляет методы для добавления, получения, удаления элементов, очистки и .
 *Интерфейс ArList<E> наследуется от Iterable
 * @param <E> тип элементов в этом списке
 */
public interface ArList<E> extends Iterable<E> {
    /**
     * Добавляет элементы в список
     * @param e - элемент
     * @return Возвращает true если элемент добавлен и false если нет
     */
    boolean add(E e);

    /**
     * Достает по индексу элемент
     * @param index индекс элемента
     * @return возвращает элемент
     */
    E get(int index);

    /**
     * Добавление по индексу
     * @param index индекс элемента
     * @param e элемент
     */
    void add(int index, E e);

    /**Удаляет элемент по индексу
     *
     * @param index-индекс удаляемого элемента
     */

    void delete(int index);

    /**
     * Удаляет всю коллекцию
     */

    void deleteAll();
}
