package station;

import user.User;

public class Clerk {
	
	boolean available = true;
	int waiting = 0;
	
	User user = new User();
	
	public int startTime;
	
	public int service(User user){
		
		this.waiting = user.ticketingDoneTime;
		this.available = false;
		Calculate calculate = new Calculate(user.departure,user.arrival);

		return calculate.calculateTime();
		}
	
	
	public User ticketing(User user,int time){
		
		this.user = user;
		this.user.ticketingDoneTime = user.ticketingStartTime +user.ticketingTime -1;
		this.user.ticketingWaitTime = user.ticketingStartTime - user.arrivalTime;
		if(time%3 == 0)
			this.user.trainTime = time+3;
		else if(time%3 == 2)
			this.user.trainTime = time+1;
		else if(time%3 == 1)
			this.user.trainTime = time+2;
		
		
		this.user.totalTime = this.service(user);
		this.user.finalTime = this.user.totalTime +this.user.trainTime;
		return this.user;
	}

}