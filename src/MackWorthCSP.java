import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MackWorthCSP{
	
	static Queue<Arc<String,Character>> arc = new LinkedList<>();
	static HashMap<Node<String,Character>, LinkedList<HashMap<Node<String,Character>, Integer>>> map = new HashMap<>();
	static LinkedList<Character> d = new LinkedList<Character>();
	static Node<String,Character> x1 = new Node<String,Character>("x1",d);
	static Node<String,Character> x2 = new Node<String,Character>("x2",d);
	static Node<String,Character> x3 = new Node<String,Character>("x3",d);
	static Node<String,Character> x4 = new Node<String,Character>("x4",d);
	static Node<String,Character> x5 = new Node<String,Character>("x5",d);
	
	
	
	static boolean revise(HashMap<Node<String,Character>, LinkedList<HashMap<Node<String,Character>, Integer>>> map,Node<String,Character> x, Node<String,Character> y) {
		LinkedList<Character > a=x.getDomain();
		LinkedList<Character> b=y.getDomain();
		boolean revised = false;
		boolean e = false;
		int type=0;
		System.out.println("arcs revised: "+x.getVariable()+"-"+y.getVariable());
		//if(map.get(x).get(y)!=null) {
		for(int i=0;i<map.get(x).size();i++) {
			if(map.get(x).get(i).containsKey(y)) {
				type=map.get(x).get(i).get(y);
			}
		}
		
		
		if(type==3) {
			//System.out.print(type);
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < b.size(); j++) {
				if(a.get(i) < b.get(j)){
					e = true;
				}
			}
			
			if(e == false) {
				revised = true;
				x.Domain.remove(i);
				
				//System.out.print("setted");
			}
			
			e = false;
		}
		
		
		}else if (type==4) {
			//System.out.print(type);
			for(int i = 0; i < a.size(); i++) {
				for(int j = 0; j < b.size(); j++) {
					if(a.get(i) > b.get(j)){
						e = true;
					}
				}
				if(e == false) {
					revised = true;
					x.Domain.remove(i);
					
				}
				
				e = false;
		}
	}
		for(int i = x.Domain.size() - 1; i > 0 ;i--) {
			if(x.Domain.get(i).equals('d') ) {
				x.Domain.remove(i);
				System.out.println("removed");
			}
		}
		
		//}
		return revised;
	}
	
	
	static boolean AC3(CSP csp) {
		LinkedList<HashMap<Node<String,Character>, Integer>> a1= new LinkedList<HashMap<Node<String,Character>, Integer>>();
		
		LinkedList<Character> d1 = new LinkedList<Character>();
		LinkedList<Character> d2 = new LinkedList<Character>();
		LinkedList<Character> d3 = new LinkedList<Character>();
		LinkedList<Character> d4 = new LinkedList<Character>();
		LinkedList<Character> d5 = new LinkedList<Character>();
		
		d1.add('a');d1.add('b');d1.add('c');
		d2.add('a');d2.add('b');d2.add('c');
		d3.add('a');d3.add('b');
		d4.add('a');d4.add('b');
		d5.add('a');d5.add('b');
		
		x1.setDomain(d1);
		x2.setDomain(d2);
		x3.setDomain(d3);
		x4.setDomain(d4);
		x5.setDomain(d5);
		
		map.put(x1,a1);
		map.put(x2,a1);
		map.put(x3,a1);
		map.put(x4,a1);
		map.put(x5,a1);
		
		
		
		HashMap<Node<String,Character>, Integer> temp= new HashMap<>();
		temp.put(x3,3);
		map.get(x1).add(temp);
		map.get(x2).add (temp);
		map.get(x4).add (temp);
		map.get(x5).add(temp);
		HashMap<Node<String,Character>, Integer> temp1= new HashMap<>();
		temp1.put(x5, 3);
		map.get(x4).add(temp1);
		HashMap<Node<String,Character>, Integer> temp2= new HashMap<>();
		temp2.put(x1,4);
		map.get(x3).add(temp2);
		HashMap<Node<String,Character>, Integer> temp3= new HashMap<>();
		temp3.put(x2,4);
		map.get(x3).add(temp3);
		HashMap<Node<String,Character>, Integer> temp4= new HashMap<>();
		temp4.put(x4,4);
		map.get(x4).add(temp4);
		HashMap<Node<String,Character>, Integer> temp5= new HashMap<>();
		temp5.put(x5,4);
		map.get(x3).add(temp5);
		HashMap<Node<String,Character>, Integer> temp6= new HashMap<>();
		temp6.put(x4,4);
		map.get(x5).add (temp6);
		
		
		
		
		
		arc.add(new Arc<String,Character>(x1,x3));
		arc.add(new Arc<String,Character>(x2,x3));
		arc.add(new Arc<String,Character>(x4,x3));
		arc.add(new Arc<String,Character>(x5,x3));
		arc.add(new Arc<String,Character>(x4,x5));
		arc.add(new Arc<String,Character>(x3,x1));
		arc.add(new Arc<String,Character>(x3,x2));
		arc.add(new Arc<String,Character>(x3,x4));
		arc.add(new Arc<String,Character>(x3,x5));
		arc.add(new Arc<String,Character>(x5,x4));
		
		
		
		x1.adj.add(x3);
		x2.adj.add(x3);
		x4.adj.add(x3);
		x5.adj.add(x3);
		x4.adj.add(x5);
		x3.adj.add(x1);x3.adj.add(x2);x3.adj.add(x4);x3.adj.add(x5);
		x5.adj.add(x4);
		
		
		
		
		
		
		while(arc.isEmpty() == false) {
			Arc<String,Character> a = arc.remove();	
			
			boolean r=revise(map, a.V1, a.V2);
			
			
			if(r==true) {
				for(int i=0;i<a.V2.adj.size();i++) {
					if(a.V2.adj.get(i)!=a.V1) {
						arc.add(new Arc(a.V2,a.V2.adj.get(i)));
					//	System.out.println("added");
					}
				}
				
			}
			
			
			
			
			
			if(isEmpty(a.V1)) {
				return false;
			}
		
		}
		
		return true;
	}
	
	public static boolean isEmpty(Node<String,Character> n) {
		
		if(n.Domain.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
}
