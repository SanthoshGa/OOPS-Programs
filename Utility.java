package com.bridgelabz.oopsprograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Utility 
{
	BufferedReader bufferedReader,br;
	public Utility()
	{
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	//take input word
	public String inputWord()
	{
		try
		{
			return bufferedReader.readLine();
		}
		catch(IOException exception)
		{
			System.out.println(exception.getMessage());
		}
		return "";
	}

	//Take Integer Input
	public int inputInteger()
	{
		 
			try
			{
				try
				{	
					return Integer.parseInt(bufferedReader.readLine());
				}
				catch(NumberFormatException exception)
				{
					System.out.println(exception.getMessage());	
				}
			}
			catch(IOException exception)
			{
				System.out.println(exception.getMessage());
			}
		return 0;
	}

	public ArrayList<Stock> getStockDetails(String fileName)
	{
		ArrayList<Stock> stockList=new ArrayList<Stock>();
		try
		{
			br=new BufferedReader(new FileReader(fileName));
			StringBuilder sb=new StringBuilder();
			String line=br.readLine();
			while(line!=null)
			{
				System.out.println();
				System.out.println(line);
				stockList.add(new Stock(line, 0, 0));
				line=br.readLine();
			}
			return stockList;
		 }
		catch(Exception exception)
		{
			return null;
		}
		finally
		{
			try
			{
				br.close();
			}
			catch(IOException exception){
			}	
		}
	}

	//Function take String in dd/MM/yyyy format and return Date Object
	public Date stringToDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			return sdf.parse(date);
		}
		catch(ParseException parseException)
		{
			return null;
		}
	}
	public void printMap(Map mp) 
	{
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) 
		{
    		Map.Entry pair = (Map.Entry)it.next();
    		System.out.println(pair.getKey() + " = " + pair.getValue());
		}

}
}
