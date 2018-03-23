package com.appfone.stepperz.Daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appfone.stepperz.Dao.Admintime_kalyannagrDao;
import com.appfone.stepperz.pojo.Timetable_kalyannagar;
import com.appfone.stepperz.pojo.Timetable_sadashivnagr;
import com.appfone.stepperz.util.HibernateUtil;

public class Admintime_kalyannagrDaoimpl implements Admintime_kalyannagrDao{

	@Override
	public List gettimetables() {
		System.out.println("admin kalyan nagar Dao");
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session =factory.openSession();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("from Timetable_kalyannagar");
		List list=query.list();
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		return list;
	}

	@Override
	public void saveSadaTime(Timetable_kalyannagar newtime) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		session.saveOrUpdate(newtime);
		t.commit();
		session.close();
		
		
		
	}

	@Override
	public Timetable_kalyannagar getsingletime(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Timetable_kalyannagar kalyantime = (Timetable_kalyannagar)session.get(Timetable_kalyannagar.class, id);
		t.commit();
		session.close();
		return kalyantime;
	}

}
