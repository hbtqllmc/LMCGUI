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
