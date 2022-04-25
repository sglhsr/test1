//Given an array of integers, return indices of the two numbers such that 

//they add up to a specific target.
//You may assume that each input would have exactly one solution.
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeeCode_0001_Two_Sum {
//	public static int[] two_Sum(int[] nums,int target) {
//		int len=nums.length;
//		int[] ans = new int[2];
//		int i,j;
//		for (i=0;i<len-1;i++) {
//			for (j=i+1;j<len;j++) {
//				if(nums[i]+nums[j]==target){
//					ans[0]=i;
//					ans[1]=j;
////					return new int[] {i,j};
//					return ans;
//				}
//			}
//		}
//		return new int[] {};
////		return ans;
//	}
	private static int[] two_Sum(int[] nums,int target) {
		Map<Integer,Integer> numMap=new HashMap<>();
		for (int i=0;i<nums.length;i++) {
			int tmp=target-nums[i];
			if (numMap.containsKey(tmp)) {
				return (new int[] {numMap.get(tmp),i});				
			}
			else {
				numMap.put(nums[i],i);
			}
		}
		
		return new int[] {};
	
	}
	public static void main(String[] args) {
//		int[] b;
//		System.out.println(1);
//		int[] a=new int[] {2,9,11,7};
//		b=two_Sum(a,9);
//		b=two_Sum(new int[]{2,9,11,7},9);
//		System.out.println("b[0] "+b[0]);
//		System.out.println("b[1] "+b[1]);
		
		Scanner input=new Scanner(System.in);
		System.out.println("key in data length");
		int n=input.nextInt();
		int[] nums=new int[n];
		System.out.println("key in data array");
		for (int i=0;i<n;i++) {
			nums[i]=input.nextInt();
		}
		System.out.println("key in target");
		int target=input.nextInt();
		input.close();
		System.out.println("Start");
		int[] result=two_Sum(nums,target);
		System.out.println("result[0] "+result[0]);
		System.out.println("result[1] "+result[1]);
		System.out.println(result);
		
	}

}
