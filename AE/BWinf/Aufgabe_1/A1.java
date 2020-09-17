import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A1 {
	public static void main (String[] args) {

	// read textfile and setup arraylist
	ArrayList<String> data = new ArrayList<String>();
	ArrayList<String> tmp = new ArrayList<String>();
	String head = "";
	String tail = "";
	try {
    	File myObj = new File("r0.txt");
      	Scanner myReader = new Scanner(myObj);
		int i = 0;
      	while (myReader.hasNextLine()) {
			if (i == 0) {
				head += myReader.nextLine();
				i++;
			}
			else tail += myReader.nextLine();
        }
      	myReader.close();
	} catch (FileNotFoundException e) {
     	System.out.println("An error occurred.");
      	e.printStackTrace();
    }

	String[] splitHead = splitSentence(head);
	String[] splitTail = splitSentence(tail);
	//String r = solve(splitHead,splitTail);

	solve(splitHead, splitTail);
	for(String k : splitHead)
		System.out.println(k);

	}

	public static String[] splitSentence(String string) {
		return string.split(" ");
	}
	public static void solve(String[] head, String[] tail) {
		String result = "";
		String tmp; 
		for(String h : head) {
			String tmpSpecial = special(h);
			h = h.replaceAll(tmpSpecial,"");
			//System.out.println(h);

			for(String t : tail) {
				if(t.length() == h.length()) {
					tmp = t;
					for(int i=0; i<t.length(); i++) {
						if(h.charAt(i) == t.charAt(i)){
							//System.out.println(tmpSpecial);
							h = t +  tmpSpecial +  " ";
							System.out.println(h);
							//tmpSpecial = "";
							continue;
						}
					}
				}
			}
		}
		//return result;
	}
	public static String special (String string) {
		if(string.contains(",")) {
			return ",";
		}
		if(string.contains(".")) {
			return ".";
		}
		if(string.contains("!")) {
			return "!";
		}
		return "";
	}
}





















