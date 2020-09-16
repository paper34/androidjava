package project01;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class ProSample {

	public static void main(String[] args) {
		// 프레임
		JFrame f = new JFrame("1차 프로젝트-코로나");
		f.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		f.setSize(900, 1000);
		f.getContentPane().setLayout(null);

		// 메뉴 버튼
		JButton loginButton = new JButton("로그인");
		loginButton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		loginButton.setBounds(620, 30, 120, 40);
		f.getContentPane().add(loginButton);

		JButton joinButton = new JButton("회원가입");
		joinButton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		joinButton.setBounds(752, 30, 120, 40);
		f.getContentPane().add(joinButton);

		JButton homeButton = new JButton("홈");
		homeButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		homeButton.setBounds(24, 128, 202, 75);
		f.getContentPane().add(homeButton);

		JButton dayButton = new JButton("일별확진자");
		dayButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		dayButton.setBounds(226, 128, 228, 75);
		f.getContentPane().add(dayButton);

		JButton cityButton = new JButton("시도별확진자");
		cityButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		cityButton.setBounds(454, 128, 214, 75);
		f.getContentPane().add(cityButton);

		JButton boardButton = new JButton("게시판");
		boardButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardButton.setBounds(670, 128, 202, 75);
		f.getContentPane().add(boardButton);

		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		f.getContentPane().add(l1);
		l1.setIcon(image);

		f.setVisible(true);

	}
}
