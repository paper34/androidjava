package project01;

import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import DataBase.BoardDAO;
import DataBase.BoardVO;
import DataBase.LoginDAO;
import DataBase.LoginVO;

public class ProBoard1 {
	private static JTextField b_title;
	private static JTextField b_writer;
	private static JTextField u3;
	private static JTextField u1;
	private static JTextField u2;
	private static JTextField u4;
	private static JTextField u5;

	public static void main(String[] args) {
		// 프레임
		JFrame f = new JFrame("1차 프로젝트-코로나");
		f.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		f.setSize(900, 1000);
		f.getContentPane().setLayout(null);

		JButton homeButton = new JButton("홈");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProHome t1 = new ProHome();
				t1.main(null);
				f.setVisible(false);
			}
		});
		homeButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		homeButton.setBounds(24, 128, 202, 75);
		f.getContentPane().add(homeButton);

		JButton dayButton = new JButton("국내별확진자 현황");
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prokor t1 = new Prokor();
				t1.main(null);
				f.setVisible(false);
			}
		});
		dayButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		dayButton.setBounds(226, 128, 228, 75);
		f.getContentPane().add(dayButton);

		JButton cityButton = new JButton("시도별확진자");
		cityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProCity t1 = new ProCity();
				try {
					t1.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		cityButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		cityButton.setBounds(454, 128, 218, 75);
		f.getContentPane().add(cityButton);

		JButton boardButton = new JButton("게시판");
		boardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProBoard2 t1 = new ProBoard2();
				try {
					t1.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		boardButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardButton.setBounds(670, 128, 202, 75);
		f.getContentPane().add(boardButton);

		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		f.getContentPane().add(l1);
		l1.setIcon(image);

		JLabel lblNewLabel = new JLabel("게시판 글쓰기");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("휴먼모음T", Font.BOLD, 32));
		lblNewLabel.setBounds(230, 231, 438, 51);
		f.getContentPane().add(lblNewLabel);

		JPanel bodpanel = new JPanel();
		bodpanel.setBackground(SystemColor.control);
		bodpanel.setBounds(65, 303, 759, 558);
		f.getContentPane().add(bodpanel);
		bodpanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("제  목");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(12, 46, 78, 46);
		bodpanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("작성자");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(499, 46, 78, 46);
		bodpanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("내  용");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(12, 102, 78, 46);
		bodpanel.add(lblNewLabel_1_1_1);

		b_title = new JTextField();
		b_title.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		b_title.setBounds(89, 54, 411, 29);
		bodpanel.add(b_title);
		b_title.setColumns(10);

		b_writer = new JTextField();
		b_writer.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		b_writer.setColumns(10);
		b_writer.setBounds(581, 54, 153, 29);
		bodpanel.add(b_writer);

		JTextPane b_content = new JTextPane();
		b_content.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		b_content.setBounds(22, 146, 714, 370);
		bodpanel.add(b_content);

		JButton okbutton = new JButton("확인");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String title = b_title.getText();
				String writer = b_writer.getText();
				String content = b_content.getText();

				BoardDAO dao = new BoardDAO();
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				try {
					dao.create(vo);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(f, "게시판 작성 완료");

				ProBoard2 Proboard2 = new ProBoard2();

				try {
					Proboard2.main(null);
					f.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}

		);
		okbutton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		okbutton.setBounds(343, 871, 97, 23);
		f.getContentPane().add(okbutton);

		JButton canclebutton = new JButton("취소");
		canclebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProBoard2 Proboard2 = new ProBoard2();
				f.setVisible(false);
				try {
					Proboard2.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		canclebutton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		canclebutton.setBounds(447, 871, 97, 23);
		f.getContentPane().add(canclebutton);

		// 상단 회원정보 수정버튼
		JButton update = new JButton("회원정보 수정");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame up = new JFrame();
				up.getContentPane().setBackground(new Color(0, 150, 179));
				up.setSize(480, 550);
				up.setLocationRelativeTo(f);
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
		f.getContentPane().add(update);

		// 상단 로그아웃 버튼
		JButton logout = new JButton("로그아웃");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(f, "로그아웃 하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_NO_OPTION) {
					ProLogin t1 = new ProLogin();
					t1.main(null);
					f.setVisible(false);
				} else {

				}

			}
		});
		logout.setBounds(766, 53, 86, 32);
		f.getContentPane().add(logout);

		f.setVisible(true);

	}
}
