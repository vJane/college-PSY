package cn.edu.hevttc.psy.bean;

public class ExamInfo {
	private int id;
	private String tableName;
	private String examName;
	private String nation;
	private int type;
	private int count;
	public ExamInfo(){
		id=0;
		tableName="";
		examName="";
		nation="";
		type=0;
		count=0;
	}
	public ExamInfo(int id,String tableName,String examName,String nation,int type,int count){
		this.id=id;
		this.tableName=tableName;
		this.examName=examName;
		this.nation=nation;
		this.type=type;
		this.count=count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
