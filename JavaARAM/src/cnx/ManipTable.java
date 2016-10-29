package cnx;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;

/**
 *
 * @author SpartandHentso
 */

public class ManipTable {
            
    public ConnexionBase connect;
   // public ControlSaisie cs;
    
    public ManipTable() throws Exception {
        connect=new ConnexionBase();
      //  cs=new ControlSaisie();
    }
    public ManipTable(String URL,String USER,String PASSWD) throws Exception {
        connect=new ConnexionBase(URL,USER,PASSWD);
      //  cs=new ControlSaisie();
    }
      
    public void executU(String querry) throws Exception{
        // your code here
        connect.executeUpdate(querry);
    }
    public void inserer(String nomTabl, String value) throws Exception{
        // your code here
        String querry1 = "INSERT INTO "+nomTabl+"  set "+value+";";
        String querry = querry1;
        System.out.println(querry);
        connect.executeUpdate(querry);
    }
    public void modifier(String nomTabl,String value,String rubr,String cle) throws Exception {
        // your code here
        String querry1 = "UPDATE "+nomTabl+" set "+value+" where "+rubr+" = '"+cle+"';";
        String querry = querry1 ;
        System.out.println(querry);
        connect.executeUpdate(querry);
    }
    public void modifier(String nomTabl,String value,String rubr,String cle,String rubr2,String cle2) throws Exception {
        // your code here
        String querry1 = "UPDATE "+nomTabl+" set "+value+" where "+rubr+" = "+cle+" and "+rubr2+" = "+cle2;
        String querry = querry1 ;
        connect.executeUpdate(querry);
    }
    public void supprimer(String nomTabl,String value,String rubr) throws Exception {
        // your code here
        String querry="DELETE FROM "+nomTabl+" WHERE "+rubr+" = "+value+";";
        System.out.println(querry);
        connect.executeUpdate(querry);
    }
    public ResultSet max(String nomTabl,String rubr) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT max(`"+rubr+"`) as max FROM "+nomTabl;
        res=connect.executeQuery(querry);
        return res;
    }
    public ResultSet count(String nomTabl) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT Count(*) as \"C\" FROM "+nomTabl;
        res=connect.executeQuery(querry);
        return res;
    }
    public ResultSet count(String nomTabl, String value,String rubr) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT Count(*) as c FROM "+nomTabl+" where "+rubr+" = "+value;
        res=connect.executeQuery(querry);
        return res;
    }
    public ResultSet count_like(String nomTabl, String value,String rubr) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT Count(*) as c FROM "+nomTabl+" where "+rubr+" LIKE '%"+value+"%'";
        res=connect.executeQuery(querry);
        return res;
    }

    public ResultSet affich(String nomTabl) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT * FROM "+nomTabl;
        res=connect.executeQuery(querry);
        return res;
    }
    public ResultSet affich(String nomTabl,String rubr1, String value1,String rubr2, String value2) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT * FROM "+nomTabl+" where `"+rubr1+"` = '"+value1+"' and `"+rubr2+"` = '"+value2+"';";
        res=connect.executeQuery(querry);
        return res;
    }
    public ResultSet select(String nomTabl,String value,String rubr) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT * FROM "+nomTabl+" where "+rubr+" = '"+value+"';";
        res = connect.executeQuery(querry);
        return res;
    }
    public ResultSet select(String nomTabl,String s,String rubr,String value) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT "+s+" FROM "+nomTabl;
        String critere= " where "+rubr+" = '"+value+"';";
        res = connect.executeQuery(querry+critere);
        System.out.println(querry+critere);
        return res;
    }
    public ResultSet cal(String nomTabl,String value) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT sum(pu*qte)as montant FROM `"+nomTabl+"` WHERE idsrt = '"+value+"'";
       // String critere= " where "+rubr+" = '"+value+"';";
        res = connect.executeQuery(querry);
        //System.out.println(querry+critere);
        return res;
    }
    public ResultSet cherche(String nomTabl,String value,String rubr) throws Exception {
        // your code here
        ResultSet res=null;
        String querry = "SELECT * FROM "+nomTabl;
        String critere= " where "+rubr+" LIKE '%"+value+"%';";
        res = connect.executeQuery(querry+critere);
        //System.out.println(querry+critere);
        return res;
    }
    
    
    //speciale
      public ResultSet count_like(String nomTabl, String value,String rubr,int type) throws Exception {
        // your code here
        ResultSet res = null;
        String querry = "SELECT Count(*) as c FROM "+nomTabl+" where "+rubr+" LIKE '%"+value+"%' and type = '"+type+"';";
        res=connect.executeQuery(querry);
        return res;
    }  
      public ResultSet cherche(String nomTabl,String value,String rubr, int type) throws Exception {
        // your code here
        ResultSet res=null;
        String querry = "SELECT * FROM "+nomTabl;
        String critere= " where "+rubr+" LIKE '%"+value+"%' and type = '"+type+"' ;";
        res = connect.executeQuery(querry+critere);
        return res;
    } 
      
     public ResultSet Liste_(String querry) throws Exception {
        // your code here
        ResultSet res = null;
        res=connect.executeQuery(querry);
        return res;
    }
}
