package com.bridgelabz.oopsprograms;

public class DoctorsModel 
{
	private String name,specialization,availability;
	private int id;
	Utility utility;
	public DoctorsModel(){
		utility=new Utility();
		System.out.println("Enter Doctors Details ...");

		System.out.print("Enter Name: ");
		this.name=utility.inputWord();
		System.out.println();

		System.out.print("Enter Id: ");
		this.id=utility.inputInteger();
		System.out.println();

		System.out.print("Enter specialization: ");
		this.specialization=utility.inputWord();
		System.out.println();

		System.out.print("Enter availability (1:AM   2:PM  3:both)");
		this.availability=utility.inputWord();
		System.out.println();
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getSpecialization(){
		return specialization;
	}

	public String getAvailability(){
		return availability;
	}

	public String toString()
	{
		return id+"     "+name+"     "+specialization+"     "+availability+"\n";
	}

}
