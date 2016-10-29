/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cnx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Cleropix copyright 2011
 */
public class ControlSaisie {
    public String regExpEmpty="^$";					// Accepte une chaine vide
    public String regExpTime="^([01][0-9]|2[0123])\\:([012345][0-9])(\\:([012345][0-9])(.([0-9]{3})+)?)?$";
    public String regExpEnglishDate="^(19|20)\\d\\d[\\- \\/\\.](0[1-9]|1[012])[\\- \\/\\.](0[1-9]|[12][0-9]|3[01])$"; // idem ci-dessus mais format anglais (Ex : aaaa/mm/jj)
    public String regExpEmailAdress="^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$"; // Accepte une adresse email. Ex : toto@toto.com
    public String regExpIpAdress="^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";	// Accepte une adresse ip. Ex : 192.168.0.1
    public String regExpTelephonePortable="^(01|02|03|04|05)[ \\.\\-]?[0-9]{2}[ \\.\\-]?[0-9]{2}[ \\.\\-]?[0-9]{2}[ \\.\\-]?[0-9]{2}$";		// Accepte un numero de téléphone de type 'fixe'. Ex : 01.34.12.52.30 ou 0134125230
    public ControlSaisie(){
    
    }

public boolean matchRegularExpression(String valeur, String regularExpression)
{
	Pattern p = Pattern.compile(regularExpression);
        Matcher  m = p.matcher(valeur);
        boolean result = m.matches();
        return result;
}

public boolean doesntMatchRegularExpression(String valeur, String regularExpression)
{
	if(matchRegularExpression(valeur, regularExpression)) return false;
	else return true;
}
public boolean isNotEmailAdress(String valeur)
{
	return doesntMatchRegularExpression(valeur, regExpEmailAdress);
}
public boolean isEmpty(String valeur)
{
	return matchRegularExpression(valeur, regExpEmpty);
}
public boolean isNotEmpty(String valeur)
{
	return doesntMatchRegularExpression(valeur, regExpEmpty);
}

public boolean isNotDate(String valeur)
{

        return doesntMatchRegularExpression(valeur, regExpEnglishDate);

}
public boolean isNotTime(String valeur)
{
	return doesntMatchRegularExpression(valeur, regExpTime);
}
public boolean isNotTelephone(String valeur)
{
	return doesntMatchRegularExpression(valeur, regExpTelephonePortable);
}
public String toHtmlCode(String value){
        String s=value;
        String caract[]={"'","’","°","ô","è","é","ê","à","ç"};
	String codecar[]={"&#180;","&#180;","&#176;","&#244;","&#232;","&#233;","&#234;","&#224;","&#231;"};
	for(int i=0;i<caract.length;i++){
            Pattern p = Pattern.compile(caract[i]);// compilation de la regex avec le motif : "caract[i]"
            Matcher m = p.matcher(s);// création du moteur associé à la regex sur la chaîne "s"
            s = m.replaceAll(codecar[i]);// remplacement de toutes les occurrences de "caract[i]" par "codecar[i]"
	}
        return s;
}
public String addslashes(String value){
        String s=value;
        String caract="'";
	String codecar="\'";
	Pattern p = Pattern.compile(caract);// compilation de la regex avec le motif : "caract[i]"
        Matcher m = p.matcher(s);// création du moteur associé à la regex sur la chaîne "s"
        s = m.replaceAll(codecar);// remplacement de toutes les occurrences de "caract[i]" par "codecar[i]"
	
       return s;
}

public boolean isNotIpAdress(String valeur)
{
	return doesntMatchRegularExpression(valeur, regExpIpAdress);
}
public static void main(String args[]) throws Exception {
    ControlSaisie cs=new ControlSaisie();
     System.out.println(cs.isEmpty("rere"));
     System.out.println(cs.addslashes("hs'gdgshgd"));
     System.out.println(cs.isNotEmpty(""));
     System.out.println(cs.isNotDate("2011/12/02"));
     System.out.println(cs.isNotTime("12:58:52"));
     System.out.println(cs.isNotTelephone("0320458099"));
     System.out.println(cs.isNotIpAdress("192.168.0.1"));
     System.out.println(cs.isNotEmailAdress("alone@yahoo.fr"));

}
}



