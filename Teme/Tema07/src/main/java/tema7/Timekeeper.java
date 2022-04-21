package tema7;

import java.util.concurrent.TimeUnit;

public class Timekeeper implements Runnable
{
	
	public Timekeeper()
	{
	
	}
	
	public void run()
	{
		long start = System.currentTimeMillis();
		long end = start + 300*1000; //
		while (System.currentTimeMillis() < end)
		{
			long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()-start);
			System.out.println("Time: " + seconds);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Time's up");
	    System.exit(-1);
	}

}
