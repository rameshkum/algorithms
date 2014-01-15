package hr.grubic.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ABCPath {

	private static int maxPath= 0;
	private static char[][] A;
	private static boolean[][]marked;
	
	public static int solve(char[][]arr) {
		if (arr==null) return 0;
		A = arr;
		int n = arr.length;
		int m = arr[0].length;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (arr[i][j] == 'A') {
					marked = new boolean[n][m];
					dfs(i,j, 1);
				}
			}
		}
		return maxPath;
	}
	private static void dfs(int i, int j, int currPathLen) {
		int n = A.length;
		int m = A[0].length;
		char c = A[i][j];
		marked[i][j] = true;
		for (int k=i-1; k<=i+1; k++) {
				if (k<0 || k>=n) continue;
				for (int l=j-1; l<=j+1; l++) {
					if (l<0 || l>=m) continue;
				
					if (A[k][l] == c+1 && !marked[k][l]) {
						dfs(k,l,currPathLen+1);
					}
				}
			}
			
		if (currPathLen>maxPath) {
				maxPath = currPathLen;
		}
	}
	
	public static void find() {
		int n = A.length;
		int m = A[0].length;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (A[i][j] == 'A') {
					char curr = 'A';
					int pathLen = 0;
					boolean found = false;
					do {
					for (int k=i-1; k<=i+1; k++) {
						if (k<0 || k>=n) continue;
						for (int l=j-1; l<=j+1; l++) {
							if (l<0 || l>=m) continue;
							if (A[k][l] == curr+1) {
								pathLen++;
								found = true;
							}
						}
					}
					curr = (char) (curr+1);
					} while (found);
				}
			}
		}
	}
	
	public static void main(String[]args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int H = Integer.parseInt(line.split(" ")[0]);
		int W = Integer.parseInt(line.split(" ")[1]);
		char[][] A = new char[H][W];
		String[] lines = new String[H];
		for (int i=0; i<H; i++) {
			lines[i] = reader.readLine();
		}
		reader.readLine();
		for (int i=0; i<H; i++) {
			String[] st = lines[i].split(" ");
			for (int j=0; j<W; j++) {
				A[i][j] = st[j].charAt(0);
			}
		}
		System.out.println(" " + solve(A));
	}
}
