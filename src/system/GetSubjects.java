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
