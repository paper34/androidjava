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
import javax.swing.SwingConstants;

public class 성인판독기 {

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
		l3.setBounds(53, 198, 269, 98);
		l3.setForeground(new Color(255, 105, 180));
		l3.setFont(new Font("굴림", Font.PLAIN, 45));
		JLabel result = new JLabel();
		result.setBounds(12, 485, 335, 154);
		result.setText("결과");
		result.setFont(new Font("굴림", Font.PLAIN, 25));
		result.setForeground(Color.BLACK);
		//가운데 정렬
		result.setHorizontalAlignment(JLabel.CENTER);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		
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
		l2.setText("이름"); // 라벨에 글자를 넣기
		l3.setText("태어난 년도");
		f.getContentPane().setLayout(null);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(t1);
		f.getContentPane().add(l3);
		f.getContentPane().add(t2);
		f.getContentPane().add(result);

		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a1 = t1.getText();
				String a2 = t2.getText();

				int i2 = Integer.parseInt(a2);

				if ((2020 - i2) >=18) {
					result.setText(a1 + "은 " + " 성인입니다." );
				} else {
					result.setText(a1 + "은 " + " 성인이 아닙니다." );
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(110, 380, 153, 73);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 55));
		btnNewButton_1.setBackground(Color.MAGENTA);
		f.getContentPane().add(btnNewButton_1);

		f.setSize(375, 728);

		f.setVisible(true);
	}
}
