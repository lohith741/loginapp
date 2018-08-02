package net.codejava.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="database")
public class Database {

	private String name;
	private int enrollment;
	private String branch;
	private int sem;
	private String gender;
	private String dob;
    private String resume;

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getEnrollment() {
		return enrollment;
	}



	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public int getSem() {
		return sem;
	}



	public void setSem(int sem) {
		this.sem = sem;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getResume() {
		return resume;
	}



	public void setResume(String resume) {
		this.resume = resume;
	}



	public String add() throws ClassNotFoundException  {
		int i=0;
		String url = "jdbc:mysql://localhost:3306/studentinfo";
		String user = "root";
		String password = "mysql";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO data values (?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, getName());

			statement.setInt(2, getEnrollment());

			statement.setString(3, getBranch());

			statement.setInt(4, getSem());

			statement.setString(5, getGender());

			statement.setString(6, getDob());

			InputStream inputStream = new FileInputStream(new File(getResume()));

			statement.setBlob(7, inputStream);
			
			i = statement.executeUpdate();

			conn.close();
			statement.close();
			}	
			catch (SQLException ex) {
			ex.printStackTrace();
		} 
			catch (IOException ex) {
			ex.printStackTrace();
		}
		
			
			if (i > 0) {
				return "Done";
			}
			else{
				return "error";
			}
			
	}	
	
}