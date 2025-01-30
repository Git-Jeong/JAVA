package musicPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMusicPlayer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		ArrayList<Music> musicList = new ArrayList<Music>();
		
		boolean runMp3Player = true;
		
		while (runMp3Player) {
 
			
			System.out.print("음악 제목을 입력 : ");
			String title = inputString(scan); 
			
			System.out.print("가수 이름을 입력 : ");
			String singer = inputString(scan);
			
			musicList.add(new Music(title, singer));
			 
			while(true) {
				printOption();
				String input = inputString(scan);
				
				if(input.equals("0")) {
					System.out.println();
					runMp3Player = false;
					break;
				}  
				else if(input.equals("1")) {
					System.out.println();
					printAllMusic(musicList);
				}
				else if(input.equals("2")) {
					System.out.println();
					printAllMusic(musicList);
					
					System.out.print("삭제할 번호를 입력하세요 : "); 
					int delete_index = inputNumver(scan) - 1;  
					deleteSelectMusic(musicList, delete_index);
				}
				else {
					break;
				}
			}
			
		}
		System.out.println();
		System.out.println("시스템이 종료되었습니다.");
		
		scan.close();
	}

	private static void printAllMusic(ArrayList<Music> musicList) {
	    for (int i = 0; i < musicList.size(); i++) { 
	        System.out.printf("[%d] 제목 : %s,\t 가수 : %s \n", i + 1, musicList.get(i).getTitle(), musicList.get(i).getSinger()); 
	    }
	}
	
	private static int inputNumver(Scanner scan) {
		int result = 0;
		while (true) {
			try {
				int temp = Integer.parseInt(scan.nextLine());
				if(temp > 0) {
					result = temp;
					break;
				}
			} catch (Exception e) {
				System.out.print("정수만 입력 : ");
			}
		}
		return result;
	}
	
	private static String inputString(Scanner scan) {
		String result = null;
		while(true) {
			try {
				result = scan.next();
				break;
			} catch (Exception e) {
				System.out.print("재입력 : ");
			}
		}
		return result;
	} 
	
	private static void printOption() {
		System.out.println();
		System.out.println("종료 : '0'"); 
		System.out.println("보유 음악들의 정보 : '1'"); 
		System.out.println("음악 선택삭제 : '2'");
		System.out.println("계속 : 'AnyKey'");
		System.out.print("원하는 옵션을 선택해 주세요 >> ");
	}

	private static void deleteSelectMusic(ArrayList<Music> musicList, int index) {
		try {
			musicList.remove(index); 
		} catch (Exception e) {
			System.out.println("잘못된 접근입니다. ");
		} 
	}

}
