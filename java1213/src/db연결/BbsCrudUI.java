package db연결;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BbsCrudUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JButton read;
	private static JButton update;
	private static JButton delete;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setSize(1000, 800);
		f.getContentPane().setLayout(null);

		t1 = new JTextField();
		t1.setFont(new Font("굴림", Font.PLAIN, 18));
		t1.setBounds(193, 94, 182, 59);
		f.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("굴림", Font.PLAIN, 18));
		t2.setBounds(193, 175, 182, 55);
		f.getContentPane().add(t2);
		t2.setColumns(10);

		t3 = new JTextField();
		t3.setFont(new Font("굴림", Font.PLAIN, 18));
		t3.setBounds(193, 261, 182, 63);
		f.getContentPane().add(t3);
		t3.setColumns(10);

		t4 = new JTextField();
		t4.setFont(new Font("굴림", Font.PLAIN, 18));
		t4.setColumns(10);
		t4.setBounds(193, 354, 182, 70);
		f.getContentPane().add(t4);

		
		
		
		JTextArea all = new JTextArea();
		all.setFont(new Font("Monospaced", Font.PLAIN, 18));
		all.setBounds(463, 129, 210, 466);
		f.getContentPane().add(all);
		f.setVisible(true);

		JButton create = new JButton("발행");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String no = t1.getText();
				String writer = t2.getText();
				String title = t3.getText();
				String content = t4.getText();

				BbsDAO dao = new BbsDAO();
				BbsVO vo = new BbsVO();
				vo.setNo(Integer.parseInt(no));
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);

				try {
					dao.create(vo);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		create.setBackground(Color.LIGHT_GRAY);
		create.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		create.setBounds(100, 474, 138, 46);
		f.getContentPane().add(create);

		JLabel lblNewLabel = new JLabel("작성자");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel.setBounds(100, 177, 86, 46);
		f.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(110, 282, 76, 46);
		f.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("내용");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(110, 363, 76, 46);
		f.getContentPane().add(lblNewLabel_2);

		read = new JButton("검색");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = t1.getText();
				BbsDAO dao = new BbsDAO();

				try {
					BbsVO bag = dao.one(Integer.parseInt(no));
					t1.setText(String.valueOf(bag.getNo()));
					t2.setText(bag.getTitle());
					t3.setText(bag.getContent());
					t4.setText(bag.getWriter());
				} catch (Exception e1) {
				}

			}
		});
		read.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		read.setBackground(Color.LIGHT_GRAY);
		read.setBounds(267, 474, 138, 46);
		f.getContentPane().add(read);

		update = new JButton("수정");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int no = Integer.parseInt(t1.getText());
				String writer = t2.getText();
				String title = t3.getText();
				String content = t4.getText();
				
				BbsDAO dao = new BbsDAO();
				BbsVO bag = new BbsVO();
				bag.setNo(no);
				bag.setWriter(writer);
				bag.setTitle(title);
				bag.setContent(content);
				
				try {
					dao.update(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		update.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		update.setBackground(Color.LIGHT_GRAY);
		update.setBounds(100, 549, 138, 46);
		f.getContentPane().add(update);

		delete = new JButton("삭제");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(t1.getText());
				BbsDAO dao = new BbsDAO();
				BbsVO bag = new BbsVO();
				bag.setNo(no);
				
				try {
					dao.delete(bag);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		delete.setBackground(Color.LIGHT_GRAY);
		delete.setBounds(267, 549, 138, 46);
		f.getContentPane().add(delete);

		lblNewLabel_3 = new JLabel("번호");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(100, 98, 86, 46);
		f.getContentPane().add(lblNewLabel_3);

		// 글 전체 목록
		JButton list = new JButton("목록");
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BbsDAO dao = new BbsDAO();
					ArrayList<BbsVO> list = dao.all();

					for (int i = 0; i < list.size(); i++) {// 5
						BbsVO bag = list.get(i);
						all.append(bag.getNo() + " " + bag.getTitle() + " " + bag.getWriter() + " " + bag.getContent()
								+ "\n");

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		list.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(182, 623, 138, 46);
		f.getContentPane().add(list);

	}
}
