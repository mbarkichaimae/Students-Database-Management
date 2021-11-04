

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


	public class DBConnection {
	public static Connection ConnectDB(){
	Connection conn=null;
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "chaimae66");//192.168.1.1
	return conn;
	}catch(Exception ex){
	JOptionPane.showMessageDialog(null, ex);
	}
	return null;
	}
	}

