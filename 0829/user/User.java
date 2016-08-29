package user;

import java.util.ArrayList;

import station.Station;

public class User {
	
	public int Id;
	public String name;
	public int arrivalTime;
	public int ticketingTime;
	public Station departure;
	public Station arrival;
	
	public int totalTime = 0;
	public int ticketingWaitTime;
	public int trainTime;
	public int ticketingStartTime;
	public int ticketingDoneTime;
	public int finalTime;
	
	public User(){};
	
	public User(int Id,String name,int arrivalTime,int ticketingTime,Station departure,Station arrival){
		this.Id = Id;
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.ticketingTime = ticketingTime;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	
	public Station findStation(String station,ArrayList<Station> stations){
		Station found = new Station();
		
		
		
		for(int i=0;i<stations.size();i++){
			if(stations.get(i).name.equals(station)){
				found = stations.get(i);
			}
		}
		return found;
	}
	
	
	public ArrayList<User> listToUser(char[] buffer,ArrayList<User> userList,ArrayList<Station> stations)
	{
		int i=0;
		
		while(buffer[i] != 0){
			
			int id = 0;
			String name = "";
			int arrivalTime=0;
			int ticketingTime = 0;
			String departure = "";
			String arrival =  "";
			Station s_departure = new Station();
			Station s_arrival = new Station ();
		
			
			id=0;
			name = "";
			arrivalTime=0;
			ticketingTime=0;
			departure="";
			arrival="";
			s_departure = new Station();
			s_arrival = new Station();
			
			while(buffer[i] != 9){
				id = id*10 + (buffer[i]-48);
				i++;
			}
			i++;
			
			while(buffer[i] != 9){
				name = name + buffer[i];
				i++;
			}
			i++;
			while(buffer[i] != 9){
				arrivalTime = arrivalTime*10 + (buffer[i]-48);
				i++;
			}
			i++;
			
			while(buffer[i] != 9){
				ticketingTime = ticketingTime*10 + (buffer[i]-48);
				i++;
			}
			i++;
			while(buffer[i] != 9){
				departure = departure + buffer[i];
				i++;
			}
			i++;
			while(buffer[i] != 9 && buffer[i] != 13 && buffer[i] != 0){
				arrival = arrival + buffer[i];
				i++;
			}
			
			i++;
			i++;
			
			
			
			User user = new User();
			s_departure = user.findStation(departure, stations);
			s_arrival = user.findStation(arrival, stations);
			
			user = new User(id, name, arrivalTime, ticketingTime, s_departure, s_arrival );
			
			userList.add(user);
		}
		
		
		return userList;
	}

}