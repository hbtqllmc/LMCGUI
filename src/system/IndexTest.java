package system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class IndexTest extends JFrame {
	public static void main(String args[]) {
		IndexTest demo = new IndexTest();//实例化demo
    }
	public IndexTest() {
	        init();
	        this.setTitle("学生选课系统");
			this.setSize(400, 150);
			this.setVisible(true);
	    }
	public void init() { 
		JFrame frame=new JFrame();
		JPanel f=new JPanel();
		JButton bn1=new JButton("学生选课");//创建按钮组件
		bn1.setBounds(10, 10, 20, 20);
		bn1.addActionListener(new ActionListener(){//监听事件
			public void actionPerformed(ActionEvent arg0) {
			ChoiceSubject choice=new ChoiceSubject();//点击按钮时，对choice进行实例化，进行页面的跳转
			}
		});
		JButton bn2=new JButton("学生退课");
		bn2.setBounds(40, 10, 20, 20);
		bn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			QuitSubjects quit=new QuitSubjects();
			}
		});
		JButton bn3=new JButton("课程打印");
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