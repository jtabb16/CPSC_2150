package cpsc2150.lab8;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * Lab 7
 * Kevin Plis
 * 3/15/2018
 * Cpsc 2150
 */

public interface IntegerQueueI {
    /**
     * A queue containing integers.
     * A queue is a data structure where the first item added to the
     structure is the first item removed from the structure
     * This queue is bounded by MAX_DEPTH
     *
     * Initialization ensures the queue is empty
     * Defines: size:Z
     * Constraints: 0 <= size <= MAX_DEPTH
     */

        int MAX_DEPTH = 100;

    /**
     * @param x's type is the wrapper class Integer
     * @requires X is a valid Integer
     * @ensures X is added to the end of the queue
     */
    // Adds x to the end of the Queue
        public void add(Integer x);


    /**
     * @requires queue size > 0
     * @ensures value is removed from the front of the queue
     * @returns the value that was on the front of the queue
     */
        //removes and returns the Integer at the front of the queue
        public Integer pop();


    /**
     * @requires requires queue to be initialized
     * @ensures 0<= size <= MAX_DEPTH and size is the size of the queue
     * @returns the size of the queue
     */
        //returns the number of Integers in the Queue
        public int size();

    /**
     * @requires [the queue cannot be empty] and [the queue has to be initialized]
     * @ensures [value of element at the front of the queue is returned] and [queue is not modified]
     * @return [integer at the front of the queue]
     */
    default Integer peek(){
        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the queue
        Integer [] tempArr = new Integer[size()];
        Integer result;
        //Get the number of elements in the queue before modifying it
        Integer size = size();

        //Traverse through the queue to the end
        for(int i = size-1; i >= 0; i--){
            tempArr[i] = pop();
        }
        //Get the value that is at the front of the queue
        result = tempArr[size - 1];

        //Fill the queue back up with the values that were removed to traverse through the queue
        for(int i = size - 1; i >= 0; i--){
            add(tempArr[i]);
        }

        return result;
    }

    /**
     * @requires [the queue cannot be empty] and [the queue has to be initialized]
     * @ensures  [value of element at the end of the queue is returned] and [queue is not modified]
     * @return [integer at the end of the queue]
     */
    default Integer endOfQueue(){

        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the queue
        Integer [] tempArr = new Integer[size()];
        Integer result;
        //Get the number of elements in the queue before modifying it
        Integer size = size();

        //Traverse through the queue to the end
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = pop();
        }
        //Get the value that is at the end of the queue
        result = tempArr[0];

        //Fill the queue back up with the values that were removed to traverse through the queue
        for(int i = size - 1; i >= 0; i--){
            add(tempArr[i]);
        }

        return result;
    }

    /**
     * @param x is the value to be added to the queue
     * @param pos is the index in the queue where x will be added
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *           and  < pos <= size
     * @ensures [x is inserted at pos]
     */
    default void insert(Integer x, int pos){

        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the queue
        Integer [] tempArr = new Integer[size()];
        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the queue
        //      and the added element in its correct position
        Integer [] tempArr2 = new Integer[size() + 1];
        Integer size = size(); //Get number of elements in the queue

        //Get to the end of the queue and store the elements from the queue into an array
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = pop();
        }

        //copy the contents of the queue up to the position to add at
        for(int i = 0; i < size - 1 - pos; i++){
            tempArr2[i] = tempArr[i];
        }

        //Add the new value at the specified location
        tempArr2[size - 1 - pos] = x;

        //loop from one index higher than where x was added until end of array (which is 1 element bigger than the array
        //that stores the original queue)
        for(int i = size - pos; i < size + 1; i++){
            tempArr2[i] = tempArr[i - 1];
        }

        //add all elements including inserted element back into the queue
        for(int i = size; i >= 0; i--){
            add(tempArr2[i]);
        }
    }

    /**
     * @param pos is the index in the queue where the Integer will be removed
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *           and 0 < pos <= size
     * @ensures [Integer is removed from pos] and [Integer value is returned]
     * @return [Integer value that was removed is returned]
     */
    default Integer remove(int pos){

        Integer [] tempArr = new Integer[size()];
        Integer [] tempArr2 = new Integer[size() - 1];
        Integer size = size();
        Integer result;

        //make a copy of tempArr and store in tempArr2 and at same time pop all values from queue
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = tempArr2[i] = pop();

        }

        //result = tempArr[size - pos];
        result = tempArr[size - 1 - pos];

        //starting from index of element to be removed, add all elements that come after the element to be removed. This
        //removes the element
        for(int i = size - 1 - pos; i < size; i++){
            tempArr[i - 1] = tempArr2[i];
        }
        //once element is removed, add elements back excluding the duplicate on the end of tempArr
        for(int i = size - 2; i >= 0; i--){
            add(tempArr[i]);
        }

       return result;
    }

    /**
     * @param pos is the index in the queue of the Integer whose value will be returned
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *            and 0 < pos <= size
     * @ensures [Integer value at pos is returned] and [queue is not modified]
     * @return [Integer value at pos is returned]
     */
    default Integer get(int pos){

        Integer [] tempArr = new Integer[size()];
        Integer [] tempArr2 = new Integer[size()];
        Integer size = size();
        Integer result;

        //make a copy of tempArr and store in tempArr2 and at same time pop all values from queue
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = tempArr2[i] = pop();

        }

        //result = tempArr[size - pos];
        result = tempArr[size - pos];

        //add elements back to queue
        for(int i = size - 1; i >= 0; i--){
            add(tempArr[i]);
        }

        return result;
    }
}

