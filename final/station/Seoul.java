package station;

import java.util.ArrayList;

public class Seoul extends Station{
	
	String name = "seoul";
	
	
	ArrayList<Station> nextList = new ArrayList<Station>();
	
	
	public void addNext(Station station){
		nextList.add(station);
	}
	
	public boolean checkNext(String name){
		
		
		return true;
	}
	
	
}
