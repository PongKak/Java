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
	public int trainWaitTime;
	public int ticketingDoneTime;
	
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
	

}