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
		return "ѧ����Ϣ��	ѧ�ţ�"+id+" �������� "+name+" ���Ա�"+sex+"��"+choicesub;
	}
}
