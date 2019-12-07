package system;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginTest extends JFrame{
	public static void main(String args[]) {
		LoginTest demo = new LoginTest();
    }
	 public LoginTest() {
	        init();
	        this.setTitle("ѧ��ѡ��ϵͳ");
			this.setBounds(400, 150, 320, 300);;
			this.setVisible(true);
	    }
	public void init() {
		FileOperations file=new FileOperations();
		JFrame frame=new JFrame();
		frame.setTitle("choice");
		JPanel f=new JPanel();
		f.setLayout(null);
		ButtonGroup group=new ButtonGroup();
		JRadioButton jrb1=new JRadioButton("�û�");
		jrb1.setBounds(80, 10, 100, 30);
		jrb1.setSelected(true);
		JRadioButton jrb2=new JRadioButton("����Ա");
		jrb2.setBounds(180, 10, 100, 30);
		group.add(jrb1);
		group.add(jrb2);
		JLabel lb2=new JLabel("�û�����");
		lb2.setBounds(10, 50, 100, 30);
		JTextField tf2=new JTextField(20);
		tf2.setBounds(80, 50, 200, 30);
		JLabel lb3=new JLabel("���룺");
		lb3.setBounds(10, 90, 200, 30);
		JTextField ps=new JTextField(10);
		ps.setBounds(80, 90, 200, 30);
		JButton bn1=new JButton("��¼");
		bn1.setBounds(40, 130, 60, 30);
		bn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			String string="310769,310769";
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
			return;
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(tf2.getText()+","+ps.getText())){
			file.writeFile("ID",tf2.getText());
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			IndexTest choice=new IndexTest();
			setVisible(false);
		}
		
		if(jrb2.isSelected()&&string.contains(tf2.getText()+","+ps.getText())) {
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			AppendSubjects demo = new AppendSubjects();
			setVisible(false);
			}
		if(jrb2.isSelected()&&string.contains(tf2.getText()+","+ps.getText())==false) {
			JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(ps.getText())==false&&file.readFile("Admin").contains(tf2.getText())) {
			JOptionPane.showMessageDialog(null, "�������");
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(tf2.getText())==false) {
			JOptionPane.showMessageDialog(null, "�û��������ڣ�����ע���ٽ��е�¼��");
		}
	}
});
		JButton bn2=new JButton("ע��");
		bn2.setBounds(120, 130, 60, 30);
		bn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
			return;
		}
		else if(jrb2.isSelected()) {
			JOptionPane.showMessageDialog(null, "��û��Ȩ��ע�����Ա��");
			return;
		}
		else{
			file.writeFile("Admin",tf2.getText()+","+new String(ps.getText())+"��");
			JOptionPane.showMessageDialog(null, "ע��ɹ���");//7
		}
	}
});
		JButton bn3 = new JButton();
		bn3.setText("����");
		bn3.setBounds(200, 130, 60, 30);
		bn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			tf2.setText("");
			ps.setText("");
		}
	});
		f.add(bn1);
		f.add(bn2);
		f.add(bn3);
		f.add(jrb1);
		f.add(lb2);
		f.add(lb3);
		f.add(jrb2);
		f.add(tf2);
		f.add(ps);
		this.add(f);
	}
}
