package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Career;

public interface AdmincareerDao {

	
	public abstract List getCareers();
	
	public void saveCareer(Career career);
	
	public abstract void deleteSingleCareer(int id);
	
	public abstract Career getSingleCareer(int id);
}
