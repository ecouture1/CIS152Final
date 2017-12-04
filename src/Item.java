import java.util.List;
import java.util.ArrayList;

/**
 * @author Eli Couture, creates and hosts methods for an Item
 *
 */
public class Item
{
	private int quantity;
	private String name;
	private String description;
	private int minQuant;
	private int maxQuant;
	private int QuantPrint;
	private double price;
	private List<Integer> orderQuants = new ArrayList<Integer>();
	private int orderQuantsLoc = 0;
	
	/**
	 * @param n, name
	 * @param desc, description
	 * @param q, quantity
	 * @param p, price
	 */
	public Item(String n, String desc, int q, double p)
	{
		name = n;
		description = desc;
		quantity = q;					// original quantity is the max quantity
		maxQuant = q;					// set to reflect that
		minQuant = (quantity/5) + 1;    // minimum quantity is 1/5 of the quantity, truncated to int always rounded up.
		QuantPrint = maxQuant;
		price = p;
	}
	
	/**
	 * @return quantity
	 */
	public int getQuant()
	{
		return quantity;
	}
	
	/**
	 * @param n, name
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * @return minQuant - read only
	 */
	public int getMin()
	{
		return minQuant;
	}
	
	/**
	 * @return maxQuant - read only
	 */
	public int getMax()
	{
		return maxQuant;
	}
	
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return orderQuant
	 */
	public int getOrderQuant()
	{
		int x = orderQuants.get(orderQuantsLoc);
		orderQuantsLoc++;
		return x;
	}
	
	/**
	 * @param q
	 */
	public void setOrderQuant(int q)
	{
		orderQuants.add(q); // each customer will order an individual amount of items.
	}
	
	/**
	 * @param d
	 */
	public void setDesc(String d)
	{
		description = d;
	}
	
	/**
	 * @return description
	 */
	public String getDesc()
	{
		return description;
	}
	
	/**
	 * @param q, quantity
	 * @return 1, 2, or 3 depending on end quantity
	 */
	public int custOrder1(int q) // does not remove quantity at all, peeks to see if allowed
	{
		if ((quantity - q) > 0)					
			if ((quantity - q) <= minQuant)
				{
					return 1;		// return 1 if after removing the quantity, it is now less than 1/5
				}
			else
				{
					return 2;	// quantity is above 0 and above 1/5 after removing, return true
				}
		else
			{
				return 0;	// if the quantity the guest wants is unavailable return false
			}

	}
	
	/**
	 * @param q
	 */
	public void custOrder2(int q) // actually orders items
	{
		quantity -= q;
	}
	
	/**
	 * @return price 
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * @param p
	 */
	public void setPrice(double p)
	{
		price = p;
	}
	
	/**
	 * @param q
	 */
	public void orderMore() // Stack/Manager order more, puts quantity back up to full.
	{
		quantity = maxQuant;
	}
	
	public String toString()
	{
		return name + " is back to full";
	}
	
	public int quantPrint(int q) // tracking/testing method. unaffected until print sequence. returns quantity after ordering.
	{
		QuantPrint -= q;
		int x = QuantPrint;
		return x;
	}
	
	public int getQuantPrint()
	{
		return QuantPrint;
	}
}
