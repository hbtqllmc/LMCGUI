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
