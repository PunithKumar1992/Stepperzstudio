package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Registration;

public interface AdminstdregDao {
	
	public abstract void savestdreg(Registration reg);
	public abstract List getSavedreglist();
	public abstract void deletesinglestdreg(int id);

}
