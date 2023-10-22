create database employeedata;
use employeedata;
create table Employee(id int primary key auto_increment,name varchar(30),salary varchar(10),designation varchar(50));
select * from employee;
insert into Employee(name,salary,designation) values("Aditya","25000","Embedded Developer");
insert into Employee(name,salary,designation) values("Onkar","35000","Cyber Domain");
insert into Employee(name,salary,designation) values("Ratnadeep","45000","JavaDeveloper");
select * from Employee;