import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class main{
	
	//Main class to demonstrate a instance of each problem
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		//An instance for the Canada Mapping problem
		CanadaCSP instance1 = new CanadaCSP();
		BTS<String,String> bts1 = new BTS<String,String>();
		System.out.println("Q1. The following is a solution to Canada mapping problem");
		System.out.println(bts1.BTS(instance1.initialize()) + "\n");
		
		//An instance for the Jop-Shop problem
		JobshopCSP instance2 = new JobshopCSP();
		BTS<String,Integer> bts2 = new BTS<String,Integer>();
		System.out.println("Q2. The following is a solution to Job-Shop problem");
		for(Map.Entry<String, Integer> entry: bts2.BTS(instance2.initialize()).entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		System.out.println();
		
		//An instance for the n-Queens problem
		System.out.println("Q3. The following is a solution to n-Queens problem");
		System.out.print("Please enter an integer for n-Queens problem:");//Prompt the user for n
		int nq = scan.nextInt();
		nQueensCSP instance3 = new nQueensCSP();//Create the instance
		BTS<Integer,Integer> bts3 = new BTS<Integer,Integer>();//Initialize CSP
		printSolutionnQ(bts3.BTS(instance3.nQinitialize(nq)));//Print solution
		
		System.out.println();
		
		//An instance of the XY problem
		//Domain for each variable will be showed after AC3
		System.out.println("Q4. The following is a solution to Y = X^2 problem");
		System.out.print("Please choose a range for X(The range will be 0 - the integer you enter): ");
		int x = scan.nextInt();
		System.out.print("Please choose a range for Y(The range will be 0 - the integer you enter): ");
		int y = scan.nextInt();
		YXCSP instance4 = new YXCSP();
		BTS<String,Integer> bts4 = new BTS<String,Integer>();
		System.out.println("The solution for Q4 is "+ bts4.BTS(instance4.initialize(x,y)));
		
		System.out.println();
		
		//An instance of Mackworth problem
		System.out.println("Q5. The following is a solution Mackworth problem");
		LinkedList<Node<String,Character>> a = new LinkedList<Node<String,Character>>();
		LinkedList<Constraint<String,Character>> c = new LinkedList<Constraint<String,Character>>();
		MackWorthCSP ac3 = new MackWorthCSP();
		CSP<String,Character> csp = new CSP<String,Character>(a,c);
		
		//Applying AC3
		if(ac3.AC3(csp) == true) {
			System.out.print("Is there a solution to Mackworth problem: ");
			System.out.print("Yes");
		}else {
			System.out.print("Is there a solution to Mackworth problem: ");
			System.out.print("No");
		}
		
		scan.close();
	}
	
	//A method to print the solution of n-Queens problem
	public static void printSolutionnQ(Map<Integer,Integer> a) {
		 System.out.println();
	
	try {
		 for (int i=0;i<a.size();i++) {
			 for (int j=0;j<a.size(); j++) {
				 if(a.get(i)==j) {
					System.out.print(1);
					System.out.print(" ");
				 }else {
					System.out.print("0 ");
				 	}
		   
			 }
		  System.out.println();
		 }
	}catch(NullPointerException e) {
		System.out.println("No solution for the integer");
	}
	}	
}