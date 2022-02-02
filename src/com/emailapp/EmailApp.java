package com.emailapp;
import java.util.*;
public class EmailApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First Name");
		String fname = sc.next();
		System.out.println("Enter last name");
		String lname = sc.next();
		
		Email e1 = new Email(fname,lname);
		int choice = -1;
		do {
			
			System.out.println("\n********\nEnter your choice \n1.Show Info \n2.Change Password \n3.Set Alternate Mail \n4.Store Data In file \n5.Display Data from File \n6.Exit");
			choice = sc.nextInt();
			switch(choice) {
			
			case 1 : e1.get_Info();
					 break;
			case 2 : e1.set_password();
					break;
			case 3 : e1.alternate_email();
					 break;
			case 4 : e1.storeFile();
					 break;
			case 5 : e1.read_file();
					 break;
			case 6 : System.out.println("Thank You");
					 break;
			default :
					System.out.println("Enter correct choice");
			}
		}while(choice!=6);
		
	}
}
