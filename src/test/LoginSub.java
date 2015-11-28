package test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginSub extends JFrame {
    JPanel p1, p2, p3;
    JTextField tex1;
    JButton button1, button2, button3;
    
	Label label1;
	public String id1, pw1;

	LoginSub() {

		// 패널 하나를 만든다 .환영한다는 텍스트가 들어갈 라이웃이다. 순차적인 flowlayout을 쓴다.
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		// 패널 하나를 만든다. 레이아웃은 그리드 레이아웃으로준다. 버튼들이 들어갈 레이아웃임
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 3, 1, 1));

		p3 = new JPanel();
		p3.setLayout(new BorderLayout());

		// 라벨 p1패널에 넣고
		label1 = new Label();
		label1.setText("aa");
		p1.add(label1);
		// 버튼
		button1 = new JButton("수정");
		button2 = new JButton("탈퇴");
		button3 = new JButton("로그아웃");
		// 버튼을 p2에 넣는다.
		p2.add(button1);
		p2.add(button2);
		p2.add(button3);
		// 타이틀
		tex1 = new JTextField();
		tex1.setText("");
		p3.add(tex1);

		setTitle("환영합니다. ");
		setSize(250, 250);
		setVisible(false);
		setLayout(new BorderLayout());
		// p1,p2를 각각 중간과 아래쪽에 둔다.
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.NORTH);
		addWindowListener(new WindowHandler());
	}

	class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}