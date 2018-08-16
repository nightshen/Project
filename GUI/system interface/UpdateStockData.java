import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Calendar;

public class UpdateStockData {

	String file_path = "C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\";
	//int[] stockNumber = {2002, 2317, 2498, 2332, 2376, 2412, 2448, 2329};
	int[] stockNumber = {2303, 2330, 2352, 2377, 2412, 2454, 2456, 2492};
	int[] oldYear = {0, 0, 0, 0, 0, 0, 0, 0};
	int[] oldMonth = {0, 0, 0, 0, 0, 0, 0, 0};
	int[] oldDate = {1, 1, 1, 1, 1, 1, 1, 1};
	int[] NowDate = {1, 1, 1, 1, 1, 1, 1, 1};
	int[] NowMonth = {1, 1, 1, 1, 1, 1, 1, 1};
	int[] NowYear = {2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003};
	
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
	            File file = new File(path); 
	        	if(!file.exists())
	        		Init();
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
