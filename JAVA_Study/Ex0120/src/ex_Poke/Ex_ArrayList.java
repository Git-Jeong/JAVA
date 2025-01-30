package ex_Poke;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_ArrayList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//ArrayList<Poke> pokemon = new ArrayList<Poke>(); 

        //pokemon.add(new Poke("피카츄", "전기", "백만볼트", 150, 40)); 
        
        
        
        
        ArrayList<String> foods = new ArrayList<String>(); 
		
        while(true) {
        	System.out.printf("[%d] 음식 이름을 입력하세요(종료:'Y') : ", foods.size() + 1);
        	String temp = scan.nextLine();
        	if(temp.equalsIgnoreCase("Y")) {
        		break;
        	}
        	else {        		
        		foods.add(temp);
        	}
        }
        
        System.out.println("get()으로 출력");
        for(int i = 0; i < foods.size(); i++) {
        	System.out.println(foods.get(i));
        }
        System.out.println();
        
        System.out.println(" : 로 출력");
        for(String temp : foods) {
        	System.out.println(temp);
        }
        System.out.println();

        System.out.println(".toString 출력");
        System.out.println(foods.toString());
        System.out.println();
        
        System.out.println(".remove(0)");
        foods.remove(0);
        System.out.println(foods.toString());
        System.out.println(); 
        
        scan.close();
	} 
}
