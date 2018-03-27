package cpsc2150.lab8;

import java.util.*;
/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * CPSC 2150
 * Lab 8
 * 3/27/2018
 * Kevin Plis
 */

/**
 * Correspondence: this = myQ. The front of myQ is the front of
 the Queue
 * Correspondence: size = myQ.size();
 *
 * @invariant: 0 <= depth <= MAX_DEPTH
 */
public class ListQueueImp implements IntegerQueueI {
    private List<Integer> myQ;

    //complete the class

    /**
     * @requires the object being instantiated with the constructor to exist
     * @ensures the queue is empty and size = 0;
     */
    public ListQueueImp(){

        myQ = new LinkedList<Integer>();

    }
    public void add(Integer x){

        //adds to the end of list
        ((LinkedList<Integer>)myQ).addFirst(x);
    }
    public Integer pop() {

        //removes first element from linked list
        return ((LinkedList<Integer>)myQ).removeLast();
    }
    public int size() {

        return myQ.size();
    }

    /**
     * @requires [the object calling the instance to exist]
     * @ensures [function doesn't modify the object] and [str, which contains the elements of the list FIFO order
     *          with a new line character between each element]
     * @return [str, which contains the elements of the linked list in FIFO order with a new line character between each
     *         element]
     */

    @Override
    public String toString () {
        String str = "";

        //creates new array to hold elements from myQ using List API toArray()  which returns the array containing all
        //of the elements in the list from first to last order
        Object [] myQContents = myQ.toArray();

        //loops through myQ from last element to first and prints elements to the screen
        for(int i = myQ.size() - 1; i >= 0; i--){
            str += (Integer)myQContents[i] + "\n";
        }
        return str;
    }
}

