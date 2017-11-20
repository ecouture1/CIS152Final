import java.util.Random;

public class CheckoutTester
{
	
	Random generator = new Random();
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Queue customers = new Queue(20);
		Item[] possibleItems = new Item[20];
		
		possibleItems[0] = new Item("Spray Paint", "Red, Blue, Green aerosolised paint", 30, 4.97);
		possibleItems[1] = new Item("Snickers Candy Bar", "Peanut, Caramel, Chocolate", 30, 1.34);
		
		customers.generateCustomers(possibleItems);
	}

}
