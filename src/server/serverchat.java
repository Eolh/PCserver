package server;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

class serverchat extends JPanel implements ActionListener {
	JButton button, but_input;
	JLabel sub;
	JTextArea ta;
	JTextField tf;
	JScrollPane scroll;

	static ServerSocket serverSocket = null;
	static Socket clientSocket = null;
	static PrintWriter out;
	static BufferedReader in;
	static String inputLine, outputLine;

	public serverchat() {
		Font fnt = new Font("굴림", Font.BOLD, 15);
		setLayout(null);
		setSize(250, 550);

		sub = new JLabel("대화창");
		sub.setHorizontalAlignment(JLabel.CENTER);
		sub.setFont(fnt);
		sub.setBounds(0, 0, 250, 30);

		ta = new JTextArea(20, 20);
		ta.setEnabled(false);
		ta.setCaretPosition(ta.getDocument().getLength());

		scroll = new JScrollPane(ta);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0, 30, 250, 450);

		tf = new JTextField(20);
		tf.setBounds(0, 480, 250, 30);

		but_input = new JButton("입력");
		but_input.setBounds(0, 510, 250, 30);
		but_input.addActionListener(this);

		add(sub);

		add(scroll);

		add(tf);
		add(but_input);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s;
		s = "서버 : " + tf.getText();
		if (arg0.getSource() == but_input) {
			ta.append(s + "\n");
			tf.setText("");
		}

	}

	public void serverStart() throws IOException {
		System.out.println("서버 시작!haha");

		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.out.println("다음의 포트 번호에 연결할 수 없습니다 : 5555");
			System.exit(1);
		}

		clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("accept() 실패 ");
			System.exit(1);
		}

		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		outputLine = "서버 : 접속 환영합니다";
		out.println(outputLine);
		ta.append("서버 메시지 : 클라이언트가 접속되었습니다.\n");

		while ((inputLine = in.readLine()) != null) {
			String s = inputLine + "\n";
			System.out.println(s);
			ta.append(s);
			// outputLine = inputLine;
			// out.println(outputLine);
			if (outputLine.equals("quit"))
				break;
		}
	}
}
