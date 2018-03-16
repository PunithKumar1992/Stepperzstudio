package com.appfone.stepperz.Dao;

import java.util.List;

import com.appfone.stepperz.pojo.Testimonials;

public interface AdmintestimonialsDao {
	
	public abstract List getAllTestimonials();
	public abstract void saveTestimonial(Testimonials test);
	public abstract void deleteSingleTesti(int id);
	public abstract Testimonials getSingleTestimonial(int id);
}
