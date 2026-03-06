package Student.Management.System.demo;
import java.sql.*;


import org.springframework.beans.factory.annotation.Autowired;
	public class StudentDAO {
	    // CREATE
		
	    public void addStudent(int id,String name, int rollno, String department, String email, long phone, double marks) {
	        String query = "INSERT INTO students (id, name, rollno, department, email, phone, marks) VALUES (?,?,?,?,?,?,?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pst = conn.prepareStatement(query)) {
	        	pst.setInt(1, id);
	            pst.setString(2, name);
	            pst.setInt(3, rollno);
	            pst.setString(4, department);
	            pst.setString(5, email);
	            pst.setLong(6, phone);
	            pst.setDouble(7, marks);
	            int rowsInserted = pst.executeUpdate();

	            if (rowsInserted > 0) {
	                System.out.println("A new student was inserted successfully!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // READ (View All)
	    public void viewStudents() {
	        String query = "SELECT * FROM students";
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement st = conn.createStatement();
	             ResultSet rs = st.executeQuery(query)) {
	            System.out.println("\n--- Student Records ---");
	            while (rs.next()) {
	                System.out.format("\n\n\nID: %d | \nName: %s | \nRollno: %s | \nDepartment: %s | \nMarks: %s | \nPhone: %s | \nEmail: %s |",
	                        rs.getInt("id"), rs.getString("name"), rs.getInt("rollno"), 
	                        rs.getString("department"), rs.getDouble("marks"), rs.getLong("phone"), rs.getString("email"));
	            }
	        } catch (SQLException e) { e.printStackTrace(); }
	    }

	   
	    
	    // Update
	    
	    @Autowired
	    public void updateStudent(String email1,String name1) throws SQLException {
	    	// Update data
            String query = "UPDATE students SET name = ? WHERE email = ?";
            try (Connection conn = DatabaseConnection.getConnection();
            	PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, email1);
                pstmt.setString(2, name1);
                pstmt.executeUpdate();
                int rows = pstmt.executeUpdate();
	            if (rows > 0) System.out.println("Record updated!");
	            else System.out.println("Student not found.");
            }catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	 // DELETE
	    public void deleteStudent(int rollno) {
	        String query = "DELETE FROM students WHERE rollno = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pst = conn.prepareStatement(query)) {
	            pst.setInt(1, rollno);
	            int rows = pst.executeUpdate();
	            if (rows > 0) System.out.println("Record deleted!");
	            else System.out.println("Student not found.");
	        } catch (SQLException e) { e.printStackTrace(); }
	    }
	    
	    //Search
	   
	        // Method to search student by roll number
	        public void searchByRollNo(int rollno1) {
	           

	            String query = "SELECT * FROM students WHERE rollNo = ?";
	            try (Connection conn = DatabaseConnection.getConnection();
	            	PreparedStatement pst = conn.prepareStatement(query)) {
	                pst.setInt(1, rollno1);
	                int rows = pst.getResultSetHoldability();
		            if (rows > 0) System.out.println("Search Student Done!");
	                ResultSet rs = pst.executeQuery();
	            }catch (SQLException e) { e.printStackTrace(); }
	
	        }
	    }
	    

