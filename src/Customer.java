import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Customer
{
	List<Item> order;
	Random generator = new Random();
	
	public Customer()
	{
		order = new ArrayList<Item>();
	}
	
	public void addToCart(Item i, int q)
	{
		order.add(i);
		i.setOrderQuant(q);
	}
	
	public void generateOrder(Item[] arrA)
	{
		for(int i = 0; i < 5; i++)
			{
				int pick = generator.nextInt(arrA.length + 5);
				
				if (pick < arrA.length)
					addToCart(arrA[pick], generateQuant(arrA[pick]));
			}
	}
	
	public int generateQuant(Item i)
	{
		int orderQuant = (generator.nextInt(10) + 1);
		return orderQuant;
	}
	
	public void clearOrders()
	{
		for (int i = 0; i < order.size(); i++)
			order.remove(i);
	}
}
