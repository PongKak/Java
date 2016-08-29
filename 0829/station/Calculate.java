package station;

import java.util.ArrayList;

public class Calculate {
	
	Station departure;
	Station arrival;
	ArrayList<Station> past = new ArrayList<Station>();
	ArrayList<Station> pass = new ArrayList<Station>();
	
	public Calculate(Station departure,Station arrival){
		this.departure = departure;
		this.arrival = arrival;
	}
	public Calculate(Station departure,Station arrival,ArrayList<Station> past){
		this.departure = departure;
		this.arrival = arrival;
		this.past = past;
	}
	
	
	public int checkNext(){
		for(int i=0;i<departure.nextList.size();i++){
			if(departure.nextList.get(i).name == arrival.name){
				return i;			
			}
		}
		
		return -1;
	}
	
	public int calculateTime(){
		if(checkNext() != -1){
			int index = checkNext();
			return departure.nextTimeList.get(index);			
		}else{
			int total= 0 ;
			ArrayList<Integer> totalList = new ArrayList<Integer>();

			
						
			for(int i=0;i<departure.nextList.size();i++){
				
				// 전에 들렀던 곳이면 0을 반환
				for(int j=0;j<past.size();j++)
					if(departure.nextList.get(i) == past.get(j))
						return 0;
				
				
				total = 0;
				past.add(departure);
				Calculate next = new Calculate(departure.nextList.get(i),arrival,past);
				// 전에 들렀던 곳이면 계산 안하고 통과
				if(next.calculateTime() == 0)
					continue;
		
				total += departure.nextTimeList.get(i)+ next.calculateTime();
				
				totalList.add(total);
				

								
			}
			if(totalList.isEmpty() == false){
				int min = totalList.get(0);
				for(int i=1;i<totalList.size();i++){
					if(totalList.get(i)<=min)
						min = totalList.get(i);
				}
				
				total = min;
			}
			return total;
		}

		
		
	}

}