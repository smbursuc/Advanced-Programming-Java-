package tema7;

import java.util.concurrent.TimeUnit;

public class Timekeeper implements Runnable
{
	
	private boolean stop = false;
	
	public Timekeeper()
	{
	
	}
	
	public boolean getStop()
	{
		return stop;
	}
	
	public void run()
	{
		long start = System.currentTimeMillis();
		long end = start + 3*1000; //
		while (System.currentTimeMillis() < end)
		{
			long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()-start);
			System.out.println("Timeeee: " + seconds);
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
	    stop = true;
	}

}
