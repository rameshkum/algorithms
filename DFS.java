package hr.grubic.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {

	private static boolean[] marked;
    private static int[] edgeTo;
    private static Stack<Integer> cycle;
    
	public static void main(String[] args) {
		List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2})));
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,3}))); 
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,3}))); 
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,6,7})));
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{6})));
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{6})));
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3,4,5,7})));
		graph.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{3,6}))); 
		int nrOfTrees = dfs(graph);
		System.out.println(nrOfTrees);
	}

	private static int dfs(List<ArrayList<Integer>> graph) {
		
		int ret = 1;
		for (int i=0; i<graph.size();i++) {
			boolean[] visited = new boolean[graph.size()];
			System.out.println("===="+i);
			Stack<Integer> cycle = new Stack<Integer>();
			int tmp = dfs(graph, visited, cycle, i, i);
			 if (tmp > 0)  ret *= tmp;
			System.out.println();
		}
		return ret;
	}
	// depth first search from v
    private static int dfs(List<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> cycle, int start, int current) {
    	System.out.print(" "+current);
    	if (visited[current]) {
    	   if (current == start && cycle.size() != 2 && min(cycle) == start) {
    		   return cycle.size();
    	   } else	return -1;
       }
    	visited[current] = true;
    	cycle.push(current);
        List<Integer> adj = graph.get(current);
        for (Integer w: adj) {
        	
        	int ret = dfs(graph, visited, cycle, start,w);
        	if (ret >0) {
        		return ret;
        	}
        }
        cycle.pop();
        visited[current] =false;
        return -1;

    }

	private static int min(Stack<Integer> cycle2) {
		int min = Integer.MAX_VALUE;
		for (Integer i:cycle2) {
			if (i<min) {
				min = i;
			}
		}
		return min;
	}
}
