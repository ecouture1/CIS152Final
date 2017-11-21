
public class Item
{
	private int quantity;
	private String name;
	private String description;
	private int minQuant;
	private int maxQuant;
	private double price;
	private int orderQuant;
	
	public Item(String n, String desc, int q, double p)
	{
		name = n;
		description = desc;
		quantity = q;
		maxQuant = q;
		minQuant = (quantity/5) + 1;
		price = p;
	}
	
	public int getQuant()
	{
		return quantity;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getMin()
	{
		return minQuant;
	}
	
	public int getMax()
	{
		return maxQuant;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getOrderQuant()
	{
		return orderQuant;
	}
	
	public void setOrderQuant(int i)
	{
		orderQuant = i;
	}
	
	public void setDesc(String d)
	{
		description = d;
	}
	
	public String getDesc()
	{
		return description;
	}
	
	public boolean custOrder(int q)
	{
		if ((quantity - q) > 0)					
			if ((quantity - q) <= minQuant)
				{
					quantity -= q;
					return false;		// return false if after removing the quantity, it is now less than 1/5
				}
			else
				{
					quantity -= q;
					return true;	// quantity is above 0 and above 1/5 after removing, return true
				}
		else
			{
				return false;	// if the quantity the guest wants is unavailable return false
			}

	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public void orderMore(int q)
	{
		quantity = maxQuant;
	}
}
