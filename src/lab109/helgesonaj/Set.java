package lab109.helgesonaj;

/**
 * A quick and easy set class for lab 109
 */

public class Set<E> {
    private E data[];
    private int size;

    Set(){
        this(10);
    }

    Set(int maxSize){
        data = (E[]) new Object[maxSize]; //safe cast
    }

    public int size(){
        return size;
    }

    public void add(E element){
        if(!contains(element)){
            data[size++] = element;
        }
    }

    public E get(int index){
        return data[index];
    }

    public boolean contains(E element){
        for(int i = 0; i < size; i++){
            if(element == data[i]){
                return true;
            }
        }
        return false;
    }
}
