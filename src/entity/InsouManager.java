package entity;

public class InsouManager{
	private String username;
	private String password;
	private int roleId;
	//�޲ι��캯��
	public InsouManager() {
		super();
	}
    //�вι��캯��
	public InsouManager(String name, String password,int roleId) {
		super();
		this.username = name;
		this.password = password;
		this.roleId = roleId;
	}	
	
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}