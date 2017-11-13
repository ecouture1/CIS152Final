import java.util.Random;

public class CheckoutTester
{
	
	Random generator = new Random();
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Queue customers = new Queue(20);
	}
	
	public void generateCustomers(Queue q)
	{
		for (int i = 0; i < 20; i++)
			{
				int pick = generator.nextInt(10);
				
				if (pick <= 6)
					{
						Customer cust = new Customer();
						q.enqueue(cust);
					}
			}
	}
}
