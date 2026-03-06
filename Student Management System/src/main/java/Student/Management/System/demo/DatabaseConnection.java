package Student.Management.System.demo;
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DatabaseConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/students";
	    private static final String USER = "Aaryan"; // Default XAMPP user
	    private static final String PASSWORD = "Aaryan@123";     // Default XAMPP password is empty

	    public static Connection getConnection() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            System.out.println("Connection Failed: " + e.getMessage());
	            return null;
	        }
	    }
	}


