package cpsc2150.lab7;

import java.util.Scanner;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * Lab 7
 * Kevin Plis
 * 3/15/2018
 * Cpsc 2150
 */
public class QueueApp {
    public static void main (String [] args){
        IntegerQueueI q;
/*
You will add in code here to ask the user whether they want an
array implementation or a list implementation. Then use their
answer to initialize q appropriately
*/

        System.out.println("Press 1 for Array Implementation or 2 for LinkedList Implementation");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.equals("1")){
            q = new ArrayQueueImp();
        }
        else if(input.equals("2")){
            q = new ListQueueImp();
        }
        else{
            q = new ListQueueImp();
            System.out.println("Invalid Input");
            System.out.println("LinkedList Implementation selected by default");
        }

        Integer x = 42;

        q.add(x);
        x = 17;
        q.add(x);
        x = 37;
        q.add(x);
        x = 36;
        q.add(x);
        x = 12;
       q.add(x);

        //print the queue. After the code is finished,
        //the queue should contain all its values in order
        for(int i = q.size(); i > 0 ; i--){
            int num = q.pop();
            q.add(num);
            System.out.println(num);
        }
    }
}
