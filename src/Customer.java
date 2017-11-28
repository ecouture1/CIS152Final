import java.util.Random;

/**
 * @author Eli Couture, creates and hosts methods for a Customer
 *
 */
public class Customer
{
	Item[] order;
	Random generator = new Random();
	private String name;
	private int orderItemsQuant; // how many items this customer will order
	
	/**
	 * @param nam, name
	 * @param arrA, possibleItems array from CheckoutTester class
	 */
	public Customer(String nam, Item[] arrA)
	{
		name = nam;
		orderItemsQuant = (generator.nextInt(10) + 1);
		order = new Item[orderItemsQuant];
		this.generateOrder(arrA);			// creates an order as soon as the customer is created
	}
	
	/**
	 * @param i, Item from possibleItems array
	 * @param q, quantity to be orderd
	 * @param loc, index item should be placed in
	 */
	public void addToCart(Item i, int q, int loc)
	{ 
		
		if (i.custOrder1(q) == 2) // Item is above minimum Quantity AFTER ordering items
			{
				order[loc] = i;
				i.setOrderQuant(q);
				i.custOrder2(q);
			}
		else if (i.custOrder1(q) == 1) // Item is above 0, below Minimum Quantity AFTER ordering items
			{
				order[loc] = i;
				i.setOrderQuant(q);
				i.custOrder2(q);
				
				//////////////// Stack.Push(i) -------- not implemented --- pseudocode
			}
		else
			{
				order[loc] = new Item("null", i.getName(), 0, 0); // fills the array with dummy items to show missed sales
			}
			
	}
	
	/**
	 * @param arrA, possibleItems array from CheckoutTester class
	 */
	public void generateOrder(Item[] arrA)
	{

		for(int i = 0; i < orderItemsQuant; i++)
			{
				int pick = generator.nextInt(arrA.length); // picks item from the array of possibleItems, want to implement way to not duplicate items.
				addToCart(arrA[pick], generateQuant(), i); // adds the item to the Customer's Item array 'order'
			}
	}
	
	/**
	 * @return int, between 1 and 10 inclusive
	 */
	public int generateQuant()
	{
		int orderQuant = (generator.nextInt(10) + 1);
		return orderQuant;
	}
	
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param n
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * 
	 */
	public void clearOrders() // untested, possibly not needed in any way shape or form.
	{
		for (Item curr : order)
			curr = null;
	}
	
	/**
	 * 
	 */
	public void order() // CheckoutTester will run this to print out purchase list
	{
		System.out.println(name + " Bought " + order.length + " item(s)."); // does not account for items not having enough quantity to purchase
		System.out.println("\t\t\tName\t\tPrice\t\tQuant\t\tExtended Price\n"); // labels
		
		for (Item current : order)
			{
				if (current.getName().indexOf("null") >= 0) // all dummy items in order will have a name of "null". String.equals(String) wasn't working for an unknown reason.
					System.out.println("\t\t\tNot Enough Quantity of " + current.getDesc() + " for " + this.getName() + " to Order.");
				else
					System.out.println("\t\t\t" + current.getName() + "\t\t" + current.getPrice() + "\t\t" + current.getOrderQuant() + "\t\t" + (current.getPrice() * current.getOrderQuant() + "\t\t" + current.getQuant()));
			}
		System.out.println("\n");
	}
}
