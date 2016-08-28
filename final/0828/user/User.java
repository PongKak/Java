package user;

import station.Station;

public class User {
	
	public int Id;
	public String name;
	public int arrivalTime;
	public int ticketingTime;
	public Station departure;
	public Station arrival;
	
	public User(int Id,String name,int arrivalTime,int ticketingTime,Station departure,Station arrival){
		this.Id = Id;
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.ticketingTime = ticketingTime;
		this.departure = departure;
		this.arrival = arrival;
	}

}