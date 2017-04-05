import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;

public class DatabasePrep {

    public static void main(String[] args) throws Exception {
 BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/review-1/pendrive/Abstract4.txt"));

 String text ="";
 String disease="";
 String treat="";
 while((text=br.readLine()) != null){       
	 if(text.contains("||TREATFORDIS"))   
	 {
		 String patternString = "TREATFORDIS";

	        Pattern pattern = Pattern.compile(patternString);

	        Matcher matcher = pattern.matcher(text);
	
	        int count = 0;
	        while(matcher.find()) {
	            count++;
	            
	     String sub1 = text.substring(0,matcher.start());

	   String patternString1 = "<DIS>(.+?)</DIS>";

	     Pattern pattern1 = Pattern.compile(patternString1);

	     Matcher matcher1 = pattern1.matcher(sub1);
		
	     int count1 = 0;
	     while(matcher1.find()) {
	         count1++;
	         if(!(count1>=2))
	         {
	      String sub2 = sub1.substring(matcher1.start(),matcher1.end());
		 disease=sub2.replace("<DIS>", "").replace("</DIS>", "");
	     }}
	     String patternString2 = "<TREAT>(.+?)</TREAT>";

	     Pattern pattern2 = Pattern.compile(patternString2);

	     Matcher matcher2 = pattern2.matcher(sub1);
		
	     int count2 = 0;
	     while(matcher2.find()) {
	         count2++;
	         if(!(count2>=2))
	         {
	      String sub3 = sub1.substring(matcher2.start(),matcher2.end());
		//  System.out.println(sub3);
	     treat=sub3.replace("<TREAT>", "").replace("</TREAT>", "");
	  //  System.out.println(treat);
	     System.out.println("INSERT into treat " + "VALUES (\""+disease+"\",\""+treat+"\")");
	  //   stmt.executeUpdate("INSERT into treat " + "VALUES (\""+disease+"\",\""+treat+"\")"); 
	     }}
	        }
	 }
	 }

	 

	        }
}