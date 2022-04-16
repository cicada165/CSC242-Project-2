import java.util.LinkedList;

public class CanadaCSP {
	
	public CSP<String,String> initialize(){
		LinkedList<Node<String, String>> node = new LinkedList<Node<String, String>>();
		LinkedList<String> domain = new LinkedList<String>();
		LinkedList<Constraint<String,String>> c = new LinkedList<Constraint<String,String>>();
		
		//Initialize the domain
		domain.add("r");domain.add("g");domain.add("b");
		
		Node<String,String> Y = new Node<String,String>("Y",domain); node.add(Y);
		Node<String,String> NT = new Node<String,String>("NT",domain); node.add(NT);
		Node<String,String> BC = new Node<String,String>("BC",domain); node.add(BC);
		Node<String,String> A = new Node<String,String>("A",domain); node.add(A);
		Node<String,String> S = new Node<String,String>("S",domain); node.add(S);
		Node<String,String> N = new Node<String,String>("N",domain); node.add(N);
		Node<String,String> M = new Node<String,String>("M",domain); node.add(M);
		Node<String,String> O = new Node<String,String>("O",domain); node.add(O);
		Node<String,String> Q = new Node<String,String>("Q",domain); node.add(Q);
		Node<String,String> NL = new Node<String,String>("NL",domain); node.add(NL);
		Node<String,String> PEI = new Node<String,String>("PEI",domain); node.add(PEI);
		Node<String,String> NS = new Node<String,String>("NS",domain); node.add(NS);
		Node<String,String> NB = new Node<String,String>("NB",domain); node.add(NB);
		
		c.add(new CanadaConstraint("Y","NT"));
		c.add(new CanadaConstraint("Y","BC"));
		c.add(new CanadaConstraint("BC","NT"));
		c.add(new CanadaConstraint("S","NT"));
		c.add(new CanadaConstraint("BC","A"));
		c.add(new CanadaConstraint("A","NT"));
		c.add(new CanadaConstraint("A","S"));
		c.add(new CanadaConstraint("N","NT"));
		c.add(new CanadaConstraint("N","M"));
		c.add(new CanadaConstraint("S","M"));
		c.add(new CanadaConstraint("M","O"));
		c.add(new CanadaConstraint("O","Q"));
		c.add(new CanadaConstraint("Q","NL"));
		c.add(new CanadaConstraint("Q","NB"));
		c.add(new CanadaConstraint("NB","NS"));
		
		return new CSP<String,String>(node,c);
				
	}
}