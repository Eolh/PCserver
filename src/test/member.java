package test;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class member extends JFrame  {
    JPanel p;
    JTextField tf_id, tf_name, tfAddr, tfEmail;
    JTextField tfTel1, tfTel2, tfTel3; //��ȭ
    JComboBox cbJob; //����
    JPasswordField tf_pass; //��й�ȣ   
    JTextField tfYear, tfMonth, tfDate; //�������
    JRadioButton rbMan, rbWoman; //��, ��
    JTextArea taIntro;
    JButton btn2, btn3; //����, ��� ��ư
    GridBagLayout gb;
    GridBagConstraints gbc;
/*	// Ŭ���� ������ ���� ����������� �����ϴ� �κ��Դϴ�..
	Panel p1, p2, p3, p9, p10, pt, tp1, tp2;
	Label la_name, la_id, la_pass, la_addr, la_title;
	TextField tf_name, tf_id, tf_pass;
	Button btn1, btn2, btn3;
	Choice job;
	Checkbox cb1, cb2;
	CheckboxGroup cbg;
	TextArea ta;*/

	// ������ ���� �κ��� �ǰڽ��ϴ�.
	member() {
		
	       super("ȸ������");
	        gb = new GridBagLayout();
	        setLayout(gb);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	       
	       
	        //���̵�
	        JLabel bId = new JLabel("���̵� : ");
	        tf_id = new JTextField(20);     
	        //�׸���鿡 ���̱�
	        gbAdd(bId, 0, 0, 1, 1);
	        gbAdd(tf_id, 1, 0, 3, 1);
	       
	        //��й�ȣ
	        JLabel bPwd = new JLabel("��й�ȣ : ");
	        tf_pass = new JPasswordField(20);
	        gbAdd(bPwd, 0, 1, 1, 1);
	        gbAdd(tf_pass, 1, 1, 3, 1);
	       
	        //�̸�
	        JLabel bName = new JLabel("�̸� :");
	        tf_name = new JTextField(20);
	        gbAdd(bName,0,2,1,1);
	        gbAdd(tf_name,1,2,3,1);
	       
	        //��ȭ
	        JLabel bTel = new JLabel("��ȭ :");
	        JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        tfTel1 = new JTextField(6);    
	        tfTel2 = new JTextField(6);    
	        tfTel3 = new JTextField(6);
	        pTel.add(tfTel1);
	        pTel.add(new JLabel(" - "));
	        pTel.add(tfTel2);
	        pTel.add(new JLabel(" - "));
	        pTel.add(tfTel3);
	        gbAdd(bTel, 0, 3, 1,1);
	        gbAdd(pTel, 1, 3, 3,1);
	       
	        //�ּ�
	        JLabel bAddr = new JLabel("�ּ�: ");
	        tfAddr = new JTextField(20);
	        gbAdd(bAddr, 0,4,1,1);
	        gbAdd(tfAddr, 1, 4, 3,1);
	       
	        //����
	        JLabel bBirth= new JLabel("����: ");
	        tfYear = new JTextField(6);
	        tfMonth = new JTextField(6);
	        tfDate = new JTextField(6);
	        JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        pBirth.add(tfYear);
	        pBirth.add(new JLabel("/"));
	        pBirth.add(tfMonth);
	        pBirth.add(new JLabel("/"));
	        pBirth.add(tfDate);
	        gbAdd(bBirth, 0,5,1,1);
	        gbAdd(pBirth, 1, 5, 3,1);
	        
	        //��ư
	        JPanel pButton = new JPanel();
	        btn2 = new JButton("����");
	        btn3 = new JButton("���");     
	        pButton.add(btn2);
	        pButton.add(btn3);    
	        gbAdd(pButton, 0, 10, 4, 1);
	        
	       
/*
		// ȭ���ġ�� �����ϰ� �Ǵ� �κ�
		// p1~ p3���� ��ü������ �ϸ鼭 FlowLayout�� ����ؼ� ȭ���ġ
		p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p3 = new Panel(new FlowLayout(FlowLayout.LEFT));

		// ��ư �г�
		p9 = new Panel();
		p10 = new Panel();

		// ���� �г� ȸ������
		pt = new Panel();
		// table �г�
		tp1 = new Panel();
		tp2 = new Panel();

		// label���� ������ �̸��� ���� Label��ü���� ����
		la_name = new Label("�� ��");
		la_id = new Label("I D");
		la_pass = new Label("��� ��ȣ");
		la_title = new Label("ȸ�� ����");

		// ���� 20�̶�� ���̸� ����ä�� TextField ��ü�� ����
		tf_name = new TextField(20);
		tf_id = new TextField(20);
		tf_pass = new TextField(20);
		job = new Choice();
		job.add("�����������ϼ���");
		job.add("���α׷���");
		job.add("����");
		job.add("ȸ���");
		job.add("������");
		job.add("�ڿ���");

		// ��ư
		btn1 = new Button("���̵��ߺ�üũ");
		btn2 = new Button();
		btn2.setLabel("���");
		btn3 = new Button("�������");

		// pt�κп� label2�� ����
		pt.add(la_title);

		// �� �󺧵��� ���� �гο� �־��ش�.
		// p1.add(la_name);
		p1.add(tf_name);
		// p2.add(la_id);
		p2.add(tf_id);
		// p3.add(la_pass);
		p3.add(tf_pass);
		// p4.add(la_pass2);

		tp1.setLayout(new GridLayout(8, 1));
		tp1.add(la_name);
		tp1.add(la_id);
		tp1.add(la_pass);

		tp2.setLayout(new GridLayout(8, 1));
		tp2.add(p1);
		tp2.add(p2);
		tp2.add(p3);

		p9.add(btn2);
		p9.add(btn3);

		add("North", pt);
		add("West", tp1);
		add("Center", tp2);
		add("South", p9);
		// �������� ������ setting �κ��� �Ǳ���..
		setSize(400, 400);
		// �������� �������� �Ⱥ��̰� �������� setting�ϴ� �κ�
*/		
	    setSize(350,500);
	    setVisible(false);
		// ������â ���� �޼ҵ�
		addWindowListener(new WindowHandler());

	}
    //�׸���鷹�̾ƿ��� ���̴� �޼ҵ�
    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        //gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }//gbAdd

	class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}