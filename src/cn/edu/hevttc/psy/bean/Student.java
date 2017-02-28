package cn.edu.hevttc.psy.bean;

public class Student {
	private int id;
	private String name;
	private	String studentID;
	private String sex;
	private String dept;
	private String major;
	private String tutor;
	private int year;
	private int grade;
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(){
		id=0;
		name="";
		studentID="";
		dept="";
		major="";
		tutor="";
		year=0;
		grade=0;
	}
	public Student( String name,String studentID){
		this();
		this.name=name;
		this.studentID=studentID;
	}
	public Student(int id,	String name,String studentID,String sex,String dept,String major,String tutor,int year,int grade){
		this.id=id;
		this.name=name;
		this.studentID = studentID;
		this.sex=sex;
		this.dept=dept;
		this.major=major;
		this.tutor=tutor;
		this.year=year;
		this.grade=grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String toString(){
		String student="Ñ§ºÅ:"+studentID+"ÐÕÃû"+name;
		return student;
	}
}
