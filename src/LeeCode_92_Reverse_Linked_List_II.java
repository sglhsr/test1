
public class LeeCode_92_Reverse_Linked_List_II {
//給定一個連結串列和兩個整數m和n，m和n分別代表連結串列當中的第m和第n個元素，其中m <= n。
//要求我們通過一次遍歷將連結串列當中m到n這一段元素進行翻轉。
//	Reverse a linked list from position m to n. Do it in-place and in one-pass.
//	For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//	return 1->4->3->2->5->NULL.
//	Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
	
	ListNode head,tail,cur,nxt;
	public static void reverse(ListNode head,int m,int n) {
		//假設1 2 3 4 5
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode cur=dummy;
		ListNode pre,last; //pre固定抓m前一位(1),一直改next讓像一輪的cur抓,
		//last: 轉完後要在後面的n (2)
		//front: 讓cur的next改抓前一位,4.next=front 3
		ListNode front =new ListNode(-1);
		for (int i=1;i<=m-1;i++) {
			cur=cur.next;
		}
		pre=cur;
		last=cur.next;
		for (int i=m;i<=n;i++) {
			cur=pre.next;
			pre.next=cur.next;
			cur.next=front;
			front=cur;			
		}
		last.next=pre.next;
		pre.next=cur;
	
		ListNode tmp =dummy.next;
		System.out.println("start");
		while(tmp !=null) {
			System.out.println(tmp.val);
			tmp=tmp.next;
		}
	}

	
	public static void main(String[] args) {
		ListNode nodeHead=new ListNode(1);
		ListNode nextNode;
		nextNode=nodeHead;
		for (int i=2;i<=5;i++) {	
			    ListNode tmpNode = new ListNode(i);  //生成新的节点
	            nextNode.next=tmpNode;               //把心节点连起来
	            nextNode=nextNode.next; 
		}
		ListNode tmpNode=nodeHead;
		while(tmpNode !=null) {
			System.out.println(tmpNode.val);
			tmpNode=tmpNode.next;
		}
		reverse(nodeHead,2,4);
//		for (int i=0;i<=4;i++) {		
//			System.out.println(tmpNode.val);
//			tmpNode=tmpNode.next;
//		}
//		
	}

}
