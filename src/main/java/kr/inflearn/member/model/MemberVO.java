package kr.inflearn.member.model;

public class MemberVO {
	

	private int num;
	private String id;
	private String password;
	private String name;
	private int age;
	private String email;
	private String phone;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + "]";
	}

	public MemberVO(int num, String id, String password, String name, int age, String email, String phone) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
