package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ChoiceSubject extends JFrame {
	public static void main(String args[]) {
		ChoiceSubject demo = new ChoiceSubject();
    }
	public ChoiceSubject() {
	        init();
	        this.setTitle("学生选课系统：学生选课");
			this.setBounds(400, 150, 900, 300);;
			this.setVisible(true);
	    }
	public void init() {
		GetSubjects s=new GetSubjects();
		FileOperations file=new FileOperations();
		String[] s1=s.getSubjects();
		String[] s2=new String[20];
		JFrame frame=new JFrame();
		frame.setTitle("choice");
		JPanel f=new JPanel();
		JList list =new JList(s.getSubjects());
		JButton bn1=new JButton("确定");
		bn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "您没有选择课程！");
					return;
				}
				else for(int i=0;i<=s2.length-1;i++) {
					if(list.isSelectedIndex(i)&&file.readFile(file.readFile("ID")).contains(s1[i])==false) {
						s2[i]=s1[i];
					}
				}
			file.WriteFile(s2,file.readFile("ID"));
				JOptionPane.showMessageDialog(null, "选课成功");
				setVisible(false);
			}
		});
		JButton bn2=new JButton("退出");
		bn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		f.add(bn1);
		f.add(bn2);
		f.add(list);
		this.add(f);
	}
}

