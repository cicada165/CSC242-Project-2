import java.util.LinkedList;
import java.util.Queue;

public class YXCSP {
	static Queue<Arc<String,Integer>> arc = new LinkedList<>();
	public CSP<String,Integer> initialize(Integer n1, Integer n2){
		LinkedList<Node<String, Integer>> node = new LinkedList<Node<String, Integer>>();
		LinkedList<Integer> domain = new LinkedList<Integer>();
		LinkedList<Integer> domain1 = new LinkedList<Integer>();
		LinkedList<Constraint<String,Integer>> c = new LinkedList<Constraint<String,Integer>>();
		//Initialize the domain for X
		for (int i=0; i<= n1;i++) {
			domain.add(i);
		}
		
		//Initialize the domain for Y
		for (int i=0; i<= n2;i++) {
			domain1.add(i);
		}
		
		Node<String,Integer> x = new Node<String,Integer>("x",domain); node.add(x);
		Node<String,Integer> y = new Node<String,Integer>("y",domain1); node.add(y);
		
		c.add(new YXConstraint("x","y"));
		
		CSP<String,Integer> a=new CSP<String,Integer>(node,c);
		
		
		
		AC3(a);
		
		System.out.println("The domain after AC3 for x is: "+a.node.get(0).Domain);
		System.out.println("The domain after AC3 for y is: "+a.node.get(1).Domain);
		
		
		
		return a;
		
	}
	
	//Revise arcs
	static boolean revise(LinkedList<Integer> x, LinkedList<Integer> y, int type) {
		  boolean revised = false;
		  boolean e = false;
		  
		  if (type==1) {
		  for(int i = 0; i < x.size(); i++) {
		   for(int j = 0; j < y.size(); j++) {
		    if(y.get(j) == x.get(i) * x.get(i)){
		     e = true;
		    }
		   }
		   
		   if(e == false) {
		    revised = true;
		    x.set(i, -1);
		   }
		   
		   e = false;
		  }
		  
		  }else if (type==2) {
		   for(int i = 0; i < x.size(); i++) {
		    for(int j = 0; j < y.size(); j++) {
		     if(y.get(j)*y.get(j) == x.get(i)){
		      e = true;
		     }
		    }
		    
		    if(e == false) {
		     revised = true;
		     x.set(i, -1);
		     
		    }
		    
		    e = false;
		   }
		  }
		  return revised;
		 }
	
	//Method to generate all arcs
	static void generateArc(CSP<String,Integer> csp) {
		for(int i = 0; i < csp.node.size(); i++) {
			for(int j = i + 1; j < csp.node.size(); j++) {
				arc.add(new Arc<String,Integer>( csp.node.get(i), csp.node.get(j) ) );
				
			}
		}
	}
	
	static boolean AC3(CSP<String,Integer> csp) {
		generateArc(csp);
		
		while(arc.isEmpty() == false) {
			Arc<String,Integer> a = arc.remove();			
			
			revise(a.V1.Domain, a.V2.Domain,1);
			revise(a.V2.Domain, a.V1.Domain,2);
			
			
			
			for(int i = a.V1.Domain.size() - 1; i > 0 ;i--) {
				if(a.V1.Domain.get(i) == -1) {
					a.V1.Domain.remove(i);
				}
			}
			
			for(int i = a.V2.Domain.size() - 1; i > 0 ;i--) {
				if(a.V2.Domain.get(i) == -1) {
					a.V2.Domain.remove(i);
				}
			}
		
		}
		
		return true;
	}
	
	
	
}
