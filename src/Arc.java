
public class Arc<K,V>{
	Node<K,V> V1;
	Node<K,V> V2;
	
	public Arc(Node<K,V> V1, Node<K,V> V2){
		this.V1 = V1;
		this.V2 = V2;
	}
	
	public Node<K,V> getV1() {
		return V1;
	}
	
	public Node<K,V> getV2() {
		return V2;
	}

	public void setV1(Node<K,V> V1) {
		this.V1 = V1;
	}

	public void setV2(Node<K,V> V2) {
		this.V2 = V2;
	}
	
	
}
