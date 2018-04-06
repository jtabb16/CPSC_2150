package cpsc2150.labs.lab9;
/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * CPSC 2150
 * Lab 9
 * 4/6/2018
 * Kevin Plis
 */


public interface IQueue <T>{
    /**
     * A queue containing T's.
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
     * @param x's type is the class T and x is the element of type T to add to the queue
     * @requires X is a valid type T and this.size < MAX_DEPTH and x is a contiguous type T(i.e no spaces for String)
     * @ensures X is added to the end of the queue and number of elements in queue is incremented by 1
     */
    // Adds x to the end of the Queue
        public void add(T x);


    /**
     * @requires queue size > 0
     * @ensures A T is removed from the front of the queue and pop = T removed from the front of the queue and
     *          this.size = #this.size - 1
     * @returns the value that was on the front of the queue
     */
        //removes and returns the T  at the front of the queue
        public T pop();


    /**
     * @requires queue to be initialized
     * @ensures 0<= size <= MAX_DEPTH and size = number of elements in the queue
     * @returns the number of items in the queue
     */
        //returns the number of Ts in the Queue
        public int size();

    /**
     * @requires [the queue cannot be empty] and [the queue has to be initialized]
     * @ensures [value of element at the front of the queue is returned] and [queue is not modified]
     * @return  [A T at the front of the queue]
     */
    default T  peek(){
        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the
        //queue
         T [] tempArr = (T[]) new  Object[size()];
         T result;
        //Get the number of elements in the queue before modifying it
         int size = size();

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
     * @return  [The T at the end of the queue]
     */
    default T  endOfQueue(){

        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the
        //queue
         T [] tempArr = (T[]) new  Object[size()];
         T result;
        //Get the number of elements in the queue before modifying it
         int size = size();

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
     * @param x is the value of type T to be added to the queue
     * @param pos is the index in the queue where x will be added
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *           and  1 <= pos <= size + 1 and x is a contiguous type T (i.e. no spaces in String)
     * @ensures [x is inserted at pos]
     */
    default void insert (T  x, int pos){

        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the
        //queue
         T [] tempArr = (T[]) new  Object[size()];
        //Array to temporarily hold the elements that get removed from the queue while traversing to the end of the
        //queue and the added element in its correct position
         T [] tempArr2 = (T[]) new  Object[size() + 1];
         int size = size(); //Get number of elements in the queue

        //Get to the end of the queue and store the elements from the queue into an array
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = pop();
        }

        //copy the contents of the queue up to the position to add at
        for(int i = 0; i <= size - pos; i++){
            tempArr2[i] = tempArr[i];
        }

        //Add the new value at the specified location
        tempArr2[size - pos + 1] = x;

        //loop from one index higher than where x was added until end of array (which is 1 element bigger than the array
        //that stores the original queue)
        for(int i = size - pos + 1; i < size; i++){
            tempArr2[i + 1] = tempArr[i];
        }

        //add all elements including inserted element back into the queue
        for(int i = size; i >= 0; i--){
            add(tempArr2[i]);
        }
    }

    /**
     * @param pos is the index in the queue where the T will be removed
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *           and 1 <= pos <= size
     * @ensures  [A T is removed from pos] and  T  value is returned]
     * @return  [The T value that was removed is returned]
     */
    default T  remove(int pos){

         T [] tempArr = (T[]) new  Object[size()];
         T [] tempArr2 = (T[]) new  Object[size()];
         int size = size();
         T result;

        //make a copy of tempArr and store in tempArr2 and at same time pop all values from queue
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = tempArr2[i] = pop();

        }

        result = tempArr[size - pos];

        //starting from index of element to be removed, add all elements that come after the element to be removed. This
        //removes the element
        for(int i = size - pos; i < size - 1; i++){
            tempArr[i] = tempArr2[i + 1];
        }
        //once element is removed, add elements back excluding the duplicate on the end of tempArr
        for(int i = size - 2; i >= 0; i--){
            add(tempArr[i]);
        }

       return result;
    }

    /**
     * @param pos is the index in the queue of the T whose value will be returned
     * @requires pos = 1 [at the very front of the queue] and [pos increases as you go from the front to end of queue]
     *            and 1 <= pos <= size
     * @ensures  [A T value at pos is returned] and [queue is not modified]
     * @return  [The T value at pos is returned]
     */
    default T get(int pos){

         T [] tempArr = (T[]) new  Object[size()];
         T [] tempArr2 = (T[]) new Object[size()];
         int size = size();
         T result;

        //make a copy of tempArr and store in tempArr2 and at same time pop all values from queue
        for(int i = size - 1; i >= 0; i--){
            tempArr[i] = tempArr2[i] = pop();

        }

        result = tempArr[size - pos];

        //add elements back to queue
        for(int i = size - 1; i >= 0; i--){
            add(tempArr[i]);
        }

        return result;
    }
}
