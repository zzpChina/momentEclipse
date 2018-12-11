package model;
/**
 * ”√ªß¿‡
 * @author zzpComputer
 *
 */
public class User {
	private String headImg;
	private String uname;
	private String password;
	private String sex;
	private Mood mood;
	public User() {
	}

	public User(String headImg,String uname, String password, String sex) {
		this.headImg=headImg;
		this.uname = uname;
		this.password = password;
		this.sex = sex;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}
}
