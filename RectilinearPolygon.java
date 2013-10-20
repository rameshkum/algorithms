package hr.grubic.algorithms;

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
 */
public class RectilinearPolygon {

	public int intersection(int K, int L, int M, int N, int P, int Q, int R, int S) {
		int x1=Math.max(K,P);
		int x2=Math.min(R,M);
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
}
