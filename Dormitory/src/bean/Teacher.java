package bean;

public class Teacher {
	private String userid;  //用户名
	private String userpassword; //密码
	private String Teachername;  //操作员名
	private String phone;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getTeachername() {
		return Teachername;
	}
	public void setTeachername(String teachername) {
		Teachername = teachername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
