import java.util.*;
public class Main
{
	public static void main(String[]args)
	{
		Scanner keyboard= new Scanner(System.in);
	
		int choice;
		MyStack<String> stack= new MyStack<String>();
			
		do
		{
			System.out.print("\n-Menu-\n1. Print\n2. Size\n3. Empty?\n4. Get Location\n5. Push\n6. Peek\n7. Pop\n8. Exit\nEnter: ");
			choice= keyboard.nextInt();
	
			if(choice==1)
			{
				System.out.println("\nCalling the toString produced: " + stack);
			}
			if(choice==2)
			{
				System.out.println("\nThe result of your size call is " + stack.size());
			}
			if(choice==3)
			{
				System.out.println("\nThe result of your isEmpty call is "+stack.isEmpty());
			}
			if(choice==4)
			{
				System.out.print("\nEnter a location: ");
				int spot = keyboard.nextInt();
			    System.out.println("The resultof your get call is "+stack.get(spot));
			}
			if(choice==5)
			{
				System.out.print("\nEnter a value: ");
				keyboard.nextLine();
				String text = keyboard.nextLine();
				stack.push(text);
                System.out.print("\nPush has been called");
			}
			if(choice==6)
			{
				System.out.println("\nThe result of your peek call is "+stack.peek());
			}
			if(choice==7)
			{
				
				System.out.println("\nThe result of your pop call is "+stack.pop());
			}
			if(choice==8)
				break;
	
		}while(true);
	
		System.out.print("\nGood Bye!!");
	}
}