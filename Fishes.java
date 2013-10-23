package hr.grubic.algorithms;

import java.util.Stack;

/**
 * 

You are given two non-empty zero-indexed arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river. The fish are numbered from 0 to N − 1, fish number P is represented by A[P] and B[P], and if P < Q then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:

        0 represents a fish flowing upstream,
        1 represents a fish flowing downstream.

If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:

        If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
        If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.

We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

For example, consider arrays A and B such that:

  A[0] = 4    B[0] = 0
  A[1] = 3    B[1] = 1
  A[2] = 2    B[2] = 0
  A[3] = 1    B[3] = 0
  A[4] = 5    B[4] = 0

Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, numbers 0 and 4, never meet and therefore stay alive.
 * @author maja
 *
 */
public class Fishes {
    public static int solution(int[] A, int[] B) {
        // write your code here...
        if (A==null || B == null) return 0;
        Stack<Integer> fishesDownstream = new Stack<Integer>();
        for (int q=0; q< A.length; q++) {
            if (B[q] == 1) {
                fishesDownstream.push(q);
            } else {
                if (fishesDownstream.isEmpty()) continue;
                int p = fishesDownstream.pop();
                if (p<q && B[p] == 1 && B[q] == 0) {
                    //fishes meet
                    if (A[p] > A[q]) {
                        //p eats q
                        A[q] = -1;
                        fishesDownstream.push(p);
                    } else {
                        //q eats p
                        A[p] = -1;
                    }
                }
            }
        }
        int alive = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] != -1) {
                alive++;
            }
        }
        return alive;
    }
    
    
    public static void main(String[]args) {
    	int A[] = new int[]{4,3,2,1,5};
    	int B[] = new int[]{0,1,0,0,0};
    	System.out.println(solution(A,B));
    }
}
