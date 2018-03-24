package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Kalyannagarvideo;

public interface AdminKalayanvideogalDao {
	
	public List getKalayanvideos();
	public void deletevideo(int id);
	public void savevideo(Kalyannagarvideo kalvideo);
	

}
