package model;

/**
 * ÅóÓÑÈ¦Item
 * 
 * @author zzpComputer
 *
 */
public class Mood {
	private String headImg;
	private String uname;
	private String mood;
	private String moodImg;

	public Mood(String headImg, String uname, String mood, String moodImg) {
		super();
		this.headImg = headImg;
		this.uname = uname;
		this.mood = mood;
		this.moodImg = moodImg;
	}

	public Mood() {
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getUname() {
		return uname;
	}

	public String getMoodImg() {
		return moodImg;
	}

	public void setMoodImg(String moodImg) {
		this.moodImg = moodImg;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	/**
	 * JSON×Ö·û´®¸ñÊ½
	 * 
	 * @return
	 */
	public String getMoodItem() {
		return "{\"headImg\":\"" + this.getHeadImg() + "\",\"uname\":\"" + this.getUname() + "\",\"mood\":\""
				+ this.getMood() + "\",\"moodImg\":\"" + this.getMoodImg() + "\"}";
	}

}
