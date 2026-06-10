package day2;
public class designlinkedlist {

    static class MyLinkedList {

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        Node head;
        int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            Node temp = head;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;

            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                size++;
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {

            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            Node temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(val);

            newNode.next = temp.next;
            temp.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {

            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                head = head.next;
                size--;
                return;
            }

            Node temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
        }

        public void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);

        list.display(); // 1 -> 2 -> 3 -> null

        System.out.println(list.get(1)); // 2

        list.deleteAtIndex(1);

        list.display(); // 1 -> 3 -> null

        System.out.println(list.get(1)); // 3
    }
}