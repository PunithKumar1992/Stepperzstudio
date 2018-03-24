package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Kalyannagarvideo;
import com.appfone.stepperz.pojo.Malleshwaramvideo;

public interface AdminMalleshvideogalleryDao {
	
	public List getMalleshvideos();
	public void deletevideo(int id);
	public void savevideo(Malleshwaramvideo malavideo);

}
