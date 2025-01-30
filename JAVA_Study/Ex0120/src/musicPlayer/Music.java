package musicPlayer;

public class Music {
	private String title;
	private String singer;
	 
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	
	public String getSinger() {
		return singer;
	} 

	public String getTitle() {
		return title;
	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
	
	public void updateSinger(String singer) {
		this.singer = singer;
	}
}
