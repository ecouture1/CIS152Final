import java.util.Random;
/**
 * @author Eli Couture, this class creates a queue and hosts the methods to utilise it.
 *
 */
public class Queue {
	
	private int maxSize;			// this Is mostly repurposed code from the Queue assignment.
	private Customer[] queArray;    // It was more efficient to change it than make it from scratch.
	private int front;
	private int rear; 
	private int nItems;
	private char na = 'A';			// part of Customer name generation
	
	private Random generator = new Random();
	
	/**
	 * @param s, maxSize, creates a Queue of maxSize length
	 */
	public Queue(int s)
	{
		maxSize = s;
		queArray = new Customer[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**
	 * @param arrA, the Item array possibleItems from the testing class
	 */
	public void generateCustomers(Item[] arrA, GMstack GM)		
	{
		int count = generator.nextInt(10) + 1; // how many customers there will be in this "runthrough"

		for (int i = 0; i < count; i++)
			{
				Customer cust = new Customer(genName(), arrA, GM);	// create a customer
				enqueue(cust);									// put customer into queue
			}	
	}
	/**
	 * @param cust, Customer to be put into queue
	 */
	public void enqueue(Customer cust)
	{
		if (rear == maxSize-1)
			rear = -1;
		queArray[++rear] = cust;
		nItems++;
	}
	
	/**
	 * @return the item at the front, decrement number of items
	 */
	public Customer dequeue()
	{
		Customer cust = queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		
		return cust;
	}
	
	/**
	 * @return number of items
	 */
	public int size()
	{
		return nItems;
	}
	
	/**
	 * @return true if no space to add items
	 */
	public boolean isFull()
	{
		return (nItems==maxSize);
	}
	
	/**
	 * @return true if no items
	 */
	public boolean isEmpty()
	{
		return (nItems == 0);
	}
	
	/**
	 * @return front item, without editing
	 */
	public Customer peek()
	{
		return queArray[front];
	}
	
	/**
	 *   Prints out entire queue without editing
	 */
	public void print()											// deprecated code. needs to deleted or changed before use
	{
		int item = front; // the array starts at the front
		
		for(int x = 0; x < (nItems); x++) // the for statement executes once per item
		{
			System.out.println("\t\t\t" + queArray[item++]); // prints the information
			
			if (item == maxSize) // accounts for wraparound
				item = 0;
		}
	}
	
	/**
	 * @return string to use as Customer name
	 */
	public String genName()
	{
		String temp;
		if (na == 'Z')					// not sure if works as intended, but works perfectly fine for
			{							// what i need it to do. will check out and edit later for efficiency.
				temp = ("CustomerZA");
				na = ('A' - 1);
			}
		else
			temp = ("Customer" + na + (na+1));
		
		na++;
		return temp;
	}
}
