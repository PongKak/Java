package station;

import user.User;

public class Clerk {
	
	boolean available = true;
	int waiting = 0;
	
	public int service(User user){
		
		waiting = user.ticketingTime;
		available = false;
		Calculate calculate = new Calculate(user.departure,user.arrival);

		return calculate.calculateTime();
		}
	
	

}