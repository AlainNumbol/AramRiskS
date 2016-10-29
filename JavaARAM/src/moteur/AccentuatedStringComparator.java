/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteur;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeSet;

/**
 *
 * @author alain
 */
public class AccentuatedStringComparator implements Comparator{
	private final Collator collator;
 
	public AccentuatedStringComparator()
	{
		collator = Collator.getInstance(Locale.FRENCH);
		collator.setStrength(Collator.PRIMARY);			
	}
 
	public int compare(Object object1, Object object2)
	{
		if ((object1 instanceof String) && (object2 instanceof String))
		{
			String s1 = (String) object1;
			String s2 = (String) object2;
			return collator.compare(s1, s2);
		}
		else
		{
			throw new IllegalArgumentException("Les objets comparés doivent être des String");
		}			
	}
        
        public static void main(String[] args){
            TreeSet set = new TreeSet(new AccentuatedStringComparator());
            set.add("L'été à la plage");		
            set.add("L'ete a la plage");
            set.add("L'ETE A LA PLAGE");
            System.out.println(set.size()); 
        }
}