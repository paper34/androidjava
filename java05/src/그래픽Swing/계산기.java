package 그래픽Swing;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 계산기 {

	public static void main(String[] args) {

		// 프레임1
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(0, 128, 0));
		// 이미지1
		ImageIcon image = new ImageIcon("call.png");
		// 라벨3
		JLabel l1 = new JLabel();
		l1.setBounds(24, 15, 0, 0);
		JLabel l2 = new JLabel();
		l2.setBounds(98, 15, 180, 98);
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("굴림", Font.PLAIN, 70));
		JLabel l3 = new JLabel();
		l3.setBounds(93, 198, 185, 98);
		l3.setForeground(new Color(255, 105, 180));
		l3.setFont(new Font("굴림", Font.PLAIN, 70));
		JLabel result = new JLabel();
		result.setBounds(142, 573, 180, 89);
		result.setText("결과");
		result.setFont(new Font("굴림", Font.PLAIN, 60));
		result.setForeground(Color.BLACK);
		// 텍스트입력2
		JTextField t1 = new JTextField(9);
		t1.setBounds(43, 123, 279, 65);
		t1.setFont(new Font("굴림", Font.PLAIN, 40));
		t1.setBackground(Color.YELLOW);
		JTextField t2 = new JTextField(9);
		t2.setBounds(43, 293, 279, 65);
		t2.setFont(new Font("굴림", Font.PLAIN, 40));
		t2.setBackground(Color.YELLOW);
		// 버튼1

		l1.setIcon(image);
		l2.setText("숫자1"); // 라벨에 글자를 넣기
		l3.setText("숫자2");
		f.getContentPane().setLayout(null);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(t1);
		f.getContentPane().add(l3);
		f.getContentPane().add(t2);
		f.getContentPane().add(result);

		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(43, 387, 79, 73);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// t1, t2에 입력한 값을 가지고 와야함.
				// 가지고 온 값의 데이터타입은 무조건 String!
				String s1 = t1.getText();
				String s2 = t2.getText();
				System.out.println("t1값: " + s1);
				System.out.println("t2값: " + s2);

				// 산술연산을 하려면, 숫자로 변환
				int i1 = Integer.parseInt(s1);
				int i2 = Integer.parseInt(s2);

				// 숫자를 변환한 값들을 더하자
				int sum = i1 + i2;

				// 처리한 결과를 사용자에게 보여줌.(출력)
				// result.setText(sum + "");
				String sum2 = String.valueOf(sum);
				result.setText(sum2);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 55));
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String m1 = t1.getText();
				String m2 = t2.getText();
				
				int j1 = Integer.parseInt(m1);
				int j2 = Integer.parseInt(m2);
				
				int minus = j1 - j2;
				
				String minus2 = String.valueOf(minus);
				result.setText(minus2);
			}
		});
		btnNewButton_1.setBounds(146, 387, 79, 73);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 55));
		btnNewButton_1.setBackground(Color.MAGENTA);
		f.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("*");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String c1 = t1.getText();
				String c2 = t2.getText();
				
				int a1 = Integer.parseInt(c1);
				int a2 = Integer.parseInt(c2);
				
				int gop = a1 * a2;
				
				String gop2 = String.valueOf(gop);
				result.setText(gop2);
				
				
			}
		});
		btnNewButton_1_1.setBounds(243, 387, 79, 73);
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 55));
		btnNewButton_1_1.setBackground(Color.MAGENTA);
		f.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("/");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n1 = t1.getText();
				String n2 = t2.getText();
				
				int x1 = Integer.parseInt(n1);
				int x2 = Integer.parseInt(n2);
				
				int na = x1 / x2;
				
				String na2 = String.valueOf(na);
				result.setText(na2);
				
				
			}
		});
		btnNewButton_1_2.setBounds(146, 490, 79, 73);
		btnNewButton_1_2.setForeground(Color.RED);
		btnNewButton_1_2.setFont(new Font("굴림", Font.PLAIN, 55));
		btnNewButton_1_2.setBackground(Color.MAGENTA);
		f.getContentPane().add(btnNewButton_1_2);

		f.setSize(375, 728);

		f.setVisible(true);
	}
}
