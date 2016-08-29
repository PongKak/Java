package station;

import java.util.ArrayList;

import user.User;

public class Train {
	
	
	public void departure(ArrayList<User> wait){
		
		System.out.println("train is departuring");
		for(int i=0;i<wait.size();i++){
			System.out.println(wait.get(i).name + " ride train");
		}
		
		wait.clear();
	}

}
