package practice;

public class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff(){
		if(isPowerOn = true){
			isPowerOn = false;
		}else{
			isPowerOn = true;
		}
	}
	void volumeUp(){
		if(volume < MAX_VOLUME){
			volume++;
		}
	}
	void volumeDown(){
		if(volume > MIN_VOLUME){
			this.volume--;
		}
	}
	void channelUp(){
		if(channel < MAX_CHANNEL){
			this.channel++;
		}
	}
	void channelDown(){
		if(channel > MIN_CHANNEL){
			this.channel--;
		}
	}

}
