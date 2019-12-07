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
