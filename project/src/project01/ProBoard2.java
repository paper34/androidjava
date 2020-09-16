package project01;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DataBase.BoardDAO;
import DataBase.BoardVO;
import DataBase.LoginDAO;
import DataBase.LoginVO;

public class ProBoard2 {
	private static JTextField number;

	private static JTextField u3;
	private static JTextField u1;
	private static JTextField u2;
	private static JTextField u4;
	private static JTextField u5;

	public static void main(String[] args) throws Exception {
		// 프레임
		JFrame boardwrite = new JFrame("1차 프로젝트-코로나");
		boardwrite.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		boardwrite.setSize(900, 1000);
		boardwrite.getContentPane().setLayout(null);

		JButton homeButton = new JButton("홈");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProHome t1 = new ProHome();
				t1.main(null);
				boardwrite.setVisible(false);
			}
		});
		homeButton.setBounds(24, 128, 202, 75);
		homeButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardwrite.getContentPane().add(homeButton);

		JButton dayButton = new JButton("국내확진자 현황");
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prokor t1 = new Prokor();
				t1.main(null);
				boardwrite.setVisible(false);
			}
		});
		dayButton.setBounds(226, 128, 228, 75);
		dayButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardwrite.getContentPane().add(dayButton);

		JButton cityButton = new JButton("시도별확진자");
		cityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProCity t1 = new ProCity();
				try {
					t1.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				boardwrite.setVisible(false);
			}
		});
		cityButton.setBounds(454, 128, 217, 75);
		cityButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardwrite.getContentPane().add(cityButton);

		JButton boardButton = new JButton("게시판");
		boardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProBoard2 t1 = new ProBoard2();
				try {
					t1.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				boardwrite.setVisible(false);
			}
		});
		boardButton.setBounds(670, 128, 202, 75);
		boardButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		boardwrite.getContentPane().add(boardButton);

		// 이미지
		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		boardwrite.getContentPane().add(l1);
		l1.setIcon(image);

		// 게시판 테이블
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.selet();

		String titles[] = { "글번호", "제목", "작성자", "게시일" };
		Object contents[][] = new Object[list.size()][];

		for (int i = 0; i < list.size(); i++) {
			BoardVO vo = list.get(i);

			Object row[] = new Object[4];
			row[0] = vo.getNo();
			row[1] = vo.getTitle();
			row[2] = vo.getWriter();
			row[3] = vo.getCreate_date();
			contents[i] = row;
		}

		JTable jTable = new JTable(contents, titles);
		jTable.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		JScrollPane jScollPane = new JScrollPane(jTable);
		jScollPane.setBounds(108, 380, 684, 476);
		jTable.setEnabled(false);
		boardwrite.getContentPane().add(jScollPane);

		JLabel bod3main = new JLabel("게 시 판");
		bod3main.setBounds(391, 225, 112, 39);
		boardwrite.getContentPane().add(bod3main);
		bod3main.setForeground(Color.WHITE);
		bod3main.setFont(new Font("휴먼모음T", Font.BOLD, 27));

		JLabel lblNewLabel = new JLabel("게시글 번호 입력");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		lblNewLabel.setBounds(108, 325, 120, 30);
		boardwrite.getContentPane().add(lblNewLabel);

		number = new JTextField();
		number.setBounds(234, 324, 52, 33);
		boardwrite.getContentPane().add(number);
		number.setColumns(10);

		// 게시글 보기
		JButton show_button = new JButton("게시글 보기");
		show_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame showboard = new JFrame();
				showboard.setSize(833, 738);
				showboard.getContentPane().setLayout(null);

				JPanel bod2panel = new JPanel();
				bod2panel.setBackground(new Color(0, 150, 179));
				bod2panel.setBounds(0, 0, 833, 738);
				showboard.getContentPane().add(bod2panel);
				bod2panel.setLayout(null);

				JLabel bod2main = new JLabel("게 시 판");
				bod2main.setForeground(Color.WHITE);
				bod2main.setFont(new Font("휴먼모음T", Font.BOLD, 27));
				bod2main.setBounds(381, 22, 112, 39);
				bod2panel.add(bod2main);

				JPanel bod2Bg = new JPanel();
				bod2Bg.setBounds(48, 66, 736, 577);
				bod2panel.add(bod2Bg);
				bod2Bg.setLayout(null);

				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.WHITE);
				panel_2.setBounds(89, 75, 623, 33);
				bod2Bg.add(panel_2);
				panel_2.setLayout(null);

				JLabel title = new JLabel("title");
				title.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
				title.setBounds(12, 0, 599, 33);
				panel_2.add(title);

				JPanel panel_2_2 = new JPanel();
				panel_2_2.setBackground(Color.WHITE);
				panel_2_2.setBounds(28, 118, 684, 434);
				bod2Bg.add(panel_2_2);
				panel_2_2.setLayout(null);

				JTextArea content = new JTextArea();
				content.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
				content.setForeground(Color.BLACK);
				content.setBounds(12, 10, 660, 414);
				content.setEditable(false);
				panel_2_2.add(content);

				JLabel lblNewLabel_1 = new JLabel("작성자");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(172, 32, 50, 33);
				bod2Bg.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

				JLabel lblNewLabel_1_1 = new JLabel("게시일");
				lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_1.setBounds(404, 32, 67, 33);
				bod2Bg.add(lblNewLabel_1_1);
				lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

				JLabel lblNewLabel = new JLabel("제 목");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(28, 75, 50, 33);
				bod2Bg.add(lblNewLabel);
				lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

				JLabel lblNewLabel_1_2 = new JLabel("글번호");
				lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
				lblNewLabel_1_2.setBounds(28, 32, 50, 33);
				bod2Bg.add(lblNewLabel_1_2);

				JPanel panel_2_1_2 = new JPanel();
				panel_2_1_2.setLayout(null);
				panel_2_1_2.setBackground(Color.WHITE);
				panel_2_1_2.setBounds(89, 32, 55, 33);
				bod2Bg.add(panel_2_1_2);

				JLabel no = new JLabel("no");
				no.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				no.setBounds(12, 0, 31, 33);
				panel_2_1_2.add(no);

				JPanel panel_2_1 = new JPanel();
				panel_2_1.setBounds(234, 32, 147, 33);
				bod2Bg.add(panel_2_1);
				panel_2_1.setBackground(Color.WHITE);
				panel_2_1.setLayout(null);

				JLabel writer = new JLabel("writer");
				writer.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				writer.setBounds(12, 0, 123, 33);
				panel_2_1.add(writer);

				JPanel panel_2_1_1 = new JPanel();
				panel_2_1_1.setBounds(470, 32, 153, 33);
				bod2Bg.add(panel_2_1_1);
				panel_2_1_1.setBackground(Color.WHITE);
				panel_2_1_1.setLayout(null);

				JLabel cr_date = new JLabel("cr_date");
				cr_date.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				cr_date.setHorizontalAlignment(SwingConstants.CENTER);
				cr_date.setBounds(12, 0, 81, 33);
				panel_2_1_1.add(cr_date);

				JLabel cr_time = new JLabel("cr_time");
				cr_time.setHorizontalAlignment(SwingConstants.CENTER);
				cr_time.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				cr_time.setBounds(94, 0, 47, 33);
				panel_2_1_1.add(cr_time);

				// 수정 버튼
				JButton bod2reButton = new JButton("수정");
				bod2reButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame boardUpdate = new JFrame("1차 프로젝트-코로나");

						boardUpdate.setSize(833, 738);
						boardUpdate.getContentPane().setLayout(null);
						boardUpdate.setLocationRelativeTo(boardwrite);

						// 판넬
						JPanel bod2panel = new JPanel();
						bod2panel.setBackground(new Color(0, 150, 179));
						bod2panel.setBounds(0, 0, 833, 738);
						boardUpdate.getContentPane().add(bod2panel);
						bod2panel.setLayout(null);

						JLabel bod2main = new JLabel("게 시 판 수 정");
						bod2main.setForeground(Color.WHITE);
						bod2main.setFont(new Font("휴먼모음T", Font.BOLD, 27));
						bod2main.setBounds(313, 17, 189, 39);
						bod2panel.add(bod2main);

						JPanel bod2Bg = new JPanel();
						bod2Bg.setBounds(48, 66, 736, 577);
						bod2panel.add(bod2Bg);
						bod2Bg.setLayout(null);

						JPanel panel_2_2 = new JPanel();
						panel_2_2.setBackground(Color.WHITE);
						panel_2_2.setBounds(28, 118, 684, 434);
						bod2Bg.add(panel_2_2);
						panel_2_2.setLayout(null);

						JTextArea content = new JTextArea();
						content.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
						content.setForeground(Color.BLACK);
						content.setBounds(12, 10, 660, 414);
						panel_2_2.add(content);

						JLabel lblNewLabel_1 = new JLabel("작성자");
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1.setBounds(172, 32, 50, 33);
						bod2Bg.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

						JLabel lblNewLabel_1_1 = new JLabel("게시일");
						lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1_1.setBounds(404, 32, 67, 33);
						bod2Bg.add(lblNewLabel_1_1);
						lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

						JLabel lblNewLabel = new JLabel("제 목");
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setBounds(28, 75, 50, 33);
						bod2Bg.add(lblNewLabel);
						lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 16));

						JLabel lblNewLabel_1_2 = new JLabel("글번호");
						lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
						lblNewLabel_1_2.setBounds(28, 32, 50, 33);
						bod2Bg.add(lblNewLabel_1_2);

						JPanel panel_2_1_2 = new JPanel();
						panel_2_1_2.setLayout(null);
						panel_2_1_2.setBackground(Color.WHITE);
						panel_2_1_2.setBounds(89, 32, 55, 33);
						bod2Bg.add(panel_2_1_2);

						JLabel no = new JLabel("no");
						no.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
						no.setBounds(12, 0, 31, 33);
						panel_2_1_2.add(no);

						JPanel panel_2_1_1 = new JPanel();
						panel_2_1_1.setBounds(470, 32, 153, 33);
						bod2Bg.add(panel_2_1_1);
						panel_2_1_1.setBackground(Color.WHITE);
						panel_2_1_1.setLayout(null);

						JLabel cr_date = new JLabel("cr_date");
						cr_date.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
						cr_date.setHorizontalAlignment(SwingConstants.CENTER);
						cr_date.setBounds(12, 0, 81, 33);
						panel_2_1_1.add(cr_date);

						JLabel cr_time = new JLabel("cr_time");
						cr_time.setHorizontalAlignment(SwingConstants.CENTER);
						cr_time.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
						cr_time.setBounds(94, 0, 47, 33);
						panel_2_1_1.add(cr_time);

						JTextField TitleText = new JTextField();
						TitleText.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
						TitleText.setBounds(90, 75, 622, 33);
						bod2Bg.add(TitleText);
						TitleText.setColumns(10);

						JTextField WriterText = new JTextField();
						WriterText.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
						WriterText.setColumns(10);
						WriterText.setBounds(234, 32, 145, 33);
						bod2Bg.add(WriterText);

						String no1 = number.getText();
						BoardDAO dao1 = new BoardDAO();
						try {
							BoardVO vo = dao1.read(Integer.parseInt(no1));

							
							no.setText(String.valueOf(vo.getNo()));
							WriterText.setText(vo.getWriter());
							TitleText.setText(vo.getTitle());
							content.setText(vo.getContent());
							cr_date.setText(vo.getCreate_date());
							cr_time.setText(vo.getCreate_time());

						} catch (Exception e1) {
							e1.printStackTrace();
						}
						showboard.setVisible(false);

						JButton okok = new JButton("확인");
						okok.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String no2 = number.getText();

								BoardVO vo = new BoardVO();
								vo.setNo(Integer.parseInt(no2));
								vo.setTitle(TitleText.getText());
								vo.setWriter(WriterText.getText());
								vo.setContent(content.getText());

								BoardDAO dao = new BoardDAO();
								try {
									dao.update(vo);
								} catch (Exception e1) {
									e1.printStackTrace();
								}

								JOptionPane.showMessageDialog(boardUpdate, "수정 완료");
								boardUpdate.setVisible(false);
								boardwrite.setVisible(false);
								ProBoard2 boradmain = new ProBoard2();

								try {
									boradmain.main(null);
								} catch (Exception e1) {
									e1.printStackTrace();
								}

							}
						});
						okok.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
						okok.setBounds(362, 653, 103, 28);
						bod2panel.add(okok);

						boardUpdate.setVisible(true);

					}
				});

				bod2reButton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				bod2reButton.setBounds(603, 653, 103, 28);
				bod2panel.add(bod2reButton);

				// 삭제 버튼
				JButton bod2delButton = new JButton("삭제");
				bod2delButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String no2 = number.getText();
						BoardDAO dao = new BoardDAO();
						try {
							dao.delete(no2);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(boardwrite, "글 삭제 완료");
						showboard.setVisible(false);
						boardwrite.setVisible(false);
						ProBoard2 boardmain = new ProBoard2();

						try {
							boardmain.main(null);
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					}
				});

				bod2delButton.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
				bod2delButton.setBounds(703, 653, 103, 28);
				bod2panel.add(bod2delButton);

				// 게시판 상세보기 DB연결
				String no2 = number.getText();
				BoardDAO dao = new BoardDAO();
				try {
					BoardVO vo = dao.read(Integer.parseInt(no2));

					no.setText(String.valueOf(vo.getNo()));
					writer.setText(vo.getWriter());
					title.setText(vo.getTitle());
					content.setText(vo.getContent());
					cr_date.setText(vo.getCreate_date());
					cr_time.setText(vo.getCreate_time());

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				showboard.setLocationRelativeTo(boardwrite);
				showboard.setVisible(true);

			}
		});
		show_button.setForeground(SystemColor.text);
		show_button.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		show_button.setBackground(SystemColor.activeCaption);
		show_button.setBounds(291, 325, 97, 33);
		boardwrite.getContentPane().add(show_button);

		JButton WriteButton = new JButton("글쓰기");
		WriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProBoard1 BoardWrite = new ProBoard1();
				BoardWrite.main(null);
				boardwrite.setVisible(false);

			}
		});
		WriteButton.setBounds(391, 866, 112, 30);
		boardwrite.getContentPane().add(WriteButton);

		// 상단 회원정보 수정버튼
		JButton update = new JButton("회원정보 수정");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame up = new JFrame();
				up.getContentPane().setBackground(new Color(0, 150, 179));
				up.setSize(480, 550);
				up.setLocationRelativeTo(boardwrite);
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
		boardwrite.getContentPane().add(update);

		// 상단 로그아웃 버튼
		JButton logout = new JButton("로그아웃");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(boardwrite, "로그아웃 하시겠습니까?", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_NO_OPTION) {
					ProLogin t1 = new ProLogin();
					t1.main(null);
					boardwrite.setVisible(false);
				} else {

				}

			}
		});
		logout.setBounds(766, 53, 86, 32);
		boardwrite.getContentPane().add(logout);

		boardwrite.setVisible(true);

	}
}
