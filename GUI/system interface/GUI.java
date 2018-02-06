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
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField budget;
	private JTextField s_year;
	private JTextField s_month;
	private JTextField s_day;
	private JTextField e_year;
	private JTextField e_month;
	private JTextField e_day;
	private JTextField lose;
	private JTextField win;

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
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor("CheckBox.background"));
		textArea.setText("請輸入預算金額：");
		textArea.setBounds(10, 45, 120, 25);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setText("請輸入投資起始日期：");
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(10, 88, 155, 25);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_2.setEditable(false);
		textArea_2.setText("請輸入投資終止日期：");
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(10, 134, 155, 25);
		frame.getContentPane().add(textArea_2);
		
		budget = new JTextField();
		budget.setHorizontalAlignment(SwingConstants.TRAILING);
		budget.setBounds(140, 42, 110, 25);
		frame.getContentPane().add(budget);
		budget.setColumns(10);
		
		s_year = new JTextField();
		s_year.setBounds(168, 85, 45, 25);
		frame.getContentPane().add(s_year);
		s_year.setColumns(10);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBackground(UIManager.getColor("CheckBox.background"));
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_3.setText("年");
		textArea_3.setBounds(215, 88, 20, 25);
		frame.getContentPane().add(textArea_3);
		
		s_month = new JTextField();
		s_month.setColumns(10);
		s_month.setBounds(235, 85, 25, 25);
		frame.getContentPane().add(s_month);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setText("月");
		textArea_4.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_4.setBackground(SystemColor.menu);
		textArea_4.setBounds(262, 88, 20, 25);
		frame.getContentPane().add(textArea_4);
		
		s_day = new JTextField();
		s_day.setColumns(10);
		s_day.setBounds(282, 85, 25, 25);
		frame.getContentPane().add(s_day);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setText("日(西元)");
		textArea_5.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_5.setBackground(SystemColor.menu);
		textArea_5.setBounds(310, 88, 60, 25);
		frame.getContentPane().add(textArea_5);
		
		e_year = new JTextField();
		e_year.setColumns(10);
		e_year.setBounds(168, 131, 45, 25);
		frame.getContentPane().add(e_year);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setText("年");
		textArea_6.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_6.setEditable(false);
		textArea_6.setBackground(SystemColor.menu);
		textArea_6.setBounds(215, 134, 20, 25);
		frame.getContentPane().add(textArea_6);
		
		e_month = new JTextField();
		e_month.setColumns(10);
		e_month.setBounds(235, 131, 25, 25);
		frame.getContentPane().add(e_month);
		
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
		textArea_8.setText("日(西元)");
		textArea_8.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_8.setEditable(false);
		textArea_8.setBackground(SystemColor.menu);
		textArea_8.setBounds(310, 134, 60, 25);
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
		test.setBounds(10, 266, 308, 269);
		frame.getContentPane().add(test);
		
		JButton sendmessage = new JButton("送出");
		sendmessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String budget_input = budget.getText();
				test.append("預算為:"+budget_input+"\n");
				
				String s_year_input = s_year.getText();
				String s_month_input = s_month.getText();
				String s_day_input = s_day.getText();
				test.append("投資開始日期為:"+s_year_input+"年"+s_month_input+"月"+s_day_input+"日\n");
				
				String e_year_input = e_year.getText();
				String e_month_input = e_month.getText();
				String e_day_input = e_day.getText();
				test.append("投資終止日期為:"+e_year_input+"年"+e_month_input+"月"+e_day_input+"日\n");
				
				String lose_input = lose.getText();
				test.append("停損比率為:"+lose_input+"\n");
				
				String win_input = win.getText();
				test.append("停利比率為:"+win_input+"\n");
			}
		});
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
		
		
	}
}
