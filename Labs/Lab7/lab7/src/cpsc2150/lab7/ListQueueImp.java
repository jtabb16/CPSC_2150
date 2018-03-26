package cpsc2150.lab7;

import java.util.*;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * Lab 7
 * Kevin Plis
 * 3/15/2018
 * Cpsc 2150
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
        myQ.add(x);
    }
    public Integer pop() {

        //removes first element from linked list
        return myQ.remove(0);
    }
    public int size() {

        return myQ.size();
    }
}
