package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List {

    private Node head = null;
    private Node tail = null;

    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */
    private static class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    public MyLinkedList() {
    }

    private Node getNode(int idx) {
        checkIndex(idx);
        Node current;
        if (idx < currentSize / 2) {
            current = head;
            while (idx > 0) {
                current = current.next;
                idx -= 1;
            }
        } else {
            current = tail;
            while (idx > 0) {
                current = current.prev;
                idx -= 1;
            }
        }
        return current;
    }

    @Override
    public void add(int item) {
        currentSize += 1;
        if (head == null) {
            tail = head = new Node(null, null, item);
        } else {
            tail = tail.next = new Node(tail, null, item);
        }

    }

    @Override
    public int remove(int idx) throws NoSuchElementException {
        Node removedNode = getNode(idx);
        removedNode.prev.next = (removedNode.prev != null) ? removedNode.next : null;
        removedNode.next.prev = (removedNode.next != null) ? removedNode.prev : null;
        head = (idx == 0) ? head.next : head;
        tail = (idx == currentSize) ? tail.prev : tail;
        currentSize -= 1;
        return removedNode.val;
    }

    @Override
    public int get(int idx) throws NoSuchElementException {
        return getNode(idx).val;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
