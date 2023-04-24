package com.pratima;

//Uncomment the list you want to display
public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(5);
//        list.insertFirst(7);
//        list.insertFirst(8);
//        list.insertFirst(12);
//        list.insertLast(99);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.print(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();

//
        CLL list = new CLL();
        list.insert(32);
        list.insert(23);
        list.insert(42);
        list.insert(20);
        list.display();
        list.delete(42);
        list.display();


    }
}