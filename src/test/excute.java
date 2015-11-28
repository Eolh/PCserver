package test;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;

public class excute extends JFrame implements ActionListener {
	// jdbc ����
	private String url = "jdbc:mysql://localhost:3306/java";// user���̺��� �����ϸ�
	private String strUser = "root"; // ���� id
	private String strPassword = "1234"; // ���� �н�����
	private String strMySQLDriver = "com.mysql.jdbc.Driver"; // ����̹� �̸� ���� �������
	Connection con;

	Statement stmt;
	ResultSet rs;
	String sql;

	//
	String id;
	String password;
	String name;

	// �α��ΰ� �ɹ� Ŭ������ �����´�.
	member sumit = new member(); // false
	Login log = new Login(); // true
	LoginSub logSub = new LoginSub(); // false
	Data d = new Data();

	// ���̾�α� , ��ư, ��,
	Button ok;
	Label msg;
	Dialog info;

	excute() {

		try {
			// �α��� ��ư�� Ŭ�� �Ǿ����ÿ� jdbc����̹��� ����Ѵ�.
			Class.forName(strMySQLDriver);
			// DriverManager�κ��� Ŀ�ؼ��� �����µ� mysql���� . id, password ���� ���´�.
			con = (Connection) DriverManager.getConnection(url, strUser,
					strPassword);
			// Ŀ�ؼ����κ��� ������ sql���� �����Ű�� ���� statement ��ü�� ���´�.
			stmt = (Statement) con.createStatement();

		} catch (Exception b) {
			System.out.println("db�������");
		}

		// ȸ������ ��Ϲ�ư ������
		sumit.btn2.addActionListener(this);// ��ư�� �����ʸ� �ܴ�.
		// ȸ������ ��� ��ư
		sumit.btn3.addActionListener(this);
		// ȸ������ ��ư
		log.button3.addActionListener(this);
		// �α��� ��ư
		log.button1.addActionListener(this);
		// LoginSub�� ������ư
		logSub.button1.addActionListener(this);
		// LoginSub�� Ż���ư
		logSub.button2.addActionListener(this);
		// LoginSub�� �α׾ƿ���ư
		logSub.button3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// �ش��ϴ� ��ư�� ��������
		Object obj = e.getSource();
		if (obj.equals(log.button3)) {
			// �α���â�� ȸ������ ��ư
			// memberŬ������ ����.
			log.setVisible(false);
			sumit.setVisible(true);
		} else if (obj.equals(log.button1)) {
			// �α���â�� �α��� ��ư
			loginCheck();
			// �ش� ������ ȯ�� �޽���
			logSub.label1.setText(name + "�� �α��� �Ͽ����ϴ�.");
			// title ����
			logSub.setTitle(name + "�� ����â");
			// �α���â�� ��� �Ⱥ��̵��� �Ѵ�.
			log.setVisible(false);
		} else if (obj.equals(logSub.button1)) {
			// �˻�
			showUpdate();
		} else if (obj.equals(logSub.button2)) {
			// Ż��(����)
			selectDelete();
		} else if (obj.equals(logSub.button3)) {
			// logSub ȭ���� �����.
			logSub.setVisible(false);
			// �α���â�� ����.
			log.setVisible(true);

			// Ŭ����
			clearText();
			// �α���â�� �ؽ�Ʈ�� �ʱ�ȭ

		} else if (obj.equals(sumit.btn2)) {
			// ȸ������ â�� ��ư ���� ��� �ϰ�� , ������ ��� �� �ش��ϴ� �޼ҵ带 ���� ���ش�.
			selectInsert();
			sumit.setVisible(false);

			log.setVisible(true);
			if (sumit.btn2.equals("����")) {
				// ����
				selectUpdate();
			}
		} else if (obj.equals(sumit.btn3)) {
			sumit.setVisible(false);
		}
	}

	private void clearText() {
		// TODO Auto-generated method stub
		log.tex1.setText("");
		log.tex2.setText("");
		sumit.tf_id.setText("");
		sumit.tf_pass.setText("");
		sumit.tf_name.setText("");
		logSub.tex1.setText("");
	}

	// ����
	private void selectUpdate() {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.password = sumit.tf_pass.getText().trim();
		d.name = sumit.tf_name.getText().trim();

		String sql = "update member set id='" + d.id + "',password='"
				+ d.password + "' where name='" + d.name + "'";
		try {
			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "������Ʈ");

			logSub.tex1.setText("������Ʈ �Ϸ� ^^");

			sumit.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	// ����
	private void selectInsert() {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.password = sumit.tf_pass.getText().trim();
		d.name = sumit.tf_name.getText().trim();
		String sql = "insert into member(id,password,name) values('" + d.id
				+ "','" + d.password + "','" + d.name + "')";

		System.out.println(sql);
		try {

			int rss = stmt.executeUpdate(sql);

			System.out.println(rss + "����");
			logSub.tex1.setText("���� �Ϸ� ^^");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	// �˻�
	void showUpdate() {
		// TODO Auto-generated method stub
		// String sql = "select * from users where name='"+name+"'";
		sumit.btn3.setLabel("�������");
		sumit.btn2.setLabel("����");
		// ������ �̸��� ������ �´�.
		String name = logSub.tex1.getText();
		String id = sumit.tf_id.getText();
		String password = sumit.tf_pass.getText();
		String sql = "select * from member where name='" + name + "'";
		System.out.println(sql);
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				sumit.tf_id.setText(rs.getString("id"));
				sumit.tf_pass.setText(rs.getString("password"));
				sumit.tf_name.setText(rs.getString("name"));
				System.out.println(rs + "����");

				logSub.tex1.setText("���������� ���� �Ϸ�� ^^");
			}
		} catch (Exception e) {
			logSub.tex1.setText("���� �� ���� �߻� T.T");
			System.out.println("���� �� ���� �߻� : " + e);
		}
		// ������ ���̵�� ��ġ�� ���ϵ���
		sumit.tf_name.setEnabled(false);
		sumit.setVisible(true);
	}

	// ����
	void selectDelete() {
		// TODO Auto-generated method stub

		String id = sumit.tf_id.getText();
		String name = logSub.tex1.getText();
		String sql = "delete from member where id='" + id + "'";
		System.out.println(sql);
		try {

			int rss = stmt.executeUpdate(sql);

			System.out.println(rss + "����");

			// Ŀ�ؼ����κ��� ������ sql���� �����Ű�� ���� statement ��ü�� ���´�.

			logSub.tex1.setText("���� �Ϸ� ^^");

		} catch (Exception e) {
			logSub.tex1.setText("������ ���� �߻� T.T?");
			System.out.println("������ ���� �߻� : " + e);
		}
	}// deleteDB

	// �α��� ü ũ
	void loginCheck() {
		// �α���â�� �ؽ�Ʈ�ʵ忡 ������ ��������
		id = log.tex1.getText().trim();
		password = log.tex2.getText().trim();

		// SELECT ������ �ۼ��Ѵ�. �ش��ϴ� ���̵��� �н����带 �˻��Ѵ�.
		String query = "SELECT name,password FROM member where id='" + id + "'AND password='" + password + "'";

		System.out.println(query);
		try {
			// executeQuery() �޼���� SELECT���� �����Ű�� ����� ResultSet ��ü�� �޴´�.
			ResultSet rs = stmt.executeQuery(query);

			// ���ڵ尡 �ִ��� �˻�
			if (rs.next()) {
				//
				name = rs.getString("name");

				// �ؽ�Ʈ�ʵ忡 ������ �����ͺ��̽��� �ִ� �н����� ���� ���Ѵ�.
				if (password.equals(rs.getString("password"))) {

					System.out.println("�¾Ҿ�");
					// ������ �α��μ��긦 ����ش�.
					logSub.setVisible(true);

				}

			}

		} catch (Exception b) {
			b.printStackTrace();
		}
	}

	// ����
	public static void main(String[] args) {
		new excute();

	}
}