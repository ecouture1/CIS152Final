import java.util.Random;

public class Customer
{
	Item[] order;
	Random generator = new Random();
	private String name;
	private int orderQuant;
	
	public Customer(String nam)
	{
		name = nam;
		orderQuant = (generator.nextInt(10) + 1);
		order = new Item[orderQuant];
	}
	
	public void addToCart(Item i, int q, int loc) // NOT DONE NEED TO COMPLETE TO HANDLE ITEM QUANTITIES
	{
	/*	int o = i.getQuant();
		
		if (o <= i.getMin())
			{
				Email to Manager. 
			}
		else if (o - q <= i.getMin())
			{
				order[loc] = i;
				i.setOrderQuant(q);
			}*/
		
		order[loc] = i;
		i.setOrderQuant(q);
		i.custOrder1(q);
		i.custOrder2(q);
	}
	
	public void generateOrder(Item[] arrA)
	{
		for(int i = 0; i < orderQuant; i++)
			{
				int pick = generator.nextInt(arrA.length);
				addToCart(arrA[pick], generateQuant(), i);
			}
	}
	
	public int generateQuant()
	{
		int orderQuant = (generator.nextInt(10) + 1);
		return orderQuant;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void clearOrders()
	{
		for (Item curr : order)
			curr = null;
	}
	
	public void order()
	{
		System.out.println(name + " Bought " + order.length + " item(s).");
		System.out.println("\t\t\tName\t\tPrice\t\tQuant\t\tExtended Price\n");
		
		for (Item current : order)
			{
				System.out.println("\t\t\t" + current.getName() + "\t\t" + current.getPrice() + "\t\t" + current.getOrderQuant() + "\t\t" + (current.getPrice() * current.getOrderQuant() + "\t\t" + current.getQuant()));
			}
		System.out.println("\n");
	}
}
