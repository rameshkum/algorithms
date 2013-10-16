package hr.grubic.algorithms;

public class ListNode {

	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if (l1 == null && l2 == null) {
	            return null;
	        }
		 
		 ListNode l3 = null;
		 ListNode first = null;
		 ListNode last = null;
		 while ((l1 != null) && (l2 != null)) {
	            if (l1.val < l2.val) {
	            	ListNode temp = new ListNode(l1.val);
	            	insert(first,last,temp);
	            	l1 = l1.next;
	            } else {
	            	ListNode temp = new ListNode(l2.val);
	            	insert(first,last,temp);
	                l2 = l2.next;
	            }
	        
		 }
		 while ((l1 != null)) {
			 insert(first,last,l1);
			 l1 = l1.next;
		 }
		 while (l2 != null) {
			 insert(first,last,l2);
			 l2 = l2.next;
		 }
		 l3 = first;
		 return l3;
	 }
	 
	 public static void insert(ListNode first, ListNode last, ListNode n) {
		 if(first==null){
             first = n; 
             last= n;
         }
         else{
             last.next = n;
             last=n;
         }
		}
	 
	 @Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append("{ ");
		 sb.append(val);
		 ListNode temp = this.next;
		 while (temp != null) {
			 sb.append(temp.val);
			 sb.append(" ,");
			 temp = temp.next;
		 }
		sb.append("}");
		return sb.toString();
	 }
	 
	 
	 public static void main(String[] args) {
		 ListNode l1 = new ListNode(2);
		 ListNode l2 = new ListNode(1);
		 ListNode l3 = ListNode.mergeTwoLists(l1, l2);
		 System.out.println(l3.toString());
	 }
}
