package com.bridgelabz.oopsprograms;

import java.io.File;
import java.util.Scanner;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class InventoryManagement 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String Path = "C:\\Users\\Admin\\Desktop\\JsonFiles\\inventory.json";
		File file = new File(Path);
		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			int num;
			JsonNode rootNode = mapper.readTree(file);
			do 
			{
				System.out.println("Enter the Choice: ");
				System.out.println(" 1 for Rice" + "\n 2 for Wheat" + "\n 3 for Pulses");
				num = sc.nextInt();
			} 
			while (num < 0 || num > 4);
			{
				String Inventoryproduct = "";
				switch (num) 
				{
					case 1:
							Inventoryproduct = "Rice";
							break;
					case 2:
							Inventoryproduct = "Wheat";
							break;
					case 3:
							Inventoryproduct = "Pulses";
							break;
					default:
							System.out.println("Invalid Input");
				}
				JsonNode inventory = rootNode.path(Inventoryproduct);	//reading the entered choice
				for (JsonNode node : inventory) 
				{
					String name = node.path("name").asText();
					int weight = node.path("weight").asInt();
					int price = node.path("price").asInt();
					
					System.out.println("Name: " + name + "\nPrice: " + price + "\nWeight: " + weight);
					System.out.println("Total: " + price * weight + " Rs" + "\n");
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println("" + e.getMessage());
			e.printStackTrace();
			
		}
		sc.close();
	}
			
}
