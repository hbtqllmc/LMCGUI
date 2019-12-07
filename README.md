计182 2018310769 刘孟琛

实验分析：

一、要求：

1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。

2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。

3、针对操作过程中可能会出现的各种异常，做异常处理。

4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。

二、分布分析

1、功能类函数设计：

（1）文件处理：

![1](https://github.com/hbtqllmc/LMCGUI/blob/master/%E6%96%87%E4%BB%B6%E5%A4%84%E7%90%86.png)

```
package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
	
	public String readFile(String filename) {
		  String str="";
		  String pathname = "D:\\"+filename+".txt";
		  try (FileReader reader = new FileReader(pathname);
		       BufferedReader br = new BufferedReader(reader)) 
		  {
		      String line;
		      while ((line = br.readLine()) != null) {
		      	str=str+line;
		      }

		  } catch (IOException e) {
		      e.printStackTrace();
		  }
		  return str;
	}
	
	public void writeFile(String filename,String s) {
		String pathname = "D:\\"+filename+".txt";
		  try {
			  if(filename=="Admin") {
		      File writeName = new File(pathname); 
		      writeName.createNewFile(); 
		      try (FileWriter writer = new FileWriter(writeName,true);
		           BufferedWriter out = new BufferedWriter(writer)
		      ) {
		      		if(s!=null) {
		      		out.write(s); 
		      	}
		          out.flush(); 
		      }
			  }
			  else {
				  File writeName = new File(pathname); 
			      writeName.createNewFile(); 
			      try (FileWriter writer = new FileWriter(writeName);
			           BufferedWriter out = new BufferedWriter(writer)
			      ) {
			      		if(s!=null) {
			      		out.write(s); 
			      	}
			          out.flush(); 
			      }
			  }
		  } catch (IOException e) {
		      e.printStackTrace();
		  }
	}
	
	public void WriteFile(String[] s,String filename) {
		try {
            File writeName = new File("D:\\"+filename+".txt"); 
            writeName.createNewFile(); 
            try (FileWriter writer = new FileWriter(writeName,true);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            	for(int i=0;i<s.length;i++) {
            		if(s[i]!=null) {
            		out.write(s[i]); 
            	}
                out.flush();
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

（2）获取课程：

![2](https://github.com/hbtqllmc/LMCGUI/blob/master/%E8%8E%B7%E5%8F%96%E8%AF%BE%E7%A8%8B.png)

```
package system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetSubjects {
	public String[] getSubjects() {
		Teacher teaone=new Teacher("001","杜老师","F","Math");
		Teacher teatwo=new Teacher("002","张老师","M","Java");
		Teacher teathree=new Teacher("003","高老师","M","Physics");
		Teacher teafour=new Teacher("004","王老师","F","Python");
		Teacher teafive=new Teacher("005","李老师","F","English");
		Subject subone=new Subject("1","Math","houseone","8:00",teaone);
		Subject subtwo=new Subject("2","Java","housetwo","9:00",teatwo);
		Subject subthree=new Subject("3","Physics","housethree","10:00",teathree);
		Subject subfour=new Subject("4","Python","housefour","11:00",teafour);
		Subject subfive=new Subject("5","English","housefive","12:00",teafive);
		String [] subjects= new String[20];
		subjects[0]=subone.toString();
		subjects[1]=subtwo.toString();
		subjects[2]=subthree.toString();
		subjects[3]=subfour.toString();
		subjects[4]=subfive.toString();
		FileOperations file=new FileOperations();
		for(int i=0;i<file.readFile("test").split("。").length;i++) {
			subjects[i+5]=file.readFile("test").split("。")[i]+"。";
		}
		return subjects;
		}
}
```

（3）学生：

![3](https://github.com/hbtqllmc/LMCGUI/blob/master/%E5%AD%A6%E7%94%9F.png)

```
package system;

public class Students extends People {
	Subject choicesub;
	String score;
	public Students(String id, String name, String sex,Subject choicesub,String score) {
		super(id, name, sex);
		this.choicesub=choicesub;
		this.score=score;
		}
	public String toString() {
		return "学生信息：	学号："+id+" ，姓名： "+name+" ，性别："+sex+"；"+choicesub;
	}
}
```

（4）教师:

![4](https://github.com/hbtqllmc/LMCGUI/blob/master/%E6%95%99%E5%B8%88.jpg)

```
package system;

public class Teacher extends People{
	String teachsub;
	public Teacher(String id, String name, String sex,String teachsub) {
		super(id, name, sex);
		this.teachsub=teachsub;
	}
	public String toString() {
		return "\n"+"授课教师:工号："+id+" ,姓名："+name+" ,性别："+sex+"。";
	}
}
```

（5）访客:

![5](https://github.com/hbtqllmc/LMCGUI/blob/master/%E8%AE%BF%E5%AE%A2.jpg)

```
package system;

public class People {
	String id;
	String name;
	String sex;
	public People(String id,String name,String sex) {
		this.id=id;
		this.name=name;
		this.sex=sex;
	}
}
```

（6）课程:

![6](https://github.com/hbtqllmc/LMCGUI/blob/master/%E8%AF%BE%E7%A8%8B.jpg)

```
package system;

public class Subject {
	String num;
	String subname;
	String place;
	String time;
	Teacher teaname;
	public Subject(String num,String subname,String place,String time,Teacher teaname) {
		this.num=num;
		this.subname=subname;
		this.place=place;
		this.time=time;
		this.teaname=teaname;
	}
	public String toString() {
		return "\n"+"课程号："+num+" ，课程名称："+subname+" ，课程地点："+place+" ，课程时间："+time+"；"+teaname;
	}
}
```

2、图形GUI函数设计：

（1）注册登录界面：

![1](https://github.com/hbtqllmc/LMCGUI/blob/master/%E6%B3%A8%E5%86%8C%E7%99%BB%E9%99%86%E7%95%8C%E9%9D%A2.png)

```
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
	        this.setTitle("学生选课系统");
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
		JRadioButton jrb1=new JRadioButton("用户");
		jrb1.setBounds(80, 10, 100, 30);
		jrb1.setSelected(true);
		JRadioButton jrb2=new JRadioButton("管理员");
		jrb2.setBounds(180, 10, 100, 30);
		group.add(jrb1);
		group.add(jrb2);
		JLabel lb2=new JLabel("用户名：");
		lb2.setBounds(10, 50, 100, 30);
		JTextField tf2=new JTextField(20);
		tf2.setBounds(80, 50, 200, 30);
		JLabel lb3=new JLabel("密码：");
		lb3.setBounds(10, 90, 200, 30);
		JTextField ps=new JTextField(10);
		ps.setBounds(80, 90, 200, 30);
		JButton bn1=new JButton("登录");
		bn1.setBounds(40, 130, 60, 30);
		bn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			String string="310769,310769";
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
			return;
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(tf2.getText()+","+ps.getText())){
			file.writeFile("ID",tf2.getText());
			JOptionPane.showMessageDialog(null, "登录成功");
			IndexTest choice=new IndexTest();
			setVisible(false);
		}
		
		if(jrb2.isSelected()&&string.contains(tf2.getText()+","+ps.getText())) {
			JOptionPane.showMessageDialog(null, "登录成功");
			AppendSubjects demo = new AppendSubjects();
			setVisible(false);
			}
		if(jrb2.isSelected()&&string.contains(tf2.getText()+","+ps.getText())==false) {
			JOptionPane.showMessageDialog(null, "登录失败！");
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(ps.getText())==false&&file.readFile("Admin").contains(tf2.getText())) {
			JOptionPane.showMessageDialog(null, "密码错误");
		}
		if(jrb1.isSelected()&&file.readFile("Admin").contains(tf2.getText())==false) {
			JOptionPane.showMessageDialog(null, "用户名不存在，请先注册再进行登录！");
		}
	}
});
		JButton bn2=new JButton("注册");
		bn2.setBounds(120, 130, 60, 30);
		bn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
			return;
		}
		else if(jrb2.isSelected()) {
			JOptionPane.showMessageDialog(null, "您没有权限注册管理员！");
			return;
		}
		else{
			file.writeFile("Admin",tf2.getText()+","+new String(ps.getText())+"。");
			JOptionPane.showMessageDialog(null, "注册成功！");//7
		}
	}
});
		JButton bn3 = new JButton();
		bn3.setText("重置");
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

```

（2）课程添加：

![2](https://github.com/hbtqllmc/LMCGUI/blob/master/%E8%AF%BE%E7%A8%8B%E6%B7%BB%E5%8A%A0.png)

```
package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppendSubjects extends JFrame{
	public static void main(String args[]) {
		
    }
	public AppendSubjects() {
	        init();
	        this.setTitle("学生选课系统:课程添加");
			this.setBounds(400, 150, 420, 400);;
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
		f.setLayout(null);
		JLabel lb1=new JLabel("课程号：");
		lb1.setBounds(10, 10, 100, 30);
		JTextField tf1=new JTextField(20);
		tf1.setBounds(80, 10, 200, 30);
		JLabel lb2=new JLabel("课程名称：");
		lb2.setBounds(10, 50, 100, 30);
		JTextField tf2=new JTextField(20);
		tf2.setBounds(80, 50, 200, 30);
		JLabel lb3=new JLabel("课程地点：");
		lb3.setBounds(10, 90, 200, 30);
		JTextField tf3=new JTextField(20);
		tf3.setBounds(80, 90, 200, 30);
		JLabel lb4=new JLabel("课程时间：");
		lb4.setBounds(10, 130, 200, 30);
		JTextField tf4=new JTextField(20);
		tf4.setBounds(80, 130, 200, 30);
		JLabel lb5=new JLabel("教师工号：");
		lb5.setBounds(10, 170, 200, 30);
		JTextField tf5=new JTextField(20);
		tf5.setBounds(80, 170, 200, 30);
		JLabel lb6=new JLabel("教师姓名：");
		lb6.setBounds(10, 210, 200, 30);
		JTextField tf6=new JTextField(20);
		tf6.setBounds(80, 210, 200, 30);
		JLabel lb7=new JLabel("性别：");
		lb7.setBounds(10, 250, 200, 30);
		String[] s3={"M","F"};
		JComboBox cb=new JComboBox(s3);
		cb.setBounds(80, 250, 200, 30);
		JButton bn1=new JButton("添加");
		bn1.setBounds(40, 290, 60, 30);
		bn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String[] s4={"M","F"};
				if(tf1.getText().trim().length()==0||tf2.getText().trim().length()==0||tf3.getText().trim().length()==0||tf4.getText().trim().length()==0||tf5.getText().trim().length()==0||tf6.getText().trim().length()==0) {

					JOptionPane.showMessageDialog(null, "信息不能为空！");
					return;
				}
				else {
					String str="课程号："+tf1.getText()+" ，课程名称："+tf2.getText()+" ，课程地点："+tf3.getText()+" ，课程时间："+tf4.getText()+"；"+"授课教师:工号："+tf5.getText()+" ,姓名："+tf6.getText()+" ,性别："+s4[cb.getSelectedIndex()]+"。";
					file.writeFile("test",str);
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		JButton bn2=new JButton("退出");
		bn2.setBounds(120, 290, 60, 30);
		bn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		JButton bn3 = new JButton();
		bn3.setText("重置");
		bn3.setBounds(200, 290, 60, 30);
		bn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成方法存根
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
			}
		});
		f.add(bn1);
		f.add(bn2);
		f.add(bn3);
		f.add(lb1);
		f.add(lb2);
		f.add(lb3);
		f.add(lb4);
		f.add(lb5);
		f.add(lb6);
		f.add(lb7);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(tf5);
		f.add(tf6);
		f.add(cb);
		this.add(f);
	}
}

```

（3）学生界面：

![3](https://github.com/hbtqllmc/LMCGUI/blob/master/%E5%AD%A6%E7%94%9F%E7%95%8C%E9%9D%A2.png)

```
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
```

（4）课程选择:

![4](https://github.com/hbtqllmc/LMCGUI/blob/master/%E8%AF%BE%E7%A8%8B%E9%80%89%E6%8B%A9.png)

```
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

```

（5）退课:

![5](https://github.com/hbtqllmc/LMCGUI/blob/master/%E9%80%80%E8%AF%BE.png)

```
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
	        this.setTitle("学生选课系统：学生退课");
			this.setBounds(400, 150, 900, 300);;
			this.setVisible(true);
	    }
	public void init() {
		String[] s2=new String[20];
		FileOperations file=new FileOperations();
		JFrame frame=new JFrame();
		frame.setTitle("Quit");
		JPanel f=new JPanel();
		s2=file.readFile(file.readFile("ID")).split("。");
		JList list =new JList(s2);
		JButton bn1=new JButton("退课");
		bn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String[] s2=file.readFile(file.readFile("ID")).split("。");
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "您没有退课！");
					return;
				}
				else for(int i=0;i<s2.length;i++) {
					if(list.isSelectedIndex(i)) {//判断课程是否被选中
						s2[i]=null;//课程信息置为空
					}

				}
				file.WriteFile(s2,file.readFile("ID"));
				JOptionPane.showMessageDialog(null, "退课成功！");
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

```

（6）显示课程:

![6](https://github.com/hbtqllmc/LMCGUI/blob/master/%E6%98%BE%E7%A4%BA%E8%AF%BE%E7%A8%8B.png)

```
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
```

三、程序运行截图：

![1](https://github.com/hbtqllmc/LMCGUI/blob/master/1.png)

![2](https://github.com/hbtqllmc/LMCGUI/blob/master/2.png)

![3](https://github.com/hbtqllmc/LMCGUI/blob/master/3.png)

![4](https://github.com/hbtqllmc/LMCGUI/blob/master/4.png)

![5](https://github.com/hbtqllmc/LMCGUI/blob/master/5.png)

![6](https://github.com/hbtqllmc/LMCGUI/blob/master/6.png)

![7](https://github.com/hbtqllmc/LMCGUI/blob/master/7.png)

![8](https://github.com/hbtqllmc/LMCGUI/blob/master/8.png)

![9](https://github.com/hbtqllmc/LMCGUI/blob/master/9.png)


四、总结：

 本次实验作为最终的综合性实验，难度相较于以往的实验提高了很多，因此老师也给了我们比以往更长的时间。但是饶是如此，我也几近最后时刻才完成本次的代码，这次的实验综合性非常强，全方位的考察了我的各方面水平，一开始我也没有一点头绪。后来通过借鉴一些网络上成熟的代码，并与同学交流心得，我的代码框架慢慢开始完善。而后经过了几天的奋斗，终于完成了本次实验。这个过程是辛苦的，但也是非常有意义的，我的学习能力，思考能力等多方面能力在这段时间内飞速的提高，对于java的认识也更加深刻了。总之，本次实验使我受益匪浅，在这个过程中所学到的知识在以后的学习生活中也会让我受益无穷。
