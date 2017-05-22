package mutualexclusion;

public class Thread2 implements Runnable
{
	
	int favoredThread;
	boolean t1wantsToEnter;
	boolean t2wantsToEnter;
	
	public Thread2(int favored, boolean t1wantsToEnter, boolean t2wantsToEnter)
	{
		
		this.favoredThread = favored;
		this.t1wantsToEnter = t1wantsToEnter;
		this.t2wantsToEnter = t2wantsToEnter;
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			t2wantsToEnter = true;
			while (favoredThread == 1)
			{
				while (t1wantsToEnter);
				
				favoredThread = 2;
			}
			try
			{
				Thread.sleep(30);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T2 Entering critical section");
			System.out.println("T2 Exiting critical section");
			t1wantsToEnter = false;
			// non-critical code // non-critical code
		}
	}
	
}
