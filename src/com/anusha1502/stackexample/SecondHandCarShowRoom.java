package com.anusha1502.stackexample;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SecondHandCarShowRoom
{
	private void SelectACar() throws FileNotFoundException, IOException, ParseException
	{
		Stack<Map> carDetails=new Stack<>();
		Scanner scan=new Scanner(System.in);
		JSONParser parser=new JSONParser();
		JSONObject jsonObj=(JSONObject)parser.parse(new FileReader("C:\\Anusha\\BikeDetailsStackUse\\carDetails.json"));
		Map<String,Object> brands=(Map)jsonObj;
		
		System.out.println(brands);
		carDetails.push((Map)brands.get("CarBrands"));
		do {
			System.out.println("Car Brands:");
			showTheCarDetails(carDetails.peek());
			//System.out.println(carDetails.peek());
			
			System.out.println("0 go to back");
			System.out.println("-1 exit");
			int choice=scan.nextInt();
			if(choice==0)
			{
				if(carDetails.size()>1)
				{
					carDetails.pop();
				}
				continue;
			}
			else if(choice==-1)
			{
				System.out.println("Thank You...");
				break;
			}
			else
			{
				if(choice<=carDetails.peek().size())
				{
					carDetails.push((Map<String,String>)brands.get(carDetails.peek().get(choice+"")));
				}
				else
				{
					System.out.println("Enter a Valid Input");
				}
			}
		}while(true);
		
	}
	private void showTheCarDetails(Object values)
	{
		Map<String,Object> details=(Map)values;
		for(Map.Entry<String,Object> map:details.entrySet())
		{
			System.out.println(map.getKey()+":"+map.getValue());
		}
	}
	
	//private void showTheCarDetails(Map peek) {
		// TODO Auto-generated method stub
		
	//}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SecondHandCarShowRoom obj=new SecondHandCarShowRoom();
		try {
			obj.SelectACar();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JSONObject obj = new JSONObject(); 
//		Stack<Car> carStack=new Stack<>();
	}
	
}
