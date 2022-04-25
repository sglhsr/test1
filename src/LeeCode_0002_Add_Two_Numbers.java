
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}

//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
//and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
//把兩個ListNode相加並回傳ListNode,須注意進位的
public class LeeCode_0002_Add_Two_Numbers {
	
	public static void add_Two_Num(ListNode L1, ListNode L2) {
		ListNode node=new ListNode(0);
		ListNode L3=node;   //把node跟L3切開 因為L3的next會一直取代掉 node保留源頭
		int carry=0;  // 進位用
		while(L1 != null || L2 != null || carry!=0) {
			int sum=carry;
			if (L1 !=null) {
				sum+=L1.val;
				L1=L1.next;
			}
			if (L2 !=null) {
				sum+=L2.val;
				L2=L2.next;
			}
			carry=sum/10;  //取需不需要進位
			ListNode tmp=new ListNode(sum % 10);
			L3.next=tmp;
			L3=L3.next;
//			L3.next=new ListNode(sum % 10);
			
		}

		node=node.next;  //移掉第一個預設值0
		while(node != null) {
			System.out.print(node.val);
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode L1=new ListNode(2);
		ListNode tmp1=new ListNode(4);
		ListNode tmp2=new ListNode(9);
		L1.next=tmp1;
		tmp1.next=tmp2;
		
		ListNode L2=new ListNode(5);
		ListNode tmp3=new ListNode(6);
		ListNode tmp4=new ListNode(4);
//		ListNode tmp5=new ListNode(2);
		L2.next=tmp3;
		tmp3.next=tmp4;
//		tmp4.next=tmp5;

	
		add_Two_Num(L1,L2);
//		while(L2 != null) {
//			System.out.println(L2.val);
//			L2=L2.next;
//		}

	
		

	}

}
