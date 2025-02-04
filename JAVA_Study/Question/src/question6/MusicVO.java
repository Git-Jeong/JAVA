package question6;

public class MusicVO {
	private String title;	//노래 제목
	private String singer;	//가수의 이름
	private int playTime;	//노래의 길이
	
	public MusicVO(String title, String singer, int playtime) {
		this.title = title;
		this.singer = singer;
		this.playTime = playtime;
	}

	public String getTitle() {
		return title;
	}

	public String getSinger() {
		return singer;
	}

	public int getPlayTine() {
		return playTime;
	}
	
	public void getTitle(String title) {
		this.title = title;
	}

	public void getSinger(String singer) {
		this.singer = singer;
	}

	public void getPlayTine(int playTime) {
		this.playTime = playTime;
	}
	
	public String toString() {
		return "제목 : " + title + "\t 가수 : " + singer + "\t 시간 : " + playTime +"초";
	}
}
