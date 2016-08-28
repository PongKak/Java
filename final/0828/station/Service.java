package station;

import java.util.ArrayList;
import user.User;

public class Service {
	
	
	int time;
	
	Clerk clerk1 = new Clerk();
	Clerk clerk2 = new Clerk();
	Clerk clerk3 = new Clerk();
	
	int clerk1Result;
	int clerk2Result;
	int clerk3Result;
	
	User clerk1User;
	User clerk2User;
	User clerk3User;

	ArrayList<Clerk> clerk = new ArrayList<Clerk>();
	
	public void service(ArrayList<User> userList){
		clerk.add(clerk1);
		clerk.add(clerk2);
		clerk.add(clerk3);
	
		ArrayList<User> ticketUser = new ArrayList<User>();
		Train train = new Train();
	
		ArrayList<User> waitingUser = new ArrayList<User>();
		User u;
		
		
		for(time=0;;time++){
			
			System.out.println("time : " +time);
			
			if(time%3 == 0)
				train.departure(ticketUser);
			
			
			
			
			for(int i=0;i<userList.size();i++){
				u = userList.get(i);
				if(u.arrivalTime == time)
					waitingUser.add(u);
			}

			if(waitingUser.isEmpty()==true 
					&& clerk1.available==true 
					&& clerk2.available==true 
					&& clerk3.available==true){
		
				System.out.println("total time : " + time);
				break;
				
			}
						

			
			
			
			if(clerk1.available == true && waitingUser.isEmpty() == false){
				clerk1Result = clerk1.service(waitingUser.get(0));
				clerk1User = waitingUser.get(0);
				
				System.out.println(waitingUser.get(0).name + " come to clerk1");
				waitingUser.remove(0);
				
			}else{
				if(clerk1.waiting>0){
					clerk1.waiting --;
				}
				if(clerk1.waiting == 0 && clerk1User != null){
					System.out.print("clerk1 service : ");
					this.print(clerk1User, clerk1Result);
					ticketUser.add(clerk1User);
					clerk1.available =true;
					clerk1User = null;
				}
			}
			
			
			if(clerk2.available == true && waitingUser.isEmpty() == false){
				clerk2Result = clerk2.service(waitingUser.get(0));
				clerk2User = waitingUser.get(0);

				System.out.println(waitingUser.get(0).name + " come to clerk2");
				waitingUser.remove(0);
			}else{
				if(clerk2.waiting>0){
					clerk2.waiting --;
					
				}
				if(clerk2.waiting == 0 && clerk2User != null){
					System.out.print("clerk2 service : ");
					this.print(clerk2User, clerk2Result);
					ticketUser.add(clerk2User);
					clerk2.available =true;
					clerk2User = null;
				}
			}
			
			if(clerk3.available == true && waitingUser.isEmpty() == false){
				clerk3Result = clerk3.service(waitingUser.get(0));
				clerk3User = waitingUser.get(0);

				System.out.println(waitingUser.get(0).name + " come to clerk3");
				waitingUser.remove(0);
			
			}else{
				if(clerk3.waiting>0){
					clerk3.waiting --;
					
				}
				if(clerk3.waiting == 0 && clerk3User != null){
					System.out.print("clerk3 service : ");
					this.print(clerk3User, clerk3Result);
					ticketUser.add(clerk3User);
					clerk3.available =true;
					clerk3User = null;
				}
			}

		}
		
	}
	
	
	public void print(User user,int time){
		System.out.print(user.name+ " 	");
		System.out.println(user.departure.name + " -> " + user.arrival.name + " -  time : " + time);
	}

}
