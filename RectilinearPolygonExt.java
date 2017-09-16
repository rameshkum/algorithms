package com.myown;

/*
 *A rectangle is called rectilinear if its edges are all parallel to coordinate axes. 
 *Such a rectangle can be described by specifying the coordinates of its bottom-left and top-right corners.
 
* Write a function
* that, given eight integers representing two rectilinear rectangles
* (one with lower-left corner (K, L) and upper-right corner (M, N),
* and another with lower-left corner (P, Q) and upper-right corner (R, S)),
* returns the area of their intersection. The function should return 0
* if the intersection is a point or a line segment, or if the rectangles do not intersect.
* The function should return −1 if the area of the intersection exceeds 2,147,483,647.
*
*for example for given integers
*K=-4, L=1, M=2, N=6
*P=0, Q=-1, R=4, S=3
*
*The function sould return 42
* The area of the first rectilinear is 30, the area of the second rectilinear is 16 and area of their intersection is 4.
* 
*
*The function sould return 42
*/

public class RectilinearPolygonExt {
	
	public static int intersection(int K, int L, int M, int N, int P, int Q, int R, int S) {
		int x1=Math.max(K,P);
		int x2=Math.min(M,R);
		int x=x2-x1;

		int y1=Math.max(L,Q);
		int y2=Math.min(N,S);
		int y=y2-y1;

		long area;
		if ((x>=0) && (y>=0)) {
		    area=x*y;
		    if (area>Integer.MAX_VALUE) {
		        area=-1;
		    }
		} else {
		    area=0;
		}
		return (int) area;
	}

	public static int  solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
		  int rectOneArea = area(K, L, M, N);
		  int rectTwoArea = area(P, Q, R, S);
		  int overLapArea = intersection(K, L, M, N, P, Q, R, S);
		  return rectOneArea + rectTwoArea - overLapArea;
	}

	public static int area(int a, int b, int c, int d) {
		  int width = Math.abs(a - c);
		  int height = Math.abs(b - d);
		  return width * height;
	}
	
	public static void main(String[] args){
		int area = intersection(-4, 1,2, 6, 0,-1,4,3);
		System.out.println(area);
		System.out.println("solution:"+solution(-4, 1,2, 6, 0,-1,4,3));
	}
	
}
