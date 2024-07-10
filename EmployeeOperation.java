package com.model;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeOperation {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		SessionFactory sessionFactory=HibernateUtill.getSesFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee>empList=criteria.list();
		for(Employee emp:empList)
		{
			System.out.println("ID="+emp.getId()+"  "+emp.getName()+"       "+emp.getSalary());
		}
     	criteria=session.createCriteria(Employee.class).add(Restrictions.eq("id", new Integer(2)));
		Employee emp=(Employee) criteria.uniqueResult();
		System.out.println("Name="+emp.getName() );
		empList=session.createCriteria(Employee.class)
				.addOrder(Order.desc("id"))
				.setFirstResult(0)
				.setMaxResults(2)
				.list();
		for(Employee emp4: empList)
		{
			System.out.println("Paginated Employees"+emp4.getId()+ emp4.getName());
			System.out.println("----------------------------------------------------------------");
		}
		empList=session.createCriteria(Employee.class)
				.add(Restrictions.like("name","%m%"))
				.list();
		for(Employee emp4:empList)
		{
			System.out.println("================================================================");
			System.out.println("Employee having 'm' in name::"+emp4.getName());
			System.out.println("================================================================");

		}
		Criteria c=session.createCriteria(Employee.class);
		c.setProjection(Projections.rowCount());
		empList=c.add(Restrictions.like("name","%m%")).list();
		System.out.println("================================================================");

		System.out.println("Number of Employees wiht m in name="+empList.getFirst());
		System.out.println("================================================================");

		Criteria d=session.createCriteria(Employee.class);
		empList=d.setProjection(Projections.sum("salary")).list();
		System.out.println("================================================================");

		System.out.println("Sum fo Salaries="+empList.getFirst());
		System.out.println("================================================================");
         
		empList=session.createCriteria(Employee.class)
				.add(Restrictions.gt("salary",25000f))
				.list();
		for(Employee emp5:empList)
		{
			
			System.out.println(emp5.getId()+emp5.getName()+emp5.getSalary());
		}
		tx.commit();
		sessionFactory.close();
		}
}

		
		
		
		
		
	