package station;

public class NextStation extends Station{
	
	String name;
	int time;
	
	
	public NextStation(Station station,int time){
		this.name = station.name;
		this.time = time;
	}

}
