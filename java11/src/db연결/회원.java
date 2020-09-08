package db연결;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 회원 {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 25));
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setBounds(227, 93, 257, 63);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 25));
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setColumns(10);
		t2.setBounds(227, 185, 257, 63);
		f.getContentPane().add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 25));
		t3.setBackground(Color.LIGHT_GRAY);
		t3.setColumns(10);
		t3.setBounds(227, 276, 257, 63);
		f.getContentPane().add(t3);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 25));
		t4.setBackground(Color.LIGHT_GRAY);
		t4.setColumns(10);
		t4.setBounds(227, 370, 257, 63);
		f.getContentPane().add(t4);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(166, 93, 47, 63);
		f.getContentPane().add(lblNewLabel);

		JLabel pw = new JLabel("PW");
		pw.setForeground(Color.WHITE);
		pw.setBackground(Color.WHITE);
		pw.setFont(new Font("굴림", Font.PLAIN, 25));
		pw.setBounds(166, 185, 47, 63);
		f.getContentPane().add(pw);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(Color.WHITE);
		lblName.setFont(new Font("굴림", Font.PLAIN, 25));
		lblName.setBounds(146, 276, 67, 63);
		f.getContentPane().add(lblName);

		JLabel lblTel = new JLabel("TEL");
		lblTel.setForeground(Color.WHITE);
		lblTel.setBackground(Color.WHITE);
		lblTel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblTel.setBounds(166, 370, 47, 63);
		f.getContentPane().add(lblTel);
		// 회원가입
		JButton create = new JButton("회원가입");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입할 정보 4개의 입력값을 가지고 와서,
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();

				// db처리 (MemberDAO), create()메서드 호출
				MemberDAO dao = new MemberDAO();
				try {
					dao.create(id, pw, name, tel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		create.setBackground(Color.CYAN);
		create.setFont(new Font("굴림", Font.PLAIN, 20));
		create.setBounds(218, 459, 129, 55);
		f.getContentPane().add(create);

		// 회원 검색
		JButton read = new JButton("검색");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				MemberDAO dao = new MemberDAO();
				try {
					int result = dao.read(id); // 0이나 1이 리턴되어왔음.
					if (result == 1) { //검색결과가 있음
						
					} else {// 검색결과가 없음
						t1.setText("없음");
						t2.setText("없음");
						t3.setText("없음");
						t4.setText("없음");
						t1.setBackground(Color.BLUE);
						t2.setBackground(Color.BLUE);
						t3.setBackground(Color.BLUE);
						t4.setBackground(Color.BLUE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		read.setBackground(Color.CYAN);
		read.setFont(new Font("굴림", Font.PLAIN, 20));
		read.setBounds(372, 459, 129, 55);
		f.getContentPane().add(read);
		// 회원정보 수정
		JButton update = new JButton("수정");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = t1.getText();
				String tel = t4.getText();

				MemberDAO db = new MemberDAO();
				try {
					db.update(tel, id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		update.setBackground(Color.CYAN);
		update.setFont(new Font("굴림", Font.PLAIN, 20));
		update.setBounds(218, 538, 129, 55);
		f.getContentPane().add(update);
		// 회원정보 삭제
		JButton delete = new JButton("삭제");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();

				MemberDAO db = new MemberDAO();

				try {
					db.delete(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		delete.setBackground(Color.CYAN);
		delete.setFont(new Font("굴림", Font.PLAIN, 20));
		delete.setBounds(372, 538, 129, 55);
		f.getContentPane().add(delete);

		f.setVisible(true);
	}
}
