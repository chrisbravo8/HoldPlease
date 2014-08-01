package cbravo_HoldPlease;

import java.util.Iterator;

import edu.neumont.util.List;

public class ArrayList<T> implements List<T> {
	final int INITIAL_SIZE = 10;
	int size = INITIAL_SIZE;
	Object[] array = new Object[size];

	int location = 0;
	
	@Override
	public Iterator<T> iterator() {
		return new arrayIterator(array);
	}

	@Override
	public boolean add(T t) {
		if(array.length<size-1){
			array[location] = t;
			location++;
		}
		else{
			size = size*2;
			Object[] array2 = new Object[size];
			for(int i = 0;i<array.length; i++){
				 array2 [i] = array[i];
			}
			array=array2;
			array[location] = t;
			location++;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T)array[index];
	}

	@Override
	public boolean remove(T t) {
		int i = 0;
		for(Object o: array){
			if(o.equals(t)){
				array[i]=null;
				for(int j = i; j<array.length-1; j++){
					
					Object temp = array[j+1];

					array[j] = temp;
					
				}
				return true;
			}
			i++;
		}
		
		return false;
	}

	@Override
	public int size() {
		int i = 0;
		for(Object o : array){
			if(o!=null)
			i++;
		}
		return i;
	}
	
	private class arrayIterator implements Iterator<T> {
		
		int location = 0;
		Object[] array;
		arrayIterator(Object[] o){
			array = o;
		}
		
		@Override
		public boolean hasNext() {
			return(array[location]!=null);
		}

		@Override
		public T next() {
			@SuppressWarnings("unchecked")
			T t = (T) array[location];
			location++;
			return t;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}
	
}
