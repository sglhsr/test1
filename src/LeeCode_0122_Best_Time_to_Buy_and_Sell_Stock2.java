import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
//(i.e., buy one and sell one share of the stock multiple times).
//Note: You may not engage in multiple transactions at the same time 
//(i.e., you must sell the stock before you buy again).
//input: 一組數字陣列代表某一個股票在七天內的價錢
//output: 算出最大收益，跟前一題不一樣的是你 can make multiple transactions 
public class LeeCode_0122_Best_Time_to_Buy_and_Sell_Stock2 {
	public static int calculate(Integer data[]) {
//		public static int calculate(ArrayList<Integer> data) {
		System.out.println("Cout "+ data.length);
		int index=0;
		int total=0;
		int left=0;
		for (int i=0;i<data.length-1;i++) {
			if (data[i]<data[i+1]) {
				total=total+data[i+1]-data[i];
			}
		}
//		while (index<data.length-1){		
//			if (data[index]<data[index+1]) {
//				total=total+data[index+1]-data[index];
//			}
//			System.out.print(data[index]+" ");
//			index++;
//		}
//		while (index<data.size()-1){		
//			System.out.print(data.get(index)+" ");
//			index++;
//		}
		
		return total;		
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
//		List<Integer> ary=List.of(23,4,45,7,1);
//		List<Integer> ary=Arrays.asList(23,4,45,7,1);
//		ArrayList<Integer> ary=new ArrayList<>(List.of(1,4,34,2,8));
//		ArrayList<Integer> ary=new ArrayList<>(Arrays.asList(7,1,5,3,6,4));
//		ArrayList<Integer> ary=new ArrayList<Integer>() {{
//			add(3);add(3);add(2);add(1);}};
		int index=0;
		Integer[] ary={1,2,3,4,5};
	
		System.out.println("keyin the 5 length array");
	
//		ary=new Integer[5];
//		while (index<5) {
//			ary[index]=input.nextInt();
//			index++;
//		}
		
	
//		for (int i=0;i<=4;i++) {
//			ary.add(input.nextInt());
//		}
		input.close();
		System.out.println("Total "+ calculate(ary));
		
	}

}
