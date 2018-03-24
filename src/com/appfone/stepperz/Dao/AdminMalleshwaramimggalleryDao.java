package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Kalyannagarimages;
import com.appfone.stepperz.pojo.Malleshwaramimages;

public interface AdminMalleshwaramimggalleryDao {
	
	public List getmalanimg();

	public void deletemalaimg(int id);
	
	public void saveadminimg(Malleshwaramimages malaimg);

}
