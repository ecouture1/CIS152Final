import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Customer
{
	List<Item> order;
	Random generator = new Random();
	private String name;
	
	public Customer(String nam)
	{
		order = new ArrayList<Item>();
		name = nam;
	}
	
	public void addToCart(Item i, int q) // NOT DONE NEED TO COMPLETE TO HANDLE ITEM QUANTITIES
	{
		int o = i.getQuant();
		
		if (o <= i.getMin())
			{
				
			}
		else if (o - q <= i.getMin())
			{
				order.add(i);
				i.setOrderQuant(q);
			}
	}
	
	public void generateOrder(Item[] arrA)
	{
		for(int i = 0; i < (generator.nextInt(5) + 1); i++)
			{
				int pick = generator.nextInt(arrA.length);
				
				if (pick < arrA.length)
					addToCart(arrA[pick], generateQuant());
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
		for (int i = 0; i < order.size(); i++)
			order.remove(i);
	}
	
	public void order()
	{
		System.out.println(name + " Bought " + order.size() + " item(s).");
		System.out.println("\t\t\tName\t\tPrice\t\tQuant\t\tExtended Price\n");
		
		for (Item current : order)
			{
				System.out.println("\t\t\t" + current.getName() + "\t\t" + current.getPrice() + "\t\t" + current.getOrderQuant() + "\t\t" + (current.getPrice() * current.getOrderQuant()));
			}
		System.out.println("\n");
	}
}
