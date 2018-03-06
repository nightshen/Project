import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPicture {
	
	public  void Download() 
	{
		String ss;
	    URL url =null ;
	    try 
	    {        
	        String[] pic = {"https://stock.wearn.com/finance_chart.asp?stockid=2317&timekind=0&timeblock=90&sma1=&sma2=&sma3=&volume=0&indicator1=SStoch&indicator2=MACD&indicator3=Vol.jpg",    
	                        "https://stock.wearn.com/finance_chart.asp?stockid=2498&timekind=0&timeblock=90&sma1=&sma2=&sma3=&volume=0&indicator1=SStoch&indicator2=MACD&indicator3=Vol.jpg",    
	                        "https://stock.wearn.com/finance_chart.asp?stockid=2002&timekind=0&timeblock=90&sma1=&sma2=&sma3=&volume=0&indicator1=SStoch&indicator2=MACD&indicator3=Vol.jpg"};

	        for (int k=0; k< pic.length ; k++)
	        {
	            ss = pic[k].substring(pic[k].length() - 108, pic[k].length() - 104);
	            ss += ".jpg";
	            
	        	url = new URL(pic[k]);
	            FileOutputStream fos = new FileOutputStream(ss, false);
	            InputStream is = url.openStream();
	            
	            int chunkSize = 1024 * 32;
	            byte[] buf = new byte[chunkSize];
	            int readLen;
	            while ((readLen = is.read( buf, 0, buf.length)) != -1)
	            {
	               fos.write(buf, 0, readLen);  
	            }

	            is.close();
	            fos.close();
	        }
	        
	    } 
	    catch (MalformedURLException e) 
	    {
	        e.printStackTrace();
	    } 
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}       

}
