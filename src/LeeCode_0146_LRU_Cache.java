import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//获取数据 `get(key)` - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 `put(key, value)` - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

//get(key) - Get the value (will always be positive) of the key if the key
// * exists in the cache, otherwise return -1.
// * put(key, value) - Set or insert the value if the key is not already present.
// * When the cache reached its capacity, it should invalidate the least recently
// * used item before inserting a new item.
// * 
// * The cache is initialized with a positive capacity.
//put 跟get都插到最底部, 都從最頂部移除
//put有的值時,插到底部並改該連接值  PUT沒值時直接插底部,並移除最上層(少用的)的值
public class LeeCode_0146_LRU_Cache {
	static class LRUCache{
		static class Node{
			private int key;
			private int value;
			Node pre,next;
			Node(){
				
			}
			Node(int key,int value){
				this.key=key;
				this.value=value;
			}
		}
		private static int capacity;
		private static Map<Integer,Node> map;
		static private Node head,tail;
		public LRUCache(int Input_capacity) {
			this.capacity=Input_capacity;
			this.map=new HashMap<>();
			this.head=new Node(-1,-1);
			this.tail=new Node(-1,-1);
			head.next=tail;
			tail.pre=head;
		}
		static int get(int key) {
			Node node=getNode(key);
			if (node==null) {
				return -1;
			}
			System.out.print("get "+key+ " "+ node.value);
			print();
			return node.value;
		}
		static Node getNode(int key) {
			Node node=map.get(key);
			if (node==null) {
				return null;
			}
			disconnect(node);
			InsertHead(node);
			return node;			
		}
		static void disconnect(Node node) {
			node.next.pre=node.pre;
			node.pre.next=node.next;
		}
		static void InsertHead(Node node) {
			node.next=head.next;
			node.next.pre=node;
			node.pre=head;
			head.next=node;
			
		}
		static void put(int key,int value) {			
			Node node=getNode(key);
			if (node!=null){	
				node.value=value;
			}else {
				Node node_New=new Node(key,value);
				InsertHead(node_New);
				map.put(key, node_New);
				if (map.size()>capacity) {
					Node lastNode = tail.pre;
					disconnect(lastNode);
					map.remove(lastNode.key);
				}			
			}
			System.out.print("put " +key+"-"+value);
			print();
		}
		static void print() {
			
			Node tmp =head.next;
			System.out.println("");
			
			for (int i=1;i<=map.size();i++) {		
				System.out.print(tmp.key+"-"+tmp.value+"  ");
				tmp=tmp.next;
			}
			System.out.println("");
		
		}
	}

	
	public static void main(String[] args) {
		LRUCache aa =new LRUCache(5);
		for (int i=1;i<=aa.capacity;i++) {
			aa.put(i, i);
		}
		aa.get(3);
		aa.get(6);
		aa.get(2);
		aa.put(4, 2);
		aa.put(6, 2);
	}
	

}
