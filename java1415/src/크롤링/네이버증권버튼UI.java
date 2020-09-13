package 크롤링;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class 네이버증권버튼UI {
	private static JTextField t1;

	public static void main(String[] args) {
		//코드
		String[] codes = { "005930", "293490", "019170" }; 
		네이버증권크롤링2 naver = new 네이버증권크롤링2();

		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.ORANGE);
		f.getContentPane().setLayout(null);

		t1 = new JTextField();
		t1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		t1.setBounds(75, 427, 336, 55);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		JTextArea t2 = new JTextArea();
		t2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		t2.setBounds(75, 494, 336, 247);
		t2.setFocusable(false);
		f.getContentPane().add(t2);
		f.setSize(500, 800);
		
		//버튼
		JButton btnNewButton = new JButton("삼성전자");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(codes[0]); // 삼성전자 코드 가져오기

			}

		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		btnNewButton.setBounds(75, 12, 336, 75);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("카카오게임즈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(codes[1]);// 카카오게임즈 코드 가져오기
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(74, 96, 336, 75);
		f.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("신풍제약");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(codes[2]); // 신풍제약 코드 가져오기
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setBounds(75, 182, 336, 75);
		f.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("CODE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 55));
		lblNewLabel.setBounds(161, 273, 154, 55);
		f.getContentPane().add(lblNewLabel);

		JButton btnNewButton_2_1 = new JButton("크롤링시작");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 코드정보 가져와서  출력
				String s = t1.getText();
				String result[] = naver.crawl(s);
				t2.setText("회사이름: " + result[0] + "\n" + "코드: " + result[1] + "\n" + "현재가: " + result[2] + "\n"
						+ "어제와의 차이: " + result[3] + "\n" + "증감비율: " + result[4] + "\n");
			}
		});
		btnNewButton_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		btnNewButton_2_1.setBackground(Color.YELLOW);
		btnNewButton_2_1.setBounds(75, 340, 336, 75);
		f.getContentPane().add(btnNewButton_2_1);

		f.setVisible(true);
	}
}
