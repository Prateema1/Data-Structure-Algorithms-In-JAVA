package com.pratima;

public class LL {
        private Node head;
        private Node tail;  //The benefit of having a tail node, is that we can directly insert element at last, optimizes performance with O(1) time complexity

        private int size;

        public LL() {
            this.size = 0;
        }

        public void insertFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;

            if(tail == null) {
                tail = head;
            }

            size += 1;
        }

        public void insertLast(int val) {
            //Time Complexity is O(1) because we are inserting at last
            if(tail == null) {
                insertFirst(val);
                return;
            }

            Node node = new Node(val);
            tail.next = node;
            tail = node;

            size += 1;
        }

        public void insert(int val, int index) {
            if(index == 0) {
                insertFirst(val);
                return;
            }

            if(index == size) {
                insertLast(val);
                return;
            }

            Node temp = head;
            for(int i = 1; i < index; i++) {
                temp = temp.next;
            }

            Node node = new Node(val, temp.next);
            temp.next = node;

            size++;
        }

        //insert using recursion
    public void insertRec(int val, int index) {

    }

//    private Node insertRec(int val, int index, Node node) {
//            if(index == 0) {
//                Node temp = new Node(val, node);
//                size++;
//                return temp;
//            }
//
//            insertRec();
//    }

        public int deleteFirst() {
            int val = head.value;
            head = head.next;
            if(head == null) {
                tail = null;
            }

            size--;
            return val;
        }

        public int deleteLast() {  //Complexity O(N)
            if(size <= 1) {
                return deleteFirst();
            }

            Node secondLast = get(size - 2);
            int val = tail.value;
            tail = secondLast;
            tail.next = null;
            return val;
        }

        public int delete(int index) {   //Time Complexity O(N)
            //Edge cases
            if(index == 0) {
                return deleteFirst();
            }

            if(index == size - 1) {
                return deleteLast();
            }

            Node prev = get(index - 1);
            int val = prev.next.value;
            prev.next = prev.next.next;
            return val;
        }
        public Node get(int index) {   //Get the value of node we want to delete;
          Node node = head;
          for(int i = 0; i < index; i++) {
              node = node.next;
          }
          return node;
        }

        //Find the node from given value
    public Node find(int value) {
            Node node = head;
            while(node != null) {
                if(node.value == value) {
                    return node;
                }
                node = node.next;
            }
        return null;
     }
        public void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.print("END");

        }

        public class Node {
            private int value;
            private Node next;

            public Node(int val) {
                this.value = val;
            }
            public Node(int val, Node next) {
                this.value = val;
                this.next = next;
            }
        }
}
