import java.sql.Date;

public class User {
	
	private String nickname;
	private String dtext;
	private sex sex;
	private Date year;
	private String pic;
	private sex desired_sex;
	private Date desired_year_max;
	private Date desired_year_min;
	private int id;
	private String nickuser;
	private String pass;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDtext() {
		return dtext;
	}
	public void setDtext(String dtext) {
		this.dtext = dtext;
	}
	public sex getSex() {
		return sex;
	}
	public void setSex(sex sex) {
		this.sex = sex;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public sex getDesired_sex() {
		return desired_sex;
	}
	public void setDesired_sex(sex desired_sex) {
		this.desired_sex = desired_sex;
	}
	public Date getDesired_year_max() {
		return desired_year_max;
	}
	public void setDesired_year_max(Date desired_year_max) {
		this.desired_year_max = desired_year_max;
	}
	public Date getDesired_year_min() {
		return desired_year_min;
	}
	public void setDesired_year_min(Date desired_year_min) {
		this.desired_year_min = desired_year_min;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickuser() {
		return nickuser;
	}
	public void setNickuser(String nickuser) {
		this.nickuser = nickuser;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	// public createPic
	
	
	

}
