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

		// �г� �ϳ��� ����� .ȯ���Ѵٴ� �ؽ�Ʈ�� �� ���̿��̴�. �������� flowlayout�� ����.
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		// �г� �ϳ��� �����. ���̾ƿ��� �׸��� ���̾ƿ������ش�. ��ư���� �� ���̾ƿ���
		p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 3, 1, 1));

		p3 = new JPanel();
		p3.setLayout(new BorderLayout());

		// �� p1�гο� �ְ�
		label1 = new Label();
		label1.setText("aa");
		p1.add(label1);
		// ��ư
		button1 = new JButton("����");
		button2 = new JButton("Ż��");
		button3 = new JButton("�α׾ƿ�");
		// ��ư�� p2�� �ִ´�.
		p2.add(button1);
		p2.add(button2);
		p2.add(button3);
		// Ÿ��Ʋ
		tex1 = new JTextField();
		tex1.setText("");
		p3.add(tex1);

		setTitle("ȯ���մϴ�. ");
		setSize(250, 250);
		setVisible(false);
		setLayout(new BorderLayout());
		// p1,p2�� ���� �߰��� �Ʒ��ʿ� �д�.
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