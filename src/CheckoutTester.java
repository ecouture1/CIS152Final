import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Eli Couture, tests methods from other classes
 *
 */
public class CheckoutTester
{
	
	static Queue customers = new Queue(20);
	static GMstack manager = new GMstack(21);
	static Item[] possibleItems = new Item[20];
	static boolean endProgram = false;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Random generator = new Random();
		Scanner reader = new Scanner(System.in);
		
		
		System.out.println("If you wish to quit, at any time when prompted to type, type \"q\" (no quotes) and hit enter\n\n"
						 + "This program simulates a very simple store. This only simulates the process of the store,\n"
						 + "It does not consider time for shipping, the reasonable quantity of an item to buy, wages, wholesale\n"
						 + "or any other major life concern. It only simulates the basic shop.\n\n"
						 + "The shop runs 10 hours a day, 8:00-6:00.\n\n");
		
		possibleItems = genItemArr(generator);
		
		for (Item cur : possibleItems)
			System.out.println("Name: " + cur.getName() + "\t\tQty: " + cur.getQuant());
		
		System.out.println("\n\n");
		
		while (!endProgram)
		{	
			runDay();
			
			System.out.print("\nWould you like to quit? If YES, type q and then hit enter. If NO, type anything else and enter. ");
			String in = reader.next();
			
			if (in.equals("q"))
				endProgram = true;
			else
				System.out.println("");
		}
		
		reader.close();
		
	}
	
	
	// to keep the main method looking clean, but I didn't want to make an extraneous class just to run some methods.
	
	
	// there are additional methods below this gap.
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param Random generator, to keep encapsulation it is not a public generator
	 * @return Item[] filled with procedurally generated Items
	 */
	public static Item[] genItemArr(Random generator)
	{
		char temp = 'A';
		Item[] pi = new Item[20];
		
		for (int i = 0; i < 20; i++)
			{
				int q = generator.nextInt(30) + 20;
				double p = (generator.nextDouble() * 30) + 1;
				p = ((int)(p*100)/100);
				pi[i] = new Item(("Object" + temp), ("Object" + temp++), q, p);
			}
		return pi;
	}
	
	public static void runDay()
	{
		Scanner reader = new Scanner(System.in);
		int input = 1;
		int cycles = 10;
		int time = 8;
		
		while (cycles > 0)
		{
			if (cycles > 1)
				System.out.print("How many hours do you want to simulate at once (1-" + cycles + "): ");
			else
				System.out.print("How many hours do you want to simulate at once (1): ");
			while (true)
				{
					try
					{
						input = reader.nextInt();
						if (input <= cycles)
							break;
						else
							System.out.print("Please enter a number between 1 and " + cycles + ": ");
					}
					catch (InputMismatchException e)
					{	
						reader.next();
						System.out.print("Did you mean to quit, if yes please enter \"q\" again and hit enter: ");
						String end = reader.next();
						if (end.equals("q"))
							{
								endProgram = true;
								break;
							}
						else
							System.out.println("\n\nPlease enter an integer between 1 & 10 (inclusive): ");
					}
				}
			
			cycles -= input;
		
			for (int i = 0; i < input; i++)
				{
					customers.generateCustomers(possibleItems, manager);
				
					System.out.println("\n\n");
					while (!customers.isEmpty())
						{
							customers.dequeue().order(); // takes the customer at front and "sends it through the checkout"
						}
					if (time + i + 1 > 12)
						System.out.println("\n\n End of one Hour. Time is: " + ((time+(i+1))-12) + ":00pm\n\n");
					else if (time + i + 1 == 12)
						System.out.println("\n\n End of one Hour. Time is 12:00pm\n\n");
					else
						System.out.println("\n\n End of one Hour. Time is: " + (time+(i+1)) + ":00am\n\n");
				}
			

			time += input;
			
			if (time >12)
				System.out.println("The time is: " + (time-12) + ":00pm");
			else if (time == 12)
				System.out.println("The time is: 12:00pm");
			else
				System.out.println("The time is: " + time + ":00am");
			
			if (time == 18)
				{
					System.out.println("GM has ordered more of all empty items.\n");
					
					while (!manager.isEmpty())
					{
						manager.pop();
					}
				}
		}
	}
	
	

}
