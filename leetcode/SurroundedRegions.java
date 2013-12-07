package hr.grubic.algorithms.leetcode;

import java.util.Stack;

public class SurroundedRegions {

	private class Node {
		int x;
		int y;
		char val;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	
	public void solve(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (board == null || board.length == 0) return;
        Stack<Node> s = new Stack<Node>();
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++) {
        	mark(i, 0, board);
        	mark(i, m-1, board);
        }
        for (int j=0; j<m; j++) {
        	mark(0, j, board);
        	mark(n-1, j, board);
        }
        for (int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		if (board[i][j] =='O') {
        			board[i][j] = 'X';
        		}
        	}
        }
        for (int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		if (board[i][j] =='+') {
        			board[i][j] = 'O';
        		}
        		System.out.print(board[i][j] + " ");
        	}
        	System.out.println();
        }
    }
	
	private void mark(int x, int y, char[][] board) {
		int n = board.length;
	    int m = board[0].length;
	    if (x<0 || x >= n || y<0 || y>=m) return;
	    if (board[x][y] == 'X') return;
	    if (board[x][y] == 'O') {
	    	board[x][y] = '+';
	    	mark(x-1, y,board);
	    	mark(x, y-1,board);
	    	mark(x,y+1,board);
	    	mark(x+1,y, board);
	    }
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][] {
				"OXXOX".toCharArray(),
				"XOOXO".toCharArray(),
				"XOXOX".toCharArray(),
				"OXOOO".toCharArray(),
				"XXOXO".toCharArray()
				
		};
		new SurroundedRegions().solve(board);
	}
}
