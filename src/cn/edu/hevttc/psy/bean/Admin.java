package cn.edu.hevttc.psy.bean;

public class Admin {
	private int id;
	private int type;
	private String user;
	private String pwd;
	private String name;
	private String dept;
	private String phone;
	public Admin(){
		id=0;
		type=0;
		user="";
		pwd="";
		name="";
		dept="";
		phone="";
	}
	public Admin(int id,int type,String user,String pwd,String name,String dept,String phone){
		this.id=id;
		this.type=type;
		this.user=user;
		this.pwd=pwd;
		this.name=name;
		this.dept=dept;
		this.phone=phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
