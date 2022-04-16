import java.util.Map;

public class Constraint<K,V> {
	K V1;
	K V2;
	
	public Constraint(K V1, K V2) {
		this.V1 = V1;
		this.V2 = V2;
	}
	
	public K getV1() {
		return V1;
	}
	
	public K getV2() {
		return V2;
	}
	
	public void setV1(K V1) {
		this.V1 = V1;
	}
	
	public void setV2(K V2) {
		this.V2 = V2;
	}
	
	public boolean kankei(K V1, K V2, Map<K, V> s) {
		return false;
	}
}
