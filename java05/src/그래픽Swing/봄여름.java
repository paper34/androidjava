package 그래픽Swing;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 봄여름 {

	public static void main(String[] args) {
		 JFrame f= new  JFrame();
		 
		 f.setSize(500, 500);
		 JButton b1 = new JButton();
		 b1.setBounds(39, 47, 405, 173);
		 b1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(f, "선선해요");
		 	}
		 });
		 f.getContentPane().setLayout(null);
		 b1.setBackground(Color.YELLOW);
		 b1.setForeground(Color.BLUE);
		 b1.setFont(new Font("굴림", Font.PLAIN, 99));
		 
		 b1.setText("봄");
		 f.getContentPane().add(b1);
		 JButton b2 = new JButton();
		 b2.setBounds(7, 230, 470, 224);
		 b2.setBackground(Color.PINK);
		 b2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(f, "더워요");
		 	}
		 });
		 b2.setForeground(Color.GREEN);
		 b2.setFont(new Font("굴림", Font.PLAIN, 99));
		 b2.setText("여름");
		 f.getContentPane().add(b2);
		 f.setVisible(true);
		 

	}
}
