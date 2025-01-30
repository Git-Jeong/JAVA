package ex_inheritance;

public class Ex_01_inheritance_child extends Ex_01_inheritance_parent   { 
	

	public void makePizza () {
		System.out.println("맛있는 치즈피자를 만든다!~"); 
	}  

	public static void main(String[] args) {
		
		Ex_01_inheritance_parent p = new Ex_01_inheritance_parent(); 
		p.makePizza();
		p.makeBear();


		Ex_01_inheritance_child c = new Ex_01_inheritance_child(); 
		c.makePizza();
		c.makeBear(); 
		
		
		//자식 클래스만 가질 수 있는 기능을 만들어 보기
	}
	 
}
