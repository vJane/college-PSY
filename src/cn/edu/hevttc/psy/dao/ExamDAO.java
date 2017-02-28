package cn.edu.hevttc.psy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import cn.edu.hevttc.psy.bean.*;
import cn.edu.hevttc.psy.database.DataConnection;
public class ExamDAO {
	public List<Question> findExam(String tableName){
		List<Question> exam = new ArrayList<Question>();
		
		String sql="select * from exam where tableName=?";
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			pstmt.setString(1, tableName);
			rs=DataConnection.getResult(pstmt);
			
			int id=1;
			while(rs.next()){//用户信息存在
				Question question= new Question();
				question.setId(id++);
				question.setTableName(rs.getString("tableName"));
				question.setType(rs.getInt("type"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				for(char i='a';i<'g';i++){
					if(rs.getString(i+"")!=null)
						question.addAnswer(rs.getString(i+""));
				}
				exam.add(question);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		
		return exam;
	}
}
