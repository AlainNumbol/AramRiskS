package cnx;
import java.sql.*;
public class ConnexionBase{
	public Connection connexion;
	public Statement statement;
        
	public ConnexionBase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
                connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/aram","root","");
                statement=connexion.createStatement();
	}
        
        public ConnexionBase(String URL,String USER,String PASSWD) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://"+URL+"/brita1",USER,PASSWD);
		//connexion=DriverManager.getConnection(URL,USER,PASSWD);
		statement=con.createStatement();
	}
//        
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            java.sql.Connection con = DriverManager.getConnection("jdbc:odbc:fingerTechEbp;integratedSecurity=true;");
//            java.sql.Statement stm = con.createStatement();
        
	public ResultSet executeQuery(String query,String critere) throws Exception{
	  ResultSet res=null;
	  if(!critere.equals("")){
	    query+=" WHERE "+critere;
	  }
	  res=statement.executeQuery(query);
	  return(res);
	}
	public ResultSet executeQuery(String query) throws Exception{
	 ResultSet res=null;
	 res=statement.executeQuery(query);
	 return(res);
	}
	public boolean executeUpdate(String query) throws Exception{
		int res=statement.executeUpdate(query);
		return true;
	}
        
	public boolean execute(String query) throws Exception{
		int res=statement.executeUpdate(query);
		return true;
	}
        
	public void close() throws Exception{
	  statement.close();
	  connexion.close();
        }
}