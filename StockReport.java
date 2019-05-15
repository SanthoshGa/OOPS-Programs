package com.bridgelabz.oopsprograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

public class StockReport 
{
	private List<StockReport_Program> stacks;

	public List<StockReport_Program> getStocks() 
	{
		return stacks;
	}

	public void setStocks(List<StockReport_Program> stacks)
	{
		this.stacks = stacks;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the number of users to store");
		int n;
		n = sc2.nextInt();

		try
		{
			ObjectMapper mapper = new ObjectMapper();
			List<StockReport_Program> stocks = new ArrayList();

			for (int i = 0; i < n; i++) 
			{							
				System.out.println("Enter the user name");
				String name = sc.nextLine();

				System.out.println("Enter the company name");
				String company = sc.nextLine();

				System.out.println("Enter the Symbol of company");
				String symbol = sc.nextLine();

				System.out.println("Enter the number of shares");
				int shares = sc1.nextInt();

				System.out.println("Enter the price");
				int price = sc1.nextInt();

				int totalprice = shares * price;
				System.out.println("The total price is:" + totalprice);
				System.out.println("Done");
				System.out.println();

				StockReport_Program stk = new StockReport_Program();
				stk.setName(name);
				stk.setCompany(company);
				stk.setSymbol(symbol);
				stk.setShares(shares);
				stk.setPrice(price);
				stk.setTotalprice(totalprice);
				stocks.add(stk);

			}
			mapper.writeValue(new File("C:\\Users\\Admin\\Desktop\\JsonFiles\\StockReport.json"), stocks);

			StockReport st = new StockReport();
			st.setStocks(stocks);

			for (StockReport_Program s : st.getStocks()) 
			{
				System.out.println("User Name:" + s.getName() + "\nCompany Name:" + s.getCompany() + "\nCompany Symbol:"
						+ s.getSymbol() + "\nShares:" + s.getShares() + "\nPrice:" + s.getPrice() + "\nTotal Price:"
						+ s.getTotalprice() + "\n");
			}
			sc.close();
			sc1.close();
			sc2.close();
		} 
		catch (IOException e)
		{
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}

	}
}
