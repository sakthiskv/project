package edu.ksr.iet.prp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import edu.ksr.iet.prp.bean.Student;
import edu.ksr.iet.prp.dao.Finaldate;
import edu.ksr.iet.util.DBUtil;


public class FinalDateimp implements Finaldate{

	@Override
	public List<String> displayAttendanceFilter(List<String> studentIdList,String date) {
		System.out.println(date);
		String sql="select *from attendance where date=?";
		   // String len="select count(*) from attendance";
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			List<String> studentidlist= new ArrayList<String>();
			//PreparedStatement1 prepareStatement1=null;
			try{
			connection  = DBUtil.getConnection();
			connection.setAutoCommit(false);
//			prepareStatement=connection.prepareStatement(len);
			//int len1=Integer.parseInt(prepareStatement);
				//while(prepareStatement!=null) {
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1,date);
			ResultSet resultset = prepareStatement.executeQuery();
			while(resultset.next())
			{
				String id=resultset.getString("studentid");
				id+="------>DATE:"+date;
				studentidlist.add(id);
				
			}
			System.out.println(studentidlist);
				
//			}
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

		return studentidlist;
	}

}
