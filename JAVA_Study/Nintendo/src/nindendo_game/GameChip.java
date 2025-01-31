package nindendo_game;

public abstract class GameChip {
	//추상 클래스는 자식 클래스를 생성하기 위한 설게도면임

	public abstract void start();
	//abstract : 내구기능이 종의도지 않은 메소드
	//선언은 되어 있지만 딱 선언만 되어 있음
	//이걸 상속받은 자식 메소드는, 추상 메소드를 무조건 구현해야 된다. 필수

	public abstract void end(); 
	
	public void temp() {
		System.out.println();
	}

}
