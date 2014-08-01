package Lines;

import java.util.ArrayList;

import edu.neumont.util.Client;
import edu.neumont.util.QueueableService;

public class GroceryStore implements QueueableService {

	ArrayList<ArrayList> clerks = new ArrayList<ArrayList>();
	ArrayList<Client> clients = new ArrayList<Client>();

	public GroceryStore(int clerks_) {
		for(int i = 0; i<clerks_; i++){
			ArrayList<Client> a = new ArrayList<Client>();
			clerks.add(a);
		}
	}
	
	@Override
	public void advanceMinute() {
		for(Client c : clients){
			c.servedMinute();
		}
	}
	
	@Override
	public boolean addClient(Client client) {
		clients.add(client);
		clerks.get(getShortestLine()).add(client);
		return true;
	}

	@Override
	public double getAverageClientWaitTime() {
		int num = 0;
		double total = 0;
		for(Client c : clients){
			num ++;
			total = total + getClientWaitTime(c);
		}
		
		return (double)total/num;
	}

	@Override
	public double getClientWaitTime(Client client) {
		for(ArrayList a : clerks){
			int i = 0;
			for(Object c : a){
				if(c.equals(client)){
					return i;
				}
				
				i= i + ((Client) c).getExpectedServiceTime();
			}
		}
		return -1;
	}
	
	public int getShortestLine(){
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		
		for (int i = 0; i < clerks.size(); i++) {
			int j = clerks.get(i).size();
		    if (j < min) {
		        minIndex = i;
		        min = clerks.get(i).size();
		    }
		}
		
		return minIndex;
	}

}
