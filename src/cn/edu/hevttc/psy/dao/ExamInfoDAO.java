package cn.edu.hevttc.psy.dao;
import cn.edu.hevttc.psy.bean.*;
import cn.edu.hevttc.psy.database.DataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ExamInfoDAO {
	public List<ExamInfo> find(){
		List<ExamInfo> list = new ArrayList<ExamInfo>();
		
		String sql="select * from examInfo ";
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			rs=DataConnection.getResult(pstmt);
			while(rs.next()){//用户信息存在
				ExamInfo examInfo = new ExamInfo();
				examInfo.setId(rs.getInt("id"));
				examInfo.setTableName(rs.getString("tableName"));
				examInfo.setExamName(rs.getString("examName"));
				examInfo.setNation(rs.getString("nation"));
				examInfo.setType(rs.getInt("type"));
				examInfo.setCount(rs.getInt("count"));
				list.add(examInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		
		return list;
	}
	public List<ExamInfo> find(String sql){
		List<ExamInfo> list = new ArrayList<ExamInfo>();
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			rs=DataConnection.getResult(pstmt);
			if(rs.next()){//用户信息存在
				ExamInfo examInfo = new ExamInfo();
				examInfo.setId(rs.getInt("id"));
				examInfo.setTableName(rs.getString("tableName"));
				examInfo.setExamName(rs.getString("examName"));
				examInfo.setNation(rs.getString("nation"));
				examInfo.setType(rs.getInt("type"));
				examInfo.setCount(rs.getInt("count"));
				list.add(examInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		
		return list;
	}
}
