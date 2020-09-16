package project01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import DataBase.LoginDAO;
import DataBase.LoginVO;

public class ProHome {
	private static JTextField u3;
	private static JTextField u1;
	private static JTextField u2;
	private static JTextField u4;
	private static JTextField u5;

	public static void main(String[] args) {
		// 프레임
		JFrame home = new JFrame("1차 프로젝트-코로나");
		home.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");
		ImageIcon image2 = new ImageIcon("src/covid-main.gif");

		// 사이즈
		home.setSize(900, 1000);
		home.getContentPane().setLayout(null);

		// 홈버튼
		JButton homeButton = new JButton("홈");
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ProHome t1 = new ProHome();
				t1.main(null);
				home.setVisible(false);
			}
		});
		homeButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		homeButton.setBounds(24, 128, 202, 75);
		home.getContentPane().add(homeButton);

		// 국내확진자 현황 버튼
		JButton dayButton = new JButton("국내 확진자 현황");
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prokor t1 = new Prokor();
				t1.main(null);
				home.setVisible(false);
			}
		});
		dayButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		dayButton.setBounds(226, 128, 228, 75);
		home.getContentPane().add(dayButton);

		// 시도별확진자 현황 버튼
		JButton cityButton = new JButton("시도별확진자");
		cityButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		cityButton.setBounds(454, 128, 216, 75);
		home.getContentPane().add(cityButton);

		// 게시판 버튼
		JButton boardButton = new JButton("게시판");
		boardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProBoard2 t1 = new ProBoard2();
				try {
					t1.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				home.setVisible(false);
			}
		});
		boardButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardButton.setBounds(670, 128, 202, 75);
		home.getContentPane().add(boardButton);

		// 하단 콘텐츠 판넬
		JPanel homemain = new JPanel();
		homemain.setBackground(new Color(0, 150, 179));
		homemain.setBounds(22, 213, 850, 738);
		home.getContentPane().add(homemain);
		homemain.setLayout(null);

		JPanel home1panel = new JPanel();
		home1panel.setBackground(new Color(0, 154, 255));
		home1panel.setBounds(0, 335, 255, 356);
		homemain.add(home1panel);
		home1panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("확진환자");
		lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 31, 255, 55);
		home1panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel lblNewLabel_2 = new JLabel("=");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("휴먼모음T", Font.PLAIN, 72));
		lblNewLabel_2.setBounds(193, 155, 96, 42);
		home1panel.add(lblNewLabel_2);

		// 하단 일일 확진자 크롤링

		Connection con = Jsoup.connect("http://ncov.mohw.go.kr/");
		String total = null;
		String complete = null;
		String ing = null;
		String dead = null;

		try {
			Document doc = con.get();

			Elements list = doc.select("li > span.num");
			total = list.get(0).text();
			complete = list.get(1).text();
			ing = list.get(2).text();
			dead = list.get(3).text();

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel a1 = new JLabel(total);
		a1.setForeground(Color.WHITE);
		a1.setFont(new Font("휴먼엑스포", Font.PLAIN, 33));
		a1.setBounds(10, 128, 209, 111);
		home1panel.add(a1);

		JPanel home2panel = new JPanel();
		home2panel.setBackground(new Color(0, 102, 153));
		home2panel.setBounds(253, 358, 226, 333);
		homemain.add(home2panel);
		home2panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("완치");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 19, 226, 61);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 40));
		home2panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("(격리해제)");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(0, 81, 226, 36);
		home2panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("+");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 95));
		lblNewLabel_2_1.setBounds(169, 150, 58, 61);
		home2panel.add(lblNewLabel_2_1);

		JLabel a2 = new JLabel(complete);
		a2.setForeground(Color.WHITE);
		a2.setFont(new Font("휴먼엑스포", Font.PLAIN, 35));
		a2.setBounds(47, 132, 119, 111);
		home2panel.add(a2);

		JPanel home3panel = new JPanel();
		home3panel.setBackground(new Color(23, 64, 105));
		home3panel.setBounds(479, 380, 205, 311);
		homemain.add(home3panel);
		home3panel.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("치료중");
		lblNewLabel_1_1.setBounds(0, 38, 204, 66);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 40));
		home3panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("(격리중)");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 30));
		lblNewLabel_1_1_2.setBounds(0, 93, 204, 36);
		home3panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("+");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 95));
		lblNewLabel_2_1_1.setBounds(143, 168, 72, 61);
		home3panel.add(lblNewLabel_2_1_1);

		JLabel a3 = new JLabel(ing);
		a3.setForeground(Color.WHITE);
		a3.setFont(new Font("휴먼엑스포", Font.PLAIN, 35));
		a3.setBounds(54, 179, 115, 53);
		home3panel.add(a3);

		JPanel home4panel = new JPanel();
		home4panel.setBackground(new Color(128, 128, 128));
		home4panel.setBounds(680, 408, 170, 283);
		homemain.add(home4panel);
		home4panel.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("사망");
		lblNewLabel_1_1_1.setBounds(0, 35, 170, 50);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 40));
		home4panel.add(lblNewLabel_1_1_1);

		JLabel a4 = new JLabel(dead);
		a4.setForeground(Color.WHITE);
		a4.setFont(new Font("휴먼엑스포", Font.PLAIN, 35));
		a4.setBounds(50, 148, 92, 75);
		home4panel.add(a4);

		JLabel l2 = new JLabel("");
		l2.setBackground(new Color(255, 255, 255));
		l2.setBounds(0, 0, 850, 293);
		homemain.add(l2);
		l2.setIcon(image2);

		// 상단 회원정보 수정버튼
		JButton update = new JButton("회원정보 수정");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame up = new JFrame();
				up.getContentPane().setBackground(new Color(0, 150, 179));
				up.setSize(480, 550);
				up.setLocationRelativeTo(home);
				up.getContentPane().setLayout(null);

				u3 = new JTextField();
				u3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				u3.setBounds(103, 198, 200, 52);
				up.getContentPane().add(u3);
				u3.setColumns(10);

				u1 = new JTextField();
				u1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				u1.setColumns(10);
				u1.setBounds(103, 34, 200, 52);
				up.getContentPane().add(u1);

				u2 = new JTextField();
				u2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				u2.setColumns(10);
				u2.setBounds(103, 117, 200, 52);
				up.getContentPane().add(u2);

				u4 = new JTextField();
				u4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				u4.setColumns(10);
				u4.setBounds(103, 280, 200, 52);
				up.getContentPane().add(u4);

				u5 = new JTextField();
				u5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				u5.setColumns(10);
				u5.setBounds(103, 356, 200, 52);
				up.getContentPane().add(u5);

				JLabel lblNewLabel = new JLabel("Name");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblNewLabel.setBounds(29, 201, 68, 42);
				up.getContentPane().add(lblNewLabel);

				JLabel lblId = new JLabel("ID");
				lblId.setForeground(Color.WHITE);
				lblId.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblId.setBounds(60, 39, 35, 42);
				up.getContentPane().add(lblId);

				JLabel lblPw = new JLabel("PW");
				lblPw.setForeground(Color.WHITE);
				lblPw.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblPw.setBounds(54, 122, 48, 42);
				up.getContentPane().add(lblPw);

				JLabel lblTel = new JLabel("Tel");
				lblTel.setForeground(Color.WHITE);
				lblTel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblTel.setBounds(58, 287, 44, 42);
				up.getContentPane().add(lblTel);

				JLabel lblBirth = new JLabel("Birth");
				lblBirth.setForeground(Color.WHITE);
				lblBirth.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblBirth.setBounds(41, 361, 62, 42);
				up.getContentPane().add(lblBirth);

				// 회원정보 수정 in 찾기버튼
				JButton read = new JButton("찾기");
				read.setBackground(Color.WHITE);
				read.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user_id = u1.getText();
						LoginDAO dao = new LoginDAO();

						try {
							LoginVO bag = dao.out(user_id);
							u2.setText(bag.getUser_pw());
							u3.setText(bag.getUser_name());
							u4.setText(bag.getUser_tel());
							u5.setText(bag.getUser_birth());

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(up, "검색결과가 없습니다.");
						}

					}

				});
				read.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				read.setBounds(324, 34, 85, 52);
				up.getContentPane().add(read);

				// 회원정보 수정 in 수정확인 버튼
				JButton read_1 = new JButton("정보 수정");
				read_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String user_id = u1.getText();
						String user_pw = u2.getText();
						String user_name = u3.getText();
						String user_tel = u4.getText();
						String user_birth = u5.getText();

						LoginDAO dao = new LoginDAO();
						LoginVO bag = new LoginVO();

						bag.setUser_id(user_id);
						bag.setUser_pw(user_pw);
						bag.setUser_name(user_name);
						bag.setUser_tel(user_tel);
						bag.setUser_birth(user_birth);

						try {
							dao.update(bag);
							JOptionPane.showMessageDialog(up, "수정이 완료되었습니다.");
							up.setVisible(false);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				read_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				read_1.setBackground(Color.WHITE);
				read_1.setBounds(103, 422, 200, 52);
				up.getContentPane().add(read_1);
				up.setVisible(true);
			}
		});
		update.setBounds(638, 53, 116, 32);
		home.getContentPane().add(update);

		// 상단 로그아웃 버튼
		JButton logout = new JButton("로그아웃");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(home, "로그아웃 하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_NO_OPTION) {
					ProLogin t1 = new ProLogin();
					t1.main(null);
					home.setVisible(false);
				} else {

				}

			}
		});
		logout.setBounds(766, 53, 86, 32);
		home.getContentPane().add(logout);

		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		home.getContentPane().add(l1);
		l1.setIcon(image);

		home.setVisible(true);

	}
}
