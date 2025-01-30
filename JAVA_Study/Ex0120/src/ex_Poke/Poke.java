package ex_Poke;

public class Poke {
    // Poke 클래스 필드
    private String name;
    private String type;
    private String skill;
    private int hp;
    private int atk;

    // 생성자
    public Poke(String name, String type, String skill, int hp, int atk) {
        this.name = name;
        this.type = type;
        this.skill = skill;
        this.hp = hp;
        this.atk = atk;
    }

    // 기본 생성자
    public Poke() {
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSkill() {
        return skill;
    }
    
    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }
    
    public void atkPoke(int atk){
    	this.hp -= atk;
    	if(hp <= 0) {
    		System.out.printf("%s는 기절했습니다.\n", name);
    	}
    }
}
