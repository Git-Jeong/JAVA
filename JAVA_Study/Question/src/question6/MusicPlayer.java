package question6;
 
import java.util.ArrayList;

public class MusicPlayer { 
	static final int ADD_OPTION = 1;
	static final int LIST_OPTION = 2;
	static final int ONE_DELETE_OPTION = 3;
	static final int ALL_DELETE_OPTION = 4;
	static final int EXIT_OPTION = 5;
	
	
	public static void main(String[] args) { 
		
		ArrayList<MusicVO> musicList = new ArrayList<MusicVO>();
		
		while(true) {
			System.out.println("===== 뮤직 플레이어 ====="); 
			System.out.printf("[%d]등록, [%d]목록, [%d]삭제, [%d]전체삭제, [%d]종료\n",
					ADD_OPTION, LIST_OPTION, ONE_DELETE_OPTION, ALL_DELETE_OPTION, EXIT_OPTION);
			System.out.print("원하는 옵션을 선택 >>> ");
			int inputOption = Input.inputNumber();
			if(inputOption == ADD_OPTION) {
				//노래 추가
				String title;
				String singer;
				int playTime;
				System.out.print("노래 제목 : ");
				title = Input.inputStrig();
				System.out.print("가수 이름 : ");
				singer = Input.inputStrig();
				System.out.print("노래 길이 : ");
				playTime = Input.inputNumber(); 
				musicList.add(new MusicVO(title, singer, playTime));
			}
			else if(inputOption == LIST_OPTION) {
				//노래목록
				musicListPage(musicList);		//노래 목록 표출
			}
			else if(inputOption == ONE_DELETE_OPTION) {
				//노래 하나를 삭제
				musicListPage(musicList);		//노래 목록 표출
				musicOneDelete(musicList);
			}
			else if(inputOption == ALL_DELETE_OPTION) {
				//모든 노래를 삭제
				musicAllDelete(musicList);
			}
			else if(inputOption == EXIT_OPTION) {
				//시스템 종료
				System.out.println("시스템을 종료하시겠습니까?");
				System.out.printf("Yes : 'Y', No : AnyKey >>>> ");
				String temp = Input.inputStrig();
				if(temp.equalsIgnoreCase("Y")) {
					break;
				} 
			}
			else {
				//입력값 오류
				System.out.println("잘못된 입력.");
			}
			
			//시각적 효과를 위한 개행일 뿐
			System.out.println();
		}
		
		System.out.println("시스템이 종료되었습니다.");
		ScannerUtil.closeScanner();
	}   
	
	private static void musicListPage(ArrayList<MusicVO> musicList) { 
		System.out.println("==== 노래 목록 ====");
		for(int i=0; i < musicList.size(); i++) {
			System.out.printf("[%d] : %s\n", i+1, musicList.get(i).getTitle()); 
		} 
	}
	
	private static void musicOneDelete(ArrayList<MusicVO> musicList) { 
		System.out.print("삭제할 노래의 번호를 입력 : ");
		int deleteNumber = Input.inputNumber() - 1;
		try {
			String deleteTitle = musicList.get(deleteNumber).getTitle();
			System.out.printf("%s 노래를 삭제합니다.\n", deleteTitle);
			musicList.remove(deleteNumber);
		} catch (Exception e) {
			System.out.println("입력한 번호가 없습니다.");
		}
	}
	
	private static void musicAllDelete(ArrayList<MusicVO> musicList) { 
		System.out.println("모든 노래를 지우겠습니까?");
		System.out.printf("Yes : 'Y', No : AnyKey >>>> ");
		String temp = Input.inputStrig();
		if(temp.equalsIgnoreCase("Y")) { 
			for(int i=musicList.size()-1; i >= 0; i--) {
				musicList.remove(i); 
			}
			System.out.println("==== 전체 노래가 삭제되었습니다. ====");
		} 
	}
	
	
	 
}
