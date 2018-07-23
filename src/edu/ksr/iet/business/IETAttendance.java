package edu.ksr.iet.business;

import java.util.List;

import edu.ksr.iet.prp.bean.Student;
import edu.ksr.iet.prp.dao.AttendanceDao;
import edu.ksr.iet.prp.dao.Finaldate;
import edu.ksr.iet.prp.dao.StudentDao;

import edu.ksr.iet.prp.dao.impl.AttendanceDaoImpl;
import edu.ksr.iet.prp.dao.impl.FinalDateimp;
import edu.ksr.iet.prp.dao.impl.StudentDaoImpl;

public class IETAttendance {
	
	StudentDao studentDao;
	AttendanceDao attendanceDao;
	Finaldate dateDao;
	public IETAttendance(){
		studentDao = new StudentDaoImpl();
		attendanceDao = new AttendanceDaoImpl();
		dateDao=new FinalDateimp();
	}
	
	public List<Student> getStudents(){
		return studentDao.getStudents();
	}
	public int putAttendance(List<String> studentIdList){
	return attendanceDao.insertAttendance(studentIdList);
		 // dateDao.displayAttendanceFilter(studentIdList,date);	
	  
	  
	}
	 public List<String>  Attendance(List<String> studentIdList,String date)
	  {
		 System.out.println(date);
		List<String> finalid= dateDao.displayAttendanceFilter(studentIdList,date);
		System.out.println(finalid);
		 return finalid;
	}


	
}
