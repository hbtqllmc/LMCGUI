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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuitSubjects extends JFrame {
	public static void main(String args[]) {
		QuitSubjects demo = new QuitSubjects();
    }
	public QuitSubjects() {
	        init();
	        this.setTitle("ѧ��ѡ��ϵͳ��ѧ���˿�");
			this.setBounds(400, 150, 900, 300);;
			this.setVisible(true);
	    }
	public void init() {
		String[] s2=new String[20];
		FileOperations file=new FileOperations();
		JFrame frame=new JFrame();
		frame.setTitle("Quit");
		JPanel f=new JPanel();
		s2=file.readFile(file.readFile("ID")).split("��");
		JList list =new JList(s2);
		JButton bn1=new JButton("�˿�");
		bn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String[] s2=file.readFile(file.readFile("ID")).split("��");
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "��û���˿Σ�");
					return;
				}
				else for(int i=0;i<s2.length;i++) {
					if(list.isSelectedIndex(i)) {//�жϿγ��Ƿ�ѡ��
						s2[i]=null;//�γ���Ϣ��Ϊ��
					}

				}
				file.WriteFile(s2,file.readFile("ID"));
				JOptionPane.showMessageDialog(null, "�˿γɹ���");
				setVisible(false);
			}
		});
		JButton bn2=new JButton("�˳�");
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
