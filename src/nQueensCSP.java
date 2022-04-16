import java.util.LinkedList;

public class nQueensCSP {
	
	public CSP<Integer, Integer> nQinitialize(int n) {
		LinkedList<Node<Integer, Integer>> node = new LinkedList<Node<Integer, Integer>>();
		LinkedList<Integer> domain = new LinkedList<Integer>();
		LinkedList<Constraint<Integer,Integer>> c = new LinkedList<Constraint<Integer,Integer>>();
		
		//Initialize the domain which takes value from 0 - n
		for(int i = 0;i < n; i++) {
			domain.add(i);
		}
		
		//Initialize each nodes
		for(int i = 0;i < n; i++) {
			node.add(new Node<Integer,Integer>(i,domain));
		}
		
		//Initialize the constraint
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				c.add(new nQueenConstraint(i,j));
			}
		}
		
		return new CSP<Integer,Integer>(node, c);
	}
}
