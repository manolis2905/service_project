package gr.hua.dit.dao;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Employee;

@Repository
public class AdminDAOImpl implements AdminDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void createUser(HttpServletRequest request) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create new employee
		Employee newEmployee = new Employee(request.getParameter("username"), request.getParameter("password"),
				Integer.valueOf(request.getParameter("position")));

		// save new employee
		currentSession.save(newEmployee);
	}

	@Override
	public void deleteUser(HttpServletRequest request) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete employee
		currentSession.delete(request.getParameter("id"));

	}

	@Override
	public void modifyUser(HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

}
