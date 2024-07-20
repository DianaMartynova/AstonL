package org.example.impl;


import org.example.LinkList;

import java.util.Comparator;
import java.util.Iterator;

/**
 * MyLinkedList - реализация пользовательского списка на основе двусвязного списка.
 * Этот класс предоставляет методы для добавления, получения, удаления элементов, очистки.
 *
 * @param <E> тип элементов в этом списке
 */
public class MyLinkedList<E> implements LinkList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    /**
     * Конструктор с созданием Node
     */
    public MyLinkedList() {
        lastNode = new Node<>(null, null, firstNode);
        firstNode = new Node<>(null, lastNode, null);
    }

    /**
     * Вставка элементов, создается новая ссылка, в нее кладем элемент е, и связываем со следующей(последней) Node
     * @param e = элемент для вставки
     */

    private void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<>(null, null, prev);
        prev.setNextElement(lastNode);
        size++;

    }

    /**
     * Добавляет элемент в начало списка
     * @param e=элемент
     */

    private void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        size++;
    }

    /**
     * @return Возвращает размер
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Возвращает элемент по индексу:
     * target- через цикл записываем следующий элемент пока не возьмем нужный
     * @param index индекс нужного элемента
     * @return нужный элемент
     */

    @Override
    public E getElementByIndex(int index) {
        if (size < index) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> target = firstNode;
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    /**
     * Метод для получения следующей ссылки на элемент
     *
     * @param current= ссылка на элемент
     * @return следующий элемент
     */
    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }
    /**
     * Метод добавляет элемент, если первый элемент уже есть, то вставляет в конец списка, если нет заполняет в начало
     * @param e=элемент который мы вставляем
     */
    @Override
    public void add(E e) {
        if (firstNode.currentElement == null) {
            addFirst(e);
        } else {
            addLast(e);
        }
    }
    /**
     * Через цикл ищем нужный элемент, далее меняем ссылки, метод работает не корректно
     * @param index= индекс удаляемого элемента
     */
    @Override
    public void delete(int index) {
        Node<E> current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextElement();
        }

        Node<E> prev = current.getPrevElement();
        Node<E> next = current.getNextElement();
        if (prev != null) {
            prev.setNextElement(next);
            next.setPrevElement(prev);

        }
    }

    /**
     Обнуляет список
     */
    @Override
    public void deleteAll() {

        size = 0;
        firstNode = null;
        lastNode = null;

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    /**
     * Сортирует элементы списка методом вставки
     */
    @Override
    public void sort() {
        if (size > 1) {
            for (Node<E> current = firstNode.nextElement; current != null; current = current.nextElement) {
                E key = current.currentElement;
                Node<E> previous = current.prevElement;
                while (previous != null && comparator().compare(previous.currentElement, key) > 0) {
                    previous.nextElement.currentElement = previous.currentElement;
                    previous = previous.prevElement;
                }
                if (previous == null) {
                    firstNode.currentElement = key;
                } else {
                    previous.nextElement.currentElement = key;
                }
            }
        }
    }
    /**
     * Возвращает компаратор для сравнения элементов
     *
     * @return компаратор для сравнения элементов
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
     * Внутренний класс, представляющий узел двусвязного списка.
     *
     * @param <E> тип элемента в узле
     */

    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }


}
