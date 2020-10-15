package bean;

public class MemberVO2 {
	private String id; //db테이블에 전달목적이므로 칼럼명과 이름 동일하게
	private String pw;
	private String name;
	private String phone;
	private String birth;
	private String gender;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO2 [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", birth=" + birth
				+ ", gender=" + gender + ", email=" + email + "]";
	}	
	
}