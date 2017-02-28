package cn.edu.hevttc.psy.bean;
import java.util.*;

public class Question {
	private int id;
	private String tableName;
	private int type;
	private String questionTitle;
	private List<String> answer;
	public Question(){
		id=0;
		tableName="";
		type=0;
		questionTitle="";
		answer=new ArrayList<String>();
	}
	public Question(int id,String tableName,int type,String questionTitle,List<String> answer){
		this.id=id;
		this.tableName=tableName;
		this.type=type;
		this.questionTitle=questionTitle;
		this.answer=answer;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public List<String> getAnswer() {
		return answer;
	}
	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}
	public void addAnswer(String answer){
		this.answer.add(answer);
	}
}
