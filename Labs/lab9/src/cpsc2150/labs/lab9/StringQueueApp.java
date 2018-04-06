package cpsc2150.labs.lab9;
import java.util.Scanner;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * CPSC 2150
 * Lab 9
 * 4/6/2018
 * Kevin Plis
 */

public class StringQueueApp {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Enter 1 for array implementation or 2 for List implementation");
        int answer = in.nextInt();
        IQueue q;
        if(answer == 1) {
            q = new ArrayQueueImpQueue<String>();
        }
        else
        {
            q = new ListQueueImpQueue<String>();
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
        System.out.println("2. Get next word from the Queue");
        System.out.println("3. Peek at the front of the Queue");
        System.out.println("4. Peek at the end of the Queue");
        System.out.println("5. Insert in the Queue");
        System.out.println("6. Get a position in the Queue");
        System.out.println("7. Remove from a position in the Queue");
        System.out.println("8. Quit");
    }
    private static void addToQueue(IQueue iQueue){

        System.out.println("What word to add to the Queue?");
        String answer = in.next();
        iQueue.add(answer);
    }
    private static void getNext(IQueue iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Next word is " + iQueue.pop());
        }
    }
    private static void peekInQueue(IQueue iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Peek: " + iQueue.peek());
        }
    }
    private static void peekAtEnd(IQueue iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            System.out.println("Peek at end: " + iQueue.endOfQueue());
        }
    }

    private static void insertInQueue(IQueue iQueue){
        System.out.println("What word to add to the Queue?");
        String answer = in.next();
        int answer2;

        do{
            System.out.println("What position to insert in?");
            answer2 = in.nextInt();
            if((answer2 <= 0) || (answer2 > iQueue.size() + 1)) {
                System.out.println("Not a valid position in the Queue!");
            }
        }while((answer2 <= 0) || (answer2 > iQueue.size() + 1));

        iQueue.insert(answer, answer2);
    }

    public static void getFromQueue(IQueue iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            int answer;
            do{
                System.out.println("What position to get from the Queue?");
                answer = in.nextInt();
                if((answer <= 0) ||(answer > iQueue.size())) {
                    System.out.println("Not a valid position in the Queue!");
                }
            }while((answer <= 0) ||(answer > iQueue.size()));
            System.out.println(iQueue.get(answer) + " is at position " + answer + " in the queue");
        }
    }
    public static void removeFromQueue(IQueue iQueue){
        if(iQueue.toString().equals("")){
            System.out.println("Queue is empty!");
        }
        else{
            int answer;
            do{
                System.out.println("What position to remove from the Queue?");
                answer = in.nextInt();
                if((answer <= 0) ||(answer > iQueue.size())) {
                    System.out.println("Not a valid position in the Queue!");
                }
            }while((answer <= 0) || (answer > iQueue.size()));
            System.out.println(iQueue.remove(answer) + " was at position " + answer + " in the queue");
        }
    }
}
