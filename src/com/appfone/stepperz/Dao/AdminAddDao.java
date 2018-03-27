package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Adminregistration;

public interface AdminAddDao {
	
	public List getAdmins();
	public void deleteAdmin(int id);
	public Adminregistration getSingleadmin(int id);

}
