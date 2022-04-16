import java.util.LinkedHashMap;
import java.util.Map;

public class BTS<K, V> {
	
	public Map<K, V> BTS(CSP<K, V> csp) {
		Map<K, V> s = new LinkedHashMap<K,V>(); 
		return BackTrack(s, csp);
	}
	
	public Map<K, V> BackTrack(Map<K, V> s, CSP<K, V> csp) {
		//Base case return the solution if csp is empty
		if(csp.node.isEmpty()) {
			return s;
		}
		
		//Choose a node from csp
		Node<K, V> n = selectunassignedV(csp);
		K var = n.Variable; 
		
		//Assign each value in the domain to the variable
		for(V value : n.Domain) {
			boolean f = true;//Boolean to determine if the assigned value follow the constraint
			s.put(var, value);
			for(Constraint<K, V> c : csp.constraint) {
				if(var.equals(c.V1) || var.equals(c.V2)) {
					if(c.kankei(c.V1, c.V2, s) == false) {
						f = false;
						break;
						}
				}
			}
			
			s.remove(var, value); //Remove the mapping regardlessly
			
			if(f == true) {
				s.put(var, value);//Add the mapping again if no inconsistency is discovered
				csp.node.remove(n);//Remove the explored node
				
				//Recursion to explore the next node
				Map<K, V> r = BackTrack(s,csp);
				
				if(r != null) {
					return r;
				}else {
					s.remove(var);
					csp.node.add(n);
				}
			}
		}
		
		return null;
		
	}
	
	//Method to select a Node in csp
	public Node<K,V> selectunassignedV(CSP<K,V> csp) {
		for(Node<K, V> e : csp.node) {
			return e;
		}
		
		return null;
	}
}
