package com.eb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eb.db.CP;
import com.eb.pojo.Employee;

public class EmployeeDao {
	public static boolean insertrecords(Employee em) {
		boolean f=false;
		
			Connection con;
			try {
				con = CP.createconnection();
				String query="insert into Employee(name,salary,designation) values(?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1,em.getName());
				pstmt.setString(2,em.getSalary());
				pstmt.setString(3,em.getDesignation());
				pstmt.executeUpdate();
				f=true;
			} catch (Exception e) {
				System.out.println(e);
				
			}
		return f;
		
	}
	
	public static void showrecords() throws ClassNotFoundException, SQLException {
		try {
		Connection conn=CP.createconnection();
		String query="select * from Employee";
		Statement stmt=conn.createStatement();
		ResultSet set=stmt.executeQuery(query);
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String salary=set.getString(3);
			String designation=set.getString(4);
			System.out.println("Employee Id:"+id+"\nEmployee Name:"+name+"\nEmployee Salary:"+salary+"\nDesignation:"+designation);
			System.out.println("-----------------------------------------------------");
		}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	public static boolean deleterecords(int employeeid) {
		boolean f=false;
		try {
			Connection conn=CP.createconnection();
			String query="delete from Employee where id=?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, employeeid);
			pstmt.executeUpdate();
			f=true;
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return f;
		
	}
	
	public static boolean updateRecords(int val,String toUpdate,int id,Employee em) throws ClassNotFoundException, SQLException {
		Connection con=CP.createconnection();
		boolean f=false;
		try {
			if(val==1){//update name 
				String query="update Employee set name=? where id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				f=true;
				
			}
			if(val==2){//update salary 
				String query="update Employee set salary=? where id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				f=true;
			
			
		}
			if(val==3){//update Designation
				String query="update Employee set designation=? where id=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, toUpdate);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();
				f=true;
			}
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
		return f;
 }
	

}
