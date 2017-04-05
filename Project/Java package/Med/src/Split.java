import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Split {
public static void main(String[] args)throws Exception {
	String text ="";
	for(char alphabet = 'A'; alphabet <= 'Z';alphabet++) {
		BufferedReader br= new BufferedReader(new FileReader("C:/Users/Kartheek/Desktop/Diseases List/"+alphabet+".txt"));
			
		System.out.println(alphabet);
	   PrintWriter writer = new PrintWriter(("C:/Users/Kartheek/Desktop/review-1/pendrive/A test/"+alphabet+1+".txt"));   
	

   while((text=br.readLine()) != null)
	{       
	         String patternString = "\\(";

		        Pattern pattern = Pattern.compile(patternString);

		        Matcher matcher = pattern.matcher(text);
		  //      System.out.println("lookingAt = " + matcher.lookingAt());
		    //    System.out.println("matches   = " + matcher.matches());
		        
		        int count = 0;
		        if(matcher.find()) {
		            count++;
		 //     System.out.println("found: " + count + " : "+ matcher.start() + " - " + matcher.end());
		            
		     String sub1 = text.substring(0,matcher.start());
		System.out.println(sub1);
		writer.println(sub1);
		        }
		        else
		        	writer.println(text); 	
		       
}
	writer.close();
}}
}
