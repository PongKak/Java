package practice;

public class SutdaCard {
	private int num;
	private boolean isKwang;
	
	
	public SutdaCard(){
		this.num = 1;
		this.isKwang = true;
	};
	public SutdaCard(int num){
		this.num = num;
		setKwang(this);
	}
	public SutdaCard(int num,boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num>=1 && num<=10){
			this.num = num;
			setKwang(this);
		}else{
			System.out.println("1~10 까지의 숫자를 입력하세요");
		}
		
	}
	
	
	public boolean isKwang() {
		return isKwang;
	}
	public void setKwang(SutdaCard sutda) {
		if(sutda.num == 1 || sutda.num == 3|| sutda.num == 8){
			sutda.isKwang = true;			
		}
		else{
			sutda.isKwang = false;
		}
	}
	
	
	
	public String info(){
		if(this.isKwang == true){
			return num+"K";
		}
		else{
			return num+" ";
		}
	}
	

}
