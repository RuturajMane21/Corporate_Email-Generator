package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultpasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//constructor
	public Email(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		//System.out.println("Email Created: " + this.firstname +" " + this.lastname);
		
		//Call a methd asking for dept -return the dept
		this.department = setDepartment();
		//System.out.println("Department: "+this.department);
		
		//Call a method that returns random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("your Password is: "+this.password);
		
		//Combine elements to generate email
		email = firstname.toLowerCase() + "."+lastname.toLowerCase()+"@"+department+"." + companySuffix;
		System.out.println("Your email is: "+email);
	}
	
	//Ask for department
	private String setDepartment() {
		System.out.println("\nNew Worker:"+firstname+"\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the Department");
		Scanner sc=new Scanner(System.in);
		int depChoice = sc.nextInt();
		if(depChoice == 1) {return "Sales";	}
		else if(depChoice == 2) {return "Dev"; }
		else if(depChoice == 3) {return "Acc"; }
		else {return "";}
	}
	//Generate Random Pass
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set  mailbox capacity
	public  void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "\nDisplay name: "+firstname +" "+lastname+"\nCompany Emil: "+email+"\nMailbox Capacity:"+mailboxCapacity+"mb";
	}
	
}
