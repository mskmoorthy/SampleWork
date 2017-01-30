import java.io.*;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;



public class BST
{


	public static class Animal implements Comparable<Animal>
	{
		public String name = "";
		public Integer count = 0;
		public Animal(String name)
		{
			this.name = name;
		}
		public Animal(String name, Integer count)
		{
			this.name = name;
			this.count = count;
		}
		public int compareTo(Animal e)
		{
			if (name.compareTo(e.name) < 0)
			{
				return -1;
			}
			if (name.compareTo(e.name) == 0)
			{
				return 0;
			}
			else { return 1; }
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		// Step a.
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		// Step b.
		Scanner scanner = new Scanner(new File("animals.txt"));
		while(scanner.hasNext()){
			String temp  = scanner.nextLine();
			try {
				int count = map.get(temp);
				map.put(temp, new Integer(++count));
			}
			catch (Exception e)
			{
				map.put(temp, new Integer(1));
			}

		}

		// Step c.
		ArrayList<Animal> arraylist= new ArrayList<Animal>();
		Integer[] intarray = new Integer[map.size()];
		int count1 = 0;
		for (Integer value: map.values())
		{
			intarray[count1] = value;
			count1++;
		}
		int count2 = 0;
		for (String key: map.keySet())
		{
			Animal tempA = new Animal(key, intarray[count2]);
			arraylist.add(tempA);
			count2++;			
		}


		while (arraylist.size() != 0)
		{
			Animal tempA = arraylist.remove(0);
			System.out.println(tempA.name + " " + tempA.count);
		}
		
	}

}
