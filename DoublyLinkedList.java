public class DoublyLinkedList<T> implements List<T> {
	private Node head, tail;
	private int numberOfElements;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}
	
	@Override
	public void addLast(T item) {
		Node newnode = new Node(item);
		if (isEmpty()) {
			head = newnode;
			tail = newnode;
		} 
		else {
			newnode.previous = tail;
			tail.next = newnode;
			tail = newnode;
		}
		numberOfElements++;
	}

	@Override
	public void addFirst(T item) {
		Node newnode = new Node(item);
		if (isEmpty()) {
			head = newnode;
			tail = newnode;
		} 
		else {
			newnode.next = head;
			head.previous = newnode;
			head = newnode;
		}
		numberOfElements++;
		
			
	}

	@Override
	public T get(int position) {
		if (position < 0 || position >= numberOfElements) {
			
		return null; }
		Node current = head;
		
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current.data;
	}

	@Override
	public void print() {
		Node current = head;

        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }

        System.out.println();
				
	}

	@Override
	public void printBackwards() {
		Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            current = current.previous;
        }
        System.out.println(); 
			
	}

	@Override
	public boolean remove(T item) {
		Node current = head;

		while (current != null) {
			if (current.data.equals(item)) {   //node found 

			   if (current.previous != null) {
				current.previous.next = current.next;
				} 
				else {
					head = current.next; //remove head
				}


				if (current.next != null) {
					current.next.previous = current.previous;
				} 
				else {
					tail = current.previous; //remove tail
				}
				numberOfElements--;  //minus one element
				return true; 
			}
			current = current.next;  //still lookin for node
		}
	
		return false;  //item not found
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
		 
	}

	@Override
	public int getLength() { 
	    return numberOfElements;
	}
	
	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next, previous;

		private Node(T data) {
			this(data,null,null);
		}

		private Node (T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
	}


}

