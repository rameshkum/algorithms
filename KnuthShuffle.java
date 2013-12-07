package hr.grubic.algorithms;

public class KnuthShuffle {

	public static void shuffle(int[] A) {
		int N = A.length;
		for (int j=N-2; j>=0; j--) {
			double R = Math.random();
			int k =(int) (R*j +1);
			int tmp = A[k];
			A[k] = A[j];
			A[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] cards = new int[52];
		for (int i=0; i<51; i++) {
			cards[i] = i;
		}
		shuffle(cards);
		for (int i=0; i<51; i++) {
			System.out.print(cards[i]+ " ");
		}
 	}
}
