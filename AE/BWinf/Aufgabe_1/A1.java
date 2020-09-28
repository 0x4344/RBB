import java.io.File;
import java.io.FileNotFoundException;  
import java.util.*;

public class A1 {

	public static void main (String[] args) {

        // load file
        ArrayList<String> data = new ArrayList<String>();
        data = loadFile("r0.txt");
       
        // substring arraylist
        String h = data.get(0); 
        String t = data.get(1);

        // remove special chars
        h = rmSpecialChars(h);
        t = rmSpecialChars(t);

        // convert string to string array
        String[] head = h.split(" ");
        String[] tail = t.split(" ");
        Arrays.sort(head, Comparator.comparingInt(String::length));
        Arrays.sort(tail, Comparator.comparingInt(String::length));


        for(String s:tail) System.out.println(s);
       /*
        for(String hs : head) {
            for(String ts : tail) {
                if(hs.length() == ts.length()) {
                    tmp = ts;
                    for(int i=0; i<hs.length(); i++) {
                        if(hs.charAt(i) == ts.charAt(i)) {
                            tmp = ts;
                            tail = tail.remove(ts);
                        }
                    }
                }
            }
        }
        */
        //for(String bla : head)
        //System.out.println(bla);

        /*
        for (int i=0;i<head.length;i++) {
            for(int k=0;k<tail.length;k++) {
                if(head[i].length() == tail[k].length()) {
                    tmp = tail[k];
                    if(head[i].charAt(k) == tail[k].charAt(k)) tmp = tail[k];
                }
            }   
        }   
        */

        /* 
        for(String s: head)
            System.out.println(s);

        for(String s : head) System.out.println(s ); 
        System.out.println(tail); 
        for(int i=0; i<dataString.length(); i++) {
                System.out.print(dataString.charAt(i) +"  ");
        }
        */
        
	}

	public static String[] splitSentence(String string) {
		return string.split(" ");
	}
    
	public static void solve(String[] head, String[] tail) {
		String result = "";
		String tmp = "";

		for(String h : head) {
			char tmpSpecial = special(h);
			String strSpecial = Character.toString(special(h));
			System.out.println(tmpSpecial);
			h = h.replaceAll(strSpecial,"");
			//System.out.println(h);

			for(String t : tail) {
				if(t.length() == h.length()) {
					tmp = t;
					for(int i=0; i<t.length(); i++) {
						if(h.charAt(i) == t.charAt(i)){
							//System.out.println(tmpSpecial);
							h = t +  tmpSpecial +  " ";
							//tmpSpecial = "";
							continue;
						}
					}
				}
			}
		}
		//return result;
	}

	public static char special (String string) {
        String pattern = "[^A-Za-z0-9]";
		String special = ",.!-_:;";
		for(int i=0; i<string.length(); i++) {
			for(int k=0; k<special.length(); k++) {
				char ch = special.charAt(k);
				if(string.charAt(i) == ch) {
					return ch;
				}
			}
		}
        return ' ';
	}

  public static ArrayList<String> loadFile(String pathg) {
    // read textfile and setup arraylist
    ArrayList<String> data = new ArrayList<String>();
    try {
        File myObj = new File(pathg);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }
    myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    return data;
    }

   public static String rmSpecialChars(String s) {
      return s.replaceAll("[^A-Za-z0-9äÄöÖüÜß_\\s]+",""); 
    }    
}





















