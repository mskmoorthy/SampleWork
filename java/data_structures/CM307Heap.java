@SuppressWarnings("unchecked")
public class CM307Heap<E extends Comparable<E>>
{
	private E[] heap = (E[]) new Comparable[50];
	private int size = 0;
	public void enqueue(E data)
	{
		if (size > heap.length + 1) { reallocate(); }
		heap[size] = data;
		size++;
		reheapUp(size - 1);
	}
	public void reheapUp(int n)
	{
		if (n == 0) { return; }
		int p = (n - 1) / 2;
		if (heap[n].compareTo(heap[p]) < 0)
		{
			E temp = heap[n];
			heap[n] = heap[p];
			heap[p] = temp;
			reheapUp(p);
		}
	}
	public E dequeue()
	{
		E data = heap[0];
		heap[0] = heap[size - 1];
		size--;
		reheapDown(0);
		return data;
	}

	private void reheapDown(int n)
	{
		if (n >= size) { return; }
		int left = 2 *n + 1;
		int right = 2 * n + 2;
		// leaf
		if (left >= size) { return; }
		// only left child
		else if (right >= size)
		{
			if(heap[left].compareTo(heap[n]) < 0)
			{
				E temp = heap[n];
				heap[n] = heap[left];
				heap[left] = temp;
			}
		}
		// has two children
		else
		{
			if (heap[n].compareTo(heap[left]) > 0 || heap[n].compareTo(heap[right]) > 0)
			{
				if (heap[left].compareTo(heap[right]) < 0 )
				{
					E temp = heap[n];
					heap[n] = heap[left];
					heap[left] = temp;
					reheapDown(left);
				}
				else
				{
					E temp = heap[n];
					heap[n] = heap[right];
					heap[right] = temp;
					reheapDown(right);
				}
			}
		}
	}

	public void reallocate()
	{
		E[] newarray = (E[]) new Object[heap.length * 2];
		for (int i = 0; i < heap.length; i++)
		{
			newarray[i] = heap[i];
		}
		heap = newarray;
	}

	public static void main(String[] args)
	{
		// Step a.
		CM307Heap<String> heap = new CM307Heap<String>();
		heap.enqueue("a");
		heap.enqueue("carafe");
		heap.enqueue("that");
		heap.enqueue("is");
		heap.enqueue("a");
		heap.enqueue("blind");
		heap.enqueue("glass");
		heap.enqueue("a");
		heap.enqueue("kind");
		heap.enqueue("in");
		heap.enqueue("glass");
		heap.enqueue("and");
		heap.enqueue("a");
		heap.enqueue("cousin");
		for (int i = 0; i < 14; i++)
		{
			System.out.println(heap.dequeue());
		}

		// Step b.
		CM307Heap<Integer> intheap = new CM307Heap<Integer>();
		intheap.enqueue(1);
		intheap.enqueue(10);
		intheap.enqueue(100);
		intheap.enqueue(1000);
		intheap.enqueue(2);
		intheap.enqueue(20);
		intheap.enqueue(200);
		intheap.enqueue(2000);
		intheap.enqueue(3);
		intheap.enqueue(30);
		intheap.enqueue(300);
		intheap.enqueue(3000);
		for (int i = 0; i < 12; i++)
		{
			System.out.println(intheap.dequeue());
		}
	}
}
