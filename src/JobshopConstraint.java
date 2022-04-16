import java.util.Map;

public class JobshopConstraint extends Constraint<String, Integer> {

	Integer t;
	
	//Constructor
	public JobshopConstraint(String V1, String V2, Integer t) {
		super(V1,V2);
		this.t = t;
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
	
	public Integer getT() {
		return t;
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
	
	public void setT(Integer t) {
		this.t = t;
	}
	
	//Constraint relation
	@Override
	public boolean kankei(String V1, String V2, Map<String,Integer> s) {
		
		if(s.get(V1) == null || s.get(V2) == null) {
			return true;
		}
		
		Integer a = s.get(V1);
		Integer b = s.get(V2);
		
		//Axles have to be in place before wheels
		if(V1.contains("Axle")) {
			
			if(V1.equals("AxleF")) {
				if(V2.equals("WheelRF") && a + t > b) {
					return false;
				}else if(V2.equals("WheelLF") && a + t > b) {
					return false;
				 	}
			}else if(V1.equals("AxleB")) {
				if(V2.equals("WheelRB") && a + t > b) {
					return false;
				}else if(V2.equals("WheelLB") && a + t > b) {
					return false;
				 	}
			}
			
			//AxleF and AxleB can't be worked at the same time
			if (V1.contains("Axle") && V2.contains("Axle") && Math.abs(a - b) < t) {
				return false;
			}
		
		}else if(V1.contains("Wheel")) {//Wheels have to be in place before nuts
			if(V1.equals("WheelRF")) {
				if(V2.equals("NutsRF") && a + t > b) {
					return false;
					}
			}else if(V1.equals("WheelLF")) {
				if(V2.equals("NutsLF") && a + t > b) {
					return false;
					}
			}else if(V1.equals("WheelRB")) {
				if(V2.equals("NutsRB") && a + t > b) {
					return false;
					}
			}else if(V1.equals("WheelLB")) {
				if(V2.equals("NutsLB") && a + t > b) {
					return false;
					}
			}
		
		}else if(V1.contains("Nuts")) {//Nuts have to be in place before Caps
			if(V1.equals("NutsRF")) {
				if(V2.equals("CapRF") && a + t > b) {
					return false;
					}
			}else if(V1.equals("NutsLF")) {
				if(V2.equals("CapLF") && a + t > b) {
					return false;
					}
			}else if(V1.equals("NutsRB")) {
				if(V2.equals("CapRB") && a + t > b) {
					return false;
					}
			}else if(V1.equals("NutsLB")) {
				if(V2.equals("CapLB") && a + t > b) {
					return false;
					}
			}
		}else if(V1.equals("Inspect")){//Inspect has to take place at the end
			if(V2.contains("Axle") && b + t > a) {
				return false;
			}else if(V2.contains("Wheel") && b + t > a) {
				return false;
			}else if(V2.contains("Nuts") && b + t > a) {
				return false;
			}else if(V2.contains("Cap") && b + t > a) {
				return false;
			}
		}
		
		return true;
		
	}
}
