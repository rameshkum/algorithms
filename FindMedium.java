package hr.grubic.algorithms;

/**
 * Given a linked list, find middle element with only one iteration
 *
 */
public class FindMedium {

	
	private static class ListNode {
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
		
		public static ListNode findMiddle(ListNode head) {
			if (head == null) return null;
			ListNode mid = head;
			int i = 0;
			while (head.next != null) {
				head = head.next;
				i++;
				if (i%2==0) {
					mid = mid.next;
				}
			}
			
			return mid;
		}
	
	
}
