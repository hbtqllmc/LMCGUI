package system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class IndexTest extends JFrame {
	public static void main(String args[]) {
		IndexTest demo = new IndexTest();//ʵ����demo
    }
	public IndexTest() {
	        init();
	        this.setTitle("ѧ��ѡ��ϵͳ");
			this.setSize(400, 150);
			this.setVisible(true);
	    }
	public void init() { 
		JFrame frame=new JFrame();
		JPanel f=new JPanel();
		JButton bn1=new JButton("ѧ��ѡ��");//������ť���
		bn1.setBounds(10, 10, 20, 20);
		bn1.addActionListener(new ActionListener(){//�����¼�
			public void actionPerformed(ActionEvent arg0) {
			ChoiceSubject choice=new ChoiceSubject();//�����ťʱ����choice����ʵ����������ҳ�����ת
			}
		});
		JButton bn2=new JButton("ѧ���˿�");
		bn2.setBounds(40, 10, 20, 20);
		bn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			QuitSubjects quit=new QuitSubjects();
			}
		});
		JButton bn3=new JButton("�γ̴�ӡ");
		bn3.setBounds(80, 10, 20, 20);
		bn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			PrintSubjects print=new PrintSubjects();
			}
		});
	    f.add(bn1);
		f.add(bn2);
		f.add(bn3);
		this.add(f);
	}
}