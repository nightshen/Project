import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;



public class GUI {

	private JFrame frame;
	private JTextField budget;
	private JTextField lose;
	private JTextField win;
	private String stockname = "";
	private int s_m = 0;
	private int e_m = 0;
	private JButton sendmessage = new JButton("送出");
	JMenu mon1 = new JMenu("幾");
	JMenu mon2 = new JMenu("幾");
	public int stockcode = 0;
	public ImageIcon img = new ImageIcon();
	public ImageIcon img2 = new ImageIcon();
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
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		TimeWork work = new TimeWork();
		work.Work();
		initialize();
		UpdateStockData up = new UpdateStockData();
		up.DownloadStockData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setTitle("投資秘書");
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lb = new JLabel();
		lb.setBounds(10, 110, 800, 550);
		lb.setVisible(true);
		frame.getContentPane().add(lb);
				
		JLabel lb2 = new JLabel();
		lb2.setBounds(860, 110, 350, 300);
		lb2.setVisible(true);
		frame.getContentPane().add(lb2);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 215, 0));
		textArea.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea.setEditable(false);
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setText("請輸入預算金額：");
		textArea.setBounds(855, 440, 190, 35);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setForeground(new Color(255, 215, 0));
		textArea_1.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_1.setEditable(false);
		textArea_1.setText("請選擇投資起始日期：");
		textArea_1.setBackground(new Color(0, 0, 0));
		textArea_1.setBounds(855, 490, 240, 35);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setForeground(new Color(255, 215, 0));
		textArea_2.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_2.setEditable(false);
		textArea_2.setText("請選擇投資終止日期：");
		textArea_2.setBackground(new Color(0, 0, 0));
		textArea_2.setBounds(855, 540, 240, 35);
		frame.getContentPane().add(textArea_2);
		
		budget = new JTextField();
		budget.setFont(new Font("Monospaced", Font.PLAIN, 20));
		budget.setHorizontalAlignment(SwingConstants.CENTER);
		budget.setBounds(1040, 440, 120, 35);
		frame.getContentPane().add(budget);
		budget.setColumns(10);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setForeground(new Color(255, 215, 0));
		textArea_6.setText("年");
		textArea_6.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_6.setEditable(false);
		textArea_6.setBackground(new Color(0, 0, 0));
		textArea_6.setBounds(1145, 540, 30, 35);
		frame.getContentPane().add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setForeground(new Color(255, 215, 0));
		textArea_7.setText("月");
		textArea_7.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_7.setEditable(false);
		textArea_7.setBackground(new Color(0, 0, 0));
		textArea_7.setBounds(1210, 540, 30, 35);
		frame.getContentPane().add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setForeground(new Color(255, 215, 0));
		textArea_8.setText("日");
		textArea_8.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_8.setEditable(false);
		textArea_8.setBackground(new Color(0, 0, 0));
		textArea_8.setBounds(1275, 540, 30, 35);
		frame.getContentPane().add(textArea_8);	
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setForeground(new Color(255, 215, 0));
		textArea_9.setText("請輸入停損比率：");
		textArea_9.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_9.setEditable(false);
		textArea_9.setBackground(new Color(0, 0, 0));
		textArea_9.setBounds(855, 590, 190, 35);
		frame.getContentPane().add(textArea_9);
		
		lose = new JTextField();
		lose.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lose.setHorizontalAlignment(SwingConstants.CENTER);
		lose.setColumns(10);
		lose.setBounds(1045, 590, 50, 35);
		frame.getContentPane().add(lose);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setForeground(new Color(255, 215, 0));
		textArea_10.setText("請輸入停利比率：");
		textArea_10.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_10.setEditable(false);
		textArea_10.setBackground(new Color(0, 0, 0));
		textArea_10.setBounds(855, 640, 190, 35);
		frame.getContentPane().add(textArea_10);
		
		win = new JTextField();
		win.setFont(new Font("Monospaced", Font.PLAIN, 20));
		win.setHorizontalAlignment(SwingConstants.CENTER);
		win.setColumns(10);
		win.setBounds(1045, 640, 50, 35);
		frame.getContentPane().add(win);
		
		/*JTextArea test = new JTextArea();
		test.setEditable(false);
		test.setBounds(10, 347, 240, 188);
		frame.getContentPane().add(test);*/
		
		JTextArea error_budget = new JTextArea();
		error_budget.setForeground(Color.CYAN);
		error_budget.setEditable(false);
		error_budget.setBackground(new Color(0, 0, 0));
		error_budget.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_budget.setBounds(1340, 440, 130, 35);
		frame.getContentPane().add(error_budget);
		
		JTextArea error_lose = new JTextArea();
		error_lose.setForeground(Color.CYAN);
		error_lose.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_lose.setEditable(false);
		error_lose.setBackground(new Color(0, 0, 0));
		error_lose.setBounds(1220, 590, 150, 35);
		frame.getContentPane().add(error_lose);
		
		JTextArea error_win = new JTextArea();
		error_win.setForeground(Color.CYAN);
		error_win.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_win.setEditable(false);
		error_win.setBackground(new Color(0, 0, 0));
		error_win.setBounds(1220, 640, 150, 35);
		
		
		
		
		frame.getContentPane().add(error_win);
		sendmessage.setForeground(new Color(255, 215, 0));
		sendmessage.setBackground(new Color(0, 0, 0));
		sendmessage.setFont(new Font("Monospaced", Font.BOLD, 30));
		sendmessage.setBounds(1300, 720, 120, 40);
		frame.getContentPane().add(sendmessage);
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setForeground(new Color(255, 215, 0));
		textArea_11.setBackground(new Color(0, 0, 0));
		textArea_11.setEditable(false);
		textArea_11.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_11.setText("(0~100%)");
		textArea_11.setBounds(1100, 590, 120, 35);
		frame.getContentPane().add(textArea_11);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setForeground(new Color(255, 215, 0));
		textArea_12.setText("(0~100%)");
		textArea_12.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_12.setEditable(false);
		textArea_12.setBackground(new Color(0, 0, 0));
		textArea_12.setBounds(1100, 640, 120, 35);
		frame.getContentPane().add(textArea_12);
		
		JMenuBar stock = new JMenuBar();
		stock.setForeground(Color.BLACK);
		stock.setBackground(new Color(255, 255, 255));
		stock.setFont(new Font("Monospaced", Font.PLAIN, 20));
		stock.setBounds(1000, 693, 50, 30);
		frame.getContentPane().add(stock);
		
		JMenu choose_stock = new JMenu("股票");
		choose_stock.setForeground(Color.BLUE);
		choose_stock.setBackground(new Color(255, 255, 255));
		choose_stock.setFont(new Font("Monospaced", Font.PLAIN, 20));
		choose_stock.setHorizontalAlignment(SwingConstants.CENTER);
		stock.add(choose_stock);
		
		
		
		JMenuItem stock1 = new JMenuItem("中鋼");
		stock1.setBackground(new Color(255, 255, 255));
		stock1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				choose_stock.setText("中鋼");
				stockname = "中鋼";
				stockcode = 2002;
			}
		});
		stock1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		stock1.setHorizontalAlignment(SwingConstants.CENTER);
		choose_stock.add(stock1);
		
		JMenuItem stock2 = new JMenuItem("宏達");
		stock2.setBackground(new Color(255, 255, 255));
		stock2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				choose_stock.setText("宏達");
				stockname = "宏達";
				stockcode = 2498;
			}
		});
		stock2.setHorizontalAlignment(SwingConstants.CENTER);
		stock2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		choose_stock.add(stock2);
		
		JMenuItem stock3 = new JMenuItem("鴻海");
		stock3.setBackground(new Color(255, 255, 255));
		stock3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				choose_stock.setText("鴻海");
				stockname = "鴻海";
				stockcode = 2317;
			}
		});
		stock3.setHorizontalAlignment(SwingConstants.CENTER);
		stock3.setFont(new Font("Monospaced", Font.PLAIN, 20));
		choose_stock.add(stock3);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setForeground(new Color(255, 215, 0));
		textArea_3.setText("年");
		textArea_3.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_3.setEditable(false);
		textArea_3.setBackground(new Color(0, 0, 0));
		textArea_3.setBounds(1145, 490, 30, 30);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setForeground(new Color(255, 215, 0));
		textArea_4.setText("月");
		textArea_4.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_4.setEditable(false);
		textArea_4.setBackground(new Color(0, 0, 0));
		textArea_4.setBounds(1210, 490, 30, 30);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setForeground(new Color(255, 215, 0));
		textArea_5.setText("日");
		textArea_5.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_5.setEditable(false);
		textArea_5.setBackground(new Color(0, 0, 0));
		textArea_5.setBounds(1275, 490, 30, 35);
		frame.getContentPane().add(textArea_5);
		
		JTextArea s_year = new JTextArea();
		s_year.setForeground(new Color(255, 215, 0));
		s_year.setBackground(new Color(0, 0, 0));
		s_year.setToolTipText("");
		s_year.setFont(new Font("Monospaced", Font.PLAIN, 20));
		s_year.setEditable(false);
		s_year.setBounds(1095, 493, 60, 35);
		frame.getContentPane().add(s_year);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setForeground(new Color(255, 215, 0));
		textArea_13.setText("(10萬~1000萬)");
		textArea_13.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_13.setEditable(false);
		textArea_13.setBackground(new Color(0, 0, 0));
		textArea_13.setBounds(1165, 440, 170, 35);
		frame.getContentPane().add(textArea_13);
		
		JTextArea e_year = new JTextArea();
		e_year.setForeground(new Color(255, 215, 0));
		e_year.setBackground(new Color(0, 0, 0));
		e_year.setToolTipText("");
		e_year.setFont(new Font("Monospaced", Font.PLAIN, 20));
		e_year.setEditable(false);
		e_year.setBounds(1095, 543, 60, 35);
		frame.getContentPane().add(e_year);
		
		/////////////////////////////////////////////////////////
		/*
								選單
		*/
		/////////////////////////////////////////////////////////
		
		JMenuBar start_m = new JMenuBar();
		start_m.setBackground(new Color(255, 255, 255));
		start_m.setFont(new Font("Monospaced", Font.PLAIN, 20));
		start_m.setBounds(1175, 493, 30, 30);
		frame.getContentPane().add(start_m);
		
		JMenu chooseSTARTmonth = new JMenu("幾");
		chooseSTARTmonth.setForeground(Color.BLUE);
		chooseSTARTmonth.setBackground(new Color(255, 255, 255));
		chooseSTARTmonth.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseSTARTmonth.setHorizontalAlignment(SwingConstants.CENTER);
		start_m.add(chooseSTARTmonth);
		
		JMenuItem s_ten = new JMenuItem("10");
		s_ten.setBackground(new Color(255, 255, 255));
		s_ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				s_m = 10;
				String ss = Integer.toString(s_m);
				chooseSTARTmonth.setText(ss);
			}
		});
		s_ten.setHorizontalAlignment(SwingConstants.CENTER);
		s_ten.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseSTARTmonth.add(s_ten);
		
		JMenuItem s_eleven = new JMenuItem("11");
		s_eleven.setBackground(new Color(255, 255, 255));
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
		s_eleven.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseSTARTmonth.add(s_eleven);
		
		JMenuItem s_twelve = new JMenuItem("12");
		s_twelve.setBackground(new Color(255, 255, 255));
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
		s_twelve.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseSTARTmonth.add(s_twelve);
		
		JMenuBar end_m = new JMenuBar();
		end_m.setBackground(new Color(255, 255, 255));
		end_m.setForeground(Color.BLACK);
		end_m.setFont(new Font("Monospaced", Font.PLAIN, 20));
		end_m.setBounds(1175, 543, 30, 30);
		frame.getContentPane().add(end_m);
		
		JMenu chooseENDmonth = new JMenu("幾");
		chooseENDmonth.setForeground(Color.BLUE);
		chooseENDmonth.setBackground(new Color(255, 255, 255));
		chooseENDmonth.setHorizontalAlignment(SwingConstants.CENTER);
		chooseENDmonth.setFont(new Font("Monospaced", Font.PLAIN, 20));
		end_m.add(chooseENDmonth);
		
		JMenuItem e_ten = new JMenuItem("10");
		e_ten.setBackground(new Color(255, 255, 255));
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
		e_ten.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseENDmonth.add(e_ten);
		
		JMenuItem e_eleven = new JMenuItem("11");
		e_eleven.setBackground(new Color(255, 255, 255));
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
		e_eleven.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseENDmonth.add(e_eleven);
		
		JMenuItem e_twelve = new JMenuItem("12");
		e_twelve.setBackground(new Color(255, 255, 255));
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
		e_twelve.setFont(new Font("Monospaced", Font.PLAIN, 20));
		chooseENDmonth.add(e_twelve);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setForeground(new Color(255, 215, 0));
		textArea_14.setText("請選擇股票：");
		textArea_14.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		textArea_14.setEditable(false);
		textArea_14.setBackground(new Color(0, 0, 0));
		textArea_14.setBounds(855, 690, 140, 35);
		frame.getContentPane().add(textArea_14);
		
		JTextArea error_stock = new JTextArea();
		error_stock.setForeground(Color.CYAN);
		error_stock.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_stock.setEditable(false);
		error_stock.setBackground(new Color(0, 0, 0));
		error_stock.setBounds(1060, 690, 130, 35);
		frame.getContentPane().add(error_stock);
		
		JTextArea error_start = new JTextArea();
		error_start.setForeground(Color.CYAN);
		error_start.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_start.setEditable(false);
		error_start.setBackground(new Color(0, 0, 0));
		error_start.setBounds(1305, 490, 130, 35);
		frame.getContentPane().add(error_start);
		
		JTextArea error_end = new JTextArea();
		error_end.setForeground(Color.CYAN);
		error_end.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 24));
		error_end.setEditable(false);
		error_end.setBackground(new Color(0, 0, 0));
		error_end.setBounds(1305, 540, 130, 35);
		frame.getContentPane().add(error_end);
		
		JTextArea na = new JTextArea();
		na.setForeground(new Color(255, 215, 0));
		na.setFont(new Font("微軟正黑體", Font.PLAIN, 50));
		na.setEditable(false);
		na.setBackground(new Color(0, 0, 0));
		na.setBounds(10, 30, 355, 60);
		frame.getContentPane().add(na);
		
		JTextArea na2 = new JTextArea();
		na2.setForeground(new Color(255, 215, 0));
		na2.setFont(new Font("微軟正黑體", Font.PLAIN, 50));
		na2.setEditable(false);
		na2.setBackground(new Color(0, 0, 0));
		na2.setBounds(855, 30, 355, 60);
		frame.getContentPane().add(na2);
		
		
		img = new ImageIcon("2002_a.jpg");
		img.setImage(img.getImage().getScaledInstance(800,550,Image.SCALE_DEFAULT));
		lb.setIcon(img);
		
		img2 = new ImageIcon("2002_b.jpg");
		img2.setImage(img2.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT));
		lb2.setIcon(img2);
		
		na.setText("中鋼技術分析圖");
		na2.setText("中鋼即時走勢圖");
		
		JMenuBar m1 = new JMenuBar();
		m1.setBackground(new Color(255, 255, 255));
		m1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		m1.setBounds(1240, 493, 30, 30);
		frame.getContentPane().add(m1);
		mon1.setForeground(Color.BLUE);
		mon1.setBackground(new Color(255, 255, 255));
		mon1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		mon1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		mon1.setEnabled(true);
		m1.add(mon1);
		
		JMenuItem[] date1 = new JMenuItem[31] ;
		for(int i = 0; i < 31; i++)
		{	
			
			date1[i] = new JMenuItem(Integer.toString(i+1));
			date1[i].setBackground(new Color(255, 255, 255));
			date1[i].setFont(new Font("Monospaced", Font.PLAIN, 20));
			date1[i].setHorizontalAlignment(SwingConstants.CENTER);
			int k1 = i+1;
			date1[i].addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{					
					mon1.setText(Integer.toString(k1));
				}
			});
			mon1.add(date1[i]);
		}
		
		JMenuBar m2 = new JMenuBar();
		m2.setBackground(new Color(255, 255, 255));
		m2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		m2.setBounds(1240, 543, 30, 30);
		frame.getContentPane().add(m2);
		mon2.setForeground(Color.BLUE);
		mon2.setBackground(new Color(255, 255, 255));
		mon2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		mon2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		m2.add(mon2);
		
		JMenuItem[] date2 = new JMenuItem[31] ;
		for(int i = 0; i < 31; i++)
		{	
			
			date2[i] = new JMenuItem(Integer.toString(i+1));
			date2[i].setBackground(new Color(255, 255, 255));
			date2[i].setFont(new Font("Monospaced", Font.PLAIN, 20));
			date2[i].setHorizontalAlignment(SwingConstants.CENTER);
			int k2 = i+1;
			date2[i].addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{					
					mon2.setText(Integer.toString(k2));	
				}
			});
			mon2.add(date2[i]);
		}
		
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
				
				PreventBaga baga = new PreventBaga(budget.getText(), s_m, e_m, mon1.getText(), mon2.getText(), win.getText(), lose.getText(), stockname);
				
				if(!baga.IsCorrectBudget(baga.getINPUT()[0]))
					error_budget.setText("無效的金額");
				else
					error_budget.setText("");	
				
				if(!baga.IsCorrectStartMonthOrDay(baga.getINPUT()[3]))
					error_start.setText("無效的日期");
				else
					error_start.setText("");
				
				if(!baga.IsCorrectEndMonthOrDay(baga.getINPUT()[4]))
					error_end.setText("無效的日期");
				else
					error_end.setText("");
				
				if(!baga.IsCorrectStopWin(baga.getINPUT()[5]))
					error_win.setText("無效的停利率");	
				else
					error_win.setText("");
				
				if(!baga.IsCorrectStopLose(baga.getINPUT()[6]))
					error_lose.setText("無效的停損率");	
				else
					error_lose.setText("");
				
				if(stockname.equals(""))
					error_stock.setText("請選擇股票");
				else
					error_stock.setText("");
				
				/**
				 * 文字設置
				 */
				if(baga.Test())
				{			
					/*test.setText("");
					test.append("預算為 : " + budget.getText() + "\n");
					test.append("投資起始日期為 : " + y + "年" + s_m + "月" + s_day.getText() + "日\n");
					test.append("投資終止日期為 : " + y + "年" + e_m + "月" + e_day.getText() + "日\n");
					test.append("停損比率為 : " + lose.getText() + " %\n");
					test.append("停利比率為 : " + win.getText() + " %\n");
					test.append("股票為 : " + stockname + "\n");*/
					
					
					
					/**
					 * 產生走勢圖 
					 */
					//ImageIcon img = new ImageIcon(Integer.toString(stockcode)+".jpg");
					img = new ImageIcon(Integer.toString(stockcode)+"_a.jpg");
					img.setImage(img.getImage().getScaledInstance(800,550,Image.SCALE_DEFAULT));
					lb.setIcon(img);
					
					img2 = new ImageIcon(Integer.toString(stockcode)+"_b.jpg");
					img2.setImage(img2.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT));
					lb2.setIcon(img2);
					
					na.setText(stockname + "技術分析圖");
					na2.setText(stockname + "即時走勢圖");
										
				}
				else
					//test.setText("");
					;
							
			}
		});
	}
}
