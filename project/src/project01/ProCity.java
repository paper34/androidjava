package project01;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import DataBase.LoginDAO;
import DataBase.LoginVO;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProCity {
	private static JTextField u3;
	private static JTextField u1;
	private static JTextField u2;
	private static JTextField u4;
	private static JTextField u5;

	public static void main(String[] args) throws IOException {

		Connection con = Jsoup.connect("http://ncov.mohw.go.kr/"); // 코로나 19 사이트

		Document doc = con.get();
		Elements nujuck_list = doc.select("div.rpsa_map span.num"); // 지역별 누적 확진자 크롤링
		Elements yseter_list = doc.select("div.rpsa_map span.before"); // 지역별 전일대비 확진자 크롤링
		Elements date = doc.select("a span.livedate"); // 2020.x.x x시 기준 크롤링
		String date1 = date.get(0).text();

		String[] city = new String[nujuck_list.size()];
		String[] city_day = new String[yseter_list.size()];

		for (int i = 0; i < nujuck_list.size(); i++) {
			String nujuck = nujuck_list.get(i).text();
			// System.out.println(i+"번째 지역"+nujuck);
			city[i] = nujuck;
		}
		// System.out.println(city[0]);

		for (int i = 0; i < yseter_list.size(); i++) {
			String yester = yseter_list.get(i).text();
			// System.out.println(i+"번째 전일대비"+yester);
			city_day[i] = yester;

		}
		// System.out.println(city_day[0]);

		// 프레임
		JFrame f = new JFrame("1차 프로젝트-코로나");
		f.getContentPane().setForeground(new Color(220, 20, 60));
		f.getContentPane().setBackground(new Color(0, 150, 179));
		ImageIcon image = new ImageIcon("src/covid-19.png");

		f.setSize(900, 1000);
		f.getContentPane().setLayout(null);

		// 메뉴 버튼
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
		cityButton.setBounds(454, 128, 217, 75);
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

		JLabel lblNewLabel = new JLabel("시도별 확진자");
		lblNewLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 29));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 207, 591, 40);
		f.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(61, 316, 384, 68);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		// 라벨들
		JLabel lblNewLabel_1 = new JLabel("서울");
		lblNewLabel_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 104, 48);
		panel.add(lblNewLabel_1);

		JLabel nu0 = new JLabel(city[0]);
		nu0.setHorizontalAlignment(SwingConstants.CENTER);
		nu0.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu0.setBounds(128, 10, 135, 48);
		panel.add(nu0);

		JLabel y0 = new JLabel(city_day[0]);
		y0.setForeground(new Color(220, 20, 60));
		y0.setHorizontalAlignment(SwingConstants.CENTER);
		y0.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y0.setBounds(275, 10, 97, 48);
		panel.add(y0);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(61, 385, 384, 68);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("인천");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(12, 10, 104, 48);
		panel_1.add(lblNewLabel_1_1);

		JLabel nu3 = new JLabel(city[3]);
		nu3.setHorizontalAlignment(SwingConstants.CENTER);
		nu3.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu3.setBounds(128, 10, 135, 48);
		panel_1.add(nu3);

		JLabel y3 = new JLabel(city_day[3]);
		y3.setForeground(new Color(220, 20, 60));
		y3.setHorizontalAlignment(SwingConstants.CENTER);
		y3.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y3.setBounds(275, 10, 97, 48);
		panel_1.add(y3);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(61, 454, 384, 68);
		f.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("대구");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(12, 10, 104, 48);
		panel_1_1.add(lblNewLabel_1_2);

		JLabel nu2 = new JLabel(city[2]);
		nu2.setHorizontalAlignment(SwingConstants.CENTER);
		nu2.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu2.setBounds(128, 10, 135, 48);
		panel_1_1.add(nu2);

		JLabel y2 = new JLabel(city_day[2]);
		y2.setForeground(new Color(220, 20, 60));
		y2.setHorizontalAlignment(SwingConstants.CENTER);
		y2.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y2.setBounds(275, 10, 97, 48);
		panel_1_1.add(y2);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(61, 523, 384, 68);
		f.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("대전");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(12, 10, 104, 48);
		panel_1_1_1.add(lblNewLabel_1_3);

		JLabel nu5 = new JLabel(city[5]);
		nu5.setHorizontalAlignment(SwingConstants.CENTER);
		nu5.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu5.setBounds(128, 10, 135, 48);
		panel_1_1_1.add(nu5);

		JLabel y5 = new JLabel(city_day[5]);
		y5.setForeground(new Color(220, 20, 60));
		y5.setHorizontalAlignment(SwingConstants.CENTER);
		y5.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y5.setBounds(275, 10, 97, 48);
		panel_1_1_1.add(y5);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(61, 592, 384, 68);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_4 = new JLabel("세종");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(12, 10, 104, 48);
		panel_2.add(lblNewLabel_1_4);

		JLabel nu7 = new JLabel(city[7]);
		nu7.setHorizontalAlignment(SwingConstants.CENTER);
		nu7.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu7.setBounds(128, 10, 135, 48);
		panel_2.add(nu7);

		JLabel y7 = new JLabel(city_day[7]);
		y7.setForeground(new Color(220, 20, 60));
		y7.setHorizontalAlignment(SwingConstants.CENTER);
		y7.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y7.setBounds(275, 10, 97, 48);
		panel_2.add(y7);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(61, 661, 384, 68);
		f.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("충북");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_5.setBounds(12, 10, 104, 48);
		panel_1_2.add(lblNewLabel_1_5);

		JLabel nu10 = new JLabel(city[10]);
		nu10.setHorizontalAlignment(SwingConstants.CENTER);
		nu10.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu10.setBounds(128, 10, 135, 48);
		panel_1_2.add(nu10);

		JLabel y10 = new JLabel(city_day[10]);
		y10.setForeground(new Color(220, 20, 60));
		y10.setHorizontalAlignment(SwingConstants.CENTER);
		y10.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y10.setBounds(275, 10, 97, 48);
		panel_1_2.add(y10);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(Color.WHITE);
		panel_1_1_2.setBounds(61, 730, 384, 68);
		f.getContentPane().add(panel_1_1_2);
		panel_1_1_2.setLayout(null);

		JLabel lblNewLabel_1_6 = new JLabel("전북");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_6.setBounds(12, 10, 104, 48);
		panel_1_1_2.add(lblNewLabel_1_6);

		JLabel nu12 = new JLabel(city[12]);
		nu12.setHorizontalAlignment(SwingConstants.CENTER);
		nu12.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu12.setBounds(128, 10, 135, 48);
		panel_1_1_2.add(nu12);

		JLabel y12 = new JLabel(city_day[12]);
		y12.setForeground(new Color(220, 20, 60));
		y12.setHorizontalAlignment(SwingConstants.CENTER);
		y12.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y12.setBounds(275, 10, 97, 48);
		panel_1_1_2.add(y12);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1.setBounds(61, 799, 384, 68);
		f.getContentPane().add(panel_1_1_1_1);
		panel_1_1_1_1.setLayout(null);

		JLabel lblNewLabel_1_7 = new JLabel("경북");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_7.setBounds(12, 10, 104, 48);
		panel_1_1_1_1.add(lblNewLabel_1_7);

		JLabel nu14 = new JLabel(city[14]);
		nu14.setHorizontalAlignment(SwingConstants.CENTER);
		nu14.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu14.setBounds(128, 10, 135, 48);
		panel_1_1_1_1.add(nu14);

		JLabel y14 = new JLabel(city_day[14]);
		y14.setForeground(new Color(220, 20, 60));
		y14.setHorizontalAlignment(SwingConstants.CENTER);
		y14.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y14.setBounds(275, 10, 97, 48);
		panel_1_1_1_1.add(y14);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1.setBounds(61, 868, 384, 68);
		f.getContentPane().add(panel_1_1_1_1_1);
		panel_1_1_1_1_1.setLayout(null);

		JLabel lblNewLabel_1_8 = new JLabel("제주");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_8.setBounds(12, 10, 104, 48);
		panel_1_1_1_1_1.add(lblNewLabel_1_8);

		JLabel nu16 = new JLabel(city[16]);
		nu16.setHorizontalAlignment(SwingConstants.CENTER);
		nu16.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu16.setBounds(128, 10, 135, 48);
		panel_1_1_1_1_1.add(nu16);

		JLabel y16 = new JLabel(city_day[16]);
		y16.setForeground(new Color(220, 20, 60));
		y16.setHorizontalAlignment(SwingConstants.CENTER);
		y16.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y16.setBounds(275, 10, 97, 48);
		panel_1_1_1_1_1.add(y16);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBounds(447, 316, 384, 68);
		f.getContentPane().add(panel_3);

		JLabel lblNewLabel_1_10 = new JLabel("경기");
		lblNewLabel_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_10.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_10.setBounds(12, 10, 104, 48);
		panel_3.add(lblNewLabel_1_10);

		JLabel nu8 = new JLabel(city[8]);
		nu8.setHorizontalAlignment(SwingConstants.CENTER);
		nu8.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu8.setBounds(128, 10, 135, 48);
		panel_3.add(nu8);

		JLabel y8 = new JLabel(city_day[8]);
		y8.setForeground(new Color(220, 20, 60));
		y8.setHorizontalAlignment(SwingConstants.CENTER);
		y8.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y8.setBounds(275, 10, 97, 48);
		panel_3.add(y8);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(447, 385, 384, 68);
		f.getContentPane().add(panel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("부산");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_1_1.setBounds(12, 10, 104, 48);
		panel_1_3.add(lblNewLabel_1_1_1);

		JLabel nu1 = new JLabel(city[1]);
		nu1.setHorizontalAlignment(SwingConstants.CENTER);
		nu1.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu1.setBounds(128, 10, 135, 48);
		panel_1_3.add(nu1);

		JLabel y1 = new JLabel(city_day[1]);
		y1.setForeground(new Color(220, 20, 60));
		y1.setHorizontalAlignment(SwingConstants.CENTER);
		y1.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y1.setBounds(275, 10, 97, 48);
		panel_1_3.add(y1);

		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setBackground(Color.WHITE);
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(447, 454, 384, 68);
		f.getContentPane().add(panel_1_1_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("광주");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_2_1.setBounds(12, 10, 104, 48);
		panel_1_1_3.add(lblNewLabel_1_2_1);

		JLabel nu4 = new JLabel(city[4]);
		nu4.setHorizontalAlignment(SwingConstants.CENTER);
		nu4.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu4.setBounds(128, 10, 135, 48);
		panel_1_1_3.add(nu4);

		JLabel y4 = new JLabel(city_day[4]);
		y4.setForeground(new Color(220, 20, 60));
		y4.setHorizontalAlignment(SwingConstants.CENTER);
		y4.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y4.setBounds(275, 10, 97, 48);
		panel_1_1_3.add(y4);

		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setBackground(Color.WHITE);
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBounds(447, 523, 384, 68);
		f.getContentPane().add(panel_1_1_1_2);

		JLabel lblNewLabel_1_3_1 = new JLabel("울산");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_3_1.setBounds(12, 10, 104, 48);
		panel_1_1_1_2.add(lblNewLabel_1_3_1);

		JLabel nu6 = new JLabel(city[6]);
		nu6.setHorizontalAlignment(SwingConstants.CENTER);
		nu6.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu6.setBounds(128, 10, 135, 48);
		panel_1_1_1_2.add(nu6);

		JLabel y6 = new JLabel(city_day[6]);
		y6.setForeground(new Color(220, 20, 60));
		y6.setHorizontalAlignment(SwingConstants.CENTER);
		y6.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y6.setBounds(275, 10, 97, 48);
		panel_1_1_1_2.add(y6);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(447, 592, 384, 68);
		f.getContentPane().add(panel_2_1);

		JLabel lblNewLabel_1_4_1 = new JLabel("강원");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_4_1.setBounds(12, 10, 104, 48);
		panel_2_1.add(lblNewLabel_1_4_1);

		JLabel nu9 = new JLabel(city[9]);
		nu9.setHorizontalAlignment(SwingConstants.CENTER);
		nu9.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu9.setBounds(128, 10, 135, 48);
		panel_2_1.add(nu9);

		JLabel y9 = new JLabel(city_day[9]);
		y9.setForeground(new Color(220, 20, 60));
		y9.setHorizontalAlignment(SwingConstants.CENTER);
		y9.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y9.setBounds(275, 10, 97, 48);
		panel_2_1.add(y9);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(Color.WHITE);
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(447, 661, 384, 68);
		f.getContentPane().add(panel_1_2_1);

		JLabel lblNewLabel_1_5_1 = new JLabel("충남");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_5_1.setBounds(12, 10, 104, 48);
		panel_1_2_1.add(lblNewLabel_1_5_1);

		JLabel nu11 = new JLabel(city[11]);
		nu11.setHorizontalAlignment(SwingConstants.CENTER);
		nu11.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu11.setBounds(128, 10, 135, 48);
		panel_1_2_1.add(nu11);

		JLabel y11 = new JLabel(city_day[11]);
		y11.setForeground(new Color(220, 20, 60));
		y11.setHorizontalAlignment(SwingConstants.CENTER);
		y11.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y11.setBounds(275, 10, 97, 48);
		panel_1_2_1.add(y11);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setBackground(Color.WHITE);
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBounds(447, 730, 384, 68);
		f.getContentPane().add(panel_1_1_2_1);

		JLabel lblNewLabel_1_6_1 = new JLabel("전남");
		lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_6_1.setBounds(12, 10, 104, 48);
		panel_1_1_2_1.add(lblNewLabel_1_6_1);

		JLabel nu13 = new JLabel(city[13]);
		nu13.setHorizontalAlignment(SwingConstants.CENTER);
		nu13.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu13.setBounds(128, 10, 135, 48);
		panel_1_1_2_1.add(nu13);

		JLabel y13 = new JLabel(city_day[13]);
		y13.setForeground(new Color(220, 20, 60));
		y13.setHorizontalAlignment(SwingConstants.CENTER);
		y13.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y13.setBounds(275, 10, 97, 48);
		panel_1_1_2_1.add(y13);

		JPanel panel_1_1_1_1_2 = new JPanel();
		panel_1_1_1_1_2.setBackground(Color.WHITE);
		panel_1_1_1_1_2.setLayout(null);
		panel_1_1_1_1_2.setBounds(447, 799, 384, 68);
		f.getContentPane().add(panel_1_1_1_1_2);

		JLabel lblNewLabel_1_7_1 = new JLabel("경남");
		lblNewLabel_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_7_1.setBounds(12, 10, 104, 48);
		panel_1_1_1_1_2.add(lblNewLabel_1_7_1);

		JLabel nu15 = new JLabel(city[15]);
		nu15.setHorizontalAlignment(SwingConstants.CENTER);
		nu15.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu15.setBounds(128, 10, 135, 48);
		panel_1_1_1_1_2.add(nu15);

		JLabel y15 = new JLabel(city_day[15]);
		y15.setForeground(new Color(220, 20, 60));
		y15.setHorizontalAlignment(SwingConstants.CENTER);
		y15.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y15.setBounds(275, 10, 97, 48);
		panel_1_1_1_1_2.add(y15);

		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1_1.setBounds(447, 868, 384, 68);
		f.getContentPane().add(panel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_8_1 = new JLabel("검역");
		lblNewLabel_1_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8_1.setFont(new Font("휴먼모음T", Font.PLAIN, 23));
		lblNewLabel_1_8_1.setBounds(12, 10, 104, 48);
		panel_1_1_1_1_1_1.add(lblNewLabel_1_8_1);

		JLabel nu17 = new JLabel(city[17]);
		nu17.setHorizontalAlignment(SwingConstants.CENTER);
		nu17.setFont(new Font("휴먼모음T", Font.PLAIN, 21));
		nu17.setBounds(128, 10, 135, 48);
		panel_1_1_1_1_1_1.add(nu17);

		JLabel y17 = new JLabel(city_day[17]);
		y17.setForeground(new Color(220, 20, 60));
		y17.setHorizontalAlignment(SwingConstants.CENTER);
		y17.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		y17.setBounds(275, 10, 97, 48);
		panel_1_1_1_1_1_1.add(y17);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(61, 283, 384, 32);
		f.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("지역");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(36, 0, 57, 32);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("누적 확진환자");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(125, 0, 135, 32);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("전일 대비");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(272, 0, 100, 32);
		panel_4.add(lblNewLabel_2_2);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(447, 283, 384, 32);
		f.getContentPane().add(panel_4_1);

		JLabel lblNewLabel_2_3 = new JLabel("지역");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(36, 0, 57, 32);
		panel_4_1.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("누적 확진환자");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(125, 0, 135, 32);
		panel_4_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2_1 = new JLabel("전일 대비");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(272, 0, 100, 32);
		panel_4_1.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_3 = new JLabel(date1);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("휴먼모음T", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(311, 248, 266, 25);
		f.getContentPane().add(lblNewLabel_3);

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
