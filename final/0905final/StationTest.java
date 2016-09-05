import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import station.ServiceSTFS;
import station.SeviceFIFO;
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
	
	
		ArrayList<User> userList = new ArrayList<User>();
		FileInputStream fis = null;
		fis = new FileInputStream("user.txt");
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
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		userList = new User().listToUser(buffer, userList, stations);

		
		
		SeviceFIFO service = new SeviceFIFO();
		service.service(userList);
		
		
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		fos =  new FileOutputStream("userFIFO.txt");
		osw = new OutputStreamWriter(fos);
		
		
		osw.write("ID	name	train	operation	finalTime	departure	arrival	");
		osw.write(13);
		for(int i=0;i<userList.size();i++){		
			
			
			osw.write((userList.get(i).Id+"	"));
			osw.write(userList.get(i).name+"	");
			osw.write(userList.get(i).trainTime+"		");
			osw.write(userList.get(i).totalTime+"			");
			osw.write(userList.get(i).finalTime+"			");

			osw.write(userList.get(i).departure.name+"	");
			osw.write(userList.get(i).arrival.name+"	");
			osw.write(13);
		}
		
		
		
		osw.close();
		
		

		ServiceSTFS service2 = new ServiceSTFS();
		service2.service(userList);

		fos = null;
		osw = null;
		fos =  new FileOutputStream("userSTFS.txt");
		osw = new OutputStreamWriter(fos);
		
		
		osw.write("ID	name	train	operation	finalTime	departure	arrival	");
		osw.write(13);
		for(int i=0;i<userList.size();i++){		
			
			
			osw.write((userList.get(i).Id+"	"));
			osw.write(userList.get(i).name+"	");
			osw.write(userList.get(i).trainTime+"		");
			osw.write(userList.get(i).totalTime+"			");
			osw.write(userList.get(i).finalTime+"			");

			osw.write(userList.get(i).departure.name+"	");
			osw.write(userList.get(i).arrival.name+"	");
			osw.write(13);
		}
		
		
		
		osw.close();
		
		
	}
	
	

}
