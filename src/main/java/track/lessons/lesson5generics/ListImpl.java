package track.lessons.lesson5generics;

import java.util.Iterator;

/**
 * Реализация связного списка с итератором
 */
public class ListImpl implements Iterable<Integer> {

    private static class Node {
        Node prev;
        Node next;
        int val;

        public Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            head = new Node(null, null, value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(current, null, value);
        }
        size++;
    }

    public int get(int idx) {
        int counter = 0;
        Node current = head;
        while (counter++ < idx) {
            current = current.next;
        }
        return current.val;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        printAll(list);

    }

    public static void printAll(Iterable<Integer> data) {
        for (Integer it : data) {
            System.out.println(it);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter();
    }

    class Iter implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }


}
