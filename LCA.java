package hr.grubic.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Find LCA using only parent pointer
 *
 */
public class LCA {

	private class Node {
		String value;
		Node parent;
		public Node(String val) {
			this.value = val;
			this.parent = null;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
		public boolean equals(Object o) {
			if (o == null) return false;
			if (!(o instanceof Node)) return false;
			Node other = (Node) o;
			return value.equals(other.value);
		}
		
		public int hashCode() {
			return value.hashCode();
		}
		
	}
	
	/**
	 *           Z
	 *         / |   \
	 *        G  H    I
	 *      /  \
	 *     C    A
	 *    /
	 *   B  
	 * @return
	 */
	private static Node getLca() {
		LCA lca = new LCA();
		
		Node z = lca.new Node("Z");
		Node g = lca.new Node("G");
		Node h= lca.new Node("H");
		Node i = lca.new Node("I");
		g.setParent(z);
		h.setParent(z);
		i.setParent(z);
		
		Node c = lca.new Node("C");
		Node a= lca.new Node("A");
		Node b = lca.new Node("B");
		c.setParent(g);
		a.setParent(g);
		b.setParent(c);
		
		return lca.getLCA(b, a);
		
	}
	
	public Node getLCA(Node first, Node second) {
		Set<Node> visitedNodes = new HashSet<Node>();
		Node lca = null;
		while (first != null || second != null) {
			if (first != null && visitedNodes.contains(first)) {
				lca = first;
				break;
			}
			if (second != null && visitedNodes.contains(second)) {
				lca = second;
				break;
			}
			visitedNodes.add(first);
			visitedNodes.add(second);
			if (first!= null) first = first.parent;
			if (second!=null) second = second.parent;
		}
		
		return lca;
	}
	

	
	public static void main(String[] args) {
		Node n = getLca();
		System.out.println(n.value);
	}
}
