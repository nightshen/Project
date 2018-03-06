
public class PreventBaga {

	/**
	 * [預算,起始月份,終止月份,起始日期,終止日期,停利,停損]
	 */
	private int[] INPUT = {0, 0, 0, 0, 0, -1, -1};
	private String STOCKNAME = "";
	
	
	public PreventBaga (String b, int sm, int em, String sd, String ed, String sw, String sl, String stock)
	{
		if(IsNum(b))
			getINPUT()[0] = Integer.parseInt(b);
				
		setINPUT(1,sm);

		setINPUT(2,em);

		if(IsNum(sd))
			getINPUT()[3] = Integer.parseInt(sd);

		if(IsNum(ed))
			getINPUT()[4] = Integer.parseInt(ed);

		if(IsNum(sw))
			getINPUT()[5] = Integer.parseInt(sw);

		if(IsNum(sl))
			getINPUT()[6] = Integer.parseInt(sl);
		
		if(IsNum(stock))
			setSTOCKNAME(stock);
	}
	
	public Boolean IsNum(String str) {
		
		if(str.equals(""))
		{		
			return false;
		}
		for (int i = str.length();--i>=0;)
		{    
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}  
		return true;
	}
	
	public Boolean IsCorrectBudget(int budget) {
		
		if(budget < 100000 || budget > 10000000)
			return false;
		return true;
	}

	
	public Boolean IsCorrectStartMonthOrDay(int start) {
		
		if(getINPUT()[1] < 10 || getINPUT()[1] > 12)
			return false;
		
		if(start < 1)
			return false;
		if(getINPUT()[1] == 11)
		{
			if(start > 30)
				return false;
		}
		else
		{
			if(start > 31)
				return false;
		}
		return true;
	}
	
	public Boolean IsCorrectEndMonthOrDay(int end) {
		
		if(getINPUT()[2] < 10 || getINPUT()[2] > 12)
			return false;
		if(getINPUT()[1] > getINPUT()[2])
			return false;
		
		if(end < 1)
			return false;
		if(getINPUT()[2] == 11)
		{
			if(end > 30)
				return false;
		}
		else
		{
			if(end > 31)
				return false;	
		}
		if(getINPUT()[1] == getINPUT()[2])
		{
			if(getINPUT()[3] > getINPUT()[4])
				return false;		
		}
		return true;
	}
	
	public Boolean IsCorrectStopWin(int win) {
		
		if(win < 0 || win > 100)
			return false;
		return true;
	}
	
	public Boolean IsCorrectStopLose(int lose) {
		
		if(lose < 0 || lose > 100)
			return false;
		return true;
	}
	
	public Boolean Test() {
		
		if(!IsCorrectBudget(getINPUT()[0]))
			return false;
		if(!IsCorrectStartMonthOrDay(getINPUT()[3]))
			return false;
		if(!IsCorrectEndMonthOrDay(getINPUT()[4]))
			return false;
		if(!IsCorrectStopWin(getINPUT()[5]))
			return false;
		if(!IsCorrectStopLose(getINPUT()[6]))
			return false;
		
		return true;
	}

	public int[] getINPUT() {
		return INPUT;
	}

	public void setINPUT(int i, int iNPUT) {
		INPUT[i] = iNPUT; 
	}

	public String getSTOCKNAME() {
		return STOCKNAME;
	}

	public void setSTOCKNAME(String sTOCKNAME) {
		STOCKNAME = sTOCKNAME;
	}
	
	
	
}
