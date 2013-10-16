package hr.grubic.algorithms;

public class BinarySearch {

	public static int iterativeBinarySearch(int number,int[] arrayToSearch) {
		if (arrayToSearch == null || arrayToSearch.length==0) {
			return -1;
		}
		int min = 0;
		int max = arrayToSearch.length-1;
		int mid = 0;
		while (max >=min) {		
			mid = (min+max)/2;
			if (arrayToSearch[mid] < number) {
				min=mid+1;
			} else if (arrayToSearch[mid] > number) {
				max=mid-1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int number, int[]arrayToSearch) {
		return BinarySearch.recursiveBinarySearch(number, arrayToSearch, 0, arrayToSearch.length-1);
	}
	
	public static int recursiveBinarySearch(int number, int[] arrayToSearch, int min, int max) {
		if (arrayToSearch==null || arrayToSearch.length==0) {
			return -1;
		}
		if (max < min) {
			return -1;
		}
		int mid = (min+max)/2;
		if (number == arrayToSearch[mid]) {
			return mid;
		}
		if (arrayToSearch[mid] < number) {
			return recursiveBinarySearch(number, arrayToSearch, mid+1, max);
		} 
		if (arrayToSearch[mid] > number) {
			return recursiveBinarySearch(number, arrayToSearch, min, mid-1);
		}
		return -1;
	}
	
	
	public static int modifiedBinarySearch(int number, int[] arrayToSearch) {
		if (arrayToSearch == null || arrayToSearch.length==0) {
			return -1;
		}
		int min = 0;
		int max = arrayToSearch.length-1;
		int mid = 0;
	
		while (max >=min) {
			mid = (min+max)/2;
			if (arrayToSearch[mid] < number ) {
				min=mid+1;
			} else if (arrayToSearch[mid] > number ) {
				max=mid-1;
			} else {
				return mid;
			}
		}
		return (number < arrayToSearch[mid] ) ? -mid : -(mid + 1);
		
	}
	
	public static void main(String[] binarySearch) {
		System.out.println(iterativeBinarySearch(11, new int[]{0,7,9,10,13,15,17}));
	}
}
