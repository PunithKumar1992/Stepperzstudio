package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Banner;

public interface AdminbannerDao {

	public abstract List getbanners();
	public void Savebanner(Banner banner);
	public abstract void deletebanner(int id,String img);
	
	
}
