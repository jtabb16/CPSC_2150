package cpsc2150.labs.lab9;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * CPSC 2150
 * Lab 9
 * 4/6/2018
 * Kevin Plis
 */

/**
 * Correspondence: this = myQ[0...depth-1], myQ[0] is the front
 *  of the Queue
 * Correspondence: size = depth
 *
 * @invariant: 0 <= depth <= MAX_DEPTH
 */
public class ArrayQueueImpQueue <T> implements IQueue <T> {
    private T[] myQ;
    private int depth;
    //complete the class

    /**
     * @requires the object being instantiated with the constructor to exist
     * @ensures the queue is empty and size = 10;
     */
    public ArrayQueueImpQueue(){
        depth = 10;

        //Each T in the queue is initialized to null to make an "empty" queue
        myQ = (T []) new Object[depth];
    }
    public void add(T x){
        T[] newMyQ;

        int numElem = 0;

        //Count how many elements are in the queue
        for(T i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }

        //if adding element results in a size greater than depth
        if (numElem + 1 > depth)
        {
            //checks to make sure size cannot be bigger than MAX_DEPTH
            if (depth + 10 <= IQueue.MAX_DEPTH)
            {
                depth += 10;
            }
            else
            {
                //Queue is full and max size
            }
        }

        newMyQ = (T []) new Object[depth];

        newMyQ[0] = x;

        for(int i = 0; i < numElem; i++){
            newMyQ[i+1] = myQ[i];
        }

        myQ = newMyQ;
    }

    public T pop(){

        int numElem = 0;

        ///Count how many elements are in the queue
        for(T i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }

        //sets last element to number of elements
        int posLastElem = numElem - 1;
        T lastPos;

        lastPos = myQ[posLastElem];

        //removes the element
        myQ[posLastElem] = null;

        return lastPos;

    }

    public int size() {
        int numElem = 0;

        ///Count how many elements are in the queue
        //myQ has blank spots for future items to be added.
        //Count up the elements in the queue until we hit one of those blank spots
        //to know how many elements are actually in the queue.
        while (myQ[numElem] != null)
        {
              numElem++;
        }
        return numElem;
    }

    /**
     * @requires [the object calling the instance to exist]
     * @ensures [function doesn't modify the object] and [str, which contains the elements of the queue in FIFO order
     *          with a new line character between each element]
     * @return [str, which contains the elements of the queue in FIFO order with a new line character between each
     *         element]
     */

    @Override
    public String toString () {
        String str = "";

        int numElem = 0;

        ///Count how many elements are in the queue
        for(T i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }

        //sets last element to number of elements - 1
        int posLastElem = numElem - 1;


        if(posLastElem >= 0) {
            //loops through myQ from last element to first and prints elements to the screen
            for(int i = posLastElem; i >= 0; i--){
                str = (str + myQ[i].toString() + "\n");
            }
        }

        return str;
    }
}
