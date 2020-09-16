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

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import DataBase.LoginDAO;
import DataBase.LoginVO;

public class Prokor {
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

		f.setSize(900,1000);
		f.getContentPane().setLayout(null);

		// 크롤링
		Connection con = Jsoup.connect(
				"http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=");
		// 누적확진자 현황
		String 누적 = null; // 확진환자 -누적
		String 누적2 = null; // 격리해제 -누적
		String 누적3 = null; // 격리중 -누적
		String 누적4 = null; // 사망 -누적

		String 전일 = null; // 격리해제-전일
		String 전일2 = null; // 격리중-전일
		String 전일3 = null; // 사망-전일

		String 확진 = null; // 확진환자-소계
		String 확진2 = null; // 확진환자-해외유입
		String 확진3 = null; // 확진환자-국내발생

		// 누적검사 현황
		String m1 = null;
		String m2 = null;
		String m3 = null;
		String m4 = null;
		String m5 = null;
		String m6 = null;
		String m7 = null;
		String m8 = null;

		String z1 = null;

		try {
			Document doc = con.get();
			// 누적확진자현황 - 누적
			Elements list = doc.select("dd");
			Elements list2 = list.select(".ca_value");

			누적 = list2.get(0).text();// 확진환자 -누적
			누적2 = list2.get(2).text();// 격리해제 -누적
			누적3 = list2.get(4).text();// 격리중 -누적
			누적4 = list2.get(6).text();// 사망 -누적

			전일 = list2.get(3).text();// 격리해제 -전일대비
			전일2 = list2.get(5).text();// 격리해제 -전일대비
			전일3 = list2.get(7).text();// 격리해제 -전일대비

			Elements list3 = doc.select("dd");
			Elements list4 = list3.select(".inner_value");
			확진 = list4.get(0).text();// 확진환자 -소계
			확진2 = list4.get(1).text();// 확진환자-해외유입
			확진3 = list4.get(2).text();// 확진환자-국내발생

			Elements li = doc.select("tbody");
			Elements li2 = li.select("td");
			m1 = li2.get(32).text(); // 확진환자수-격리중
			m2 = li2.get(33).text(); // 확진환자수-격리해제
			m3 = li2.get(34).text(); // 확진환자수-사망
			m4 = li2.get(35).text(); // 확진환자수-소계
			m5 = li2.get(36).text(); // 결과음성
			m6 = li2.get(37).text(); // 소계
			m7 = li2.get(38).text(); // 검사중
			m8 = li2.get(39).text(); // 합계

			Elements li4 = doc.select("span.t_date");
			z1 = li4.get(0).text(); // 날짜시간

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 상단 홈버튼
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
		// 국내확진자 현황 버튼
		JButton dayButton = new JButton("국내확진자 현황");
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
		//시도별확진자 버튼
		JButton cityButton = new JButton("시도별확진자");
		cityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProCity t1 = new ProCity();
				try {
					t1.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.setVisible(false);
			}
		});
		cityButton.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		cityButton.setBounds(454, 128, 217, 75);
		f.getContentPane().add(cityButton);
		//게시판버튼
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 227, 255));
		panel.setBounds(22, 359, 328, 39);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("확진환자");
		lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 328, 39);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(200, 227, 255));
		panel_1.setBounds(353, 359, 169, 39);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("격리해제");
		lblNewLabel_1.setBounds(0, 0, 169, 39);
		lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(lblNewLabel_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(200, 227, 255));
		panel_1_1.setBounds(525, 359, 169, 39);
		f.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("격리중");
		lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(0, 0, 169, 39);
		lblNewLabel_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_1.add(lblNewLabel_1_1);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(200, 227, 255));
		panel_1_2.setBounds(697, 359, 169, 39);
		f.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("사망");
		lblNewLabel_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(0, 0, 169, 39);
		lblNewLabel_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_2.add(lblNewLabel_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 400, 99, 39);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("누적");
		lblNewLabel_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 99, 39);
		lblNewLabel_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_2.add(lblNewLabel_1_1_1_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(125, 400, 225, 39);
		f.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1.setBounds(0, 0, 225, 39);
		lblNewLabel_1_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_2_1.add(lblNewLabel_1_1_1_1_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(22, 442, 99, 75);
		f.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);

		JLabel a1 = new JLabel(누적);
		a1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a1.setBounds(0, 0, 99, 75);
		a1.setHorizontalAlignment(JLabel.CENTER);
		panel_2_2.add(a1);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(353, 400, 79, 39);
		f.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(null);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("누적");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 0, 75, 39);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3.add(lblNewLabel_1_1_1_1_1_1_1);

		JPanel panel_1_3_3 = new JPanel();
		panel_1_3_3.setLayout(null);
		panel_1_3_3.setBounds(435, 400, 87, 39);
		f.getContentPane().add(panel_1_3_3);

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(0, 0, 87, 39);
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3.add(lblNewLabel_1_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3.add(lblNewLabel_1_1_1_1_1_1_1_1);

		JPanel panel_1_3_4 = new JPanel();
		panel_1_3_4.setBounds(353, 442, 79, 75);
		f.getContentPane().add(panel_1_3_4);
		panel_1_3_4.setLayout(null);

		JLabel lblNewLabel_1_1_1_1_1_1_1_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_2.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4.add(lblNewLabel_1_1_1_1_1_1_1_2);

		JLabel a4 = new JLabel(누적2);
		a4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a4.setBounds(0, 0, 79, 75);
		a4.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4.add(a4);

		JPanel panel_1_3_3_1 = new JPanel();
		panel_1_3_3_1.setLayout(null);
		panel_1_3_3_1.setBounds(435, 443, 87, 74);
		f.getContentPane().add(panel_1_3_3_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_1.add(lblNewLabel_1_1_1_1_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(-82, 0, 80, 75);
		lblNewLabel_2_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_1.add(lblNewLabel_2_1_1);

		JLabel a5 = new JLabel(전일);
		a5.setForeground(Color.RED);
		a5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a5.setBounds(0, 0, 87, 75);
		a5.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_1.add(a5);

		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBounds(525, 400, 79, 39);
		f.getContentPane().add(panel_1_3_1);

		JLabel lblNewLabel_1_1_1_1_1_1_3 = new JLabel("누적");
		lblNewLabel_1_1_1_1_1_1_3.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_3.setBounds(0, 0, 75, 39);
		lblNewLabel_1_1_1_1_1_1_3.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1.add(lblNewLabel_1_1_1_1_1_1_3);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1.add(lblNewLabel_1_1_1_1_1_1_1_3);

		JPanel panel_1_3_3_2 = new JPanel();
		panel_1_3_3_2.setLayout(null);
		panel_1_3_3_2.setBounds(607, 400, 87, 39);
		f.getContentPane().add(panel_1_3_3_2);

		JLabel lblNewLabel_1_1_1_1_1_1_2_3 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_2_3.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_2_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2_3.setBounds(0, 0, 87, 39);
		lblNewLabel_1_1_1_1_1_1_2_3.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_2.add(lblNewLabel_1_1_1_1_1_1_2_3);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_2.add(lblNewLabel_1_1_1_1_1_1_1_1_2);

		JPanel panel_1_3_3_3 = new JPanel();
		panel_1_3_3_3.setLayout(null);
		panel_1_3_3_3.setBounds(779, 400, 87, 39);
		f.getContentPane().add(panel_1_3_3_3);

		JLabel lblNewLabel_1_1_1_1_1_1_2_4 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_2_4.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_2_4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_2_4.setBounds(0, 0, 87, 39);
		lblNewLabel_1_1_1_1_1_1_2_4.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_3.add(lblNewLabel_1_1_1_1_1_1_2_4);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_3 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_1_3.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_3.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_1_3.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_3_3.add(lblNewLabel_1_1_1_1_1_1_1_1_3);

		JPanel panel_1_3_1_1 = new JPanel();
		panel_1_3_1_1.setLayout(null);
		panel_1_3_1_1.setBounds(697, 400, 79, 39);
		f.getContentPane().add(panel_1_3_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_3_1 = new JLabel("누적");
		lblNewLabel_1_1_1_1_1_1_3_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_3_1.setBounds(0, 0, 75, 39);
		lblNewLabel_1_1_1_1_1_1_3_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_1.add(lblNewLabel_1_1_1_1_1_1_3_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_1.add(lblNewLabel_1_1_1_1_1_1_1_3_1);

		JPanel panel_1_3_1_2 = new JPanel();
		panel_1_3_1_2.setLayout(null);
		panel_1_3_1_2.setBounds(525, 442, 79, 75);
		f.getContentPane().add(panel_1_3_1_2);

		JLabel a6 = new JLabel(누적3);
		a6.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a6.setBounds(0, 0, 79, 75);
		a6.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2.add(a6);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3_2.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2.add(lblNewLabel_1_1_1_1_1_1_1_3_2);

		JPanel panel_1_3_1_2_1 = new JPanel();
		panel_1_3_1_2_1.setLayout(null);
		panel_1_3_1_2_1.setBounds(607, 442, 87, 75);
		f.getContentPane().add(panel_1_3_1_2_1);

		JLabel a7 = new JLabel(전일2);
		a7.setForeground(Color.RED);
		a7.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a7.setBounds(0, 0, 87, 75);
		a7.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2_1.add(a7);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3_2_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3_2_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3_2_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2_1.add(lblNewLabel_1_1_1_1_1_1_1_3_2_1);

		JPanel panel_1_3_1_2_2 = new JPanel();
		panel_1_3_1_2_2.setLayout(null);
		panel_1_3_1_2_2.setBounds(697, 442, 79, 75);
		f.getContentPane().add(panel_1_3_1_2_2);

		JLabel a8 = new JLabel(누적4);
		a8.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a8.setBounds(0, 0, 79, 75);
		a8.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2_2.add(a8);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3_2_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3_2_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3_2_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3_2_2.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3_2_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2_2.add(lblNewLabel_1_1_1_1_1_1_1_3_2_2);

		JPanel panel_1_3_1_2_1_1 = new JPanel();
		panel_1_3_1_2_1_1.setLayout(null);
		panel_1_3_1_2_1_1.setBounds(779, 442, 87, 75);
		f.getContentPane().add(panel_1_3_1_2_1_1);

		JLabel a9 = new JLabel(전일3);
		a9.setForeground(Color.RED);
		a9.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a9.setHorizontalAlignment(JLabel.CENTER);
		a9.setBounds(0, 0, 87, 75);
		panel_1_3_1_2_1_1.add(a9);

		JLabel lblNewLabel_1_1_1_1_1_1_1_3_2_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_3_2_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_3_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_3_2_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_3_2_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_1_2_1_1.add(lblNewLabel_1_1_1_1_1_1_1_3_2_1_1);

		JPanel panel_1_3_4_1_1 = new JPanel();
		panel_1_3_4_1_1.setLayout(null);
		panel_1_3_4_1_1.setBounds(208, 442, 70, 75);
		f.getContentPane().add(panel_1_3_4_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_2_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_2_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_2_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_2_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1.add(lblNewLabel_1_1_1_1_1_1_1_2_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("해외유입");
		lblNewLabel_2_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(0, 0, 70, 26);
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1.add(lblNewLabel_2_1);

		JLabel a31 = new JLabel(확진2);
		a31.setForeground(Color.RED);
		a31.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a31.setBounds(0, 28, 70, 47);
		a31.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1.add(a31);

		JPanel panel_1_3_4_1_1_1 = new JPanel();
		panel_1_3_4_1_1_1.setLayout(null);
		panel_1_3_4_1_1_1.setBounds(282, 442, 68, 75);
		f.getContentPane().add(panel_1_3_4_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_2_1_1_1 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_2_1_1_1.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_2_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_2_1_1_1.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_2_1_1_1.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1_1.add(lblNewLabel_1_1_1_1_1_1_1_2_1_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("국내발생");
		lblNewLabel_2_1_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_2_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(0, 0, 70, 26);
		lblNewLabel_2_1_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1_1.add(lblNewLabel_2_1_2);

		JLabel a41 = new JLabel(확진3);
		a41.setForeground(Color.RED);
		a41.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a41.setBounds(0, 28, 68, 47);
		a41.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_1_1.add(a41);

		JPanel panel_1_3_4_1_2 = new JPanel();
		panel_1_3_4_1_2.setLayout(null);
		panel_1_3_4_1_2.setBounds(125, 442, 79, 75);
		f.getContentPane().add(panel_1_3_4_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_1_2_1_2 = new JLabel("전일대비");
		lblNewLabel_1_1_1_1_1_1_1_2_1_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_1_1_1_1_1_1_1_2_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_2_1_2.setBounds(89, 0, 80, 39);
		lblNewLabel_1_1_1_1_1_1_1_2_1_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_2.add(lblNewLabel_1_1_1_1_1_1_1_2_1_2);

		JLabel lblNewLabel_2 = new JLabel("소계");
		lblNewLabel_2.setForeground(new Color(64, 89, 133));
		lblNewLabel_2.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(0, 0, 79, 26);
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_2.add(lblNewLabel_2);

		JLabel a21 = new JLabel(확진);
		a21.setForeground(Color.RED);
		a21.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		a21.setBounds(0, 28, 79, 47);
		a21.setHorizontalAlignment(JLabel.CENTER);
		panel_1_3_4_1_2.add(a21);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(24, 594, 604, 52);
		panel_3.setBackground(new Color(217, 236, 255));
		f.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("검사 완료");
		lblNewLabel_4.setForeground(new Color(64, 89, 133));
		lblNewLabel_4.setBounds(247, 5, 109, 34);
		lblNewLabel_4.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("◇국내 발생 현황");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.PLAIN, 32));
		lblNewLabel_3.setBounds(24, 215, 265, 50);
		f.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("□누적 확진자 현황");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 24));
		lblNewLabel_3_1.setBounds(22, 315, 217, 33);
		f.getContentPane().add(lblNewLabel_3_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(24, 273, 843, 5);
		f.getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(217, 236, 255));
		panel_5.setBounds(738, 594, 128, 184);
		f.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("합계");
		lblNewLabel_5.setForeground(new Color(64, 89, 133));
		lblNewLabel_5.setBounds(0, 0, 128, 184);
		lblNewLabel_5.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_5.setHorizontalAlignment(JLabel.CENTER);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_3_1_1 = new JLabel("□누적 검사현황");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 24));
		lblNewLabel_3_1_1.setBounds(22, 554, 217, 33);
		f.getContentPane().add(lblNewLabel_3_1_1);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(217, 236, 255));
		panel_5_1.setBounds(632, 594, 102, 184);
		f.getContentPane().add(panel_5_1);
		panel_5_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("검사중");
		lblNewLabel_6.setForeground(new Color(64, 89, 133));
		lblNewLabel_6.setBounds(0, 0, 102, 184);
		lblNewLabel_6.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		panel_5_1.add(lblNewLabel_6);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(217, 236, 255));
		panel_3_1.setBounds(527, 649, 101, 128);
		f.getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("소계");
		lblNewLabel_9.setForeground(new Color(64, 89, 133));
		lblNewLabel_9.setBounds(0, 0, 101, 128);
		lblNewLabel_9.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_9.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1.add(lblNewLabel_9);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(217, 236, 255));
		panel_3_1_1.setBounds(426, 649, 97, 128);
		f.getContentPane().add(panel_3_1_1);
		panel_3_1_1.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("결과음성");
		lblNewLabel_8.setForeground(new Color(64, 89, 133));
		lblNewLabel_8.setBounds(0, 0, 97, 128);
		lblNewLabel_8.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_8.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_1.add(lblNewLabel_8);

		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBackground(new Color(217, 236, 255));
		panel_3_1_2.setBounds(24, 650, 398, 64);
		f.getContentPane().add(panel_3_1_2);
		panel_3_1_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("확진환자수");
		lblNewLabel_7.setForeground(new Color(64, 89, 133));
		lblNewLabel_7.setBounds(0, 0, 398, 64);
		lblNewLabel_7.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		lblNewLabel_7.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2.add(lblNewLabel_7);

		JPanel panel_3_1_2_1 = new JPanel();
		panel_3_1_2_1.setBackground(new Color(217, 236, 255));
		panel_3_1_2_1.setBounds(24, 718, 99, 60);
		f.getContentPane().add(panel_3_1_2_1);
		panel_3_1_2_1.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("격리중");
		lblNewLabel_10.setForeground(new Color(64, 89, 133));
		lblNewLabel_10.setBounds(0, 0, 99, 60);
		lblNewLabel_10.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_10.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1.add(lblNewLabel_10);

		JPanel panel_3_1_2_1_1 = new JPanel();
		panel_3_1_2_1_1.setBackground(new Color(217, 236, 255));
		panel_3_1_2_1_1.setBounds(127, 718, 99, 60);
		f.getContentPane().add(panel_3_1_2_1_1);
		panel_3_1_2_1_1.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("격리해제");
		lblNewLabel_11.setForeground(new Color(64, 89, 133));
		lblNewLabel_11.setBounds(0, 0, 99, 60);
		lblNewLabel_11.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_11.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1.add(lblNewLabel_11);

		JPanel panel_3_1_2_1_1_1 = new JPanel();
		panel_3_1_2_1_1_1.setBackground(new Color(217, 236, 255));
		panel_3_1_2_1_1_1.setBounds(322, 718, 99, 60);
		f.getContentPane().add(panel_3_1_2_1_1_1);
		panel_3_1_2_1_1_1.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("소계");
		lblNewLabel_13.setForeground(new Color(64, 89, 133));
		lblNewLabel_13.setBounds(0, 0, 99, 60);
		lblNewLabel_13.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_13.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1_1.add(lblNewLabel_13);

		JPanel panel_3_1_2_1_1_2 = new JPanel();
		panel_3_1_2_1_1_2.setBounds(230, 718, 89, 60);
		panel_3_1_2_1_1_2.setBackground(new Color(217, 236, 255));
		f.getContentPane().add(panel_3_1_2_1_1_2);
		panel_3_1_2_1_1_2.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("사망");
		lblNewLabel_12.setForeground(new Color(64, 89, 133));
		lblNewLabel_12.setBounds(0, 0, 89, 60);
		lblNewLabel_12.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		lblNewLabel_12.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1_2.add(lblNewLabel_12);

		JPanel panel_3_1_2_1_2 = new JPanel();
		panel_3_1_2_1_2.setBounds(24, 780, 99, 60);
		f.getContentPane().add(panel_3_1_2_1_2);
		panel_3_1_2_1_2.setLayout(null);

		JLabel c1 = new JLabel(m1);
		c1.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c1.setBounds(0, 0, 99, 60);
		c1.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_2.add(c1);

		JPanel panel_3_1_2_1_1_3 = new JPanel();
		panel_3_1_2_1_1_3.setBounds(127, 780, 99, 60);
		f.getContentPane().add(panel_3_1_2_1_1_3);
		panel_3_1_2_1_1_3.setLayout(null);

		JLabel c2 = new JLabel(m2);
		c2.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c2.setBounds(0, 0, 99, 60);
		c2.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1_3.add(c2);

		JPanel panel_3_1_2_1_1_2_1 = new JPanel();
		panel_3_1_2_1_1_2_1.setBounds(230, 780, 89, 60);
		f.getContentPane().add(panel_3_1_2_1_1_2_1);
		panel_3_1_2_1_1_2_1.setLayout(null);

		JLabel c3 = new JLabel(m3);
		c3.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c3.setBounds(0, 0, 89, 60);
		c3.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1_2_1.add(c3);

		JPanel panel_3_1_2_1_1_1_1 = new JPanel();
		panel_3_1_2_1_1_1_1.setBounds(322, 780, 99, 60);
		f.getContentPane().add(panel_3_1_2_1_1_1_1);
		panel_3_1_2_1_1_1_1.setLayout(null);

		JLabel c4 = new JLabel(m4);
		c4.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c4.setBounds(0, 0, 99, 60);
		c4.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_2_1_1_1_1.add(c4);

		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBounds(425, 780, 97, 59);
		f.getContentPane().add(panel_3_1_1_1);
		panel_3_1_1_1.setLayout(null);

		JLabel c5 = new JLabel(m5);
		c5.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c5.setBounds(0, 0, 97, 60);
		c5.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_1_1.add(c5);

		JPanel panel_3_1_3 = new JPanel();
		panel_3_1_3.setBounds(527, 780, 101, 59);
		f.getContentPane().add(panel_3_1_3);
		panel_3_1_3.setLayout(null);

		JLabel c6 = new JLabel(m6);
		c6.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c6.setBounds(0, 0, 101, 60);
		c6.setHorizontalAlignment(JLabel.CENTER);
		panel_3_1_3.add(c6);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBounds(632, 780, 102, 60);
		f.getContentPane().add(panel_5_1_1);
		panel_5_1_1.setLayout(null);

		JLabel c7 = new JLabel(m7);
		c7.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c7.setBounds(0, 0, 102, 60);
		c7.setHorizontalAlignment(JLabel.CENTER);
		panel_5_1_1.add(c7);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBounds(738, 780, 128, 60);
		f.getContentPane().add(panel_5_2);
		panel_5_2.setLayout(null);

		JLabel c8 = new JLabel(m8);
		c8.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		c8.setBounds(0, 0, 128, 60);
		c8.setHorizontalAlignment(JLabel.CENTER);
		panel_5_2.add(c8);

		JLabel lblNewLabel_14 = new JLabel(z1);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_14.setBounds(258, 230, 149, 26);
		f.getContentPane().add(lblNewLabel_14);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(24, 594, 842, 246);
		f.getContentPane().add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(22, 359, 844, 159);
		f.getContentPane().add(panel_7);
		//회원정보 수정
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
				// 회원정보 수정 in 정보찾기
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
				// 회원정보 수정 in 수정확인
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
		//로그아웃 버튼
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
