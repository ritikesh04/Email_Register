package com.emailapp;

import java.util.*;
import java.io.*;

public class Email {

	public Scanner sc =  new Scanner(System.in); 
	
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alter_email;
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMailCapacity() {
		return mailCapacity;
	}
	public void setMailCapacity(int mailCapacity) {
		this.mailCapacity = mailCapacity;
	}
	public String getAlter_email() {
		return alter_email;
	}
	public void setAlter_email(String alter_email) {
		this.alter_email = alter_email;
	}
	
	
	public Email(String fname,String lname) {
		this.fname = fname;
		this.lname = lname;
		System.out.println("New Employee: " +this.fname+ " - " +this.lname);
		this.dept = setDepartment();
		this.email = generate_email();
		this.password = generate_password(10);
		
	}
		
	
	//Generate Mail Method
	private String generate_email() {
		String mail = this.fname.toLowerCase()+"."+this.lname.toLowerCase()+ "@" +this.dept.toLowerCase()+ ".company.com";
		return mail;
	}
	
	
	
	private String setDepartment() {
		System.out.println("Department Codes \n1 for Sales \n2 for Development \n3 for Accounts");
		boolean flag = false;
		do {
			System.out.println("Enter the department code");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				return "Sales";
				
			case 2 :
				return "Development";
			
			case 3 : 
				return "Accounting";
			
			case 0 : 
				return "None";
			
			default :
				System.out.println("Enter correct Choice");
			}
		}while(!flag);
		return null; 
			
	}
	
	private String generate_password(int length){
		
		Random r= new Random();
		String Capital_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%&?";;
		String values = Capital_char + Small_chars + numbers + symbols;
		String password = "";
		for(int i=0;i<length;i++) {
			
			password = password + values.charAt(r.nextInt(values.length()));
		}
			
		return password;
	}
	
	
	public void set_password() {
		boolean flag = false;
		do {
			
			System.out.println("Do you want to change the password(Y/N)");
			char ch = sc.next().charAt(0);
			if(ch == 'Y' || ch == 'y') {
				flag = true;
				System.out.println("Enter the current password");
				String temp = sc.next();
				if(temp.equals(password)) {
					System.out.println("Enter new password");
					setPassword(sc.next());
					System.out.println("Password Changed Success");
				}else {
					System.out.println("The current  password entered is wrong ");
				}
			
			}
			else if(ch == 'N' || ch == 'n') {
				flag = true;

				System.out.println("Password Not changed");
			}
			
			
		}while(!flag);
		
	}
	
	public void  alternate_email() {
		System.out.println("Enter the alternate mail");
		String alt_mail = sc.next();
		setAlter_email(alt_mail);
		System.out.println("Your alternate mail is : " +alt_mail);
		
	}
	
	
	public void get_Info() {
		System.out.println("Name :" +getFname()+ " " +getLname());
		System.out.println("Department :" +getDept());
		System.out.println("Email : " +getEmail());
		System.out.println("Password :" +getPassword());
		System.out.println("Alternate Password :" +getAlter_email());
		
	}
	
		
	public void storeFile() {
		try {
			
			FileWriter in = new FileWriter("C:\\Users\\ritik\\Desktop\\Ritikes\\email.txt");
			in.write("First Name :" +this.fname);
			in.append("\nLast Name :" +this.lname);
			in.append("\nEmail :" +this.email);
			in.append("\nPassword : " +this.password);
			in.append("\nAlternate Mail :" +this.alter_email);
			in.close();
			System.out.println("Data Stored");
			
		} catch (Exception e) {	
				System.out.println(e);
		}
			
	}
	
	public void read_file() {
		try {
			FileReader fr = new FileReader("C:\\Users\\ritik\\Desktop\\Ritikes\\email.txt");
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			//System.out.println();
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
