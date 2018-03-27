package com.appfone.stepperz.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appfone.stepperz.Dao.AdminAddDao;
import com.appfone.stepperz.pojo.Adminregistration;
import com.appfone.stepperz.pojo.Career;
import com.appfone.stepperz.util.HibernateUtil;

public class AdminAddDaoimpl implements AdminAddDao {

	@Override
	public List getAdmins() {
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Query query = session.createQuery("from Adminregistration ");
		List list = query.list();
		
		return list;
	}

	@Override
	public void deleteAdmin(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session= factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Query query = session.createQuery("delete from Adminregistration where admin_id =:adid");
		query.setParameter("adid", id);
		int rowCount = query.executeUpdate();
		System.out.println("delete ads complete");
		System.out.println("rowcount "+rowCount);
		t.commit();
		session.close();
		
		
	}

	@Override
	public Adminregistration getSingleadmin(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Adminregistration admin = (Adminregistration)session.get(Adminregistration.class, id);
		
		t.commit();
		session.close();
		
		return admin;
	}

}
