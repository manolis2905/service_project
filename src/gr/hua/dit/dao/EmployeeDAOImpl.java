package gr.hua.dit.dao;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Car;
import gr.hua.dit.entity.Customer;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertNewCustomer(HttpServletRequest request) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		int afm = Integer.valueOf(request.getParameter("afm"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		
		String carModel = request.getParameter("model");
		String plate = request.getParameter("plate");
		String fuel_type = request.getParameter("fuelType");
		int release_year = 0;
		if(!request.getParameter("releaseYear").equals("")) {
			release_year = Integer.valueOf(request.getParameter("releaseYear"));
		}

		//Customer customer = new Customer(afm, lastName, firstName);
		//Car car = new Car(carModel, plate, fuel_type, release_year);
		//customer.addCar(car);
				
		//currentSession.save(customer);
		//currentSession.save(car);

	}

}
