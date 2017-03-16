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

    public MyLinkedList(){
    }

    private Node getNode(int index){
        checkIndex(index);
        Node current;
        if(index<currentSize/2) {
            current = head;
            while (index > 0){
                current = current.next;
                index -= 1;
            }
        } else {
            current = tail;
            while (index > 0){
                current = current.prev;
                index -= 1;
            }
        }
        return current;
    }

    @Override
    public void add(int item) {
        currentSize += 1;
        if (head == null){
          tail = head = new Node(null,null,item);
        } else {
            tail = tail.next = new Node(tail,null,item);
        }

    }

    @Override
    public int remove(int index) throws NoSuchElementException {
        Node removedNode = getNode(index);
        removedNode.prev.next = (removedNode.prev != null)? removedNode.next : null;
        removedNode.next.prev = (removedNode.next != null)? removedNode.prev : null;
        head = (index == 0)? head.next : head;
        tail = (index == currentSize)? tail.prev : tail;
        currentSize -= 1;
        return removedNode.val;
    }

    @Override
    public int get(int index) throws NoSuchElementException {
        return getNode(index).val;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
