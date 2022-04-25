import java.util.Random;

public class LeeCode_0206_Reverse_Linked_List {
	public static void reverse(ListNode head,int length){	
		ListNode front=null;
		ListNode nxt=new ListNode(-1);
		while (head !=null) {
			nxt=head.next;
			head.next=front;
			front=head;
			head=nxt;
		}
//		for (int i=1;i<length;i++) {
//			nxt=head.next;
//			head.next=front;
//			front=head;
//			head=nxt;		
//		}
		while (front !=null) {
			System.out.print(front.val + " ");
			front=front.next;
		}
		System.out.println("Finish");
//		for (int i=1;i<=length;i++) {
//			System.out.print(head.val+" ");
//			head=head.next;
//			
//		}

	}
	public static void main(String[] args) {
		Random rand=new Random();
		ListNode head=new ListNode(1);//rand.nextInt(10)
		ListNode nxt=head;		
		int target=7;
		for (int i=2;i<=target;i++) {
			nxt.next=new ListNode(i);	
			nxt=nxt.next;
		}
		nxt=head;
		while (nxt !=null) {
			System.out.print(nxt.val+" ");
			nxt=nxt.next;
		}
		System.out.print("\n");
		reverse(head,target);
	}

}
