import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int moves = 0;
        int disks = 0;
        while(disks < 3 || disks > 5){
        System.out.print("Enter the number (between 3 and 5) of disks: ");
        disks = sc.nextInt();
        if(disks < 3 || disks > 5)
        {
            System.out.println("Out of Range");
        }
        }
        MyStack<Integer>[] hanoi = new MyStack[3];
        for(int i=0;i<3;i++)
        {
            hanoi[i] = new MyStack();
        }
        for(int j=disks;j>0;j--)
        {
            hanoi[0].push(j);
        }
        while(hanoi[2].size() != disks)
        {
           // displayHanoi(hanoi,disks);
            System.out.print("Enter Source Pole: ");
            int source = sc.nextInt();
            System.out.print("Enter Destination Pole: ");
            int destination = sc.nextInt();
            if(source == destination || source <1 || source >3 || destination<1 || destination>3)
            {
                System.out.println("Value Out Of Range");
            }
            else if(hanoi[source-1].isEmpty())
            {
                System.out.println("Empty Pole");
            }
            else if(hanoi[destination-1].isEmpty() || hanoi[source-1].peek() < hanoi[destination-1].peek())
            {
                int temp = hanoi[source-1].pop();
                hanoi[destination-1].push(temp);
                moves++;
            }
            else{
                System.out.println("Invalid Input - Try Again");
            }
        }
        //displayHanoi(hanoi,disks);
        System.out.println("Fannnnnnnntasic! You Solved The " + disks + " Disk Hanoi Challenge in " + moves + " Moves");
    }

        
}