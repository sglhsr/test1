
public class LeetCode_680_Valid_Palindrome2 {
	//�����@�r����,����ݰ_�Ӧr�곣�@��
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
		//�q�̥���̥k�̧Ǩ�,�����@�˪��N�P�_(left,right-1) or (left+1,right)�@��
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
