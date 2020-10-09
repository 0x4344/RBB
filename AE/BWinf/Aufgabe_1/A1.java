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
        String[] hSplit = h.split(" ");
        String[] tSplit = t.split(" ");
        Arrays.sort(hSplit, Comparator.comparingInt(String::length));
        Arrays.sort(tSplit, Comparator.comparingInt(String::length));

        // convert array to list
        List<String> head = new ArrayList<>(Arrays.asList(hSplit));
        List<String> tail = new ArrayList<>(Arrays.asList(tSplit));
        List<String> copyTail = new ArrayList<>(Arrays.asList(tSplit));
         
        //for(String s: head)System.out.println(s);
        int counter = 0;
        String result = "";
        String tmp = "";
        boolean done = false;

        //for(Iterator<String> iterator = tail.iterator(); iterator.hasNext();) {
        //    String x = iterator.next();
        //    if(x.equals("oh")) iterator.remove();
        //}

/*
        for(String s: head)System.out.println(s);
        for(String o: tail)System.out.println(o);
    
        //System.out.println(head.get(0).charAt(1));
        System.out.println(tmp);
*/
        for(String sh : head) {
            for(Iterator<String> iterator = tail.iterator(); iterator.hasNext();) {
                String st = iterator.next();
                //System.out.println(st);
                if(sh.length() != st.length()) continue;
                if(sh.length() == st.length()) {
                   tmp = st;
                   for(int k=0; k<st.length(); k++) {
                       if(sh.charAt(k) == st.charAt(k)) {
                           result += st + " ";
                           iterator.remove();
                           //continue;
                           //iterator.remove();
                           //System.out.println(sh.charAt(k));
                       }
                   } 
                   if(iterator.next().length() > sh.length()) {
                           result += st + " ";
                           iterator.remove();
                   } 
                }
            }
        }

        System.out.println(result);
        //for(String s: tail)System.out.println(s);
        //System.out.println(result);
       



    }

    public static String[] splitSentence(String string) {
		return string.split(" ");
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





















