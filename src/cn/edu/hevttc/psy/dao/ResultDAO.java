package cn.edu.hevttc.psy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hevttc.psy.bean.Result;
import cn.edu.hevttc.psy.bean.Temporary;
import cn.edu.hevttc.psy.database.DataConnection;

public class ResultDAO {
	public static List<Temporary> find(String sql){
		List<Temporary> list = new ArrayList<Temporary>();
		Connection conn=DataConnection.getFreeConnection();
		Statement st=DataConnection.getStatement(conn);
		ResultSet rs=DataConnection.getResult(st,sql);
		try {
			while(rs.next()){
				Temporary student =new Temporary();
				student.setName(rs.getString("name"));
				student.setCardID(rs.getString("cardID"));
				student.setDept(rs.getString("dept"));
				student.setResultInfo(rs.getString("resultInfo"));
				student.setResultDate(rs.getString("resultDate"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataConnection.closeResultSet(rs);
			DataConnection.closeStatement(st);
			DataConnection.closeConnection(conn);
		}
	     return list;
	}
	public static List<Result> find1(String sql){
		List<Result> list = new ArrayList<Result>();
		Connection conn=DataConnection.getFreeConnection();
		Statement st=DataConnection.getStatement(conn);
		ResultSet rs=DataConnection.getResult(st,sql);
		try {
			while(rs.next()){
				Result student =new Result();
				student.setName(rs.getString("name"));
				student.setStudentID(rs.getString("studentID"));
				student.setTableName(rs.getString("tableName"));
				student.setExamName(rs.getString("examName"));
				student.setSex(rs.getString("sex"));
				student.setDept(rs.getString("dept"));
				student.setMajor(rs.getString("major"));
				student.setTutor(rs.getString("tutor"));
				student.setYear(rs.getInt("year"));
				student.setGrade(rs.getInt("grade"));
				student.setPhone(rs.getString("phone"));
				student.setResultInfo(rs.getString("resultInfo"));
				student.setResultDate(rs.getString("resultDate"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataConnection.closeResultSet(rs);
			DataConnection.closeStatement(st);
			DataConnection.closeConnection(conn);
		}
	     return list;
	}
    public static boolean updateResult(String sql){
		
		Connection conn=DataConnection.getFreeConnection();
		Statement st=DataConnection.getStatement(conn);
		try {
		int i=DataConnection.getUpdate(st,sql);
		if(i>0)
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataConnection.closeStatement(st);
			DataConnection.closeConnection(conn);
		}
	     return false;
	}

}
