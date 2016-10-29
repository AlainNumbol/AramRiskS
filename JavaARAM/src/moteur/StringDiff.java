/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteur;

/**
 *
 * @author alain
 */
import java.util.*;

class StringDiff {
    
    public static List<int[]> from(String s1, String s2) {
    	int start = -1;
    	int pos = 0;
    	LinkedList<int[]> list = new LinkedList<>();

    	for(; pos < s1.length() && pos < s2.length(); ++pos) {
    		if(s1.charAt(pos) == s2.charAt(pos)) {
    			if(start < 0) start = pos;
    		}
    		else {
    			if(start >= 0) list.add(new int[] { start, pos });
    			start = -1;
    		}
    	}
    	if(start >= 0) list.add(new int[] { start, pos });
    	return list;
    }

    public static void main(String[] args) {
        
    	for(int[] idx : from("Strings are immutable", "Strings are immutable"))
            System.out.println(idx);
        
    }
}