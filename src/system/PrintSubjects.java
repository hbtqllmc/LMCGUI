package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PrintSubjects extends JFrame {//extends继承JFrame类
	public static void main(String args[]) {
		PrintSubjects demo = new PrintSubjects();//实例化demo
    }
	public PrintSubjects() {
	        init();
	        this.setTitle("学生选课系统：课程打印");
			this.setBounds(400, 150, 900, 300);;
			this.setVisible(true);
	    }
	public void init() { 
		FileOperations file=new FileOperations();
		String[] s2=new String[5];
		JFrame frame=new JFrame();
		frame.setTitle("Quit");
		JPanel f=new JPanel();
		s2=file.readFile(file.readFile("ID")).split("。");
		JList list =new JList(s2);
		JButton bn2=new JButton("退出");
		bn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		f.add(bn2);
		f.add(list);
		this.add(f);
	}
}