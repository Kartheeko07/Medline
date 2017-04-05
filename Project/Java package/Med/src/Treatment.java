import java.io.*;
import java.sql.*;
import java.lang.*;
public class Treatment {

    public static void main(String[] args) throws Exception {
    	 PrintWriter writer = new PrintWriter(("C:/Users/Kartheek/Desktop/review-1/pendrive/dis3.txt"));
 String text ="";
 Connection con=null;
 Statement stmt=null;
ResultSet r=null;
 try
 {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/treatment?"+ "user=root&password=");
System.out.println("Database Created");
stmt=con.createStatement();
String sql="";
sql="select distinct(Disease) from treat order by Disease";
stmt=con.createStatement();
r=stmt.executeQuery(sql);
while(r.next())
{
	text=r.getString("Disease");
	System.out.println(text);
	writer.println(text);
}
 }
 catch(Exception e)
 {
	 System.out.println(e);
 }
 
 }
 }