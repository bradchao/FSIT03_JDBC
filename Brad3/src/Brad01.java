

public class Brad01 {

	public static void main(String[] args) {
		p1 obj1 = new Brad011();
		p1 obj2 = new Brad012();
		
		main2(obj1);
		
	}
	
	static void main2(p1 anyobj){
		anyobj.m1();
		if (anyobj instanceof Brad011){
			((Brad011)anyobj).m3();
		}else if (anyobj instanceof Brad012){
			((Brad012)anyobj).m4();
		}
	}

}
interface p1 {
	void m1();
}
class Brad011 implements p1 {
	public void m1(){System.out.println("A");}
	void m3(){System.out.println("A1");}
}
class Brad012 implements p1 {
	public void m1(){System.out.println("B");}
	void m4(){System.out.println("B1");}
}
