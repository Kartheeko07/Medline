import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;

public class Prevention {

    public static void main(String[] args) throws Exception {
 BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/review-1/pendrive/M.txt"));
 String text ="";
 Connection con=null;
 Statement stmt=null;

 try
 {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/treatment?"+ "user=root&password=");
System.out.println("Database Created");
stmt=con.createStatement();
String disease="";
String prevent="";

 
 while((text=br.readLine()) != null){       
// System.out.println("kartheek"+text);
 if(text.contains("||PREVENT"))   
 {
	 String patternString = "PREVENT";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);
  //      System.out.println("lookingAt = " + matcher.lookingAt());
    //    System.out.println("matches   = " + matcher.matches());
        
        int count = 0;
        while(matcher.find()) {
            count++;
      //      System.out.println("found: " + count + " : "
         //           + matcher.start() + " - " + matcher.end());
            
     String sub1 = text.substring(0,matcher.start());
//	System.out.println(sub1);
        
	 String patternString1 = "<DIS_PREV>(.+?)</DIS_PREV>";

     Pattern pattern1 = Pattern.compile(patternString1);

     Matcher matcher1 = pattern1.matcher(sub1);
	
     int count1 = 0;
     while(matcher1.find()) {
         count1++;
         
      String sub2 = sub1.substring(matcher1.start(),matcher1.end());
//	  System.out.println(sub2);
	 disease=sub2.replace("<DIS_PREV>", "").replace("</DIS_PREV>", "");
//	 System.out.println(disease);
//	System.out.println("INSERT into treat(Disease) " + "VALUES ('"+disease+"')"); 
     }
     String patternString2 = " <TREAT_PREV>(.+?) </TREAT_PREV>";

     Pattern pattern2 = Pattern.compile(patternString2);

     Matcher matcher2 = pattern2.matcher(sub1);
	
     int count2 = 0;
     while(matcher2.find()) {
         count2++;
        
      String sub3 = sub1.substring(matcher2.start(),matcher2.end());
	//  System.out.println(sub3);
     prevent=sub3.replace("<TREAT_PREV>", "").replace("</TREAT_PREV>", "");
  //  System.out.println(treat);
     System.out.println("INSERT into prevent " + "VALUES (\""+disease+"\",\""+prevent+"\")");
     stmt.executeUpdate("INSERT into prevent " + "VALUES (\""+disease+"\",\""+prevent+"\")");    
     }
        }
 }
 }

 con.close();

        }
        catch(Exception e)
        {
       	  System.out.println(e);
        }
            
        
	
}}