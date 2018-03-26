package cpsc2150.lab7;

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
     * @param X's type is the wrapper class Integer
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
    }

