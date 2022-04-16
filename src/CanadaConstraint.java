import java.util.Map;

public class CanadaConstraint extends Constraint<String, String>{

	public CanadaConstraint(String V1, String V2) {
		super(V1, V2);
	}
	
	@Override
	public String getV1() {
		return V1;
	}
	
	@Override
	public String getV2() {
		return V2;
	}
	
	@Override
	public void setV1(String V1) {
		this.V1 = V1;
	}
	
	@Override
	public void setV2(String V2) {
		this.V2 = V2;
	}
	
	@Override
	public boolean kankei(String V1, String V2, Map<String,String> s) {
		if(s.get(V1) == null || s.get(V2) == null) {
			return true;
		}
		
		String a = s.get(V1);
		String b = s.get(V2);
		
		if(a.equals(b)) {
			return false;
		}
		
		return true;
	}
	
}
