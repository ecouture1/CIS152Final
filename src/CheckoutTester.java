import java.util.Random;

/**
 * @author Eli Couture, tests methods from other classes
 *
 */
public class CheckoutTester
{
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Queue customers = new Queue(20);
		Item[] possibleItems = new Item[20];
		Random generator = new Random();
		

		possibleItems = genItemArr(generator);
		
		customers.generateCustomers(possibleItems);
		
		while (!customers.isEmpty())
			{
				customers.dequeue().order(); // takes the customer at front and "sends it through the checkout"
			}
	}
	
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
				int q = generator.nextInt(30) + 10;
				double p = (generator.nextDouble() * 30) + 1;
				p = ((int)(p*100)/100);
				pi[i] = new Item(("Object" + temp), ("Object" + temp++), q, p);
			}
		return pi;
	}
	
	

}
