package cn.edu.hevttc.psy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.edu.hevttc.psy.database.DataConnection;


public class MsgDao {
	public synchronized boolean insertMessages(String sql){
		Connection conn=DataConnection.getFreeConnection();
		PreparedStatement pstmt=DataConnection.getPreparedStatement(conn, sql);
		try{
			if(DataConnection.execute(pstmt)){//≤Â»Î≥…π¶
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConnection.colsePstmt(pstmt);
			DataConnection.closeConnection(conn);
		}
		return false;
	}

}
