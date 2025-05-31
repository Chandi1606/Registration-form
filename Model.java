package assign_pro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Model {
	
	private String url = "jdbc:mysql://localhost:3306/college1";
	private String userName = "root";
	private String password = "chandi@1606";
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String usn = null;
	String name = null;
	int marks1 = 0;
	int marks2 = 0;
	int marks3 = 0;
	float percentage = 0.0f;
	
	int num = 0;	
	
	public Model() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public void saveRecord() {
		try {
			pstmt = con.prepareStatement("INSERT INTO student2 VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, usn);
			pstmt.setString(2, name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			pstmt.setFloat(6, percentage);
			
			int num = pstmt.executeUpdate();
			setNum(num);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeConnection() {
		try {
			con.close();
			pstmt.close();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
