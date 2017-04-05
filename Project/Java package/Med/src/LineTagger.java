import java.io.*;
public class LineTagger {

	public static void main(String[] args) throws Exception {
		String dis ="<DIS>";
		String treat ="<TREAT>";
		PrintWriter writer = new PrintWriter(
				("C:/Users/Kartheek/Desktop/review-1/pendrive/Abstract4.txt"));

		BufferedReader brr = new BufferedReader(new FileReader(
				"C:/Users/Kartheek/Desktop/review-1/pendrive/Abstract3.txt"));
		String line = "";
		while ((line = brr.readLine()) != null) {
	         if(line.contains(dis)==true)
	         {
	        	 if(line.contains(treat)==true)
		         {  
	        		 System.out.println(line+"||TREATFORDIS");
						writer.println(line+"||TREATFORDIS");
		         }
	        	 
	         }
		}
		writer.close();
	}
}
