import java.util.Map;

public class nQueenConstraint extends Constraint<Integer, Integer> {

	public nQueenConstraint(Integer V1, Integer V2) {
		super(V1, V2);
	}
	
	@Override
	public Integer getV1() {
		return V1;
	}
	
	@Override
	public Integer getV2() {
		return V2;
	}
	
	@Override
	public void setV1(Integer V1) {
		this.V1 = V1;
	}
	
	@Override
	public void setV2(Integer V2) {
		this.V2 = V2;
	}
	
	@Override
	public boolean kankei(Integer V1, Integer V2, Map<Integer, Integer> s) {
		if(s.get(V1) == null || s.get(V2) == null) {
			return true;
		}
		
		int a = s.get(V1);
		int b = s.get(V2);
		
		//if two queens are on the same column then return false
		if(a == b) {
			return false;
		}
		
		//Calculate the distance between two variables vertically
		int d = Math.abs(V1 - V2);
		
		if(a == b + d || a == b - d) {
			return false;
		}
		
		return true;
	}
}
