package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Timetable_kalyannagar;
import com.appfone.stepperz.pojo.Timetable_sadashivnagr;


public interface Admintime_kalyannagrDao {
	
	public abstract List gettimetables();
	public void saveSadaTime(Timetable_kalyannagar newtime);
	public Timetable_kalyannagar getsingletime(int id);

}
