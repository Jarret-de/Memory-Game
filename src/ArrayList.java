import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 4;
    private E[] data;
    private int size = 0;
    
    public ArrayList() { this(CAPACITY); }
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    //Generic add method that adds element at specified index
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size+1);
        if (size == data.length) resize(2 * data.length);
        for (int k=size-1; k >= i; k--) data[k+1] = data[k];
        data[i] = e;
        size++;
    }

    //Generic add method that adds element at end of array
    public void add(E e) throws IndexOutOfBoundsException {
        if (size == data.length) resize(2 * data.length);
        data[size] = e;
        size++;
    }

    //Removes element from specified index and changes the index of every element after to fit the array
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k=i; k<size-1; k++) data[k] = data[k+1];
        data[size-1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i=0; i < size; i++) temp[i] = data[i];
        data = temp;    
    } 

    //Override of generic equals method, Checks if two arrays lists are equal. Checks size first then each 
    //element until either an element is found to be not equal or the loop finishes 
    @Override
    public boolean equals(Object o) {
        ArrayList check = (ArrayList) o;
        if (size != check.size()) return false;
        for (int i=0; i < size; i++) {
            if (!data[i].equals(check.get(i))) {
                return false;
            }
        }
        return true;
    }
    

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;

        public boolean hasNext() {return j < size;}

        public E next() throws NoSuchElementException {
            if (j == size) throw new NoSuchElementException("No next element");
            return data[j++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}
