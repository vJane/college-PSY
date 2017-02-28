package cn.edu.hevttc.psy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




import cn.edu.hevttc.psy.bean.ExamInfo;
import cn.edu.hevttc.psy.bean.Question;
import cn.edu.hevttc.psy.database.DataConnection;

public class UploadDAO {
	public boolean createTable(String tableName,List<String> examTitle ){
		boolean flag=false;
		Connection conn=DataConnection.getFreeConnection();
		Statement st = DataConnection.getStatement(conn);
		String sql;
		 sql="create table "+tableName+"(id int not null primary key,";
         for(int j=1;j<examTitle.size();j++){
         	if(j==examTitle.size()-1)
         	  sql=sql+" "+examTitle.get(j)+" varchar(255)";
         	else
         	  sql=sql+examTitle.get(j)+" varchar(255),";
         }
         sql=sql+");";
        // System.out.println(sql);
		 try{			 
			 flag=DataConnection.executeSql(st,sql);
		 }catch(Exception e){
			 e.printStackTrace();
		}finally{
			DataConnection.closeConnection(conn);
		}		
		 return flag;
	}
	public ExamInfo insertInfo(ExamInfo examinfo){
		String sql = "insert into examinfo(tableName,examName,nation,type,count) values(?,?,?,?,?)";
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn, sql);
		try{
			pstmt.setString(1,examinfo.getTableName());
			pstmt.setString(2,examinfo.getExamName());
			pstmt.setString(3,examinfo.getNation());
			pstmt.setInt(4,examinfo.getType());
			pstmt.setInt(5,examinfo.getCount());
			if(DataConnection.execute(pstmt)){//²åÈë³É¹¦
				return examinfo;
			}else{
				examinfo=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		return examinfo;
	}
	public boolean insertExam(List<String> sqls,List<Question> questions){
		boolean flag=false;
		String sql;
		PreparedStatement pstmt=null;
		Connection conn=DataConnection.getFreeConnection();
			try{
				conn.setAutoCommit(false); 
				for(int i=0;i<sqls.size();i++){
					sql=sqls.get(i);
					pstmt=DataConnection.getPreparedStatement(conn, sql);
					Question question=questions.get(i);	
					pstmt.setString(1,question.getTableName());
					pstmt.setInt(2,question.getType());
					pstmt.setString(3,question.getQuestionTitle());
					List<String> answer=question.getAnswer();
					for(int j=0;j<answer.size() && j<6;j++){
						if(answer.size()>0) pstmt.setString(4+j,answer.get(j));
						else pstmt.setString(4+j,null);
					}
					flag=DataConnection.execute(pstmt);
				}
				conn.commit(); 
			}catch(Exception e){
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}finally{
				DataConnection.colsePstmt(pstmt);
				DataConnection.closeConnection(conn);
			}
		return flag;
	}
	public boolean insertExamStand(List<String> sqls,List<Question> questions){
		boolean flag=false;
		String sql;
		PreparedStatement pstmt=null;
		Connection conn=DataConnection.getFreeConnection();
			try{
				conn.setAutoCommit(false); 
				for(int i=0;i<sqls.size();i++){
					pstmt.setInt(1,questions.get(i).getId());
					List<String> answer=questions.get(i).getAnswer();
					for(int j=0;j<answer.size();j++){
						pstmt.setString(2+j,answer.get(j));
					}
					flag=DataConnection.execute(pstmt);
				}
				conn.commit(); 
			}catch(Exception e){
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}finally{
				DataConnection.colsePstmt(pstmt);
				DataConnection.closeConnection(conn);
			}
		return flag;
	}
	

}
