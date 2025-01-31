package nindendo_game;

public class GameMain {
	public static void main(String[] args) {

		GameChip_Pokemon p = new GameChip_Pokemon();
		GameChip_Mario m = new GameChip_Mario();
		GameChip_Kirby k = new GameChip_Kirby();

		insert(p);
		insert(m);
		insert(k);
		
		remove(p);
		remove(m);
		remove(k);
		
	}

	public static void insert(GameChip G) {
		G.start();
	} 
	
	public static void remove(GameChip G) {
		G.end(); 
	} 
}
