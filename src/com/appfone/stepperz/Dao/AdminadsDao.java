package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Advertisement;

public interface AdminadsDao {
	public abstract List getads();
	public abstract void saveads(Advertisement ads);
	public abstract void deletead(int id);
}
