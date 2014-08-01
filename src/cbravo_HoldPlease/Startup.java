package cbravo_HoldPlease;

import Lines.Bank;
import Lines.GroceryStore;
import edu.neumont.util.Client;

public class Startup {

	public static void main(String[] args) {
		// This place is for testing
		// GroceryStoreTest();
		//BankTest();
		//ArrayTest();
		LinkedListTest();
	}

	public static void ArrayTest() {

		ArrayList<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String i : a) {
			System.out.println(i);
		}
		System.out.println("Get [0]: "+a.get(0));

		System.out.println("Size: "+a.size());
		System.out.println("removed 2");
		a.remove("2");
		for (String i : a) {
			System.out.println(i);
		}
		
		System.out.println("Size: "+a.size());
	}

	public static void LinkedListTest() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.offer(1);

	}

	public static void BankTest() {

		Client a1 = new Client(30);
		Client a2 = new Client(30);
		Client a3 = new Client(20);
		Client a4 = new Client(100);
		Client a5 = new Client(100);
		Bank b = new Bank(3);
		b.addClient(a1);
		b.addClient(a2);
		b.addClient(a3);
		b.addClient(a4);
		b.addClient(a5);
		System.out.println(b.getClientWaitTime(a4));
		System.out.println(b.getAverageClientWaitTime());
		b.advanceMinute();
		System.out.println(b.getClientWaitTime(a4));
		System.out.println(b.getAverageClientWaitTime());
	}

	public static void GroceryStoreTest() {

		Client a1 = new Client(30);
		Client a2 = new Client(30);
		Client a3 = new Client(20);
		Client a4 = new Client(100);
		Client a5 = new Client(100);
		GroceryStore b = new GroceryStore(3);
		b.addClient(a1);
		b.addClient(a2);
		b.addClient(a3);
		b.addClient(a4);
		b.addClient(a5);
		System.out.println(b.getClientWaitTime(a4));
		System.out.println(b.getAverageClientWaitTime());
		b.advanceMinute();
		System.out.println(b.getClientWaitTime(a4));
		System.out.println(b.getAverageClientWaitTime());
	}
}
