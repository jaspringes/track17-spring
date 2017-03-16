package track.lessons.lesson3;

import java.util.NoSuchElementException;
/**
 * Created by alldark on 16.03.17.
 */
interface Queue {
    void pushBack(int value);
    int popFront() throws NoSuchElementException;
    int size();
}