package ex_01;

import java.util.ArrayList;
import java.util.Random;

public class Ex_04_2_sub {
    private static ArrayList<Ex_04_2_sub> sub_check = new ArrayList<>();
    private Random rd = new Random();
    private String name;
    private int age;
    private int number;

    Ex_04_2_sub(String name, int age) {
        this.name = name;
        this.age = age;
        this.number = newNumber();
        sub_check.add(this);
    }  
    
    private int newNumber() {
    	//중복을 피하며 
        int result = 0;
        while (true) {
            boolean check_success = true;
            result = rd.nextInt(99999) + 1;
            for (int i = 0; i < sub.size(); i++) {
                if (result == sub.get(i).number) {  
                    check_success = false;
                    break;
                }
            }
            if (check_success) {
                break;
            }
        }
        return result;
    } 
    
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number: " + number);
    }
}
