package com.appfone.stepperz.Daoimpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appfone.stepperz.Dao.Admintime_malleshwaramDao;
import com.appfone.stepperz.pojo.Timetable_malleshwaram;
import com.appfone.stepperz.pojo.Timetable_sadashivnagr;
import com.appfone.stepperz.util.HibernateUtil;

public class Admintime_malleshwaramDaoimpl implements Admintime_malleshwaramDao {

	@Override
	public List gettimetables() {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session =factory.openSession();
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("from Timetable_malleshwaram");
		List list=query.list();
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		return list;
	}

	@Override
	public void saveMalleshTime(Timetable_malleshwaram newtime) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		session.saveOrUpdate(newtime);
		t.commit();
		session.close();
		
	}

	@Override
	public Timetable_malleshwaram getsingletime(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Timetable_malleshwaram malleshtime = (Timetable_malleshwaram)session.get(Timetable_malleshwaram.class, id);
		t.commit();
		session.close();
		return malleshtime;
	}

}
