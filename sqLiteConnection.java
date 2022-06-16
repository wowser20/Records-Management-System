import java.sql.*;

import javax.swing.*;
// Class used to connect to SQL database
public class sqLiteConnection {
	Connection con=null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");				
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
			return connection;
		
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		}
		}
