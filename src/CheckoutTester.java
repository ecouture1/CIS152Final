import java.util.Random;

public class CheckoutTester
{
	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Queue customers = new Queue(20);
		Item[] possibleItems = new Item[20];
		Random generator = new Random();
		
		char temp = 'A';
		for (int i = 0; i < 20; i++)
			{
				int q = generator.nextInt(30) + 10;
				double p = (generator.nextDouble() * 30) + 1;
				p = ((int)(p*100)/100);
				possibleItems[i] = new Item(("Object" + temp), ("Object" + temp++), q, p);
			}
		
		customers.generateCustomers(possibleItems);
		
		while (!customers.isEmpty())
			{
				customers.dequeue().order();
			}
	}
	
	

}
