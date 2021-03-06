package cpsc2150.lab7;


/**
 * Correspondence: this = myQ[0...depth-1], myQ[0] is the front
 of the Queue
 * Correspondence: size = depth
 *
 * @invariant: 0 <= depth <= MAX_DEPTH
 */
public class ArrayQueueImp implements IntegerQueueI {
    private Integer[] myQ;
    private int depth;
    //complete the class


    /**
     * Sangram Kadam (sangrak)
     * Jack Tabb (jbtabb)
     * Lab 7
     * Kevin Plis
     * 3/15/2018
     * Cpsc 2150
     */

    public ArrayQueueImp(){
        depth = 10;

        myQ = new Integer[depth];

        //Each Integer in the queue is initialized to null to make an "empty" queue
    }
    public void add(Integer x){
        Integer[] newMyQ;

        int numElem = 0;

        ///Count how many elements are in the queue
        for(Integer i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }

        //if adding element results in a size greater than depth
        if (numElem + 1 > depth)
        {
            //checks to make sure size cannot be bigger than MAX_DEPTH
            if (depth + 10 <= IntegerQueueI.MAX_DEPTH)
            {
                depth += 10;
            }
            else
            {
                //Queue is full and max size
            }
        }

        newMyQ = new Integer[depth];

        newMyQ[0] = x;

        for(int i = 0; i < numElem; i++){
            newMyQ[i+1] = myQ[i];
        }

        myQ = newMyQ;
    }
    public Integer pop(){

        int numElem = 0;

        ///Count how many elements are in the queue
        for(Integer i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }

        //sets last element to number of elements - 1
        int posLastElem = numElem - 1;

        int lastPos = myQ[posLastElem];

        //removes the element
        myQ[posLastElem] = null;

        return lastPos;
    }
    public int size(){

        int numElem = 0;

        ///Count how many elements are in the queue
        for(Integer i: myQ){
            if (i != null)
            {
                numElem++;
            }
        }
        return numElem;
    }
}




