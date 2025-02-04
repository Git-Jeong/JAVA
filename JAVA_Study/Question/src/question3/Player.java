package question3;

public class Player {
	private String name;	//모델명
	private String color;	//색상
	private boolean power;	//전원상태
	
	public Player(String name, String color, boolean power) {
		this.name = name;
		this.color = color;
		this.power = power;
	}
	
	public void powerOnOff(boolean onOff) {
		if(onOff) {
			//파워 on
			this.power = onOff;
		}
		else if(onOff) {
			this.power = onOff;
		}
		else {
			System.out.println("파워 스위치에 에러가 발생");
		}
	}

	public void play() {
		// onOff가 있는데 굳이?
		power = true;
	}

	public void stop() {
		// onOff가 있는데 굳이?
		power = false;
	}
	
	public int remove(int number) {
		//뭘 remove 하는 것?
		return 1;
	}
}
