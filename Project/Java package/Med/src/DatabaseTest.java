import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseTest {

	
	public static void main(String[] args) throws Exception
	{
		 Connection con=null;
		  Statement stmt=null;
		  ResultSet rs=null;
		  String sql;
		  try
		  {
       Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/treatment?"+ "user=root&password=");
        System.out.println("Database Created");
        stmt=con.createStatement();
        stmt.executeUpdate("INSERT into treat " + "VALUES ('Kartheek','Anumolu')"); 
        con.close();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		
	}

}
