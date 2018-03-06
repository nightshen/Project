import java.util.Timer;
import java.util.TimerTask;

public class TimeWork extends TimerTask{
	
	public void run()
	{
		DownloadPicture dp = new DownloadPicture();
		dp.Download();
		System.out.println("Download!");
		
		
		
	}

	public void Work()
	{	
		TimeWork tw = new TimeWork();
		Timer timer = new Timer();
		timer.schedule(tw, 1000, 10000);
	}
}
