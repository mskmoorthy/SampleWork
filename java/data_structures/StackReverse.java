import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class StackReverse 
{
	

	public static void main(String[] args) throws FileNotFoundException
	{
		Integer[] array;
		Scanner scanner = new Scanner(new File("linkedArray.txt"));
		ArrayList<Integer> arrayList = new ArrayList<>();
		while(scanner.hasNext())
		{
			String temp = scanner.next();
			Integer temp2 = Integer.parseInt(temp);
			arrayList.add(temp2);
		}
		scanner.close();
		array = arrayList.toArray(new Integer[0]);	
		System.out.println(java.util.Arrays.toString(array));
		int size = array.length;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		int k = 0;
		while (k != -1)
		{
			stack.push(k);
			stack2.push(k);
			k = array[k];
		
		}
		int result = stack2.pop();
		while (result != 0)
		{
			System.out.println(result);
			result = stack2.pop();
		}
		int[] array2 = new int[size];
		int peek = stack.peek();
		while (peek > 0)
		{
			array2[peek] = stack.pop();
			peek = array2[peek];
		}
	
		System.out.println(java.util.Arrays.toString(array2));

		for (int i = 0; i < array2.length; i++)
		{
			System.out.println(i + " " + array2[i]);
		}
	}

}
