import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Calendar;

public class UpdateStockData {

	String file_path = "C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\";
	//, 3231, 3481, 3673, 4904, 5880, 6505
	 
	int[] stockNumber = {2303, 2330, 2352, 2377, 2412, 2454, 2456,
						 2002, 2317, 1101, 1102, 1216, 1301, 1303, 
						 1402, 1722, 2105, 2201, 2207, 2301, 2308, 2885,
						 2324, 2347, 2353, 2354, 2357, 2382, 1326, 2886,
						 2409, 2474, 2801, 2880, 2882, 2881, 2883, 2890,
						 2891, 2892, 2912, 3045};
						 
	int[] oldYear;
	int[] oldMonth;
	int[] oldDate;
	int[] NowDate;
	int[] NowMonth;
	int[] NowYear;
	
	public void DownloadStockData() throws IOException
	    {	
			oldYear = new int[stockNumber.length];
			oldMonth = new int[stockNumber.length];
			oldDate = new int[stockNumber.length];
			NowDate = new int[stockNumber.length];
			NowMonth = new int[stockNumber.length];
			NowYear = new int[stockNumber.length];
			
			for(int array = 0; array < stockNumber.length; array++)
			{
				oldYear[array] = 0;
				oldMonth[array] = 0;
				oldDate[array] = 0;
				NowDate[array] = 0;
				NowMonth[array] = 0;
				NowYear[array] = 0;
			}
			
	    	Calendar calendar = Calendar.getInstance();
	    	int nowYear = calendar.get(Calendar.YEAR);		
	        int nowMonth = calendar.get(Calendar.MONTH);
	        int nowDate = calendar.get(Calendar.DATE);
	        nowMonth += 1;      
	        
	        getTime();
	        for(int h = 0; h < stockNumber.length; h++)
	        {
	        	if(nowYear == oldYear[h] && nowMonth == oldMonth[h] && nowDate == oldDate[h])
	        		continue;
	        	String path = file_path + Integer.toString(stockNumber[h]) + ".csv";        
	            String first, last, url;
	        	first = "http://www.twse.com.tw/exchangeReport/STOCK_DAY?response=html&date=";
	        	last = "01&stockNo=";
	            File file = new File(path); 
	        	if(!file.exists())
	        		Init(stockNumber[h]);
	        	try {
	            	int D = 0;
	            	int MONTH = oldMonth[h];
	            	FileWriter fw = new FileWriter(path,true);
	    	    	for(int year = oldYear[h]; year <= nowYear; year++)
	    	    	{    	    		
	    	    		for(int mon = oldMonth[h]; mon <= 12; mon++)
	    	    		{
	    	    			int temp;
	    	    				
	    	    			if(year == nowYear && mon > nowMonth)
	    	    				break;
	    	    			
	    	    			if(mon < 10)
	    	    				temp = year * 10;
	    	    			else
	    	    				temp = year;
	    	    			
	    	    			url = first + Integer.toString(temp) + Integer.toString(mon) + last + Integer.toString(stockNumber[h]);
	    	    			
	    	    			Document doc = Jsoup.connect(url).get();
	    					Elements link = doc.select("tbody");
	    					String linkText = link.text();
	    	        		System.out.print("Now Download " + stockNumber[h] + "\r\n");
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
	        		        		NowMonth[h] = M;
	        		        		NowYear[h] = j;
	        		        	}
	        	        		
	    		        		if(M == MONTH)
	    		        		{
	    		        			if(D <= oldDate[h] && year <= oldYear[h] && mon <= oldMonth[h])
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
	    	        		
	    	        		oldMonth[h] = mon;
	    	        		if(mon == 12)
	    	        			oldMonth[h] = 1;
	    	        		
	    	        		NowDate[h] = D;
	    	        		setTime();
	    	        		
	    	        		if(mon == 12)
	    	        			break;
	    	        		
	    	        		try {
	    						Thread.sleep(5000);
	    					} catch (InterruptedException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}   
	    	        		
	    	    		}
	    	    		if(year == nowYear)
	    	    			break;
	    	    	}  
	    	    	fw.close();
	            }
	        	catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	            try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
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
	        	NowYear[i] = Integer.parseInt(l[0]);
	        	NowMonth[i] = Integer.parseInt(l[1]); 
	        	NowDate[i] = Integer.parseInt(l[2]);
	        	
	    	}
	    	
	    	fr.close();
	    }
	    
	    public void setTime() throws IOException
	    {    	       
	        
	        FileWriter fw = new FileWriter("C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\Time.txt");
	    	
	    	for(int i = 0; i < stockNumber.length; i++)
	    	{
	    		
	    		String str = Integer.toString(NowYear[i]) + "/" + Integer.toString(NowMonth[i]) + "/" + Integer.toString(NowDate[i]);
	    		fw.write(str + "\r\n");
	        	fw.flush();
	    	}
	    	fw.close();
	    }
	    
	    public void Init(int stocknum) throws IOException
	    {
	    	String stock = "日期,成交股數,成交金額,開盤價,最高價,最低價,收盤價,漲跌價差,成交筆數";
	    	
	    	String path = file_path + Integer.toString(stocknum) + ".csv";
	    	File file = new File(path);
	    	BufferedWriter writer;		
	    	writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "BIG5"));			
	    	writer.write(stock + "\r\n"); 
	    	writer.close();
	    	
	    }
}
