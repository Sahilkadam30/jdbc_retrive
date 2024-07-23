import jdbc.Connection;
import jdbc.ResultSet;
import jdbc.SQLException;
import jdbc.Statement;

public class myjdbc {
	 private static final String  url="jdbc:mysql://localhost:3306/mydb";
	 private static final String  username="root";
	 private static final String  password="Sahil@123";
	 
	 public static void main(String[] args) {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 }catch(ClassNotFoundException e) {
			 System.out.println(e.getMessage());
		 }
		 
		 try {
			 Connection connection = DriverManager.getConnection(url,username,password);
			 Statement statement=connection.createstatement();
			 String query="select *from student";
			 ResultSet resultset= statement.executeQuery(query);
			 while(resultset.next()) {
				 int id=resultset.getInt("id");
				 String name=resultset.getString("name");
				 int age=resultset.getInt("age");
				 double marks=resultset.getDouble("marks");
				 
				 System.out.println(" id: "+id);
				 System.out.println(" name: "+name);
				 System.out.println(" age: "+age);
				 System.out.println(" marks: "+marks);
				 
			 }
			 
		 }catch(SQLException e) {
			 System.out.println(e.getMessage());
			 }
	 }
	 

}