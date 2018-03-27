package cpsc2150.lab8;

import java.util.Scanner;
/**
 * Created by sangrak on 3/26/2018.
 */
public class IntegerQueueApp {
    private static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Enter 1 for array implementation or 2 for List implementation");
        int answer = in.nextInt();
        IntegerQueueI q;
        if(answer == 1) {
            q = new ArrayQueueImp();
        }
        else
        {
            q = new ListQueueImp();
        }
        displayMenu();
        answer = in.nextInt();
        while(answer != 8)
        {
            if(answer == 1)
            {
                addToQueue(q);
            }
            else if(answer == 2)
            {
                getNext(q);
            }
            else if(answer == 3)
            {
                peekInQueue(q);
            }
            else if(answer == 4)
            {
                peekAtEnd(q);
            }
            else if(answer == 5)
            {
                insertInQueue(q);
            }
            else if(answer == 6)
            {
                getFromQueue(q);
            }
            else if(answer == 7)
            {
                removeFromQueue(q);
            }
            else
            {
                System.out.println("Not a valid option!");
            }
            System.out.println("Queue is: ");
            System.out.println(q.toString());
            System.out.println(" ");
            displayMenu();
            answer = in.nextInt();
        }
    }
    private static void displayMenu()
    {
        System.out.println("Select an option: ");
        System.out.println("1. Add to the Queue");
        System.out.println("2. Get next number from the Queue");
        System.out.println("3. Peek at the front of the Queue");
        System.out.println("4. Peek at the end of the Queue");
        System.out.println("5. Insert in the Queue");
        System.out.println("6. Get a position in the Queue");
        System.out.println("7. Remove from a position in the Queue");
                System.out.println("8. Quit");
    }
    private static void addToQueue(IntegerQueueI iQueue){

        System.out.println("What number to add to the Queue?");
        int answer = in.nextInt();
        iQueue.add(answer);
    }
    private static void getNext(IntegerQueueI iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Next number is " + iQueue.pop());
        }
    }
    private static void peekInQueue(IntegerQueueI iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Peek: " + iQueue.peek());
        }
    }
    private static void peekAtEnd(IntegerQueueI iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Peek at end: " + iQueue.endOfQueue());
        }
    }
    private static void insertInQueue(IntegerQueueI iQueue){
        System.out.println("What number to add to the Queue?");
        int answer = in.nextInt();
        int answer2;

        do{
            System.out.println("What position to insert in?");
            answer2 = in.nextInt();
            if((answer2 < 0) || (answer2 > iQueue.size())) {
                System.out.println("Not a valid position in the Queue!");
            }
        }while((answer2 < 0) || (answer2 > iQueue.size()));
    }
    public static void getFromQueue(IntegerQueueI iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            int answer;
            do{
                System.out.println("What position to get from the Queue?");
                answer = in.nextInt();
                if((answer < 0) ||(answer > iQueue.size())) {
                    System.out.println("Not a valid position in the Queue!");
                }
            }while((answer < 0) ||(answer > iQueue.size()));
            System.out.println(iQueue.get(answer) + " is at position " + answer + " in the queue");
        }
    }
    public static void removeFromQueue(IntegerQueueI iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            int answer;
            do{
                System.out.println("What position to remove from the Queue?");
                answer = in.nextInt();
                System.out.println("Answer is: " + answer);
                if((answer < 0) ||(answer > iQueue.size())) {
                    System.out.println("Not a valid position in the Queue!");
                }
            }while((answer < 0) || (answer > iQueue.size()));
            System.out.println(iQueue.remove(answer) + " was at position " + answer + " in the queue");
        }
    }
}
