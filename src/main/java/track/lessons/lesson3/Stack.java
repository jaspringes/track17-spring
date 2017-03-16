package track.lessons.lesson3;

import java.util.NoSuchElementException;
/**
 * Created by alldark on 16.03.17.
 */

interface Stack {

    void push(int value);

    int pop() throws NoSuchElementException;

    int size();
}
