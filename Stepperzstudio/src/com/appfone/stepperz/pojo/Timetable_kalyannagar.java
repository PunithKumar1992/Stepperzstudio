package com.appfone.stepperz.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Timetable_kalyannagar {
	
	 private int tb_id;
	 private String timetable_caption;
	 private String timetable_image;
	 private MultipartFile kalafile;
	public int getTb_id() {
		return tb_id;
	}
	public void setTb_id(int tb_id) {
		this.tb_id = tb_id;
	}
	public String getTimetable_caption() {
		return timetable_caption;
	}
	public void setTimetable_caption(String timetable_caption) {
		this.timetable_caption = timetable_caption;
	}
	public String getTimetable_image() {
		return timetable_image;
	}
	public void setTimetable_image(String timetable_image) {
		this.timetable_image = timetable_image;
	}
	public MultipartFile getKalafile() {
		return kalafile;
	}
	public void setKalafile(MultipartFile kalafile) {
		this.kalafile = kalafile;
	}
	@Override
	public String toString() {
		return "Timetable_kalyannagar [tb_id=" + tb_id + ", timetable_caption=" + timetable_caption
				+ ", timetable_image=" + timetable_image + ", kalafile=" + kalafile + "]";
	}
	
	
	 

}
