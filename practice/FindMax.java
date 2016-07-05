package practice;

public class FindMax {
	
	public static int max(int[] data){
		if(data == null){
			return -999999;
		}
		int length = data.length;
		if(length == 0)
		{
			return -999999;
		}
		int max = data[0];
		for(int i=1;i<length;i++)
		{
			if(data[i] >= max){
				max = data[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {

		int[] data = {3,2,9,4,7};
		
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪 : " + max(data));
		System.out.println("�ִ밪 : " + max(null));
		System.out.println("�ִ밪 : " + max(new int[]{}));
		
	}

}
