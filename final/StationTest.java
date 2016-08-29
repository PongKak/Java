import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import station.Service;
import station.Station;
import user.User;

public class StationTest {

	public static void main(String[] args) throws IOException{
		
		Station Seoul = new Station("Seoul");
		Station Chuncheon = new Station("Chuncheon");
		Station Gyeongju = new Station("Gyeongju");
		Station Wonju = new Station("Wonju");
		Station Daejeon = new Station("Daejeon");
		Station Gwangju = new Station("Gwangju");
		Station Asan = new Station("Asan");
		
		ArrayList<Station> stations = new ArrayList<Station>();
		
		stations.add(Seoul);
		stations.add(Daejeon);
		stations.add(Chuncheon);
		stations.add(Gyeongju);
		stations.add(Asan);
		stations.add(Gwangju);
		stations.add(Wonju);

		Seoul.addNext(Chuncheon, 16);
		Seoul.addNext(Wonju, 22);
		Seoul.addNext(Daejeon, 29);
		Seoul.addNext(Asan, 20);
		
		Chuncheon.addNext(Seoul, 16);
		Chuncheon.addNext(Gyeongju, 31);
		Chuncheon.addNext(Wonju, 28);
		
		Gyeongju.addNext(Chuncheon, 31);
		Gyeongju.addNext(Wonju, 32);
		Gyeongju.addNext(Daejeon, 15);
		Gyeongju.addNext(Gwangju, 18);
		
		Wonju.addNext(Seoul, 22);
		Wonju.addNext(Chuncheon, 28);
		Wonju.addNext(Gyeongju, 32);
		Wonju.addNext(Daejeon, 23);
		
		Daejeon.addNext(Seoul, 29);
		Daejeon.addNext(Wonju, 23);
		Daejeon.addNext(Gyeongju, 15);
		Daejeon.addNext(Gwangju, 12);
		Daejeon.addNext(Asan, 35);
		
		Gwangju.addNext(Gyeongju, 18);
		Gwangju.addNext(Daejeon, 12);
		Gwangju.addNext(Asan, 25);
		
		Asan.addNext(Seoul, 20);
		Asan.addNext(Daejeon, 35);
		Asan.addNext(Gwangju, 25);
	
		/////////////////////////////
		//TEST
//		ArrayList<User> userList = new ArrayList<User>();
//		User user1 = new User(1,"2001",0,2,Seoul,Chuncheon);
//		User user2 = new User(2,"2002",0,1,Chuncheon,Wonju);
//		User user3 = new User(3,"2003",0,3,Wonju,Gwangju);
//		User user4 = new User(4,"2004",0,5,Gyeongju,Wonju);
//		User user5 = new User(5,"2005",0,1,Chuncheon,Daejeon);
//		User user6 = new User(6,"2006",1,10,Asan,Daejeon);
//		User user7 = new User(7,"2007",1,1,Seoul,Gyeongju);
//		User user8 = new User(8,"2008",1,2,Gwangju,Chuncheon);
//		User user9 = new User(9,"2009",3,1,Daejeon,Seoul);
//		User user10 = new User(10,"2010",3,3,Gwangju,Asan);
//		
//		userList.add(user1);
//		userList.add(user2);
//		userList.add(user3);
//		userList.add(user4);
//		userList.add(user5);
//		userList.add(user6);
//		userList.add(user7);
//		userList.add(user8);
//		userList.add(user9);
//		userList.add(user10);
	
		ArrayList<User> userList = new ArrayList<User>();
		
		FileInputStream fis = null;
		fis = new FileInputStream("user");
		InputStreamReader isr;
		char[] buffer = new char[2048];
		try {
			isr = new InputStreamReader(fis);
			int i;
			isr.read(buffer);
			isr.close();
			
			for(i=0;i<buffer.length;i++){
				if(buffer[i] == 0)
					break;
//				System.out.print(buffer[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i=0;
		
		while(buffer[i] != 0){
			
			int id = 0;
			String name = "";
			int arrivalTime=0;
			int ticketingTime = 0;
			String departure = "";
			String arrival =  "";
			Station s_departure = new Station();
			Station s_arrival = new Station ();
		
			
			id=0;
			name = "";
			arrivalTime=0;
			ticketingTime=0;
			departure="";
			arrival="";
			s_departure = new Station();
			s_arrival = new Station();
			
			while(buffer[i] != 9){
				id = id*10 + (buffer[i]-48);
				i++;
			}
			i++;
			
			while(buffer[i] != 9){
				name = name + buffer[i];
				i++;
			}
			i++;
			while(buffer[i] != 9){
				arrivalTime = arrivalTime*10 + (buffer[i]-48);
				i++;
			}
			i++;
			
			while(buffer[i] != 9){
				ticketingTime = ticketingTime*10 + (buffer[i]-48);
				i++;
			}
			i++;
			while(buffer[i] != 9){
				departure = departure + buffer[i];
				i++;
			}
			i++;
			while(buffer[i] != 9 && buffer[i] != 13 && buffer[i] != 0){
				arrival = arrival + buffer[i];
				i++;
			}
			
			i++;
			i++;
			
			
			
			User user = new User();
			s_departure = user.findStation(departure, stations);
			s_arrival = user.findStation(arrival, stations);
			
			user = new User(id, name, arrivalTime, ticketingTime, s_departure, s_arrival );
			
			userList.add(user);
		}
		System.out.println("size : " + userList.size());

		
		
		Service service = new Service();
		service.service(userList);
		
		System.out.println("user 1 total time : " + userList.get(0).totalTime);
		
	}

}
