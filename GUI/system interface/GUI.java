import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.text.DateFormat;
import java.awt.Color;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.DropMode;

public class GUI {

	private JFrame frame;
	private JTextField budget;
	private JTextField e_day;
	private JTextField lose;
	private JTextField win;
	private String stockname = "";
	private int s_m = 0;
	private int e_m = 0;
	private JButton sendmessage = new JButton("送出");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 判斷是否為數字 
	 */
	public static boolean isNumeric(String str)
	{  
		if(str.equals(""))
			return false;
		for (int i = str.length();--i>=0;)
		{    
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}  
		return true;  
	}  
	
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("投資秘書");
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor("CheckBox.background"));
		textArea.setText("請輸入預算金額：");
		textArea.setBounds(10, 45, 120, 25);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setText("請選擇投資起始日期：");
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(10, 88, 155, 25);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_2.setEditable(false);
		textArea_2.setText("請選擇投資終止日期：");
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(10, 134, 155, 25);
		frame.getContentPane().add(textArea_2);
		
		budget = new JTextField();
		budget.setHorizontalAlignment(SwingConstants.TRAILING);
		budget.setBounds(140, 42, 110, 25);
		frame.getContentPane().add(budget);
		budget.setColumns(10);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setText("年");
		textArea_6.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_6.setEditable(false);
		textArea_6.setBackground(SystemColor.menu);
		textArea_6.setBounds(215, 134, 20, 25);
		frame.getContentPane().add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setText("月");
		textArea_7.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_7.setEditable(false);
		textArea_7.setBackground(SystemColor.menu);
		textArea_7.setBounds(262, 134, 20, 25);
		frame.getContentPane().add(textArea_7);
		
		e_day = new JTextField();
		e_day.setColumns(10);
		e_day.setBounds(282, 131, 25, 25);
		frame.getContentPane().add(e_day);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setText("日");
		textArea_8.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_8.setEditable(false);
		textArea_8.setBackground(SystemColor.menu);
		textArea_8.setBounds(310, 134, 25, 25);
		frame.getContentPane().add(textArea_8);	
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setText("請輸入停損比率：");
		textArea_9.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_9.setEditable(false);
		textArea_9.setBackground(SystemColor.menu);
		textArea_9.setBounds(10, 181, 120, 25);
		frame.getContentPane().add(textArea_9);
		
		lose = new JTextField();
		lose.setHorizontalAlignment(SwingConstants.TRAILING);
		lose.setColumns(10);
		lose.setBounds(140, 178, 50, 25);
		frame.getContentPane().add(lose);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setText("請輸入停利比率：");
		textArea_10.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_10.setEditable(false);
		textArea_10.setBackground(SystemColor.menu);
		textArea_10.setBounds(10, 231, 120, 25);
		frame.getContentPane().add(textArea_10);
		
		win = new JTextField();
		win.setHorizontalAlignment(SwingConstants.TRAILING);
		win.setColumns(10);
		win.setBounds(140, 228, 50, 25);
		frame.getContentPane().add(win);
		
		JTextArea test = new JTextArea();
		test.setEditable(false);
		test.setBounds(10, 347, 240, 188);
		frame.getContentPane().add(test);
		
		JTextArea error_budget = new JTextArea();
		error_budget.setEditable(false);
		error_budget.setBackground(UIManager.getColor("CheckBox.background"));
		error_budget.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_budget.setBounds(380, 45, 85, 25);
		frame.getContentPane().add(error_budget);
		
		JTextArea error_lose = new JTextArea();
		error_lose.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_lose.setEditable(false);
		error_lose.setBackground(SystemColor.menu);
		error_lose.setBounds(262, 181, 95, 25);
		frame.getContentPane().add(error_lose);
		
		JTextArea error_win = new JTextArea();
		error_win.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_win.setEditable(false);
		error_win.setBackground(SystemColor.menu);
		error_win.setBounds(262, 231, 95, 25);
		
		
		
		
		frame.getContentPane().add(error_win);
		sendmessage.setFont(new Font("Monospaced", Font.PLAIN, 15));
		sendmessage.setBounds(325, 487, 149, 48);
		frame.getContentPane().add(sendmessage);
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setBackground(UIManager.getColor("CheckBox.background"));
		textArea_11.setEditable(false);
		textArea_11.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_11.setText("(0~100%)");
		textArea_11.setBounds(190, 181, 70, 25);
		frame.getContentPane().add(textArea_11);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setText("(0~100%)");
		textArea_12.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_12.setEditable(false);
		textArea_12.setBackground(SystemColor.menu);
		textArea_12.setBounds(190, 231, 70, 25);
		frame.getContentPane().add(textArea_12);
		
		JMenuBar stock = new JMenuBar();
		stock.setForeground(Color.BLACK);
		stock.setBackground(new Color(220, 220, 220));
		stock.setFont(new Font("Monospaced", Font.PLAIN, 15));
		stock.setBounds(110, 277, 40, 30);
		frame.getContentPane().add(stock);
		
		JMenu choose_stock = new JMenu("股票");
		choose_stock.setForeground(Color.BLUE);
		choose_stock.setBackground(Color.LIGHT_GRAY);
		choose_stock.setFont(new Font("Monospaced", Font.PLAIN, 15));
		choose_stock.setHorizontalAlignment(SwingConstants.CENTER);
		stock.add(choose_stock);
		
		
		
		JMenuItem stock1 = new JMenuItem("中鋼");
		stock1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				choose_stock.setText("中鋼");
				stockname = "中鋼";
			}
		});
		stock1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		stock1.setHorizontalAlignment(SwingConstants.CENTER);
		choose_stock.add(stock1);
		
		JMenuItem stock2 = new JMenuItem("宏達");
		stock2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				choose_stock.setText("宏達");
				stockname = "宏達";
			}
		});
		stock2.setHorizontalAlignment(SwingConstants.CENTER);
		stock2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		choose_stock.add(stock2);
		
		JMenuItem stock3 = new JMenuItem("鴻海");
		stock3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				choose_stock.setText("鴻海");
				stockname = "鴻海";
			}
		});
		stock3.setHorizontalAlignment(SwingConstants.CENTER);
		stock3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		choose_stock.add(stock3);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("年");
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_3.setEditable(false);
		textArea_3.setBackground(SystemColor.menu);
		textArea_3.setBounds(215, 88, 20, 25);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("月");
		textArea_4.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_4.setEditable(false);
		textArea_4.setBackground(SystemColor.menu);
		textArea_4.setBounds(262, 88, 20, 25);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setText("日");
		textArea_5.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_5.setEditable(false);
		textArea_5.setBackground(SystemColor.menu);
		textArea_5.setBounds(310, 88, 25, 25);
		frame.getContentPane().add(textArea_5);
		
		JTextArea s_year = new JTextArea();
		s_year.setBackground(UIManager.getColor("CheckBox.background"));
		s_year.setToolTipText("");
		s_year.setFont(new Font("Monospaced", Font.PLAIN, 15));
		s_year.setEditable(false);
		s_year.setBounds(168, 88, 45, 25);
		frame.getContentPane().add(s_year);
		
		JTextArea s_day = new JTextArea();
		s_day.setFont(new Font("Monospaced", Font.PLAIN, 15));
		s_day.setEditable(false);
		s_day.setBounds(282, 88, 25, 25);
		frame.getContentPane().add(s_day);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setText("(10萬~1000萬)");
		textArea_13.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_13.setEditable(false);
		textArea_13.setBackground(SystemColor.menu);
		textArea_13.setBounds(260, 45, 110, 25);
		frame.getContentPane().add(textArea_13);
		
		JTextArea e_year = new JTextArea();
		e_year.setBackground(UIManager.getColor("CheckBox.background"));
		e_year.setToolTipText("");
		e_year.setFont(new Font("Monospaced", Font.PLAIN, 15));
		e_year.setEditable(false);
		e_year.setBounds(168, 131, 45, 25);
		frame.getContentPane().add(e_year);
		
		/////////////////////////////////////////////////////////
		/*
								選單
		*/
		/////////////////////////////////////////////////////////
		
		JMenuBar start_m = new JMenuBar();
		start_m.setBackground(new Color(220, 220, 220));
		start_m.setFont(new Font("Monospaced", Font.PLAIN, 15));
		start_m.setBounds(235, 88, 25, 25);
		frame.getContentPane().add(start_m);
		
		JMenu chooseSTARTmonth = new JMenu("幾");
		chooseSTARTmonth.setForeground(Color.BLUE);
		chooseSTARTmonth.setBackground(Color.LIGHT_GRAY);
		chooseSTARTmonth.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseSTARTmonth.setHorizontalAlignment(SwingConstants.CENTER);
		start_m.add(chooseSTARTmonth);
		
		JMenuItem s_ten = new JMenuItem("10");
		s_ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				s_m = 10;
				String ss = Integer.toString(s_m);
				chooseSTARTmonth.setText(ss);
			}
		});
		s_ten.setHorizontalAlignment(SwingConstants.CENTER);
		s_ten.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseSTARTmonth.add(s_ten);
		
		JMenuItem s_eleven = new JMenuItem("11");
		s_eleven.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				s_m = 11;
				String ss = Integer.toString(s_m);
				chooseSTARTmonth.setText(ss);
			}
		});
		s_eleven.setHorizontalAlignment(SwingConstants.CENTER);
		s_eleven.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseSTARTmonth.add(s_eleven);
		
		JMenuItem s_twelve = new JMenuItem("12");
		s_twelve.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				s_m = 12;
				String ss = Integer.toString(s_m);
				chooseSTARTmonth.setText(ss);
			}
		});
		s_twelve.setHorizontalAlignment(SwingConstants.CENTER);
		s_twelve.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseSTARTmonth.add(s_twelve);
		
		JMenuBar end_m = new JMenuBar();
		end_m.setBackground(new Color(220, 220, 220));
		end_m.setForeground(Color.BLACK);
		end_m.setFont(new Font("Monospaced", Font.PLAIN, 15));
		end_m.setBounds(235, 131, 25, 25);
		frame.getContentPane().add(end_m);
		
		JMenu chooseENDmonth = new JMenu("幾");
		chooseENDmonth.setForeground(Color.BLUE);
		chooseENDmonth.setBackground(Color.LIGHT_GRAY);
		chooseENDmonth.setHorizontalAlignment(SwingConstants.CENTER);
		chooseENDmonth.setFont(new Font("Monospaced", Font.PLAIN, 15));
		end_m.add(chooseENDmonth);
		
		JMenuItem e_ten = new JMenuItem("10");
		e_ten.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				e_m = 10;
				String sss = Integer.toString(e_m);
				chooseENDmonth.setText(sss);
			}
		});
		e_ten.setHorizontalAlignment(SwingConstants.CENTER);
		e_ten.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseENDmonth.add(e_ten);
		
		JMenuItem e_eleven = new JMenuItem("11");
		e_eleven.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				e_m = 11;
				String sss = Integer.toString(e_m);
				chooseENDmonth.setText(sss);
			}
		});
		e_eleven.setHorizontalAlignment(SwingConstants.CENTER);
		e_eleven.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseENDmonth.add(e_eleven);
		
		JMenuItem e_twelve = new JMenuItem("12");
		e_twelve.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				e_m = 12;
				String sss = Integer.toString(e_m);
				chooseENDmonth.setText(sss);
			}
		});
		e_twelve.setHorizontalAlignment(SwingConstants.CENTER);
		e_twelve.setFont(new Font("Monospaced", Font.PLAIN, 15));
		chooseENDmonth.add(e_twelve);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setText("請選擇股票：");
		textArea_14.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_14.setEditable(false);
		textArea_14.setBackground(SystemColor.menu);
		textArea_14.setBounds(10, 280, 90, 25);
		frame.getContentPane().add(textArea_14);
		
		JTextArea error_stock = new JTextArea();
		error_stock.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_stock.setEditable(false);
		error_stock.setBackground(SystemColor.menu);
		error_stock.setBounds(168, 280, 85, 25);
		frame.getContentPane().add(error_stock);
		
		JTextArea error_start = new JTextArea();
		error_start.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_start.setEditable(false);
		error_start.setBackground(SystemColor.menu);
		error_start.setBounds(340, 88, 100, 25);
		frame.getContentPane().add(error_start);
		
		JTextArea error_end = new JTextArea();
		error_end.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		error_end.setEditable(false);
		error_end.setBackground(SystemColor.menu);
		error_end.setBounds(340, 134, 100, 25);
		frame.getContentPane().add(error_end);
		
		
		
		/////////////////////////////////////////////////////////
		/*
								顯示時間
		*/
		/////////////////////////////////////////////////////////
		
		
		Calendar calendar = Calendar.getInstance();	
        int year = calendar.get(Calendar.YEAR);		
        int month = calendar.get(Calendar.MONTH);
        month += 1;      
        int day = calendar.get(Calendar.DATE);
	
		String y = Integer.toString(year);
		
		s_year.append(y);
		e_year.append(y);
		
		/////////////////////////////////////////////////////////
		/*
								送出內容
		*/
		/////////////////////////////////////////////////////////
		
		sendmessage.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				
				Boolean flag = true;
				Boolean flagBudget = true;
				Boolean flagWin = true;
				Boolean flagLose = true;
				Boolean flagStock = true;
				Boolean flagStart = true;
				Boolean flagEnd = true;
				String budget_input = budget.getText();
				String lose_input = lose.getText();
				String win_input = win.getText();
				
				/**
				 * 預算防呆
				 */
				if(!isNumeric(budget_input))
				{
					flag = false;
					flagBudget = false;
				}
				else
				{
					int bud_in = Integer.parseInt(budget_input);
					if(bud_in < 100000 || bud_in > 10000000)
					{	
						flag = false;
						flagBudget = false;
					}	
				}		
				if(!flagBudget)
					error_budget.setText("無效的金額");	
				else
					error_budget.setText("");
				/**
				 * 停利防呆
				 */
				if(!isNumeric(win_input))
				{
					flag = false;
					flagWin = false;
				}
				else
				{
					int win_in = Integer.parseInt(win_input);
					if(win_in < 0 || win_in > 100)
					{
						flag = false;
						flagWin = false;
					}
				}
				if(!flagWin)
					error_win.setText("無效的停利率");	
				else
					error_win.setText("");
				/**
				 * 停損防呆
				 */
				if(!isNumeric(lose_input))
				{
					flag = false;
					flagLose = false;
				}
				else
				{
					int lose_in = Integer.parseInt(lose_input);
					if(lose_in < 0 || lose_in > 100)
					{
						flag = false;
						flagLose = false;
					}
				}
				if(!flagLose)
					error_lose.setText("無效的停損率");
				else
					error_lose.setText("");
				/**
				 * 股票防呆
				 */
				if(stockname.equals(""))
				{
					flag = false;
					flagStock = false;
				}
				if(!flagStock)
					error_stock.setText("請選擇股票");
				else
					error_stock.setText("");
				/**
				 * 起始日期防呆
				 */
				if(s_m == 0)
				{
					flag = false;
					flagStart = false;
				}

				if(!flagStart)
					error_start.setText("請選擇日期");
				else
					error_start.setText("");
				/**
				 * 終止日期防呆
				 */
				if(e_m == 0 || e_m < s_m)
				{
					flag = false;
					flagEnd = false;
				}	
				if(!flagEnd)
				{
					if(e_m < s_m)
						error_end.setText("小於起始日期");
					else
						error_end.setText("請選擇日期");
				}
				else
					error_end.setText("");
				
				/**
				 * 文字設置
				 */
				if(flag)
				{			
					test.setText("");
					test.append("預算為 : " + budget_input + "\n");
					test.append("投資起始日期為 : " + y + "年" + s_m + "月" + "日\n");
					test.append("投資終止日期為 : " + y + "年" + e_m + "月" + "日\n");
					test.append("停損比率為 : " + lose_input + " %\n");
					test.append("停利比率為 : " + win_input + " %\n");
					test.append("股票為 : " + stockname + "\n");
				}
				else
					test.setText("");
			}
		});
	}
}
