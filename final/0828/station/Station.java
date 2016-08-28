package station;

import java.util.ArrayList;

public class Station {
	

	String name;

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
	
	public void getNext(){
		for(int i=0;i<nextList.size();i++)
			System.out.println(nextList.get(i).name+ "	" + nextTimeList.get(i));
	}
	
}