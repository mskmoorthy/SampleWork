import java.util.ArrayList;

public class CM307HashMap
{
	private String[] keys;
	private Object[] objects;

	public CM307HashMap()
	{
		keys = new String[100];
		objects = new Object[100];
	}

	public void put(String key, Object object)
	{	
		int hashValue = key.hashCode();
		hashValue = Math.abs(hashValue);
		hashValue = hashValue % 100;
		int initial = hashValue;
		while(true)
		{
			if (keys[hashValue] == null)
			{
				keys[hashValue] = key;
				objects[hashValue] = object;
				return;
			}
			else
			{
				boolean check = key.equals(keys[hashValue]);
				if (check == true)
				{
					objects[hashValue] = object;
					return;
				}
			}
			hashValue = (hashValue + 1) % 100;
			// Infinite Loop Check
			if (hashValue == initial) { return; }
		}
	

	}

	public Object get(String key)
	{
		int hashValue = key.hashCode();
		hashValue = Math.abs(hashValue);
		hashValue = hashValue % 100;
		int initial = hashValue;
		while(true)
		{
			if (keys[hashValue] == null) { return null; }
			boolean matches = key.equals(keys[hashValue]);
			if (matches == true)
			{
				return objects[hashValue];
			}
			else
			{
				hashValue = (hashValue + 1) % 100;
				// Infinite Loop check
				if (hashValue == initial) { return null; }
				
			}
		}
	}

	public void printObjects()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.print(i + " ");
			System.out.println(keys[i]==null?"null":(keys[i] + " " + objects[i]));
		}
	}
}
