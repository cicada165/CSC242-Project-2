import java.util.LinkedList;

public class JobshopCSP {
	
	public CSP<String,Integer> initialize(){
		LinkedList<Node<String, Integer>> node = new LinkedList<Node<String, Integer>>();
		LinkedList<Integer> domain = new LinkedList<Integer>();
		LinkedList<Constraint<String,Integer>> c = new LinkedList<Constraint<String,Integer>>();
		
		//Initializing the domain 1-27
		for(int i = 1; i < 28; i++ ) {
			domain.add(i);
		}
		
		//Adding all the nodes
		node.add(new Node<String,Integer>("AxleF",domain));
		node.add(new Node<String,Integer>("AxleB",domain));
		node.add(new Node<String,Integer>("WheelRF",domain));
		node.add(new Node<String,Integer>("WheelLF",domain));
		node.add(new Node<String,Integer>("WheelRB",domain));
		node.add(new Node<String,Integer>("WheelLB",domain));
		node.add(new Node<String,Integer>("NutsRF",domain));
		node.add(new Node<String,Integer>("NutsLF",domain));
		node.add(new Node<String,Integer>("NutsRB",domain));
		node.add(new Node<String,Integer>("NutsLB",domain));
		node.add(new Node<String,Integer>("CapRF",domain));
		node.add(new Node<String,Integer>("CapLF",domain));
		node.add(new Node<String,Integer>("CapRB",domain));
		node.add(new Node<String,Integer>("CapLB",domain));
		node.add(new Node<String,Integer>("Inspect",domain));
		
		//Adding all the constraint
		JobshopConstraint c1 = new JobshopConstraint ("AxleF", "WheelRF", 10); c.add(c1);
		JobshopConstraint c2 = new JobshopConstraint ("AxleF", "WheelLF", 10); c.add(c2);
		JobshopConstraint c3 = new JobshopConstraint ("AxleB", "WheelRB", 10); c.add(c3);
		JobshopConstraint c4 = new JobshopConstraint ("AxleB", "WheelLB", 10); c.add(c4);
		JobshopConstraint c5 = new JobshopConstraint ("WheelRF", "NutsRF", 1); c.add(c5);
		JobshopConstraint c6 = new JobshopConstraint ("WheelLF", "NutsLF", 1); c.add(c6);
		JobshopConstraint c7 = new JobshopConstraint ("WheelRB", "NutsRB", 1); c.add(c7);
		JobshopConstraint c8 = new JobshopConstraint ("WheelLB", "NutsLB", 1); c.add(c8);
		JobshopConstraint c9 = new JobshopConstraint ("NutsRF", "CapRF", 2); c.add(c9);
		JobshopConstraint c10 = new JobshopConstraint ("NutsLF", "CapLF", 2); c.add(c10);
		JobshopConstraint c11 = new JobshopConstraint ("NutsRB", "CapRB", 2); c.add(c11);
		JobshopConstraint c12 = new JobshopConstraint ("NutsLB", "CapLB", 2); c.add(c12);
		JobshopConstraint c13 = new JobshopConstraint ("AxleF", "AxleB", 10); c.add(c13);
		JobshopConstraint c14 = new JobshopConstraint ("Inspect", "AxleF", 10); c.add(c14);
		JobshopConstraint c15 = new JobshopConstraint ("Inspect", "AxleB", 10); c.add(c15);
		JobshopConstraint c16 = new JobshopConstraint ("Inspect", "WheelRF", 1); c.add(c16);
		JobshopConstraint c17 = new JobshopConstraint ("Inspect", "WheelLF", 1); c.add(c17);
		JobshopConstraint c18 = new JobshopConstraint ("Inspect", "WheelRB", 1); c.add(c18);
		JobshopConstraint c19 = new JobshopConstraint ("Inspect", "WheelLB", 1); c.add(c19);
		JobshopConstraint c20 = new JobshopConstraint ("Inspect", "NutsRF", 2); c.add(c20);
		JobshopConstraint c21 = new JobshopConstraint ("Inspect", "NutsLF", 2); c.add(c21);
		JobshopConstraint c22 = new JobshopConstraint ("Inspect", "NutsRB", 2); c.add(c22);
		JobshopConstraint c23 = new JobshopConstraint ("Inspect", "NutsLB", 2); c.add(c23);
		JobshopConstraint c24 = new JobshopConstraint ("Inspect", "CapRF", 1); c.add(c24);
		JobshopConstraint c25 = new JobshopConstraint ("Inspect", "CapLF", 1); c.add(c25);
		JobshopConstraint c26 = new JobshopConstraint ("Inspect", "CapRB", 1); c.add(c26);
		JobshopConstraint c27 = new JobshopConstraint ("Inspect", "CapLB", 1); c.add(c27);
		
		//Return csp
		return new CSP<String, Integer> (node,c);
	
	}
}
