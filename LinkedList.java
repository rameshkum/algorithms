package hr.grubic.algorithms;

import java.util.Stack;

public class LinkedList {

	private static class Node {
		int value;
		Node next;
		Node(int val) {
			this.value = val;
			this.next = null;
		}
		public static Node createFromArray(int[] arr) {
			Node head =  new Node(arr[0]);
			Node tmp = head;
			for (int i=1; i<arr.length;i++) {
				head.next = new Node(arr[i]);
				head = head.next;
			}
			return tmp;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node head = this;
			while (head != null) {
				sb.append(head.value).append("->");
				head = head.next;
			}
			sb.append("null");
			return sb.toString();
		}
	}
	
	private Node head;
	
	public LinkedList(int[]arr) {
		head = Node.createFromArray(arr);
	}
	
	public String toString() {
		return head.toString();
	}
	
	public void reverse() {
		System.out.println(head.value);
		head = reverseIterative(head);
	}
	
	private Node reverse(Node head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		Node first = head;
		Node rest = reverse(head.next);
	
		first.next.next = first;
		first.next = null;
		return rest;
	}
	
	private Node reverseWithStack(Node head) {
		if (head == null) return null;
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		head = new Node(stack.pop().value);
		Node tmp = head;
		while (!stack.isEmpty()) {
			tmp.next = new Node(stack.pop().value);
			tmp = tmp.next;
		}
		return head;	
	}
	
	private Node reverseIterative(Node head) {
		if (head == null) return null;
	
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {

			prev.next = curr.next;
			curr.next = head;
			head = curr;
			curr = prev.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		LinkedList list = new LinkedList(arr);
		list.reverse();
		System.out.println(list.toString());
	}
	
	
}
