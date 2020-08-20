package 그래픽Swing;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 숫자판별기 {

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
		result.setBounds(43, 485, 279, 154);
		result.setText("결과");
		result.setFont(new Font("굴림", Font.PLAIN, 50));
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

		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a1 = t1.getText();
				String a2 = t2.getText();

				int i1 = Integer.parseInt(a1);
				int i2 = Integer.parseInt(a2);

				if (i1 > i2) {
					String res = String.valueOf(i1);
					result.setText(res);
				} else {
					String res1 = String.valueOf(i2);
					result.setText(res1);
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
