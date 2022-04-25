
//Given two sorted arrays nums1 and nums2 of size m and n respectively, 
//return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
public class LeeCode_0004_Median_of_Two_Sorted_Arrays {
	public static double find_median(int[] num1,int[] num2) {
		//二分成左右 左邊一定比右邊小
		//num1 num2判斷的值比彼此的next小就等於抓到了
		//讓Num1為小維度的,只判斷num1, num1的值>num2的值時end向左移1 => num2就會自動向右移1
		// num1的值<num2的值時start向右移1 => num2就會自動向左移1
		if (num1.length>num2.length) {
			int[] temp=num1;
			num1=num2;
			num2=temp;
		}
		int len1=num1.length;
		int len2=num2.length;
		int leftLen=(len1+len2+1)/2;  //合併後總長度的中間index,左半邊的長度
		int start=0;   //num1要判斷數的起點
		int end=len1;  //num1要判斷的終點
		while (start<=end) {
			int c1=start+(end-start+1)/2;
			int c2=leftLen-c1;
			if (c1>0 && num1[c1-1]>num2[c2]) {
				end=c1-1;
			}else if(c1<len1 && num2[c2-1]>num1[c1]) {
				start=c1+1;
			}else {
				int result= (c1==0)?num2[c2-1]:
				            (c2==0)?num1[c1-1]:
				            Math.max(num1[c1-1], num2[c2-1]);
				if (isOdd(len1+len2)) {
					return result;
				}
				
				int nextValue=(c1==len1)?num2[c2]:  //偶數時抓下一位數要抓兩個num最小的
					 		  (c2==len2)?num1[c1]:
					 		  Math.min(num1[c1], num2[c2]);
				System.out.println("result= "+result);
				System.out.println("nextValue= "+nextValue);
				return (result+nextValue)/2.0;
			}
		
		}
		
		return Integer.MIN_VALUE;
	} 
	
	
	private static boolean isOdd(int x) {
		return (x & 1)==1;
	}
	public static void main(String[] args) {
		//如果?前面的式子为真，那么就返回冒号:左边的值;否则返回右边的值。。
		int[] num1= {11,12,14,15};
		int[] num2= {3,6,7,9,10,13,16,17};
		System.out.println(find_median(num1,num2));
	}
}
