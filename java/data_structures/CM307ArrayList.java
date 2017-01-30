public class CM307ArrayList<E> implements CM307List<E>
{
	private E[] data;
	private int size = 0;
	public static final int CAPACITY = 20;

	@SuppressWarnings("unchecked")
	public CM307ArrayList()
	{
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public CM307ArrayList(int capacity)
	{
		data = (E[]) new Object[capacity];
	}

	public void add(E e)
	{
		if (size == data.length)
		{
			reallocate();
		}
		data[size] = e;
		size++;
	}

	public boolean insert(int n, E e) throws IndexOutOfBoundsException
	{
		if (n < 0 || n >= size + 1)
		{
			return false;
		}
		if (e == null)
		{
			return false;
		}
		if (size == data.length)
		{
			reallocate();
		}
		for (int k = size - 1; k >= n; k--)
		{
			data[k+1] = data[k];
		}
		data[n] = e;
		size++;
		return true;
	}


	public E get(int n)
	{
		if (n < 0 || n >= size)
		{
			return null;
		}
		return data[n];
	}

	public E remove(int n)
	{
		if (n < 0 || n >= size)
		{
			return null;
		}
		E temp = data[n];
		for (int k = n; k < size-1; k++)
		{
			data[k] = data[k+1];
		}
		data[size-1]= null;
		size--;
		return temp;
	}


	public boolean isEmpty() { return size == 0; }

	public int size() { return size; }

	@SuppressWarnings("unchecked")
	public void reallocate()
	{
		E[] newArray = (E[]) new Object[size * 2];
		for (int i = 0; i < size; i++)
		{
			newArray[i] = data[i];
		}
		data = newArray;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("List has " + size  + " elements:\n");
		sb.append("[");
		for (int i = 0; i < size; i++)
		{
			if (i < size - 1) { sb.append(data[i] + ","); }
			else { sb.append(data[i]); }
		}
		sb.append("]");
		return sb.toString();
	}

}
