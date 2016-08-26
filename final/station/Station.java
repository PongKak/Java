package station;

import java.util.ArrayList;

public abstract class Station {
	

	String name;
	ArrayList<Clerk> clerkList;

	ArrayList<NextStation> nextList = new ArrayList<NextStation>();
	public void addNext(Station station,int time){
		NextStation next = new NextStation(station,time);
		nextList.add(next);
	}
	
	public int checkNext(Station station){
		
		for(int i=0;i<nextList.size();i++){
			if(this.nextList.get(i).name == station.name)
				return i;
		}
		
		return -1;
	}
	
	public int calculateTime(Station station){
		
		if(checkNext(station) != -1){
			int index = checkNext(station);
			return nextList.get(index).time;
		}else{
			int total=0;
			
			for(int i=0;i<nextList.size();i++){
				total = nextList.get(i).time + nextList.get(i).calculateTime(station);
			}
						
			return total;
		}
		
	}

}
