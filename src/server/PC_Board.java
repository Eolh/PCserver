package server;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableColumn;

public class PC_Board extends JFrame {
	JButton btn1;
	JPanel body_panel;
	JLabel cnt1;
	JLabel cnt2;
	JLabel cnt3;
	JLabel cnt4;
	JLabel cnt5;
	JLabel cnt6;
	JLabel cnt7;
	JLabel cnt8;
	JLabel cnt9;
	JLabel cnt10;
	JLabel cnt11;
	JLabel cnt12;
	JLabel cnt13;
	JLabel cnt14;
	JLabel cnt15;
	JLabel cnt16;

	JPanel controll_panel;
	JTextField text1;
	JPanel ch = new chat();
	JPanel info = new info();
	serverchat chat = new serverchat();
	PC_Board() throws IOException {

		cnt1 = new JLabel("cnt1");
		cnt1.addMouseListener(new MyListener());
		cnt1.setLayout(null);
		cnt1.setBackground(Color.blue);

		cnt2 = new JLabel("bbb");
		cnt2.addMouseListener(new MyListener());
		cnt2.setLayout(null);
		cnt2.setBackground(Color.CYAN);

		cnt3 = new JLabel("dsd");
		cnt3.addMouseListener(new MyListener());
		cnt3.setLayout(null);
		cnt3.setBackground(Color.GREEN);

		cnt4 = new JLabel("Cc");
		cnt4.addMouseListener(new MyListener());
		cnt4.setLayout(null);
		cnt4.setBackground(Color.WHITE);

		cnt5 = new JLabel("cnt1");
		cnt5.addMouseListener(new MyListener());
		cnt5.setLayout(null);

		cnt6 = new JLabel("bbb");
		cnt6.addMouseListener(new MyListener());
		cnt6.setLayout(null);

		cnt7 = new JLabel("dsd");
		cnt7.addMouseListener(new MyListener());
		cnt7.setLayout(null);

		cnt8 = new JLabel("Cc");
		cnt8.addMouseListener(new MyListener());
		cnt8.setLayout(null);

		cnt9 = new JLabel("cnt1");
		cnt9.addMouseListener(new MyListener());
		cnt9.setLayout(null);

		cnt10 = new JLabel("bbb");
		cnt10.addMouseListener(new MyListener());
		cnt10.setLayout(null);

		cnt11 = new JLabel("dsd");
		cnt11.addMouseListener(new MyListener());
		cnt11.setLayout(null);

		cnt12 = new JLabel("Cc");
		cnt12.addMouseListener(new MyListener());
		cnt12.setLayout(null);

		cnt13 = new JLabel("cnt1");
		cnt13.addMouseListener(new MyListener());
		cnt13.setLayout(null);

		cnt14 = new JLabel("bbb");
		cnt14.addMouseListener(new MyListener());
		cnt14.setLayout(null);

		cnt15 = new JLabel("dsd");
		cnt15.addMouseListener(new MyListener());
		cnt15.setLayout(null);

		cnt16 = new JLabel("Cc");
		cnt16.addMouseListener(new MyListener());
		cnt16.setLayout(null);

		body_panel = new JPanel();

		body_panel.setBounds(250, 0, 950, 1000);

		cnt5.setBackground(Color.WHITE);
		cnt6.setBackground(Color.blue);
		cnt7.setBackground(Color.CYAN);
		cnt8.setBackground(Color.GREEN);
		cnt9.setBackground(Color.GREEN);
		cnt10.setBackground(Color.WHITE);
		cnt11.setBackground(Color.blue);
		cnt12.setBackground(Color.CYAN);
		cnt13.setBackground(Color.CYAN);
		cnt14.setBackground(Color.GREEN);
		cnt15.setBackground(Color.WHITE);
		cnt16.setBackground(Color.blue);

		cnt1.setOpaque(true);
		cnt2.setOpaque(true);
		cnt3.setOpaque(true);
		cnt4.setOpaque(true);
		cnt5.setOpaque(true);
		cnt6.setOpaque(true);
		cnt7.setOpaque(true);
		cnt8.setOpaque(true);
		cnt9.setOpaque(true);
		cnt10.setOpaque(true);
		cnt11.setOpaque(true);
		cnt12.setOpaque(true);
		cnt13.setOpaque(true);
		cnt14.setOpaque(true);
		cnt15.setOpaque(true);
		cnt16.setOpaque(true);

		controll_panel = new JPanel();
		controll_panel.setLayout(null);
		controll_panel.setSize(250, 1000);
		
		controll_panel.add(chat);
		controll_panel.add(info);

		btn1 = new JButton();
		text1 = new JTextField();

		body_panel.add(cnt1);
		body_panel.add(cnt2);
		body_panel.add(cnt3);
		body_panel.add(cnt4);
		body_panel.add(cnt5);
		body_panel.add(cnt6);
		body_panel.add(cnt7);
		body_panel.add(cnt8);
		body_panel.add(cnt9);
		body_panel.add(cnt10);
		body_panel.add(cnt11);
		body_panel.add(cnt12);
		body_panel.add(cnt13);
		body_panel.add(cnt14);
		body_panel.add(cnt15);
		body_panel.add(cnt16);

		body_panel.setLayout(new GridLayout(4, 4));
		add(body_panel);
		add(controll_panel);

		setLayout(null);

		setSize(1200, 1000);
		setVisible(true);
		setResizable(false);
		chat.serverStart();
	}

	private class MyListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getSource());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
}

class chat extends JPanel {
	JTextField f1 = new JTextField("aaaa");
	JTextField f2 = new JTextField("vvvvv");

	chat() {
		this.setBackground(Color.black);
		this.setSize(250, 500);

		this.add(f1);
		this.add(f2);
		this.setVisible(true);
	}
}

class info extends JPanel {
	JLabel member_ = new JLabel("회원 리스트");

	info() {

		String[] columnNames = { "Name", "age", "tel", "sit" };
		Object[][] data = { { "Kathy", "22", "01000000000", "1" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "Jane", "18", "01099887766", "4" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" },
				{ "John", "30", "01012345678", "2" },
				{ "Sue", "19", "01011112222", "3" } };

		
		JTable member_in = new JTable(data, columnNames);
		
		TableColumn column = null;
		for (int i = 0; i < 4; i++) {
			column = member_in.getColumnModel().getColumn(i);
			if (i != 2) {
				column.setMaxWidth(100);
				column.setMinWidth(100);
				column.setPreferredWidth(100); // third column is bigger
			} else {
				column.setMaxWidth(50);
				column.setMinWidth(50);
				column.setPreferredWidth(50);
			}
		}

		JScrollPane scrollPane = new JScrollPane(member_in);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		member_in.setFillsViewportHeight(true);

		this.setBackground(Color.gray);
		this.setBounds(0, 550, 250, 450);

		this.add(member_);
		this.add(scrollPane);
		this.setVisible(true);

		
	}
}
