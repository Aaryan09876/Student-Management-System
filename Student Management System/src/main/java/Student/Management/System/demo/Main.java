package Student.Management.System.demo;
	import java.sql.SQLException;
import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) throws SQLException {
	        Scanner sc = new Scanner(System.in);
	        StudentDAO dao = new StudentDAO();

	        // Admin Login
	        System.out.println("=== SmartStudent Login ===");
	        System.out.print("Username: ");
	        String user = sc.next();
	        System.out.print("Password: ");
	        String pass = sc.next();

	        if (user.equals("Aaryan") && pass.equals("Aaryan@123")) {
	            System.out.println("Login Successful!\n");
	            boolean exit = false;

	            while (!exit) {
	                System.out.println("\n1. Add Student\n2. View All\n3. Delete Student\n4. Update Student\n5. Search Feature\n6. Exit");
	                System.out.print("Choice: ");
	                int choice = sc.nextInt();

	                switch (choice) {
	                    case 1:
	                    	System.out.print("Id: "); int id = sc.nextInt();
	                        System.out.print("Name: "); String name = sc.next();
	                        System.out.print("Roll No: "); int  rollno = sc.nextInt();
	                        System.out.print("Dept: "); String department = sc.next();
	                        System.out.print("Marks: "); double marks = sc.nextDouble();
	                        System.out.print("Email: "); String email = sc.next();
	                        System.out.print("Phone: "); long phone = sc.nextLong();
	                        dao.addStudent(id,name, rollno, department, email, phone, marks);
	                        break;
	                    case 2:
	                        dao.viewStudents();
	                        break;
	                    case 3:
	                        System.out.print("Enter Roll No to delete: ");
	                        dao.deleteStudent(sc.nextInt());
	                        break;
	                    case 4:
	                    	 System.out.print("Name: "); String name1 = sc.next();
	                    	 System.out.print("Email: "); String email1 = sc.next();    
		                     dao.updateStudent(name1,email1);
		                        break;
	                    case 5:
	                    	System.out.print("Rollno: "); int rollno1=sc.nextInt();
	                    	dao.searchByRollNo(rollno1);
	                    	  break;
	                    case 6:
	                        exit = true;
	                        break;
	                }
	            }
	        } else {
	            System.out.println("Invalid Credentials.");
	        }
	    }
	}


