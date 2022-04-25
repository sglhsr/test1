
public class LeetCode_680_Valid_Palindrome2 {
	//移除一字元後,兩邊看起來字串都一樣
	public static boolean Valid_Palindrom(String s) {	
		return check_Palindrom(s.split(""),0,s.length()-1,0);
	}
	
	public static boolean check_Palindrom(String[] s, int left, int right, int count) {
//		if (left==right) {
//			return true;
//		}
		if (count>1 || left>right) {
			return false;
		}
		//abcba true,   abcbadd false
		//從最左跟最右依序取,有不一樣的就判斷(left,right-1) or (left+1,right)一次
		while (left<right) {
			System.out.println("left "+left+" " +s[left]+ " - "+"right "+right+" " +s[right]);
			System.out.println("Count " + count + " " +s[left].equals(s[right]));
			if (!s[left].equals(s[right])) {
				return check_Palindrom(s,left,right-1,count+1) |
						check_Palindrom(s,left+1,right,count+1);
			}
			left++;
			right--;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Valid_Palindrom("abcdee");

		String s="abcbadd";
		System.out.println(s + " " + Valid_Palindrom(s));
	}

}
