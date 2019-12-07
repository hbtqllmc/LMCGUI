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
