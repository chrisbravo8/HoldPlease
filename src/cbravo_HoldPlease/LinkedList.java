package cbravo_HoldPlease;

import java.util.Iterator;

import edu.neumont.util.Queue;

public class LinkedList<T> implements Queue<T> {
	Node<T> first;

	public Iterator<T> iterator() {
		return new nodeIterator(first);
	}

	public T poll() {
		T value = first.getValue();
		first = first.getChild();
		return value;
	}

	public boolean offer(T t) {

		Node offeredValue = new Node(t);
		Node current = first;
		
		while (current.getChild() != null) {
			current = current.getChild();
        }
		current.setChild(offeredValue);
		return true;
	}

	public T peek() {
		return first.getValue();
	}
	
	

	private class nodeIterator implements Iterator<T> {

		Node<T> currentNode;

		nodeIterator(Node<T> first) {
			currentNode = first;
		}

		@Override
		public boolean hasNext() {
			return (currentNode.getChild() != null);
		}

		@Override
		public T next() {
			T value = first.getChild().getValue();
			first = first.getChild();
			return value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}
