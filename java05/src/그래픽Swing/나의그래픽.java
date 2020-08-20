package 그래픽Swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class 나의그래픽 {

	public static void main(String[] args) {
		// 자바는 부품조립식 코드 => 객체지향형프로그래밍(OOP)
		// ctrl + shift + o: 자동import
		JFrame f = new JFrame();// new는 원본을 복사의 의미
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "나를 눌러요를 눌렀군요");
			}
		});
		JButton b2 = new JButton();
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "나도 눌러요를 눌렀군요");
			}
		});
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "이미지를 눌렀군요");
			}
		});
		ImageIcon img = new ImageIcon("sky.png");
		b1.setText("나를 눌러요");
		b2.setText("나도 눌러요");
		b3.setIcon(img);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JDesktopPane desktopPane = new JDesktopPane();
		f.getContentPane().add(desktopPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		f.getContentPane().add(layeredPane);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		

		f.setSize(1000, 500);
		// 맨 아래에 두어야 한다.
		f.setVisible(true);

	}

}
