import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class CalculateResult {
	public static int read(String stock,String Date[],double Highest_Price[],double Lowest_Price[],double Closing_Price[]) throws IOException
	{
		String path = ("C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\stock\\" + stock + ".csv");
		FileReader fr = new FileReader(path);    	
    	BufferedReader br = new BufferedReader(fr);
    	System.out.print(stock + ".csv" + "\r\n");
    	int flag = 0;
    	String line;
        ArrayList myList = new ArrayList();
        while((line = br.readLine())!=null)
        {
        	if(flag == 0)
        		flag = 1;
        	else
        	{
        		String tempArray[]  = line.split("\\,");
        		for (int z = 0; z < tempArray.length; z++) 
        		{
        			myList.add(tempArray[z]);
        		}
        	}	
        }

        int count = 0;
        int kk = 0;
        double t = 0;
        for (Object obj : myList) 
        {
        	if(kk % 9 == 4)
        	{	
        		if(obj.toString().equals("--"))
        			t = 0;
        		else
        			t = Double.parseDouble(obj.toString());
        		
        		Highest_Price[count] = t;
        	}
        	else if(kk % 9 == 5)
        	{	
        		if(obj.toString().equals("--"))
        			t = 0;
        		else
        			t = Double.parseDouble(obj.toString());
        		
        		Lowest_Price[count] = t;
        	}
        	else if(kk % 9 == 6)
        	{	
        		if(obj.toString().equals("--"))
        			t = 0;
        		else
        			t = Double.parseDouble(obj.toString());
        		
        		Closing_Price[count] = t;
        		count++;
        	}
        	else if(kk % 9 == 0)
        	{
        		Date[count] = obj.toString();
        		
        	}      	
        	kk++;
        }
        
		return count;
	}
	public static double RSV(double Highest_Price,double Lowest_Price,double Closing_Price)
	{
		return (Closing_Price-Lowest_Price)/(Highest_Price-Lowest_Price)*100;
	}
	public void Calculate() throws IOException {
		// TODO Auto-generated method stub
		String[] stock={
			                "1101","1102","1216","1301",
			                "1303","1326","1402","1722",
			                "2002","2105","2201","2207",
			                "2301","2303","2308","2317",
			                "2324","2330","2347","2352",
			                "2353","2354","2357","2377",
			                "2382","2409","2412","2454",
			                "2456","2474","2801","2880",
			                "2881","2882","2883","3045",
			                "2912","2892","2891","2890",
			                "2886","2885"
			             };
		
		for(int stock_num=0;stock_num<42;stock_num++)
		{
			//---define--//
		    String txt = "", name = "";
		    int s=0;
		    String[] Date;
		    Date = new String[10000]; 
		    double[] Highest_Price;
		    Highest_Price = new double[10000];
		    double[] Lowest_Price;
		    Lowest_Price = new double[10000];
		    double[] Closing_Price;
		    Closing_Price = new double[10000];
		    for(int l = 0; l < Date.length; l++)
		    	Date[l] = "";
		    for(int l = 0;l < Highest_Price.length;l++)
		    {
		    	Highest_Price[l] = 0;
		    	Lowest_Price[l] = 0;
		    	Closing_Price[l] = 0;
		    }
		    
		    //-KD-//
		    double rsv = 0, K = 0, D = 0;
		    double[] k, d;
		    k = new double[6000];
		    d = new double[6000];
		    Vector high = new Vector();
		    Vector low = new Vector();
		    double highest = 0;
		    double lowest = 0;
		    for(int l = 0;l < k.length;l++)
		    {
		    	k[l] = 0;
		    	d[l] = 0;
		    }
		    
		    //-RSI-//
		    double RS = 0, H = 0, L = 0, last_day = 0;
		    double[] RSI_short, RSI_long;
		    RSI_short = new double[10000];
		    RSI_long = new double[10000];
		    for(int l = 0;l < RSI_short.length;l++)
		    {
		    	RSI_short[l] = 0;
		    	RSI_long[l] = 0;
		    }
		    
		    //----------------input----------------//
		    
		    s = read(stock[stock_num],Date,Highest_Price,Lowest_Price,Closing_Price);
		    for(int i=1;i<s;i++)
		    {
		        if(Highest_Price[i]==0)
		            Highest_Price[i]=Highest_Price[i-1];
		        if(Lowest_Price[i]==0)
		            Lowest_Price[i]=Lowest_Price[i-1];
		        if(Closing_Price[i]==0)
		            Closing_Price[i]=Closing_Price[i-1];
		    }
		    int km=-1;
		    for(int i=2491;i<s;i++)
		    {
		        km++;
		        Date[km]=Date[i];
		        Highest_Price[km]=Highest_Price[i];
		        Lowest_Price[km]=Lowest_Price[i];
		        Closing_Price[km]=Closing_Price[i];
		    }
		    s=km+1;
		    
		    //----------------KD----------------//
		    
		    for(int i=0;i<8;i++)
		    {
		        high.insertElementAt(Highest_Price[i], 0);
		        low.insertElementAt(Lowest_Price[i], 0);
		    }
		    highest = new Double(Collections.max(high).toString());
		    lowest = new Double(Collections.min(low).toString());
		    K = RSV(highest, lowest, Closing_Price[8]);
		    D = K;
		    
		    for(int i=9;i<s;i++)
		    {
		    	high.insertElementAt(Highest_Price[i], 0);
		        low.insertElementAt(Lowest_Price[i], 0);
		        high.remove(high.size() - 1);
		        low.remove(high.size() - 1);
		        highest = new Double(Collections.max(high).toString());
			    lowest = new Double(Collections.min(low).toString());
		        rsv=RSV(highest,lowest,Closing_Price[i]);
		        K = (2 * K + rsv)/3;
		        D = (2 * D + K)/3;
		        k[i]=K;d[i]=D;
		    }
		    
		    //----------------RSI----------------//
		    
		    for(int i=11;i<s;i++)
		    {
		        H=0;L=0;RS=0;

		        for(int j=i-5;j<=i;j++)
		        {
		            last_day=Closing_Price[j]-Closing_Price[j+1];
		            if(last_day>=0){
		                H=H+last_day;
		            }
		            if(last_day<=0){
		                L=L+last_day;
		            }
		        }
		        H=H/6;
		        L=L/6;
		        RS=H/L;
		        RSI_short[i]=RS/(RS+1)*100;

		        H=0;L=0;RS=0;

		        for(int j=i-11;j<=i;j++)
		        {
		            last_day=Closing_Price[j]-Closing_Price[j+1];
		            if(last_day>=0){
		                H=H+last_day;
		            }
		            if(last_day<=0){
		                L=L+last_day;
		            }
		        }
		        H=H/12;
		        L=L/12;
		        RS=H/L;
		        RSI_long[i]=RS/(RS+1)*100;
		    }
		    
		    //----------------W%R----------------//
		    double[] WR_short, WR_long;
		    WR_short = new double[10000];
		    WR_long = new double[10000];
		    for(int l = 0;l < RSI_short.length;l++)
		    {
		    	WR_short[l] = 0;
		    	WR_long[l] = 0;
		    }
		    
		    for(int i=17;i<s;i++)
		    {
		        double max_price=0,min_price=99999;
		        for(int j=i-8;j<=i;j++)
		        {
		            if(max_price < Highest_Price[j]){
		                max_price = Highest_Price[j];
		            }
		            if(min_price > Lowest_Price[j]){
		                min_price = Lowest_Price[j];
		            }
		        }
		        WR_short[i] = (max_price - Closing_Price[i])/(max_price - min_price) * 100;
		        WR_short[i] = (int)(WR_short[i] * 100 + 0.5) / 100. ;
		        max_price = 0;
		        min_price = 99999;
		        for(int j=i-17;j<=i;j++)
		        {
		            if(max_price < Highest_Price[j]){
		                max_price = Highest_Price[j];
		            }
		            if(min_price > Lowest_Price[j]){
		                min_price = Lowest_Price[j];
		            }
		        }
		        WR_long[i] = (max_price - Closing_Price[i])/(max_price - min_price) * 100;
		        WR_long[i] = (int)(WR_long[i] * 100 + 0.5) / 100. ;
		    }
		    
		    //---output---//

		    int my_money=2000;
		    int tempc = 0;
		    int st = 0;
		    
		    //---filename---//
		    
		    FileWriter fw = new FileWriter("C:\\Users\\佳昇\\Desktop\\GUI\\system interface\\result\\" + stock[stock_num] + "ALL.txt");
		    System.out.print("create: " + stock[stock_num] + "ALL.txt" + "\r\n");
		    
		    boolean[] buy1, buy2, buy3, buy_mid1, buy_mid2, buy_final;
		    boolean[] sell1, sell2, sell3, sell_mid1, sell_mid2, sell_final;

		    buy1 = new boolean[10000];
		    buy2 = new boolean[10000];
		    buy3 = new boolean[10000];
		    buy_mid1 = new boolean[10000];
		    buy_mid2 = new boolean[10000];
		    buy_final = new boolean[10000];
		    sell1 = new boolean[10000];
		    sell2 = new boolean[10000];
		    sell3 = new boolean[10000];
		    sell_mid1 = new boolean[10000];
		    sell_mid2 = new boolean[10000];
		    sell_final = new boolean[10000];
		    
		    for(int l = 0;l < buy1.length;l++)
		    {
		    	buy1[l] = false;
			    buy2[l] = false;
			    buy3[l] = false;
			    buy_mid1[l] = false;
			    buy_mid2[l] = false;
			    buy_final[l] = false;
			    sell1[l] = false;
			    sell2[l] = false;
			    sell3[l] = false;
			    sell_mid1[l] = false;
			    sell_mid2[l] = false;
			    sell_final[l] = false;
		    }
		    
		    for(int i=41;i<s;i++)
		    {
		        //-BIAS-//
		        if((WR_short[i] - WR_long[i]) < 2)
		        if(/*BIAS[i] <= -4.5 && */WR_short[i] >= 90)
		            buy1[i]=true;
		        //-KD-//
		        //if(d[i-2]<15&&d[i-1]<15&&d[i]<15)
		        if(k[i-3]<d[i-3]&&k[i-2]<d[i-2]&&k[i-1]<d[i-1]&&k[i]>d[i]){
		            buy2[i]=true;
		        }
		        //-RSI-//
		        if(RSI_short[i]>90)
		        if(RSI_short[i-3]<RSI_long[i-3]&&RSI_short[i-2]<RSI_long[i-2]&&RSI_short[i-1]<RSI_long[i-1]&&RSI_short[i]>RSI_long[i]){
		            buy3[i]=true;
		        }
		        //------------------------buy-sell------------------------//
		        //-BIAS-//
		        if((WR_short[i] - WR_long[i]) < 2)
		        if(/*BIAS[i] >= 5 && */WR_short[i] <= 10)
		            sell1[i]=true;
		        //-KD-//
		        //if(d[i-2]>85&&d[i-1]>85&&d[i]>85)
		        if(k[i-3]>d[i-3]&&k[i-2]>d[i-2]&&k[i-1]>d[i-1]&&k[i]<d[i]){
		            sell2[i]=true;
		        }
		        //-RSI-//
		        if(RSI_short[i]<10)
		        if(RSI_long[i-3]<RSI_short[i-3]&&RSI_long[i-2]<RSI_short[i-2]&&RSI_long[i-1]<RSI_short[i-1]&&RSI_long[i]>RSI_short[i]){
		            sell3[i]=true;
		        }
		    }
		    
		    for(int i=10;i<s;i++)
		    {
		        //if((buy1[i-4]!=0||buy1[i-3]!=0||buy1[i-2]!=0||buy1[i-1]!=0||buy1[i]!=0)&&buy2[i]!=0)
		           //buy_mid1[i]=1;
		       if((buy3[i-4] != false||buy3[i-3]!=false||buy3[i-2]!=false||buy3[i-1]!=false||buy3[i]!=false)&&buy2[i]!=false)
		           buy_mid2[i]=true;

		        //if((sell1[i-4]!=0||sell1[i-3]!=0||sell1[i-2]!=0||sell1[i-1]!=0||sell1[i]!=0)&&sell2[i]!=0)
		           //sell_mid1[i]=1;
		       if((sell3[i-4]!=false||sell3[i-3]!=false||sell3[i-2]!=false||sell3[i-1]!=false||sell3[i]!=false)&&sell2[i]!=false)
		           sell_mid2[i]=true;


		        //if((new_buy[i-4]!=0||new_buy[i-3]!=0||new_buy[i-2]!=0||new_buy[i-1]!=0||new_buy[i]!=0)&&buy2[i]!=0)
		        //  buy_mid2[i]=1;
		        //if((new_sell[i-4]!=0||new_sell[i-3]!=0||new_sell[i-2]!=0||new_sell[i-1]!=0||new_sell[i]!=0)&&sell2[i]!=0)
		        //   sell_mid2[i]=1;
		    }
		    
		    for(int i=3;i<s;i++)
		    {
		        if((buy1[i-3]!=false||buy1[i-2]!=false||buy1[i-1]!=false||buy1[i]!=false)&&buy_mid2[i]!=false)
		           buy_final[i]=true;

		        if((sell1[i-3]!=false||sell1[i-2]!=false||sell1[i-1]!=false||sell1[i]!=false)&&sell_mid2[i]!=false)
		           sell_final[i]=true;
		    }
		    
		    for(int i=0;i<s;i++)
		    {
		        /*if(buy1[i])
		            fin<<Date[i]<<"  buy_price:   "<<Closing_Price[i]<<endl;
		        if(sell1[i])
		            fin<<Date[i]<<"  sell_price:   "<<Closing_Price[i]<<endl;*/
		        if(buy_final[i]!=false){
		                    tempc = 0;
		                    tempc = my_money/4;
		                    st = st + (int)(tempc/Closing_Price[i]);
		                    int y = (int)(Closing_Price[i]+0.5);
		                    my_money = my_money - (my_money / 4) + tempc%y;
		            
		                    fw.write(Date[i] + "  buy_price:   " + Closing_Price[i] + "   |   "+ "         st: "+ st+ " m: " + my_money + "\r\n");
		                    fw.flush();
		        }
		        if(sell_final[i]!=false){
		            if(st>1)
		            {
		                tempc = 0;
		                tempc = st / 2;
		                st = st - (tempc);
		                my_money = my_money + (int)(tempc*Closing_Price[i]);
		            }
		            else if(st==1)
		            {
		                tempc = 0;
		                tempc = 1;
		                st = st - (tempc);
		                my_money = my_money + (int)(tempc*Closing_Price[i]);
		            }
		            fw.write(Date[i] + "  sell_price:   " + Closing_Price[i] + "   |   "+ "         st: "+ st+ " m: " + my_money + "\r\n");
                    fw.flush();}
		    }
		    
		    fw.write("\r\n");
		    fw.flush();
		    if(st!=0)
		    {
		    	fw.write("stock you have: " + st + "\r\n");
		    	fw.write("my_money (didn't sell): " + my_money + "\r\n");
		        my_money = my_money + (int)(st*Closing_Price[s-1]);
		    }
		    fw.write(Date[s-1] + " total money (sell the stock): " + my_money);
		    fw.close();
		}
	}

}
