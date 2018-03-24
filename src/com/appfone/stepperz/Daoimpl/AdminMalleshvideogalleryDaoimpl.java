package com.appfone.stepperz.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appfone.stepperz.Dao.AdminMalleshvideogalleryDao;
import com.appfone.stepperz.pojo.Malleshwaramvideo;
import com.appfone.stepperz.util.HibernateUtil;

public class AdminMalleshvideogalleryDaoimpl implements AdminMalleshvideogalleryDao {

	@Override
	public List getMalleshvideos() {
		SessionFactory  factory =HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Query query= session.createQuery(" from Malleshwaramvideo");
		List list = query.list();
		
		
		return list;
		
	}

	@Override
	public void deletevideo(int id) {
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Query query = session.createQuery("delete from Malleshwaramvideo where video_id =:delvidid");
		query.setParameter("delvidid", id);
		int rowCount = query.executeUpdate();
		System.out.println("row count" +rowCount);
		t.commit();
		session.close();
	}

	@Override
	public void savevideo(Malleshwaramvideo malavideo) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		session.saveOrUpdate(malavideo);
		t.commit();
		session.close();
	}

}
