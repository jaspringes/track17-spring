package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * <p>
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    private static final int defaultSize = 16;
    private int[] array;
    private int size = 0;


    public MyArrayList() {
        array = new int[defaultSize];
        size = defaultSize;
    }

    public MyArrayList(int initSize) {
        if (initSize < defaultSize) {
            initSize = defaultSize;
        }
        array = new int[initSize];
        size = initSize;
    }

    private void boost() throws OutOfMemoryError {
        size *= 2;
        int[] buffer = new int[size];
        System.arraycopy(array, 0, buffer, 0, currentSize);
        array = buffer;
    }

    private void reduce() {
        if (size <= defaultSize) {
            return;
        } else {
            int[] buffer = new int[size / 2];
            System.arraycopy(buffer, 0, array, 0, currentSize);
            array = buffer;
        }
    }

    @Override
    public void add(int item) {
        if (currentSize == size) {
            boost();
        }
        array[currentSize] = item;
        currentSize += 1;
    }

    @Override
    public int remove(int idx) throws NoSuchElementException {
        checkIndex(idx);
        currentSize -= 1;
        int answer = array[idx];
        System.arraycopy(array, idx + 1, array, idx, currentSize - idx);
        if (currentSize < (size / 4)) {
            reduce();
        }
        return answer;
    }

    @Override
    public int get(int idx) throws NoSuchElementException {
        checkIndex(idx);
        return array[idx];
    }
}

