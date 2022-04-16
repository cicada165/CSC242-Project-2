import java.util.Map;

public class YXConstraint extends Constraint<String, Integer>{

	//Constructor
	public YXConstraint(String V1, String V2) {
		super(V1, V2);
	}
	
	//Getter
	@Override
	public String getV1() {
		return V1;
	}
	
	@Override
	public String getV2() {
		return V2;
	}
	
	//Setter
	@Override
	public void setV1(String V1) {
		this.V1 = V1;
	}
	
	@Override
	public void setV2(String V2) {
		this.V2 = V2;
	}
	
	//Constraint relation
	@Override
	public boolean kankei(String V1, String V2, Map<String,Integer> s) {
		if(s.get(V1) == null || s.get(V2) == null) {
			return true;
		}
		
		int a = s.get(V1);
		int b = s.get(V2);
		
		//Y=X^2
		if(a*a!=b) {
			return false;
		}
		
		return true;
	}
}