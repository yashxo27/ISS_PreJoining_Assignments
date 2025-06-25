import java.sql.*;

public class Q11{
	public static void main(String[] args){
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String password="password123";	
		String dbName="jdbcDB";

		try{
			//Class.forName("com.mysql.cj.jdbc.driver");
			
			Connection c = DriverManager.getConnection(url,user,password);
			Statement stmt=c.createStatement();

			String createDBSQL="CREATE DATABASE IF NOT EXISTS "+dbName;
			stmt.execute(createDBSQL);
			System.out.println("Databse Created");

			stmt.close();
			c.close();
			
			String dbURL=url+dbName;
			
			c = DriverManager.getConnection(dbURL,user,password);
			stmt=c.createStatement();

			String createTableSql = """
                	CREATE TABLE IF NOT EXISTS users (
                    	id INT AUTO_INCREMENT PRIMARY KEY,
                    	name VARCHAR(100),
                    	email VARCHAR(100)
                	)
            		""";
            
			stmt.executeUpdate(createTableSql);
            		System.out.println("Table Created");
			
			String insertSql = """
                	INSERT INTO users (name, email)
                	VALUES ('Alice', 'alice@example.com'),
                       	('Bob', 'bob@example.com')
            		""";
            
			stmt.executeUpdate(insertSql);
            		System.out.println("Sample data inserted.");

            		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            		System.out.println("Data from 'users' table:");
            		while (rs.next()) {
               			System.out.printf("ID: %d, Name: %s, Email: %s%n",
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"));
            		}

            		rs.close();
            		stmt.close();
            		c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}