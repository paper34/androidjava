package 배열정리;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 영화앨범배열이용 {

	static int now = 2; // 현재 위치를 제크할 수 있는 변수

	public static void main(String[] args) {

		// 영화제목, 이미지목록, 감독목록, 평점목록
		String[] titles = { "다만 악에서 구하소서", "오케이 마담", "테넷", " 남매의 여름밤", "나의 소녀시대" };
		String[] images = { "다만.png", "오케.png", "테넷.jpg", "여름.png", "소녀시대.png" };
		String[] directors = { "홍원찬", "이철하", "크리스토퍼 놀란", "윤단비", "프랭키 첸" };
		double[] rates = { 7.79, 6.61, 9.09, 8.84, 100 };

		JFrame f = new JFrame("나의 영화앨범");
		f.getContentPane().setBackground(Color.ORANGE);
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);

		JLabel title = new JLabel(titles[2]);
		title.setForeground(new Color(220, 20, 60));
		title.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		title.setBounds(61, 51, 333, 64);
		f.getContentPane().add(title);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(images[2]));
		img.setBounds(74, 139, 196, 287);
		f.getContentPane().add(img);

		JLabel lblNewLabel_1 = new JLabel("감독");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(305, 149, 60, 37);
		f.getContentPane().add(lblNewLabel_1);

		JLabel director = new JLabel(directors[2]);
		director.setForeground(Color.RED);
		director.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		director.setBounds(289, 183, 140, 46);
		f.getContentPane().add(director);

		JLabel lblNewLabel_2_2 = new JLabel("평점");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_2_2.setBounds(305, 239, 60, 37);
		f.getContentPane().add(lblNewLabel_2_2);

		JLabel rate = new JLabel(rates[2] + "");
		rate.setForeground(Color.RED);
		rate.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		rate.setBounds(305, 270, 60, 37);
		f.getContentPane().add(rate);

		JButton btnNewButton = new JButton("◀◀");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				now--;
				title.setText(titles[now]);
				ImageIcon icon = new ImageIcon(images[now]);
				img.setIcon(icon);
				director.setText(directors[now]);
				rate.setText(rates[now] + "");
				if (now == 0) {
					now = 4;
				}
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(0, 0, 66, 461);
		f.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("▶▶");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				now++;
				title.setText(titles[now]);
				ImageIcon icon = new ImageIcon(images[now]);
				img.setIcon(icon);
				director.setText(directors[now]);
				rate.setText(rates[now] + "");
				if (now == 4) {
					now = -1;
				}

			}
		});
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(418, 0, 66, 461);
		f.getContentPane().add(btnNewButton_1);
		f.setVisible(true);
	}
}
