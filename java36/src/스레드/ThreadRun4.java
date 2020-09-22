package 스레드;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadRun4 extends JFrame {
	JLabel top = new JLabel(); // 전역변수, 글로벌변수
	JLabel center = new JLabel();
	JLabel sub = new JLabel();

	public ThreadRun4() {
		getContentPane().setBackground(Color.GREEN);
		setTitle("나의 멀티스레드");
		setSize(863, 332);
		getContentPane().setLayout(null);

		top.setBounds(0, 0, 845, 35);
		top.setFont(new Font("굴림", Font.BOLD, 35));
		getContentPane().add(top);

		center.setFont(new Font("굴림", Font.BOLD, 50));
		center.setBounds(161, 35, 513, 215);
		getContentPane().add(center);

		sub.setBounds(0, 250, 845, 35);
		sub.setFont(new Font("굴림", Font.BOLD, 30));
		getContentPane().add(sub);

		CounterThread2 counter = new CounterThread2();
		counter.start();

		imgThread2 img = new imgThread2();
		img.start();

		TimerThread2 timer = new TimerThread2();
		timer.start();

		setVisible(true);
	}

	// 카운터-top
	public class CounterThread2 extends Thread {
		@Override
		public void run() {
			for (int i = 500; i > 0; i--) {
				top.setText("카운터: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 이미지-center
	public class imgThread2 extends Thread {
		@Override
		public void run() {
			String[] img = { "1.png", "2.png", "3.png", "4.png", "5.png" };
			for (int i = 0; i < img.length; i++) {
				ImageIcon img2 = new ImageIcon(img[i]);
				center.setIcon(img2);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {	
					e.printStackTrace();
				}
			}
		}
	}

	// 시간-sub
	public class TimerThread2 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 300; i++) {
				Date date = new Date();
				sub.setText(date + "");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreadRun4 t = new ThreadRun4();
	}

}
