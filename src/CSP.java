import java.util.LinkedList;

public class CSP<K,V> {
	LinkedList<Node<K,V>> node;
	LinkedList<Constraint<K,V>> constraint;
	
	public CSP(LinkedList<Node<K,V>> node, LinkedList<Constraint<K,V>> constraint) {
		this.node = node;
		this.constraint = constraint;
	}
	
	public LinkedList<Node<K,V>> getNode() {
		return node;
	}
	
	public LinkedList<Constraint<K,V>> getConstraint() {
		return constraint;
	}
	
	public void setNode(LinkedList<Node<K,V>> node) {
		this.node = node;
	}
	
	public void setConstraint(LinkedList<Constraint<K,V>> constraint) {
		this.constraint = constraint;
	}
	
	
}
