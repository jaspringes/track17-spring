package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 *
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    private static final int defaultSize = 64;
    private int[] array;
    private int size = 0;


    public MyArrayList() {
        array = new int[defaultSize];
        size = defaultSize;
    }

    public MyArrayList(int size) {
        if (size < defaultSize){
            size = defaultSize;
        }
        array = new int[size];
    }

    private void boost() throws OutOfMemoryError{
        size *= 2;
        int[] buffer = new int[size];
        System.arraycopy(array,0,buffer,0, currentSize);
        array = buffer;
    }

    private void reduce(){
        if (size <=defaultSize){
            return;
        }
        int[] buffer = new int[size/2];
        System.arraycopy(buffer,0,array,0, currentSize);
        array = buffer;
    }

    @Override
    public void add(int item) {
        if (currentSize == size){
            boost();
        }
        array[currentSize] = item;
        currentSize += 1;
    }

    @Override
    public int remove(int index) throws NoSuchElementException {
        checkIndex(index);
        currentSize = currentSize - 1;
        int answer = array[index];
        System.arraycopy(array, index+1, array,index,currentSize-index);
        if (currentSize < size/4){
            reduce();
        }
        return answer;
    }

    @Override
    public int get(int index) throws NoSuchElementException {
        checkIndex(index);
        return array[index];
    }
}
