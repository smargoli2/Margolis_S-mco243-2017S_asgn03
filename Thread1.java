package mutualexclusion;

import java.util.Random;

public class Thread1 implements Runnable
{
	int favoredThread;
	boolean t1wantsToEnter;
	boolean t2wantsToEnter;
	
	public Thread1(int favored, boolean t1wantsToEnter, boolean t2wantsToEnter){
	
		this.favoredThread = favored;
		this.t1wantsToEnter = t1wantsToEnter;
		this.t2wantsToEnter = t2wantsToEnter;
	}
	
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			t1wantsToEnter = true;
			try
			{
				Thread.sleep(20);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (favoredThread == 2)
			{
				while (t2wantsToEnter);
				
				favoredThread = 1;
			}
			
			System.out.println("T1 Entering critical section");
			
			System.out.println("T1 Exiting critical section");
			t1wantsToEnter = false;
			// non-critical code // non-critical code
		}
	}
	
}
