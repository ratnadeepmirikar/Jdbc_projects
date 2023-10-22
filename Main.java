package com.eb.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.eb.DAO.EmployeeDao;
import com.eb.pojo.Employee;

public class Main
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello User Please Enter Your Name:\n");
		String name=sc.next();
		System.out.println("Welcome To Employee Management System,"+name);
		
		int ch;
		
		do 
		{
			System.out.println("Press 1 to Add Employee");
			System.out.println("Press 2 to Delete Employee");
			System.out.println("Press 3 to Display Employee");
			System.out.println("Press 4 to Update Employee");
			System.out.println("Press 5 to Exit");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				// add Employee
				System.out.println("Enter Employee Name:");
				String ename=sc.next();
				System.out.println("Enter Employee Salary:");
				String salary=sc.next();
				System.out.println("Enter Employee Designation:");
				String designation=sc.next();
				//create Employee object
				Employee s= new Employee(ename,salary,designation);
				boolean ans=EmployeeDao.insertrecords(s);
				if(ans) 
				{
					System.out.println("Records Added Succesfully");
					System.out.println("Student Record"+s);
				}else
				{
					System.out.println("Some Error Occuring while Adding...try again");
				}
				break;
			case 2:
				//delete student
				System.out.println("Enter Employee Id to Delete:");
				int employeeId=sc.nextInt();
				boolean f=EmployeeDao.deleterecords(employeeId);
				if (f)
				{
					System.out.println("Employee of Id"+employeeId+"Record Deleted");
				}else 
				{
					System.out.println("Something Went Wrong......");
				}
				break;
			case 3:
				//Display Student
				EmployeeDao.showrecords();
				break;
			case 4:
				//update student
				System.out.println("PRESS 1 to UPDATE Name");
				System.out.println("PRESS 2 to UPDATE Salary");
				System.out.println("PRESS 3 to UPDATE Designation");
				int val = sc.nextInt();
				if(val == 1) 
				{
				//Update Name
				System.out.println("Enter Name to UPDATE...");
				name = sc.next();
				System.out.println("Enter ID to identify Employee!");
				int id = sc.nextInt();;
				Employee st1 = new Employee();
				st1.setName(name);
				f = EmployeeDao.updateRecords(val,name,id,st1);
				if(f)
				{
				System.out.println("Student Name Updated Successfully...");
				}else
				{
				System.out.println("Something Went Wrong Please try Again!");
				}
				}
				else if(val == 2) 
				{
				//Update Phone
				System.out.println("Enter Salary to UPDATE...");
				salary= sc.next();
				System.out.println("Enter ID to identify Employee!");
				int id = Integer.parseInt(sc.next());
				Employee st2 = new Employee();
				st2.setSalary(salary);
				f = EmployeeDao.updateRecords(val,salary,id,st2);
				if(f) 
				{
				System.out.println("Student salary Updated Successfully...");
				}else
				{
				System.out.println("Something Went Wrong Please try Again!");
				}
				}
				else if(val == 3)
				{
				//Update city
				System.out.println("Enter Designation to UPDATE...");
				designation = sc.next();
				System.out.println("Enter ID to identify Employee!");
				int id = Integer.parseInt(sc.next());
				Employee st3 = new Employee();
				st3.setDesignation(designation);
				f = EmployeeDao.updateRecords(val,designation,id,st3);
				if(f)
				{
				System.out.println("Employee Designation Updated Successfully...");
				}else
				{
				System.out.println("Something Went Wrong Please try Again!");
				}
				}
				else 
				{
				System.out.println("Hey You have not updated Anything... Please choose option Correctly!");
				}
				break;
			case 5:
				//exit
				System.out.println("Thanks for using this application....see you again");
				break;
				default:
					System.out.println("Please press valid choice");

			}
			
			
			}while(ch!=5);
			
		


		}

}
