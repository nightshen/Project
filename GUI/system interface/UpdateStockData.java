import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Calendar;

public class UpdateStockData {

	String file_path = "C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\";
	int[] stockNumber = {2002, 2317, 2498};
	int[] oldYear = {0, 0, 0};
	int[] oldMonth = {0, 0, 0};
	int[] oldDate = {0, 0, 0};
	int[] NowDate = {0, 0, 0};
	
	public void DownloadStockData() throws IOException
	    {	
	    	Calendar calendar = Calendar.getInstance();
	    	int nowYear = calendar.get(Calendar.YEAR);		
	        int nowMonth = calendar.get(Calendar.MONTH);
	        nowMonth += 1;      
	        
	        getTime();
	        for(int h = 0; h < stockNumber.length; h++)
	        {
	        	String path = file_path + Integer.toString(stockNumber[h]) + ".csv";        
	            String first, last, url;
	        	first = "http://www.twse.com.tw/exchangeReport/STOCK_DAY?response=html&date=";
	        	last = "01&stockNo=";
	            try {
	            	int D = 0;
	            	int MONTH = oldMonth[h];
	            	FileWriter fw = new FileWriter(path,true);
	    	    	for(oldYear[h] = oldYear[h]; oldYear[h] <= nowYear; oldYear[h]++)
	    	    	{    	    		
	    	    		for(oldMonth[h] = oldMonth[h]; oldMonth[h] <= 12; oldMonth[h]++)
	    	    		{
	    	    			int temp;
	    	    			if(oldYear[h] == nowYear && oldMonth[h] > nowMonth)
	    	    				break;
	    	    				
	    	    			if(oldMonth[h] < 10)
	    	    				temp = oldYear[h] * 10;
	    	    			else
	    	    				temp = oldYear[h];
	    	    			
	    	    			url = first + Integer.toString(temp) + Integer.toString(oldMonth[h]) + last + Integer.toString(stockNumber[h]);
	    	    			
	    	    			Document doc = Jsoup.connect(url).get();
	    					Elements link = doc.select("tbody");
	    					String linkText = link.text();
	    	        		System.out.println(linkText);
	    	        		
	    	        		linkText = linkText.replaceAll(",", "");
	    	        		linkText = linkText.replaceAll(" ", ",");
	    	        		String[] str = linkText.split("\\,");
	    	        		
	    	        		for(int i = 0; i < str.length; i++)
	    	        		{	
	    	        			
	    	        			int M = 0;
	    		        		if(i % 9 == 0)
	        		        	{
	    		        			String[] k = str[i].split("/");
	        		        		int j = Integer.parseInt(k[0]);
	        		        		M = Integer.parseInt(k[1]);
	        		        		D = Integer.parseInt(k[2]);		        		
	        		        		j += 1911;
	        		        		str[i] = Integer.toString(j) + "/" + k[1] + "/" +k[2];
	        		        	}
	        	        		
	    		        		if(M == MONTH)
	    		        		{
	    		        			if(D <= oldDate[h])
	    		        			{
	    		        				i += 8;
	    		        				continue;
	    		        			}
	    		        			else
	    		        			{
	    		        				if(i % 9 == 8)
	                		        		fw.append(str[i] + "\r\n");	
	                		        	else	        		
	                		        		fw.append(str[i] + ",");
	    		        			}
	    		        		}
	    		        		else
	    		        		{
	    		        			if(i % 9 == 8)
	            		        		fw.append(str[i] + "\r\n");	
	            		        	else	        		
	            		        		fw.append(str[i] + ",");
	    		        		}
	        	        		   	        				        		
	    	        		}
	    	        		fw.flush();
	    	        		
	    	        		NowDate[h] = D;
	    	        		setTime();
	    	        		
	    	        		if(oldMonth[h] == nowMonth)
	    	        			break;
	    	        		
	    	        		try {
	    						Thread.sleep(5000);
	    					} catch (InterruptedException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}   
	    	        		
	    	    		}
	    	    		if(oldYear[h] == nowYear)
	    	    			break;
	    	    	}  
	    	    	fw.close();
	            }
	        	catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }         	
	    }
	    
	    public void getTime() throws IOException
	    {
	    	FileReader fr = new FileReader("C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\Time.txt");    	
	    	BufferedReader br = new BufferedReader(fr);
	    	for(int i = 0; i < stockNumber.length; i++)
	    	{
	    		String str = br.readLine();
	        	String[] l = str.split("/");
	        	oldYear[i] = Integer.parseInt(l[0]);
	        	oldMonth[i] = Integer.parseInt(l[1]); 
	        	oldDate[i] = Integer.parseInt(l[2]);
	        	
	    	}
	    	
	    	fr.close();
	    }
	    
	    public void setTime() throws IOException
	    {    	       
	        
	        FileWriter fw = new FileWriter("C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\Time.txt");
	    	
	    	for(int i = 0; i < stockNumber.length; i++)
	    	{
	    		String str = Integer.toString(oldYear[i]) + "/" + Integer.toString(oldMonth[i]) + "/" + Integer.toString(NowDate[i]);
	    		fw.write(str + "\r\n");
	        	fw.flush();
	    	}
	    	fw.close();
	    }
	    
	    public void Init() throws IOException
	    {
	    	String stock = "日期,成交股數,成交金額,開盤價,最高價,最低價,收盤價,漲跌價差,成交筆數";
	    	for(int i = 0; i < stockNumber.length; i++)
	    	{
	    		String path = file_path + Integer.toString(stockNumber[i]) + ".csv";
	    	    File file = new File(path);
	    	    BufferedWriter writer;		
	    	    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "BIG5"));			
	    	    writer.write(stock + "\r\n"); 
	    	    writer.close();
	    	}
	    }
}
