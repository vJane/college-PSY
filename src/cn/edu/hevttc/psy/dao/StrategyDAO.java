package cn.edu.hevttc.psy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.edu.hevttc.psy.bean.Standard;
import cn.edu.hevttc.psy.database.DataConnection;

public class StrategyDAO{
	public List<Standard> getScore(String StandardName){
		List<Standard> list = new ArrayList<Standard>();
		String sql="select * from "+StandardName;
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			rs=DataConnection.getResult(pstmt);
			while(rs.next()){//用户信息存在
				Standard standard = new Standard();
				standard.setId(rs.getInt("id"));
				standard.setA(rs.getInt("a"));
				standard.setB(rs.getInt("b"));
				standard.setC(rs.getInt("c"));
				list.add(standard);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		return list;
	}
	public List<String> getScore(int id,String StandardName){
		List<String> list = new ArrayList<String>();
		String sql="select * from "+StandardName;
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			rs=DataConnection.getResult(pstmt);
			while(rs.next()){//用户信息存在
				list.add(rs.getString("standard"));
				//System.out.println(rs.getString("standard"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		return list;
	}
	public boolean insertResult(String sql){
		boolean flag=false;
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			flag=DataConnection.execute(pstmt);
			return flag;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		return flag;
	}

}
