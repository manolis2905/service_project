package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="afm")
	private int afm;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@OneToMany(mappedBy="customer")
	private List<Car> cars;
	
	// define constructors
	public Customer() {}
	
	public Customer(int afm, String lName, String fName) {
		this.afm = afm;
		this.lastName = lName;
		this.firstName = fName;
	}

	// define getters and setters
	public int getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	// add convenience methods for bi-directional relation
	public void addCar(Car car) {
		if(cars == null) {
			cars = new ArrayList<>();
		}
		cars.add(car);
		car.setCustomer(this);
	}
	
}
