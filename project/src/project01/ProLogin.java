package project01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import DataBase.LoginDAO;
import DataBase.LoginVO;
import javax.swing.JPasswordField;

public class ProLogin {
	private static JTextField t1;
	private static JTextField id1;
	private static JTextField id2;
	private static JTextField id3;
	private static JTextField id4;
	private static JTextField id5;
	private static JTextField del1;
	private static JTextField del2;
	private static JTextField del3;
	private static JTextField del4;
	private static JTextField del5;
	private static JPasswordField t2;

	public static void main(String[] args) {
		// 프레임
		JFrame f = new JFrame("1차 프로젝트-코로나");

		f.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		f.setSize(900, 1000);
		f.getContentPane().setLayout(null);

		// 판넬1
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 150, 179));
		panel.setBounds(22, 213, 850, 738);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		t1 = new JTextField();
		t1.setBounds(229, 232, 398, 73);
		t1.setFont(new Font("굴림", Font.PLAIN, 25));
		panel.add(t1);
		t1.setColumns(10);
		// 로그인버튼
		JButton login = new JButton("로그인");
		login.setBounds(229, 430, 398, 75);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user_id = t1.getText();
				String user_pw = t2.getText();
				LoginDAO dao = new LoginDAO();

				try {
					boolean res = dao.login(user_id, user_pw);
					if (res) {
						JOptionPane.showMessageDialog(f, "로그인성공");

						ProHome t1 = new ProHome();
						t1.main(null);
						f.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(f, "로그인실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		login.setBackground(new Color(255, 255, 255));
		login.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		panel.add(login);
		// 회원가입 버튼
		JButton join = new JButton("회원가입");
		join.setBounds(229, 521, 398, 75);
		join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ProJoin t1 = new ProJoin();
				try {
					t1.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);

			}
		});
		join.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		join.setBackground(new Color(255, 255, 255));
		panel.add(join);

		JLabel lblNewLabel = new JLabel("코로나 바이러스 19");
		lblNewLabel.setBounds(229, 73, 404, 74);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("휴먼모음T", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(27, 388, 651, -327);
		panel.add(layeredPane);
		// 회원탈퇴 버튼
		JButton delete = new JButton("회원 탈퇴");
		delete.setBounds(435, 617, 192, 60);
		panel.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f2 = new JFrame();
				f2.getContentPane().setBackground(new Color(0, 150, 179));
				f2.setSize(500, 550);
				f2.getContentPane().setLayout(null);
				f2.setLocationRelativeTo(f);

				del3 = new JTextField();
				del3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				del3.setBounds(144, 201, 200, 52);
				f2.getContentPane().add(del3);
				del3.setColumns(10);

				del1 = new JTextField();
				del1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				del1.setColumns(10);
				del1.setBounds(144, 41, 200, 52);
				f2.getContentPane().add(del1);

				del2 = new JTextField();
				del2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				del2.setColumns(10);
				del2.setBounds(144, 121, 200, 52);
				f2.getContentPane().add(del2);

				del4 = new JTextField();
				del4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				del4.setColumns(10);
				del4.setBounds(144, 281, 200, 52);
				f2.getContentPane().add(del4);

				del5 = new JTextField();
				del5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				del5.setColumns(10);
				del5.setBounds(144, 358, 200, 52);
				f2.getContentPane().add(del5);

				JLabel lblNewLabel = new JLabel("Name");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblNewLabel.setBounds(64, 204, 68, 42);
				f2.getContentPane().add(lblNewLabel);

				JLabel lblId = new JLabel("I D");
				lblId.setForeground(Color.WHITE);
				lblId.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblId.setBounds(64, 44, 54, 42);
				f2.getContentPane().add(lblId);

				JLabel lblPw = new JLabel("P W");
				lblPw.setForeground(Color.WHITE);
				lblPw.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblPw.setBounds(66, 124, 66, 42);
				f2.getContentPane().add(lblPw);

				JLabel lblTel = new JLabel("Tel");
				lblTel.setForeground(Color.WHITE);
				lblTel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblTel.setBounds(74, 284, 44, 42);
				f2.getContentPane().add(lblTel);

				JLabel lblBirth = new JLabel("Birth");
				lblBirth.setForeground(Color.WHITE);
				lblBirth.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblBirth.setBounds(70, 361, 62, 42);
				f2.getContentPane().add(lblBirth);

				// 회원탈퇴 in 정보찾기
				JButton read = new JButton("찾기");
				read.setBackground(Color.WHITE);
				read.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user_id = del1.getText();
						LoginDAO dao = new LoginDAO();

						try {
							LoginVO bag = dao.out(user_id);

							del2.setText(bag.getUser_pw());
							del3.setText(bag.getUser_name());
							del4.setText(bag.getUser_tel());
							del5.setText(bag.getUser_birth());

						} catch (Exception e1) {

							e1.printStackTrace();
						}

					}

				});
				read.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				read.setBounds(356, 41, 74, 52);
				f2.getContentPane().add(read);

				JButton read_1 = new JButton("회원탈퇴");
				read_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user_id = del1.getText();
						LoginDAO dao = new LoginDAO();
						LoginVO bag = new LoginVO();
						bag.setUser_id(user_id);

						try {
							dao.delete(bag);
							int result = JOptionPane.showConfirmDialog(f2, "회원탈퇴를 하시겠습니까?", "confirm",
									JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.CLOSED_OPTION) {

							} else if (result == JOptionPane.YES_NO_OPTION) {
								JOptionPane.showMessageDialog(f2, "회원탈퇴가 완료되었습니다.");
								f2.setVisible(false);
							} else {

							}

						} catch (Exception e1) {
						}
					}
				});
				read_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				read_1.setBackground(Color.WHITE);
				read_1.setBounds(138, 447, 200, 42);
				f2.getContentPane().add(read_1);
				f2.setVisible(true);
			}
		});
		delete.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		// 아이디 찾기버튼
		JButton read = new JButton("아이디 찾기");
		read.setBounds(229, 617, 192, 60);
		panel.add(read);
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f1 = new JFrame();
				f1.getContentPane().setBackground(new Color(0, 150, 179));
				f1.setSize(500, 500);
				f1.setLocationRelativeTo(f);
				f1.getContentPane().setLayout(null);

				id1 = new JTextField();
				id1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				id1.setBounds(128, 34, 200, 52);
				f1.getContentPane().add(id1);
				id1.setColumns(10);

				id2 = new JTextField();
				id2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				id2.setColumns(10);
				id2.setBounds(128, 117, 200, 52);
				f1.getContentPane().add(id2);

				id3 = new JTextField();
				id3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				id3.setColumns(10);
				id3.setBounds(128, 200, 200, 52);
				f1.getContentPane().add(id3);

				id4 = new JTextField();
				id4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				id4.setColumns(10);
				id4.setBounds(128, 284, 200, 52);
				f1.getContentPane().add(id4);

				id5 = new JTextField();
				id5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				id5.setColumns(10);
				id5.setBounds(128, 365, 200, 52);
				f1.getContentPane().add(id5);

				JLabel lblNewLabel = new JLabel("Name");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblNewLabel.setBounds(55, 37, 70, 42);
				f1.getContentPane().add(lblNewLabel);

				JLabel lblId = new JLabel("I D");
				lblId.setHorizontalAlignment(SwingConstants.LEFT);
				lblId.setForeground(Color.WHITE);
				lblId.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblId.setBounds(55, 120, 61, 42);
				f1.getContentPane().add(lblId);

				JLabel lblPw = new JLabel("PW");
				lblPw.setHorizontalAlignment(SwingConstants.LEFT);
				lblPw.setForeground(Color.WHITE);
				lblPw.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblPw.setBounds(55, 203, 61, 42);
				f1.getContentPane().add(lblPw);

				JLabel lblTel = new JLabel("Tel");
				lblTel.setHorizontalAlignment(SwingConstants.LEFT);
				lblTel.setForeground(Color.WHITE);
				lblTel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblTel.setBounds(55, 294, 61, 42);
				f1.getContentPane().add(lblTel);

				JLabel lblBirth = new JLabel("Birth");
				lblBirth.setHorizontalAlignment(SwingConstants.LEFT);
				lblBirth.setForeground(Color.WHITE);
				lblBirth.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
				lblBirth.setBounds(55, 368, 62, 42);
				f1.getContentPane().add(lblBirth);

				// 아이디찾기 in 정보찾기
				JButton read = new JButton("찾기");
				read.setBackground(Color.WHITE);
				read.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user_name = id1.getText();
						LoginDAO dao = new LoginDAO();

						try {
							LoginVO bag = dao.one(user_name);
							id2.setText(bag.getUser_id());
							id3.setText(bag.getUser_pw());
							id4.setText(bag.getUser_tel());
							id5.setText(bag.getUser_birth());

						} catch (Exception e1) {
					
						}

					}

				});
				read.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
				read.setBounds(340, 34, 85, 52);
				f1.getContentPane().add(read);

				JLabel lblNewLabel_1 = new JLabel("* 이름을 입력하세요");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
				lblNewLabel_1.setBounds(128, 85, 136, 18);
				f1.getContentPane().add(lblNewLabel_1);
				f1.setVisible(true);

			}
		});
		read.setFont(new Font("휴먼모음T", Font.PLAIN, 17));

		t2 = new JPasswordField();
		t2.setFont(new Font("굴림", Font.PLAIN, 25));
		t2.setBounds(229, 330, 398, 73);
		panel.add(t2);

		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		f.getContentPane().add(l1);
		l1.setIcon(image);

		f.setVisible(true);

	}
}
