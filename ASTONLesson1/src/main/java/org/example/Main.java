package org.example;

import org.example.impl.MyArrayList;
import org.example.impl.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        //Создали список и добавили элементы
   ArList<String> myArrayList=new MyArrayList<>();
   myArrayList.add("ноль");
   myArrayList.add("один");
   myArrayList.add("два");
   myArrayList.add("три");
   myArrayList.add("четыре");
   //Добавили по индексу
   myArrayList.add(0,"добавка элемента");
   //Вывели на экран через метод get
        System.out.println("-----ArrayList-----");
   System.out.println(myArrayList.get(0));
   System.out.println(myArrayList.get(1));
   System.out.println(myArrayList.get(2));
   System.out.println(myArrayList.get(3));
   System.out.println(myArrayList.get(4));
   System.out.println(myArrayList.get(5));
   //Удалили первый элемент
        myArrayList.delete(0);
        System.out.println(myArrayList.get(0) + " - Удалили ");
        myArrayList.deleteAll();
        System.out.println(myArrayList.get(1) + "- Очистили лист");


LinkList<String> list = new MyLinkedList<>();
list.add("ноль");
list.add("один");
list.add("три");
list.add("четыре");
list.add("пять");
System.out.println("-----LinkList----");

System.out.println(list.size()+ " -размер списка");
System.out.println(list.getElementByIndex(0));
System.out.println(list.getElementByIndex(1));
System.out.println(list.getElementByIndex(2));
System.out.println(list.getElementByIndex(3));
System.out.println(list.getElementByIndex(4));
System.out.println(list.getElementByIndex(5));
list.deleteAll();









    }
}
