package com.bridgelabz.oopsprograms;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression 
{
		String firstName;
		String fullName;
		String contactNumber;
		String date;
	 	String message="Hello <<name>>, We have Your Full " +
						"Name as <<full name>> in our system. \nYour "
						+ "contact number is 91-xxxxxxxxxx." 
						+" \nPlease, Let us know in  case  of  any" 
						+" clarification. \nThank you BRIDGELABZ 01/01/2016.";
		
		void start()
		{
			getUserInfo();
			replace("<<name>>",firstName);//REPLACE FIRST NAME...
			replace("<<full name>>",fullName);//REPLACE FULL NAME...
			replace("xxxxxxxxxx",contactNumber);//REPLACE CONTACT NUMBER...
			replace("01/01/2016",date);//REPLACE DATE...
			System.out.println(message);//PRINT UPDATED MESSAGE...
		}
		void getUserInfo() 
		{
			Scanner sc=new Scanner(System.in);
			System.out.print("ENTER YOUR FIRST NAME...");
			firstName=sc.nextLine();
			System.out.print("ENTER YOUR FULL NAME...");
			fullName=sc.nextLine();
			System.out.print("ENTER YOUR CONTACT NUMBER...");
			contactNumber=sc.nextLine();
			System.out.print("ENTER DATE IN DD/MM/YYYY FORMAT...");
			date=sc.nextLine();
			sc.close();
		}
		void replace(String stringToBeReplaced,String replacement) 
		{
			Pattern pattern=Pattern.compile(stringToBeReplaced);//PATTERN
			Matcher matcher=pattern.matcher(message);//MATCHER
			message = matcher.replaceFirst(replacement);
		}
		public static void main(String args[]) 
		{
			RegularExpression reg=new RegularExpression();
			reg.start();
		}
	}
