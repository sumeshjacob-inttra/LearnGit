package com.sumesh.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Duplicates
{
	private static String[] inputData = { "a", "b", "c", "d", "a", "c", "e", "f", "b" };

	public static void main(String[] args)
	{
		readUserInput();

		if (null != inputData && inputData.length > 0)
		{
			Set<String> uniqueElements = new HashSet<String>();
			Map<String, Integer> duplicates = new HashMap<String, Integer>();
			for (String data : inputData)
			{
				if (uniqueElements.contains(data))
				{
					if (null == duplicates.get(data))
					{
						duplicates.put(data, 2);
					}
					else
					{
						duplicates.put(data, (duplicates.get(data) + 1));
					}
				}
				else
				{
					uniqueElements.add(data);
				}
			}
			uniqueElements.removeAll(duplicates.keySet());

			displayOutput(uniqueElements, duplicates);
		}
	}

	private static void displayOutput(Set<String> uniqueElements, Map<String, Integer> duplicates)
	{
		System.out.println("-------- Results after processing --------");
		System.out.println(" Input Data : " + Arrays.toString(inputData));
		System.out.print(" Unique elements : ");
		for (String data : uniqueElements)
		{
			System.out.print(" " + data);
		}
		System.out.println(" \n Duplicate elements : ");
		for (String data : duplicates.keySet())
		{
			System.out.print(" " + data + " had " + duplicates.get(data) + " occurances \n");
		}
	}

	/**
	 * Read the data from user based on user preference
	 */
	private static void readUserInput()
	{
		System.out.println("Do you want to input your data (Y/N)?");

		Scanner consoleSCanner = new Scanner(System.in);
		String userResponse = consoleSCanner.nextLine();

		if ("Y".equalsIgnoreCase(userResponse))
		{
			System.out.println("Enter the size of sample data : ");
			String dataSizeStr = consoleSCanner.nextLine();
			Integer dataSize = 0;
			try
			{
				dataSize = Integer.parseInt(dataSizeStr);
				inputData = new String[dataSize];
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid numeric input");
			}

			for (int i = 0; i < dataSize; i++)
			{
				System.out.println("Enter entry " + (i + 1 + ": "));
				inputData[i] = consoleSCanner.nextLine();
			}

		}
		consoleSCanner.close();
	}
}
