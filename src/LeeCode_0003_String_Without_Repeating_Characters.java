import java.util.ArrayList;
import java.util.Arrays;

//Given a string s, find the length of the longest substring without repeating characters.

public class LeeCode_0003_String_Without_Repeating_Characters {
//	public static int check_Size(String s) {
//		if (s==null) {
//			return 0;
//		}
//		if (s.length()<2) {
//			return 1;
//		}
//		int max=0;
//		ArrayList<Character> list=new ArrayList<>();
//		for (char c:s.toCharArray()) {
//			int index=list.indexOf(c);
//			if (index>-1) {   //c沒出現過沒在index裡 =-1  
//				System.out.println("Break "+ c);
//				System.out.println(list);
//				int size=list.size();
//				max=Math.max(size, max);
//				for (int i=0;i<=index;i++) {
//					list.remove(0);   //abcdbefg 到b重複 移除ab
//				}
//			}
//			list.add(c);
//		}
//		System.out.println(list);
//		return Math.max(list.size(), max);
//	}
	public static int check_Size2(String s ) {
//- （1）如果当前遍历到的字符从未出现过，那么直接扩大右边界；
//- （2）如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；
//- （3）重复（1）（2），直到左边索引无法再移动；
//- （4）维护一个结果res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果。
		if (s==null) {
			return 0;
		}
		if(s.length()<2) {
			return s.length();
		}
		   //int freq[256] = {0};
		int[] temp=new int[256];

		Arrays.fill(temp,-1);
		int max=0;
		int left=-1;

		for (int i=0;i<s.length();i++) {
			//將 char 轉換為 int 以在 Java 中將字元轉換為 ASCII 值
			//left每次是任何有重複的最右邊index,有重複的左邊之後就賦歸重算
			left=Math.max(left, temp[s.charAt(i)]); //left=最早出現重複的index(左邊那格),abcb 的b=>1  temp["a"]會自動換Ascll碼
			temp[s.charAt(i)]=i;  //a的ASC=97,  temp[97]等於a掃到的index,更新每個字最後出現的位置
			max=Math.max(max, i-left); // i-left: 上次重複的到目前i的長度,跟舊的max取最大值
		}
		
		return max;	
	}
	public static void main(String[] args) {
		
		System.out.println(check_Size2("abcdbe"));
	}
}
