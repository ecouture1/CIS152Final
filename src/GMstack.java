
/**
 * @author Eli Couture
 * This method creates a stack and hosts all of the methods for it
 *
 */
public class GMstack {
	
	private int maxSize;
	private Item[] stackArray;
	private int top;
	
	/**
	 * @param s, max size
	 */
	public GMstack(int s)
	{
		maxSize = s; 
		stackArray = new Item[maxSize];
		for (int i = 0; i < stackArray.length; i++)
			stackArray[i] = new Item("", "", 0, 0);
		top = -1;
	}
	
	/**
	 * @param piece, pushes the Item into the stack if it is not full
	 */
	public void push(Item piece)
	{
		boolean itemAlreadyInArray = false;
		for (Item curr : stackArray)
			{
				if (curr.getName().equals(piece.getName()))
					itemAlreadyInArray = true;
			}
			
		if (!itemAlreadyInArray)
			stackArray[++top] = piece;
	}
	
	/**
	 * prints and then removes Item off of top, if not empty
	 */
	public void pop()
	{
		if (!this.isEmpty())
			{
				System.out.println(stackArray[top--] + ".");
				
				if (top != -1)
					stackArray[top].orderMore();
			}
		else
			System.out.println("Can't remove: stack is empty.");
	}
	
	/**
	 *  prints the size of the array
	 */
	public void size()
	{
		System.out.println(top+1);
	}
	
	/**
	 * @return true if stack is empty
	 */
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	/**
	 * @return true if stack is full
	 */
	public boolean isFull()
	{
		return (top == maxSize-1);
	}
	
	/**
	 *  prints the toString for each item in stack
	 */
	public void print()
	{
		if (!this.isEmpty())
			for(Item piece : stackArray)
				System.out.println(piece);
		else
			System.out.println("Can't print: stack is empty.");

	}
	
	/**
	 *  prints top item without editing stack
	 */
	public void top()
	{
		System.out.println(stackArray[top]);
	}
}
