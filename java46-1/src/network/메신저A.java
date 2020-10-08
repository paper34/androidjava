package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class 메신저A extends JFrame {
	private JTextField input;
	private JTextArea list;
	DatagramSocket socket;
	
	public 메신저A() {
		setTitle("메신저 A");
		setSize(300, 500);

		list = new JTextArea();
		list.setFont(new Font("궁서", Font.PLAIN, 30));
		list.setBackground(Color.YELLOW);
		getContentPane().add(list, BorderLayout.CENTER);

		input = new JTextField();
		input.setFont(new Font("궁서", Font.BOLD, 30));
		input.setBackground(Color.GREEN);
		getContentPane().add(input, BorderLayout.SOUTH);
		input.setColumns(10);
		list.setEditable(false);
		
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = input.getText();
				// 입력한 값 가지고 와서, list up!
				list.append("나>>" + data + "\n");
				input.setText("");
				try {
					DatagramSocket socket = new DatagramSocket();
					// 상대방에게 네트워크 전송!
					byte[] data2 = data.getBytes();
					InetAddress ip = InetAddress.getByName("127.0.0.1");
					DatagramPacket packet = new DatagramPacket(data2, data2.length, ip, 6000);
					socket.send(packet);
					socket.close();
				} catch (Exception e2) {
					 e2.printStackTrace();
					System.out.println("데이터 받는 중 에러발생1!");
				}

			}
		});

		setVisible(true);
	}

	public void process() throws Exception{
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket(5000);
				// 빈 패킷 필요
				byte[] data = new byte[256];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				list.append("너>>" + data + "\n");
			} catch (Exception e1) {
				 e1.printStackTrace();
				System.out.println("데이터 받는 도중 에러발생2!!");
			}
		}
	}

	public static void main(String[] args) throws Exception{
		메신저A m = new 메신저A();
		m.process();
	}

}