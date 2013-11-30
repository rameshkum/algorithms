package hr.grubic.algorithms;

import java.util.ArrayList;
import java.util.List;

public class KWayMerge {

	private static class Node {
		Integer val;
		int row;
		int index;
		
		public Node(Integer val, int row, int index) {
			this.val = val;
			this.row = row;
			this.index = index;
		}

	}
	
	
	public static List<Integer> merge(List<Integer>... lists) {
		int k = lists.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i=0;
		ArrayList<Node> minHeap = new ArrayList<Node>();
		//for convenience, first element is null
		//indexing starts at 1
		minHeap.add(null);
		
		//create initial minHeap with first elements from each array
		for (int j=0; j<k; j++) {
			List<Integer> currentList = lists[j];
			if (currentList == null || currentList.isEmpty()) continue;
			Node node = new Node(currentList.get(i), j, i);
			insertIntoMinHeap(minHeap, node);
		}
		//while minHeap is not empty remove smallest element;
		//add to the minHeap next element from the same row as the removed element
		while(minHeap.size() > 1) {
			Node minNode = delMin(minHeap);
			result.add(minNode.val);
			int row = minNode.row;
			int index = minNode.index;
			List<Integer> currentList = lists[row];
			if (index >= currentList.size()-1) continue;
			index++;
			Node node = new Node(currentList.get(index), row, index);
			insertIntoMinHeap(minHeap, node);
		}
		return result;
	}
	
	private static void insertIntoMinHeap(ArrayList<Node> minHeap, Node x) {
		minHeap.add(x);
		swim(minHeap, minHeap.size()-1);
	}

	private static void swim(ArrayList<Node> minHeap, int k) {
		while (k> 1 && minHeap.get(k/2).val > minHeap.get(k).val) {
			exchange(minHeap, k, k/2);
			k = k/2;
		}
	}
	
	private static Node delMin(ArrayList<Node> minHeap) {
		//for convenience, smallest element is at 1
		Node min = minHeap.remove(1);
		//put last element first
		int n = minHeap.size();
		if (n==1) return min;
		Node last = minHeap.remove(n-1);
		minHeap.add(1, last);
		//sink the new top to its right position
		sink(minHeap);
		return min;
	}
	
	private static void sink(ArrayList<Node> minHeap) {
		int n = minHeap.size()-1;
		int k = 1;
		while (2*k <= n) {
			int j= 2*k;
			//find smaller child
			if (j<n && minHeap.get(j).val > minHeap.get(j+1).val) {
				j++;
			}
			//nothing to exchange; already in the right order
			if(minHeap.get(k).val < minHeap.get(j).val) break;
			//exchange parent with smaller of its children
			exchange(minHeap, k, j);
			k =j;
		}
		
	}

	private static void exchange(ArrayList<Node>list, int i, int j) {
		Node tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	private static ArrayList<Node> createMinHeap(ArrayList<Node> original) {
		ArrayList<Node> minHeap = new ArrayList<Node>();
		minHeap.add(null);
		for (Node x: original) {
			minHeap.add(x);
			swim(minHeap, minHeap.size()-1);
		}
		return minHeap;
	}
	
	public static void main(String[]args) {
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		firstList.add(5);
		firstList.add(10);
		firstList.add(15);
		firstList.add(20);
		
		ArrayList<Integer> secondList = new ArrayList<Integer>();
		secondList.add(10);
		secondList.add(13);
		secondList.add(16);
		secondList.add(19);
		
		ArrayList<Integer> thirdList = new ArrayList<Integer>();
		thirdList.add(2);
		thirdList.add(19);
		thirdList.add(26);
		
		ArrayList<Integer> fourthList = new ArrayList<Integer>();
		fourthList.add(18);
		fourthList.add(22);
		fourthList.add(23);
		fourthList.add(24);
		
		Node node = new Node(23, 0, 0);
		Node node2 = new Node(24, 0, 0);
		Node node3 = new Node(25, 0, 0);
		Node node4 = new Node(23, 0, 0);
		ArrayList<Node> minHeap = new ArrayList<Node>();
		//for convenience, first element is null
		//indexing starts at 1
		minHeap.add(null);
		insertIntoMinHeap(minHeap, node);
		insertIntoMinHeap(minHeap, node2);
		insertIntoMinHeap(minHeap, node3);
		insertIntoMinHeap(minHeap, node4);
		
		System.out.println(merge(firstList, secondList, thirdList, fourthList));
	}
}
