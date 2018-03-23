package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Timetable_malleshwaram;
public interface Admintime_malleshwaramDao {
	
	public abstract List gettimetables();
	public void saveMalleshTime(Timetable_malleshwaram newtime);
	public Timetable_malleshwaram getsingletime(int id);

}
