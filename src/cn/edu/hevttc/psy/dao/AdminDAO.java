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
public class AdminDAO {
	public Admin findAdmin(Admin admin){
		Admin returnAdmin =null;

		String sql="select * from admins where user=? and pwd=?";
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn,sql);
		ResultSet rs=null;
		try{
			pstmt.setString(1,admin.getUser());
			pstmt.setString(2,admin.getPwd());
			rs=DataConnection.getResult(pstmt);
			if(rs.next()){//用户信息存在
				returnAdmin=new Admin();
				returnAdmin.setId(rs.getInt("id"));
				returnAdmin.setName(rs.getString("name"));
				returnAdmin.setPhone(rs.getString("phone"));
				returnAdmin.setDept(rs.getString("dept"));
				returnAdmin.setType(rs.getInt("Type"));
				returnAdmin.setUser(rs.getString("user"));				
				returnAdmin.setPwd(rs.getString("pwd"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		
		return returnAdmin;
	}
	public static List<Admin> find(String sql){
		List<Admin> list = new ArrayList<Admin>();
		Connection conn=DataConnection.getFreeConnection();
		Statement st=DataConnection.getStatement(conn);
		ResultSet rs=DataConnection.getResult(st,sql);
		try {
			while(rs.next()){
				Admin admin=new Admin();
				admin.setUser(rs.getString("user"));
				admin.setPwd(rs.getString("pwd"));
				admin.setName(rs.getString("name"));
				admin.setType(rs.getInt("type"));
				admin.setDept(rs.getString("dept"));
				admin.setPhone(rs.getString("phone"));
				list.add(admin);
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
	public static boolean updateAdmin(String sql){
		
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
