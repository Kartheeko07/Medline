import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test {
public static void main(String[] args)throws Exception {
	String text ="";
	 PrintWriter writer = new PrintWriter(("C:/Users/Kartheek/Desktop/review-1/pendrive/test2/DisList.txt"));
	for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
		BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/review-1/pendrive/A test/"+alphabet+1+".txt"));
			
	//	System.out.println(alphabet);
	     
	
//	writer.println("katheek");
   while((text=br.readLine()) != null)
	{       
	   System.out.println(text);      	
	   	writer.println(text);
		        }
		       
}
	writer.close();
}}

