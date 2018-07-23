package edu.ksr.iet.prp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import edu.ksr.iet.prp.dao.AttendanceDao;
import edu.ksr.iet.util.DBUtil;

public class AttendanceDaoImpl implements AttendanceDao{

	public AttendanceDaoImpl(){
		
	}

	@Override
	public int insertAttendance(List<String> studentIdsList) {
		String sql = "insert into attendance(studentid,date) values(?,?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try{
		connection  = DBUtil.getConnection();
		connection.setAutoCommit(false);
		java.util.Date currentDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		for (String studentid : studentIdsList) {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, studentid);
			prepareStatement.setDate(2, sqlDate);
			prepareStatement.executeUpdate();
		}
		connection.commit();
		}catch(Exception e){
			try{
				connection.rollback();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			DBUtil.close(connection, prepareStatement, null);
		}
		return studentIdsList.size();
	}
}










