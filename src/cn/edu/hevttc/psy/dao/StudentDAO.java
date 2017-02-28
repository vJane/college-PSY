package cn.edu.hevttc.psy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hevttc.psy.bean.*;
import cn.edu.hevttc.psy.database.DataConnection;

public class StudentDAO {
	public Student find(Student student){
		Student returnStudent=null;
		
		String sql="select * from student where name=? and studentID=?";
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			pstmt.setString(1,student.getName() );
			pstmt.setString(2,student.getStudentID() );
			rs=DataConnection.getResult(pstmt);
			if(rs.next()){//用户信息存在
				//System.out.println("----------------------");
				returnStudent=new Student();
				returnStudent.setId(rs.getInt("id"));
				returnStudent.setName(rs.getString("name"));
				returnStudent.setStudentID(rs.getString("studentID"));
				returnStudent.setSex(rs.getString("sex"));
				returnStudent.setDept(rs.getString("dept"));
				returnStudent.setMajor(rs.getString("major"));
				returnStudent.setTutor(rs.getString("tutor"));
				returnStudent.setYear(rs.getInt("year"));
				returnStudent.setGrade (rs.getInt("grade"));	
				returnStudent.setPhone(rs.getString("phone"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		
		return returnStudent;
	}
	public static List<Student> find(String sql){
		List<Student> list = new ArrayList<Student>();
		Connection conn=DataConnection.getFreeConnection();
		Statement st=DataConnection.getStatement(conn);
		ResultSet rs=DataConnection.getResult(st,sql);
		try {
			while(rs.next()){
				Student student =new Student();
				student.setName(rs.getString("name"));
				student.setStudentID(rs.getString("studentID"));
				student.setSex(rs.getString("sex"));
				student.setDept(rs.getString("dept"));
				student.setMajor(rs.getString("major"));
				student.setTutor(rs.getString("tutor"));
				student.setYear(rs.getInt("year"));
				student.setGrade(rs.getInt("grade"));
				student.setPhone(rs.getString("Phone"));
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
	public static boolean updateStudent(String sql){
		
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
