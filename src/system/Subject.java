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
		return "\n"+"�γ̺ţ�"+num+" ���γ����ƣ�"+subname+" ���γ̵ص㣺"+place+" ���γ�ʱ�䣺"+time+"��"+teaname;
	}
}
