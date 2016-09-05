package station;

import java.util.ArrayList;

public class Station {
	

	public String name;

	ArrayList<Station> nextList = new ArrayList<Station>();
	ArrayList<Integer> nextTimeList = new ArrayList<Integer>();
	public Station(){}
	public Station(String name){
		this.name = name;
	}
	
	
	public void addNext(Station station,int time){
		nextList.add(station);
		nextTimeList.add(time);
	}
	
	
}