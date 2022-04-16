import java.util.LinkedList;

public class Node<K, V> {
	K Variable;
	LinkedList<V> Domain;
	LinkedList<Node<K,V>> adj;
	
	//Constructor
	public Node(K Variable, LinkedList<V> Domain) {
		this.Variable = Variable;
		this.Domain = Domain;
		adj = new LinkedList<Node<K,V>>();
	}
	
	//Getter
	public LinkedList<V> getDomain(){
		return Domain;
	}
	
	public K getVariable() {
		return Variable;
	}
	
	//Setter
	public void setDomain(LinkedList<V> Domain) {
		this.Domain = Domain;
	}
	
	public void setVariable(K Variable) {
		this.Variable = Variable;
	}
}
