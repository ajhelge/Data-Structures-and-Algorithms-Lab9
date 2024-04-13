package lab109.helgesonaj;

/**
 * A quick and easy set class for lab 109
 * @version 4/12/2024
 * @author Alec Helgeson
 */

public class Set<E> {
    private E data[];
    private int size;

    /**
     * Constructor
     */
    Set(){
        this(10);
    }
    /**
     * Override Constructor
     * @param maxSize
     */
    Set(int maxSize){
        data = (E[]) new Object[maxSize]; //safe cast
    }
    /**
     * Returns number of items/objects in the set.
     * @return
     */
    public int size(){
        return size;
    }
    /**
     * adds and item/object to the set
     * @param element
     */
    public void add(E element){
        if(!contains(element)){
            data[size++] = element;
        }
    }
    /**
     * gets an item/object from the set
     * @param index
     * @return
     */
    public E get(int index){
        return data[index];
    }
    /**
     * checks to see if the given item/object exists within the set
     * @param element
     * @return
     */
    public boolean contains(E element){
        for(int i = 0; i < size; i++){
            if(element == data[i]){
                return true;
            }
        }
        return false;
    }
}
