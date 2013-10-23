package hr.grubic.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithms {
	
	/*************************************************************************************************
	 * MERGE SORT
	 * Running time: O(nlogn)
	 *************************************************************************************************/
	public static int[] mergeSort(int[] A) {
		if (A == null) {
			return null;
		}
		if (A.length == 0 || A.length == 1) {
			return A;
		}
		int n = A.length;
		int mid = A.length/2;
		int[] leftArray = Arrays.copyOfRange(A, 0, mid);
		int[] rightArray = Arrays.copyOfRange(A, mid, n);
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return merge(leftArray, rightArray);
	}
	
	private static int[]merge(int[] A1, int[] A2) {
		int n1 = A1.length;
		int n2 = A2.length;
		int i = 0;
		int j = 0;
		int k = 0;
		int[] mergedArray = new int[n1+n2];
		while (i< n1 && j < n2) {
			int el1 = A1[i];
			int el2 = A2[j];
			if (el1 < el2) {
				mergedArray[k] = el1;
				i++;
			} else {
				mergedArray[k] = el2;
				j++;
			}
			k++;
		}
		while (i<n1) {
			mergedArray[k] = A1[i];
			i++;
			k++;
		}
		while (j<n2) {
			mergedArray[k] = A2[j];
			j++;
			k++;
		}
		return mergedArray;
	}
	
	
	/**********************************************************************************************************
	 * SELECTION SORT
	 * Running time: O(n2)
	 ************************************************************************************************************/
	public static int[] selectionSort(int[] A){
		if (A == null) {
			return null;
		}
		if (A.length == 0 || A.length == 1) {
			return A;
		}
		for (int i=0; i<A.length; i++) {
			int min = A[i];
			int minIndex = i;
			for (int j=i+1;j<A.length;j++) {
				if (A[j] < min) {
					min = A[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int tmp = A[i];
				A[i] = min;
				A[minIndex] = tmp;
			}
		}
		return A;
	}
	
	
	/**********************************************************************************************************
	 * INSERTION SORT
	 * Running time: O(n2)
	 ************************************************************************************************************/
	public static int[] insertionSort(int[] A){
		if (A == null) {
			return null;
		}
		if (A.length == 0 || A.length == 1) {
			return A;
		}
		for (int i=1; i< A.length; i++) {
			// A[0..i-1] are in sorted order
			int valueToInsert = A[i];
			//mark current position
			int k = i;
		    // keep moving down the array
			// compare each element with value to insert
			while (k>0 && A[k-1]> valueToInsert) {
				A[k] = A[k-1];
				k--;
			}
			A[k]=valueToInsert;
		}
		return A;
	}
	
	/**********************************************************************************************************
	 * QUICKSORT
	 * Running time: O(nlogn); worstCase: O(n2)
	 * @return 
	 ************************************************************************************************************/
	public static List<Integer> quickSort(List<Integer> list){
		if (list == null) {
			return null;
		}
		int n = list.size();
		if (n == 0 || n == 1) {
			return list;
		}
		int pivotIndex = choosePivot(list);
		Integer pivot = list.get(pivotIndex);
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		List<Integer> pivotList = new ArrayList<Integer>();
		java.util.Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer el = it.next();
			if (el<pivot) {
				leftList.add(el);
			} else if (el>pivot){
				rightList.add(el);
			} else {
				pivotList.add(el);
			}
		}
		leftList = quickSort(leftList);
		rightList = quickSort(rightList);
		leftList.addAll(pivotList);
		leftList.addAll(rightList);
		return leftList;
	}
	
	private static int choosePivot(List<Integer> list) {
		int n = list.size();
		int pivot = n/2;
		return pivot;
	}
	
	public static List<Integer> quicksortInPlace(List<Integer> list) {
		if (list == null) {
			return null;
		}
		int begin = 0;
		int end = list.size()-1;
		return quicksort(list, begin, end);
	}
	
	private static List<Integer> quicksort(List<Integer>list, int begin, int end) {
		System.out.println(list);
		if (end > begin) {
			int pivotIndex = (end-begin)/2;
			System.out.println(pivotIndex);
			int newPivotIndex = partition(list, begin, end, pivotIndex);
			System.out.println(newPivotIndex);
			quicksort(list, begin, newPivotIndex);
			quicksort(list, newPivotIndex+1, end);
		}
		return list;
	}

	private static int partition(List<Integer> list, int begin, int end, int pivotIndex) {
		
		int pivot = list.get(pivotIndex);
		Collections.swap(list, pivotIndex, end);
		int storeIndex = begin;
		for (int i=begin; i<end-1; i++)  {
			if (list.get(i)<pivot) {
				Collections.swap(list, storeIndex, i);
				storeIndex++;
			}
		}
		Collections.swap(list, storeIndex, end);
		return storeIndex;
	}
	
	public static void main(String[] args) {
		Integer[] arrayToSort = new Integer[] { 17,3,2,9,1,6,4, 12, 2, 19};
		int[] A = new int[] { 17,3,2,9,1,6,4, 12, 2, 19};
		System.out.println(arrayToSort);
		List<Integer> sortedList = quicksortInPlace(Arrays.asList(arrayToSort));
		for (int i= 0; i< sortedList.size(); i++) {
			System.out.println(sortedList.get(i));
		}
		
	}

}
