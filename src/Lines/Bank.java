package Lines;

import java.util.ArrayList;

import edu.neumont.util.Client;
import edu.neumont.util.QueueableService;

public class Bank implements QueueableService {
	
	ArrayList<Client> clients = new ArrayList<Client>();
	
	ArrayList<Integer> bankers = new ArrayList<Integer>(); 
	
	public Bank(int numberOfTellers) {
		for(int i = 0; i<numberOfTellers; i++){
			bankers.add(0);
		}
	}
	
	
	public void advanceMinute() {
		for(Client c : clients){
			c.servedMinute();
		}
	}
	

	@Override
	public boolean addClient(Client client) {
		clients.add(client);
		return true;
	}
	
	public double getClientWaitTime(Client client) {
		ArrayList<Integer> bankers2 = new ArrayList<Integer>(bankers);
		for(Client c : clients){
			int lli = getLowestLine();
			int toReturn = bankers.get(lli);
			bankers.set(lli, bankers.get(lli)+c.getExpectedServiceTime());
			
			if(c.equals(client)){
				bankers = bankers2;
				return toReturn;
			}
		}
		return -1;
	}
	public double getAverageClientWaitTime() {
		int num = 0;
		double total = 0;
		for(Client c : clients){
			num ++;
			total = total + getClientWaitTime(c);
		}
		
		return (double)total/num;
	}
	
	public int getLowestLine(){
		int min = bankers.get(0);
		int minIndex = 0;
		
		for (int i = 1; i < bankers.size(); i++) {
		    if (bankers.get(i) < min) {
		        minIndex = i;
		        min = bankers.get(i);
		    }
		}
		
		return minIndex;
	}
}

