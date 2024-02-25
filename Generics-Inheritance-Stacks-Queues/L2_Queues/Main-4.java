import java.util.*;
public class Main
{
	public static void main(String[]args)
	{
		Scanner keyboard= new Scanner(System.in);
	
		int choice;
		MyQueue<Integer> queue= new MyQueue<Integer>();
	
		do
		{
			System.out.print("\n-Menu-\n1. Print\n2. Offer\\Add\n3.Element\n4. Poll\n5. Size\n6. Get Location\n7. Empty?\n8.clear\n9. Exit\nEnter: ");
			choice= keyboard.nextInt();
			System.out.println("");
			
			if(choice==1)
			{
				System.out.println("\nThe result of your toString call is " + queue);
			}
			if(choice==2)
			{
				System.out.print("Enter a number: ");
				int enter= keyboard.nextInt();
                System.out.println("\nThe result of your add call is " + queue.offer(enter));
			}
			if(choice==3)
			{
                System.out.println("\nThe result of your element call is " +queue.element());
			}
			if(choice==4)
			{
                System.out.println("\nThe result of your poll call is " + queue.poll());
			}
			if(choice==5)
			{
                System.out.println("\nThe result of your size call is " +queue.size());
			}
			if(choice==6)
			{
				System.out.print("Enter a location: ");
				int enter= keyboard.nextInt();
                System.out.println("\nThe result of your get call is " +queue.get(enter));
			}
			if(choice==7)
			{
                System.out.println("\nThe result of your isEmpty call is " +queue.isEmpty());
			}
			if(choice==8)
			{
                System.out.println("\nClear was called"); 
				queue.clear();
			}
			if(choice==9)
				break;
		
		}while(choice<9);
	
		System.out.print("\tGood Bye");
	}
}