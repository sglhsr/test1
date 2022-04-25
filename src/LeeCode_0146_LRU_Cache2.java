import java.util.HashMap;
import java.util.Map;



public class LeeCode_0146_LRU_Cache2 {
	static class LRUCache {
	    static class Node {
	        private int key;
	        private int value;
	        Node prev, next;
	        public Node() {
	        	
	        }
	        public Node(int key, int value) {
	            this.key = key;
	            this.value = value;
	        }
	    }
	    
	    private int capacity;
	    private Map<Integer, Node> map;
	   static  private Node dummyhead, dummytail;

	   public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.map = new HashMap<>();
	        this.dummyhead = new Node(-1, -1);
	        this.dummytail = new Node(-1, -1);
	        this.dummyhead.next = this.dummytail;
	        this.dummytail.prev = this.dummyhead;
	    }
	    
	    public int get(int key) {
	        Node node = getNode(key);
	        if(null == node) return -1;
	        System.out.println("get " + key );
	        printNode();
	        return node.value;
	    }
	    
	    Node getNode(int key) {
	        Node node = map.get(key);
	        if(null == node) return null;
	        disconnect(node);
	        insertHead(node);
	        return node;
	    }
	    
	    void disconnect(Node node) {
	        node.next.prev = node.prev;
	        node.prev.next = node.next;        
	    }
	    
	    void insertHead(Node node) {
	        node.next = dummyhead.next;
	        dummyhead.next.prev = node;
	        node.prev = dummyhead;
	        dummyhead.next = node;        
	    }
	    //如果已經有值了,只需修改value,因只改道head,size不會變
	    public void put(int key, int value) {
	        Node node = getNode(key);
	        if(null != node) {
	            node.value = value;
	        }
	        else {
	            node = new Node(key, value);
	            insertHead(node);
	            
	            map.put(key, node);
	            if(map.size() > capacity) {
	                Node tail = dummytail.prev;
	                disconnect(tail);
	                map.remove(tail.key);
	            }
	        }
	        System.out.println("put /n");
	        printNode();
	    }
	}
	static void printNode() {
		LRUCache.Node cur =new LRUCache.Node();
		cur=LRUCache.dummyhead.next;
		while (cur !=LRUCache.dummytail) {
			System.out.print(cur.key+"-"+cur.value+" ");
			cur=cur.next;
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		int capacity=5;
		LRUCache ary=new LRUCache(capacity);
		for (int i=1;i<=capacity;i++) {
			ary.put(i, i);
		}

		System.out.println("start");
		ary.get(3);
		ary.get(2);
		ary.put(4,6);
		ary.put(5,7);
		ary.put(6,7);
//		System.out.print("\n get 1 value:"+ary.get(1));
//		
//		ary.put(6, 6);

	}

}
