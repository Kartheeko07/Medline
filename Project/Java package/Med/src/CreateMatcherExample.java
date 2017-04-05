import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;

public class CreateMatcherExample {

    public static void main(String[] args) throws Exception {
 BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/review-1/pendrive/M.txt"));
 PrintWriter writer = new PrintWriter(("C:/Users/Kartheek/Desktop/review-1/pendrive/treatment.txt"));
 String text ="";
 Connection con=null;
 Statement stmt=null;
 long x=System.currentTimeMillis();
 try
 {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/treatment?"+ "user=root&password=");
System.out.println("Database Created");
stmt=con.createStatement();
String disease="";
String treat="";

 
 while((text=br.readLine()) != null){       
// System.out.println("kartheek"+text);
 if(text.contains("||TREAT_FOR_DIS"))   
 {
	 String patternString = "TREAT_FOR_DIS";

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
        
	 String patternString1 = "<DIS>(.+?)</DIS>";

     Pattern pattern1 = Pattern.compile(patternString1);

     Matcher matcher1 = pattern1.matcher(sub1);
	
     int count1 = 0;
     while(matcher1.find()) {
         count1++;
         if(!(count1>=2))
         {
      String sub2 = sub1.substring(matcher1.start(),matcher1.end());
//	  System.out.println(sub2);
	 disease=sub2.replace("<DIS>", "").replace("</DIS>", "");
//	 System.out.println(disease);
//	System.out.println("INSERT into treat(Disease) " + "VALUES ('"+disease+"')"); 
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
    // writer.println(treat);
     }}
        }
 }
 }

 con.close();

        }
        catch(Exception e)
        {
       	  System.out.println(e);
        }
        long y=System.currentTimeMillis();
		System.out.println("The starting time is");
		System.out.println(x+" milliseconds");
		System.out.println("The ending time is");
		System.out.println(System.currentTimeMillis()+" milliseconds");
		System.out.println("The time taken to insert data into database is\t"+(y-x)+" milliseconds");
            
        
	
}}