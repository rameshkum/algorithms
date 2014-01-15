package hr.grubic.algorithms;

/**
 * Determine if a given linked list is a palindrome
 * @author macbookpro
 *
 */
public class PalindromeList {

	private class Node {
		char val;
		Node next;
		
		public Node(char val) {
			this.val = val;
			this.next = null;
		}
		
		public String toString() {
			Node tmp = this;
			StringBuilder sb = new StringBuilder();
			while (tmp != null) {
				sb.append(tmp.val);
				tmp = tmp.next;
			}
			return sb.toString();
		}
	}
	
	public boolean isPalindrome(Node head) {
		if (head == null) {
			return false;
		}
		Node fast = head;
		Node slow = head;
		Node slowPrev = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slowPrev= slowPrev.next;
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
	    }
	
		Node second = slow;
		second = reverse(second);
		
		while (head != slowPrev && second != null) {
			if (head.val != second.val) return false;
			head = head.next;
			second = second.next;
		}
		
		return true;
	}

	private Node reverse(Node head) {
		if (head == null) return null;
		Node first = head;
		Node rest = head.next;
		if (rest == null) return first;
		
		Node reversedHead = reverse(rest);
		first.next.next = first;
		first.next = null;
		
		return reversedHead;
	}
	
	public static void main (String[] args) {
		PalindromeList pl = new PalindromeList();
		Node n = pl.new Node('a');
		Node n1 = pl.new Node('b');
		Node n2 = pl.new Node('b');
		Node n3 = pl.new Node('b');
		n.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = pl.new Node('a');
		System.out.println(pl.isPalindrome(n));
		
	}
}
