package 배열정리;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 중국집 {

	static int count = 0; static int jc = 0; static int jjc = 0; static int uc = 0;
	static int total = 0;
	static int jp = 5000; //짜장면
	static int jjp = 4000; // 짬뽕
	static int up = 4500; // 우동
	
	
	private static JTextField counttext;

	public static void main(String[] args) {

		String[] images = { "1.jpg", "2.jpg", "3.jpg" };

		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.PINK);
		f.setSize(1000, 800);
		f.getContentPane().setLayout(null);

		

		JLabel lblNewLabel = new JLabel("총 개수");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(651, 59, 83, 30);
		f.getContentPane().add(lblNewLabel);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon());
		img.setBackground(Color.WHITE);
		img.setBounds(32, 117, 877, 410);
		f.getContentPane().add(img);

		JLabel lblNewLabel_2 = new JLabel("지불할 총 금액");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(60, 651, 228, 55);
		f.getContentPane().add(lblNewLabel_2);
		//짜장, 짬뽕 ,우동 카운트
		JLabel jc1 = new JLabel("");
		jc1.setFont(new Font("굴림", Font.PLAIN, 20));
		jc1.setBounds(381, 537, 90, 55);
		f.getContentPane().add(jc1);
		
		JLabel jjc1 = new JLabel("");
		jjc1.setFont(new Font("굴림", Font.PLAIN, 20));
		jjc1.setBounds(595, 537, 90, 55);
		f.getContentPane().add(jjc1);
		
		JLabel uc1 = new JLabel("");
		uc1.setFont(new Font("굴림", Font.PLAIN, 20));
		uc1.setBounds(819, 537, 90, 55);
		f.getContentPane().add(uc1);
		
		//총 갯수 카운트
		counttext = new JTextField();
		counttext.setFont(new Font("굴림", Font.PLAIN, 20));
		counttext.setBackground(Color.WHITE);
		counttext.setBounds(734, 26, 175, 81);
		f.getContentPane().add(counttext);
		counttext.setColumns(10);
		//가격
		JLabel price = new JLabel("");
		price.setForeground(Color.RED);
		price.setFont(new Font("굴림", Font.PLAIN, 25));
		price.setBounds(300, 639, 260, 81);
		f.getContentPane().add(price);
		
		// 짜장면 버튼
		JButton btnNewButton = new JButton("짜장면");
		btnNewButton.setBackground(new Color(153, 51, 255));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				img.setIcon(new ImageIcon(images[0]));
				count++;
				jc++;
				total += jp;
				
				jc1.setText(jc + "개");
				counttext.setText(count + "개");
				price.setText(total + "원");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton.setBounds(32, 26, 175, 81);
		f.getContentPane().add(btnNewButton);
		// 짬뽕버튼
		JButton btnNewButton_1 = new JButton("짬뽕");
		btnNewButton_1.setBackground(new Color(153, 51, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				img.setIcon(new ImageIcon(images[1]));
				count++;
				jjc++;
				total += jjp;
				
				jjc1.setText(jjc + "개");
				counttext.setText(count + "개");
				price.setText(total + "원");
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton_1.setBounds(240, 26, 175, 81);
		f.getContentPane().add(btnNewButton_1);
		//우동버튼
		JButton btnNewButton_2 = new JButton("우동");
		btnNewButton_2.setBackground(new Color(153, 51, 153));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				img.setIcon(new ImageIcon(images[2]));
				count++;
				uc++;
				total += up;
				
				uc1.setText(uc + "개");
				counttext.setText(count + "개");
				price.setText(total + "원");
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 30));
		btnNewButton_2.setBounds(454, 26, 175, 81);
		f.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("짜장면 개수:");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(256, 537, 115, 55);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("짬뽕 개수:");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(497, 537, 115, 55);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("우동 개수:");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(721, 537, 115, 55);
		f.getContentPane().add(lblNewLabel_1_2);
		
		
		
		
		
		
		
		

		f.setVisible(true);
	}
}
