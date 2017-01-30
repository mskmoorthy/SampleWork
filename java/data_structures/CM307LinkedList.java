public class CM307LinkedList<E> implements CM307List<E>
{
	private class Node<E>
	{
		private E data = null;
		private Node<E> next = null;
	}

	private Node<E> head = null;
	private int size = 0;

	public CM307LinkedList()
	{
	}
	
	public void add(E e)
	{
		if (e == null) { return; }
		size++;
		head = addRecur(head, e);
		return;
	}

	public Node<E> addRecur(Node<E> head, E e)
	{
		if (head == null)
		{
			Node<E> newNode = new Node<E>();
			newNode.data = e;
			return newNode;
		}
		else
		{
			head.next = addRecur(head.next, e);
			return head;
		}
	}


	/*
	public void add(E e)
	{
		Node<E> newNode = new Node<E>();
		newNode.data = e;
		newNode.next = null;
		Node<E> cur = head;
		if (cur == null)
		{
			head = newNode;

		}
		else
		{
			while(cur.next != null)
			{
				cur = cur.next;
			}
			cur.next = newNode;
		}
		size++;
	}
	*/
	

	
	public boolean insert(int n, E e)
	{
		if (n < 0 || n > size)
		{
			return false;
		}
		size++;
		head = insertRecur(head, n, e);
		return true;
	}

	public Node<E> insertRecur(Node<E> head, int index, E e)
	{
		if (index == 0)
		{
			Node<E> newNode = new Node<E>();
			newNode.data = e;
			newNode.next = head;
			return newNode;
		}
		head.next =  insertRecur(head.next, index - 1, e);
		return head;
	}
		

	/*
	public boolean insert(int n, E e)
	{
		if (n < 0 || n > size)
		{
			return false;
		}
		Node<E> newNode = new Node<E>();
		newNode.data = e;
		if (n == 0)
		{
			newNode.next = head;
			head = newNode;
		}
		else
		{
			Node<E> prev = head;
			for (int i = 0; i < n-1; i++)
			{
				prev = prev.next;
			}
			newNode.next = prev.next;
			prev.next = newNode;
		}
		size++;
		return true;
	}
	*/
	

	public E get(int n)
	{
		if (n < 0 || n > size)
		{
			return null;
		}
		return getRecur(head, 0, n);
	}

	public E getRecur(Node<E> head, int counter, int index)
	{
		if (head == null)
		{
			return null;
		}
		else if (index == counter)
		{
			E temp = head.data;
			return temp;
		}
		else
		{
			counter++;
			return getRecur(head.next, counter, index);
		}
	}

	/*
	public E get(int n)
	{
		if (n < 0 || n >= size)
		{
			return null;
		}
		Node<E> cur = head;
		for (int i = 0; i < n; i++)
		{
			cur = cur.next
		}
		return cur.data;
	}

	*/

	
	public E remove(int n)
	{
		if (n < 0 || n >= size)
		{
			return null;
		}
		E data;
		if (n == 0)
		{
			data = head.data;
			head = head.next;
		}
		else
		{
			Node<E> prev = head;
			for (int i = 0; i < n-1; i++)
			{
				prev = prev.next;
			}
			data = prev.next.data;
			prev.next = prev.next.next;
		}
		size--;
		return data;
	}


	public boolean isEmpty()
	{
		return size == 0;
	}

	public int size()
	{
		return size;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("List has " + size + " elements:\n[");
		StringBuilder sb2 = new StringBuilder();
		sb.append(toStringRecur(head, sb2));
		sb.append("]");
		return sb.toString();
			
	}

	public String toStringRecur(Node<E> head, StringBuilder s)
	{
		if (head == null)
		{
			
			return s.toString();
		}
		else
		{
			s.append(head.data + ",");
			toStringRecur(head.next, s);
		}
		
		return s.toString();
	}
}
