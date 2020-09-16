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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DataBase.JoinDAO;
import DataBase.JoinVO;

public class ProJoin {
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;

	public static void main(String[] args) throws Exception {
		// 프레임
		JFrame f = new JFrame("1차 프로젝트-코로나");
		f.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		f.setSize(900, 1000);
		f.getContentPane().setLayout(null);

		

		// 판넬
		JPanel joinpanel = new JPanel();
		joinpanel.setBackground(new Color(0, 150, 179));
		joinpanel.setBounds(22, 213, 850, 738);
		f.getContentPane().add(joinpanel);
		joinpanel.setLayout(null);

		// 회원가입 입력창

		JTextField joinid = new JTextField(10);
		joinid.setFont(new Font("굴림", Font.PLAIN, 20));
		joinid.setBounds(316, 119, 290, 39);
		joinpanel.add(joinid);

		passwordField = new JPasswordField();
		passwordField.setBounds(316, 190, 290, 39);
		joinpanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(316, 259, 290, 39);
		joinpanel.add(passwordField_1);

		JTextField joinname = new JTextField(10);
		joinname.setFont(new Font("굴림", Font.PLAIN, 20));
		joinname.setBounds(316, 334, 290, 39);
		joinpanel.add(joinname);
		JTextField joinbirth = new JTextField(10);
		joinbirth.setToolTipText("ddddd");
		joinbirth.setFont(new Font("굴림", Font.PLAIN, 20));
		joinbirth.setBounds(316, 409, 290, 39);
		joinpanel.add(joinbirth);
		JTextField joinhp = new JTextField(10);
		joinhp.setFont(new Font("굴림", Font.PLAIN, 20));
		joinhp.setBounds(316, 485, 290, 39);
		joinpanel.add(joinhp);

		JButton joinOkButton = new JButton("회원가입");
		joinOkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String user_id = joinid.getText();
				String user_pw = new String(passwordField.getText());
				String user_pwchk = new String(passwordField_1.getText());
				String user_name = joinname.getText();
				String user_birth = joinbirth.getText();
				String user_tel = joinhp.getText();

				//회원가입 빈칸 & 비밀번호 확인 유무
				if (user_id.isEmpty()) { //isEmpty, 빈칸인 경우 확인
					JOptionPane.showMessageDialog(f, "아이디를 입력해주세요.");
				} else if (user_pw.isEmpty()) { 
					JOptionPane.showMessageDialog(f, "비밀번호를 입력해주세요.");

				} else if (user_name.isEmpty()) {
					JOptionPane.showMessageDialog(f, "이름을 입력해주세요.");
				} else if (user_birth.isEmpty()) {
					JOptionPane.showMessageDialog(f, "생일을 입력해주세요.");
				} else if (user_tel.isEmpty()) {
					JOptionPane.showMessageDialog(f, "전화번호를 입력해주세요.");
				} else if (!user_pw.equals(user_pwchk)) { // String, equals로 비교
					JOptionPane.showMessageDialog(f, "입력하신 비밀번호가 다릅니다. 비밀번호를 확인해주세요.");
				}

				else {
					JOptionPane.showMessageDialog(f, "회원가입 완료");
					
					JoinDAO dao = new JoinDAO();
					JoinVO vo = new JoinVO();
					vo.setUser_id(user_id);
					vo.setUser_pw(user_pw);
					vo.setUser_name(user_name);
					vo.setUser_birth(user_birth);
					vo.setUser_tel(user_tel);
					
					try {
						dao.create(vo);
						
						ProLogin t1 = new ProLogin();
						t1.main(null); // 회원가입 완료 후 로그인 프레임 띄우기
						f.setVisible(false); // 회원가입 프레임 닫기
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
		
				
				
			}
		}

		);
		joinOkButton.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		joinOkButton.setBounds(316, 594, 103, 28);
		joinpanel.add(joinOkButton);

		JButton joincancelButton = new JButton("취소");
		joincancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProLogin t1 = new ProLogin();
				t1.main(null);
				f.setVisible(false);
			}
		});
		joincancelButton.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		joincancelButton.setBounds(419, 594, 103, 28);
		joinpanel.add(joincancelButton);

		JLabel joinIDlabel = new JLabel("I    D");
		joinIDlabel.setForeground(Color.WHITE);
		joinIDlabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinIDlabel.setBounds(112, 118, 156, 39);
		joinpanel.add(joinIDlabel);

		JLabel joinPWlabel = new JLabel("비밀번호");
		joinPWlabel.setForeground(Color.WHITE);
		joinPWlabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinPWlabel.setBounds(112, 190, 156, 39);
		joinpanel.add(joinPWlabel);

		JLabel joinPWrelabel = new JLabel("비밀번호 확인");
		joinPWrelabel.setForeground(Color.WHITE);
		joinPWrelabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinPWrelabel.setBounds(112, 259, 198, 39);
		joinpanel.add(joinPWrelabel);

		JLabel joinnamelabel = new JLabel("이      름");
		joinnamelabel.setForeground(Color.WHITE);
		joinnamelabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinnamelabel.setBounds(112, 333, 198, 39);
		joinpanel.add(joinnamelabel);

		JLabel joinbirthlabel = new JLabel("생 년 월 일");
		joinbirthlabel.setForeground(Color.WHITE);
		joinbirthlabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinbirthlabel.setBounds(112, 408, 198, 39);
		joinpanel.add(joinbirthlabel);

		JLabel joinhplabel = new JLabel("연  락  처");
		joinhplabel.setForeground(Color.WHITE);
		joinhplabel.setFont(new Font("휴먼모음T", Font.BOLD, 27));
		joinhplabel.setBounds(112, 484, 198, 39);
		joinpanel.add(joinhplabel);

		JButton joinIDokButton = new JButton("중복확인");
		joinIDokButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_id = joinid.getText();

				JoinDAO dao = new JoinDAO();
				JoinVO vo = new JoinVO();
				vo.setUser_id(user_id);

				try {
					boolean result = dao.read(vo);
					if (result) {
						JOptionPane.showMessageDialog(f, "중복된 ID가 있습니다.");
					} else {
						JOptionPane.showMessageDialog(f, "사용가능한 ID 입니다.");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		joinIDokButton.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		joinIDokButton.setBounds(618, 119, 86, 39);
		joinpanel.add(joinIDokButton);

		JLabel lblNewLabel = new JLabel("* 010 부터 '-' 없이 입력해주세요.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(316, 522, 225, 28);
		joinpanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* 생년월일 6자리 입력 ex)900305");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(316, 447, 225, 28);
		joinpanel.add(lblNewLabel_1);

		// 이미지
		JLabel l1 = new JLabel("img");
		l1.setBounds(0, 0, 884, 203);
		f.getContentPane().add(l1);
		l1.setIcon(image);

		f.setVisible(true);

	}
}
