import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreatmentMatch {

	public static void main(String[] args) throws Exception {
		String text = "";
		int[] start = new int[20000];
		int[] end = new int[20000];
		int i = 1;
		int count = 0;
		PrintWriter writer = new PrintWriter(
				("C:/Users/Kartheek/Desktop/review-1/pendrive/Abstract3.txt"));

		BufferedReader brr = new BufferedReader(new FileReader(
				"C:/Users/Kartheek/Desktop/review-1/pendrive/TreatList.txt"));
		String dis = "";
		long x=System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		while ((dis = brr.readLine()) != null) {
			System.out.println(dis);
			BufferedReader br = new BufferedReader(new FileReader(
			"C:/Users/Kartheek/Desktop/review-1/pendrive/Abstract2.txt"));
           while ((text = br.readLine()) != null) {
				String patternString = "\\b"+dis+"\\b";

				Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
				
				Matcher matcher = pattern.matcher(text);
				// System.out.println("lookingAt = " + matcher.lookingAt());
				// System.out.println("matches   = " + matcher.matches());
				// System.out.println("this is the text"+text);

				while (matcher.find()) {
					count++;
					System.out.println("found: " + count + " : "
							+ matcher.start() + " - " + matcher.end());
					start[i] = matcher.start();
					end[i] = matcher.end();
					String sub1 = text
							.substring(matcher.start(), matcher.end());
					System.out.println(sub1);
					String newLine = text.substring(0, start[i]) + "<TREAT>"
							+ text.substring(start[i], end[i]) + "</TREAT>"
							+ text.substring(end[i], text.length());
					String newLine2 = text.substring(end[i], text.length());

					System.out.println(newLine);
					writer.println(newLine);
					i++;

				}
				// writer.println(text);
			}
           br.close();
		}
		System.out.println(count);
		for (i = 1; i <= count; i++) {
			System.out.println(start[i]);
			System.out.println(end[i]);

		}
		writer.close();
		long y=System.currentTimeMillis();
		System.out.println("The starting time is");
		System.out.println(x);
		System.out.println("The ending time is");
		System.out.println(System.currentTimeMillis());
		System.out.println("The time taken to compare a single abstract\t"+(y-x));
	}
}
