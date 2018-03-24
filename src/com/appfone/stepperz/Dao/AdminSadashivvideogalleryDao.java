package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Kalyannagarvideo;
import com.appfone.stepperz.pojo.Sadashivnagarvideo;

public interface AdminSadashivvideogalleryDao {
	
	public List getSadavideos();
	public void deletevideo(int id);
	public void savevideo(Sadashivnagarvideo sadavideo);
	

}
