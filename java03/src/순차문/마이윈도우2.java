package 순차문;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

public class 마이윈도우2 {
	private static JTable table;
	private static JTable table_1;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JButton btnNewButton = new JButton("홈");
		btnNewButton.setForeground(new Color(153, 153, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "나를 눌렀네..");
			}
		});
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
		
		table = new JTable();
		f.getContentPane().add(table);
		
		table_1 = new JTable();
		f.getContentPane().add(table_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f.getContentPane().add(btnNewButton_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		f.getContentPane().add(tglbtnNewToggleButton);
		f.getContentPane().add(btnNewButton);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		f.getContentPane().add(formattedTextField);
		f.setVisible(true);
	}

}
