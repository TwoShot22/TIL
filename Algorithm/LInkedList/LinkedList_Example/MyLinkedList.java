package LinkedList_Example;

public class MyLinkedList {
	class Node{
		String name;
		Node next;

		public Node(String s){
			name = s;
			next = null;
		}
	}

	Node head;

	public MyLinkedList() {
		head = null;
	}
	
	public void add(String name) {
		Node newNode = new Node(name);
		newNode.next = head;
		head = newNode;
	}

	public boolean remove(String name) {
		boolean found = false;
		Node position = head;
		Node previous = null;

		while(position!=null) {
			if (name.equals(position.name)) {
				found = true;
				if (previous == null)
					head = position.next;
				else
					previous.next = position.next;
				position = null;
			} else {
				previous = position;
				position = position.next;
			}
		}
		return found;
	}

	public int size() {
			int count = 0;
			Node position = head;
			while (position != null) {
				count++;
				position = position.next;
			}
		return count;
	}

	public int indexOf(String name) {
		int size = size();
		int count = 0;
		Node position = head;
		while(position!=null){
			count++;
			if(name.equals(position.name))
				return size-count;
			else
				position = position.next;
		}
		return -1;
	}
	
	public String toString() {
		String result = "";
		Node position = head;
		while(position!=null){
			result = result + " -> "+position.name;
			position = position.next;
		}
		return result;
	}
}
