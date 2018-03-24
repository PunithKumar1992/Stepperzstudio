package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Kalyannagarimages;
import com.appfone.stepperz.pojo.Sadashivnagarimages;

public interface AdminkalayanimggalleryDao {
	public List getkalayanimg();
	
	public void deletekalaimg(int id);
	public void saveadminimg(Kalyannagarimages kalaimg);


}
