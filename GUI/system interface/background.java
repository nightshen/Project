import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class background extends JFrame {
/**
	public background() {
	setBak(); //調用背景方法
	Container c = getContentPane(); //獲取JFrame面板
	JPanel jp = new JPanel(); //創建個JPanel
	jp.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
	c.add(jp);
	setSize(1000, 600);
	setVisible(true);
	}
	public void setBak() {
	((JPanel)this.getContentPane()).setOpaque(false);
	ImageIcon img = new ImageIcon("D://eclipse-workspace//system interface//MJpfRSz.jpg");
	JLabel back = new JLabel(img);
	this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
	back.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	
	}

	public static void main(String[] args) {
		background s = new background();
	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
*/
}

