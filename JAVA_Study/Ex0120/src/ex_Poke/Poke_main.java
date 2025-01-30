package ex_Poke;

public class Poke_main {

	public static void main(String[] args) {
        Poke[] bag = new Poke[3];
        
        bag[0] = new Poke("피카츄", "전기", "백만볼트", 150, 40);
        bag[1] = new Poke("독침붕", "벌레", "독침", 180, 55);
        ba	g[2] = new Poke("스라크", "벌레", "쌍날 베기", 200, 70);  
		
		
		for(int i = 0; i < bag.length; i++) { 
			System.out.printf("%s \t", bag[i].getName()); 
			System.out.printf("%s \t", bag[i].getType()); 
			System.out.printf("%s \t", bag[i].getSkill()); 
			System.out.printf("%d \t", bag[i].getHp()); 
			System.out.printf("%d \t", bag[i].getAtk()); 
			System.out.println();
		}
	}

}
