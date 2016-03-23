package entity;

public class InsouUser{
	private String username;
	private String password;

	private int age;
	private String job;
	private String email;
	//无参构造函数
	public InsouUser() {
		super();
	}
    //有参构造函数
	public InsouUser(String username, String password,  int age,String job,String email) {
		super();
		this.username = username;
		this.password = password;

		this.age = age;
		this.job = job;
		this.email = email;
		
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}