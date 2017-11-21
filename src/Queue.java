import java.util.Random;
/**
 * @author Eli Couture, this class creates a queue and hosts the methods to utilise it.
 *
 */
public class Queue {
	
	private int maxSize;
	private Customer[] queArray;
	private int front;
	private int rear;
	private int nItems;
	private char na = 'A';
	private Random generator = new Random();
	/**
	 * @param s, maxSize
	 */
	public Queue(int s)
	{
		maxSize = s;
		queArray = new Customer[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void generateCustomers(Item[] arrA)
	{
		int count = generator.nextInt(20) + 1;

		for (int i = 0; i < count; i++)
			{
				Customer cust = new Customer(genName());
				enqueue(cust, arrA);
			}	
	}
	/**
	 * @param str, data put into the queue
	 */
	public void enqueue(Customer cust, Item[] arrA)
	{
		if (rear == maxSize-1)
			rear = -1;
		queArray[++rear] = cust;
		cust.generateOrder(arrA);
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
	public void print()
	{
		int item = front; // the array starts at the front
		
		for(int x = 0; x < (nItems); x++) // the for statement executes once per item
		{
			System.out.println("\t\t\t" + queArray[item++]); // prints the information
			
			if (item == maxSize) // accounts for wraparound
				item = 0;
		}
	}
	
	public String genName()
	{
		String temp;
		if (na == 'Z')
			{
				temp = ("CustomerZA");
				na = ('A' - 1);
			}
		else
			temp = ("Customer" + na + (na+1));
		
		na++;
		return temp;
	}
}
