import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Split2 {
public static void main(String[] args)throws Exception {
	String text ="";
	for(char alphabet = 'A'; alphabet <= 'D';alphabet++) {
		BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/review-1/pendrive/A test/"+alphabet+1+".txt"));
			
		System.out.println(alphabet);
	   PrintWriter writer = new PrintWriter(("C:/Users/Kartheek/Desktop/review-1/pendrive/test2/"+alphabet+2+".txt"));   
	
//	writer.println("katheek");
   while((text=br.readLine()) != null)
	{       
	         String patternString = "\\(";

		        Pattern pattern = Pattern.compile(patternString);

		        Matcher matcher = pattern.matcher(text);
		  //      System.out.println("lookingAt = " + matcher.lookingAt());
		    //    System.out.println("matches   = " + matcher.matches());
		        
		        int count = 0;
		        while(matcher.find()) {
		            count++;
		 //     System.out.println("found: " + count + " : "+ matcher.start() + " - " + matcher.end());
		            
		     String sub1 = text.substring(0,matcher.start());
		System.out.println(sub1);
		writer.println(sub1);
		        }
		       
}
	writer.close();
}}
}
