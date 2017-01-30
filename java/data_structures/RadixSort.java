import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.NoSuchElementException;
public class RadixSort
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Step 2
		Scanner scanner = new Scanner(new File("radixSortData.txt"));
		ArrayList<String> list = new ArrayList<>();
		while (scanner.hasNext())
		{
			list.add(scanner.next().toString());
		}

		// Step 3
		ArrayBlockingQueue<String>[] queuelist = new ArrayBlockingQueue[10];
		for (int i = 0; i < queuelist.length; i++)
		{
			queuelist[i] = new ArrayBlockingQueue(40);
		}
		
		// Step 4
		step4(queuelist, list, 2);

		// Step 5
		list.clear();

		// Step 6
		step6(queuelist, list);
		

		// Step 7
		step4(queuelist, list, 1);

		// Step 8
		list.clear();

		// Step 9
		step6(queuelist, list);

		// Step 10
		step4(queuelist, list, 0);
		list.clear();
		
		// Step 11
		step6(queuelist, list);

		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + "\n");
		}


		


	}

	public static void step6(ArrayBlockingQueue<String>[] queuelist, ArrayList<String> list)
	{	
		for (int i = 0; i < queuelist.length; i++)
		{
			boolean flag = true;
			while(flag)
			{
				try{	
					String result = queuelist[i].remove();
					list.add(result);
				}catch(NoSuchElementException nsee){
					flag = false;	
				}
			}
		}
	}

	public static void step4(ArrayBlockingQueue<String>[] queuelist, ArrayList<String> list, int index)
	{
	
		for (int i = 0; i < list.size(); i++)
		{
			queuelist[Integer.parseInt((list.get(i)).substring(index,index+1))].add(list.get(i));
		}
	}
}
