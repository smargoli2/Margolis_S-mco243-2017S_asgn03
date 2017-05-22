package mutualexclusion;

import java.util.Random;

public class RunThreads
{
	public static void main(String args[])
	{
		int favoredThread = 1;
		boolean t1wantsToEnter = false;
		boolean t2wantsToEnter = false;
		
		Thread t1 = new Thread(new Thread1(favoredThread, t1wantsToEnter, t2wantsToEnter));
		Thread t2 = new Thread(new Thread2(favoredThread, t1wantsToEnter, t2wantsToEnter));
		
		t1.start();
		t2.start();
		
	}
}
