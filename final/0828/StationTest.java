import java.util.ArrayList;

import station.Service;
import station.Station;
import user.User;

public class StationTest {

	public static void main(String[] args){
		
		Station Seoul = new Station("Seoul");
		Station Chuncheon = new Station("Chuncheon");
		Station Gyeongju = new Station("Gyeongju");
		Station Wonju = new Station("Wonju");
		Station Daejeon = new Station("Daejeon");
		Station Gwangju = new Station("Gwangju");
		Station Asan = new Station("Asan");
		
		
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
		ArrayList<User> userList = new ArrayList<User>();
		User user1 = new User(1,"2001",0,2,Seoul,Chuncheon);
		User user2 = new User(2,"2002",0,1,Chuncheon,Wonju);
		User user3 = new User(3,"2003",0,3,Wonju,Gwangju);
		User user4 = new User(4,"2004",0,5,Gyeongju,Wonju);
		User user5 = new User(5,"2005",0,1,Chuncheon,Daejeon);
		User user6 = new User(6,"2006",1,10,Asan,Daejeon);
		User user7 = new User(7,"2007",1,1,Seoul,Gyeongju);
		User user8 = new User(8,"2008",1,2,Gwangju,Chuncheon);
		User user9 = new User(9,"2009",3,1,Daejeon,Seoul);
		User user10 = new User(10,"2010",3,3,Gwangju,Asan);
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
		
		Service service = new Service();
		service.service(userList);
		
	}

}
