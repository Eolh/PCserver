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
    JTextField tfTel1, tfTel2, tfTel3; //전화
    JComboBox cbJob; //직업
    JPasswordField tf_pass; //비밀번호   
    JTextField tfYear, tfMonth, tfDate; //생년월일
    JRadioButton rbMan, rbWoman; //남, 여
    JTextArea taIntro;
    JButton btn2, btn3; //가입, 취소 버튼
    GridBagLayout gb;
    GridBagConstraints gbc;
/*	// 클래스 내에서 사용될 멤버변수들을 선언하는 부분입니다..
	Panel p1, p2, p3, p9, p10, pt, tp1, tp2;
	Label la_name, la_id, la_pass, la_addr, la_title;
	TextField tf_name, tf_id, tf_pass;
	Button btn1, btn2, btn3;
	Choice job;
	Checkbox cb1, cb2;
	CheckboxGroup cbg;
	TextArea ta;*/

	// 생성자 정의 부분이 되겠습니다.
	member() {
		
	       super("회원가입");
	        gb = new GridBagLayout();
	        setLayout(gb);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	       
	       
	        //아이디
	        JLabel bId = new JLabel("아이디 : ");
	        tf_id = new JTextField(20);     
	        //그리드백에 붙이기
	        gbAdd(bId, 0, 0, 1, 1);
	        gbAdd(tf_id, 1, 0, 3, 1);
	       
	        //비밀번호
	        JLabel bPwd = new JLabel("비밀번호 : ");
	        tf_pass = new JPasswordField(20);
	        gbAdd(bPwd, 0, 1, 1, 1);
	        gbAdd(tf_pass, 1, 1, 3, 1);
	       
	        //이름
	        JLabel bName = new JLabel("이름 :");
	        tf_name = new JTextField(20);
	        gbAdd(bName,0,2,1,1);
	        gbAdd(tf_name,1,2,3,1);
	       
	        //전화
	        JLabel bTel = new JLabel("전화 :");
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
	       
	        //주소
	        JLabel bAddr = new JLabel("주소: ");
	        tfAddr = new JTextField(20);
	        gbAdd(bAddr, 0,4,1,1);
	        gbAdd(tfAddr, 1, 4, 3,1);
	       
	        //생일
	        JLabel bBirth= new JLabel("생일: ");
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
	        
	        //버튼
	        JPanel pButton = new JPanel();
	        btn2 = new JButton("가입");
	        btn3 = new JButton("취소");     
	        pButton.add(btn2);
	        pButton.add(btn3);    
	        gbAdd(pButton, 0, 10, 4, 1);
	        
	       
/*
		// 화면배치를 시작하게 되는 부분
		// p1~ p3까지 객체생성을 하면서 FlowLayout을 사용해서 화면배치
		p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p3 = new Panel(new FlowLayout(FlowLayout.LEFT));

		// 버튼 패널
		p9 = new Panel();
		p10 = new Panel();

		// 북쪽 패널 회원가입
		pt = new Panel();
		// table 패널
		tp1 = new Panel();
		tp2 = new Panel();

		// label들은 각각의 이름을 가진 Label객체들이 생성
		la_name = new Label("이 름");
		la_id = new Label("I D");
		la_pass = new Label("비밀 번호");
		la_title = new Label("회원 가입");

		// 각각 20이라는 길이를 가진채로 TextField 객체가 생성
		tf_name = new TextField(20);
		tf_id = new TextField(20);
		tf_pass = new TextField(20);
		job = new Choice();
		job.add("직업을선택하세요");
		job.add("프로그래머");
		job.add("강사");
		job.add("회사원");
		job.add("연구원");
		job.add("자영업");

		// 버튼
		btn1 = new Button("아이디중복체크");
		btn2 = new Button();
		btn2.setLabel("등록");
		btn3 = new Button("가입취소");

		// pt부분에 label2를 붙임
		pt.add(la_title);

		// 각 라벨들을 왼쪽 패널에 넣어준다.
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
		// 프레임의 사이즈 setting 부분이 되구요..
		setSize(400, 400);
		// 프레임을 보여줄지 안보이게 숨길지를 setting하는 부분
*/		
	    setSize(350,500);
	    setVisible(false);
		// 프레임창 종료 메소드
		addWindowListener(new WindowHandler());

	}
    //그리드백레이아웃에 붙이는 메소드
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