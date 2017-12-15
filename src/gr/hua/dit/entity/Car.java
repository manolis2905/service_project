package gr.hua.dit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="fuel_type")
	private String fuel_type;
	
	@Column(name="vehicle_condition")
	private String vehicle_condition;
	
	@Column(name="release_year")
	private int release_year;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_afm")
	private Customer customer;
	
	// define constructors
	public Car() {}
	
	public Car(String model, String plate, String fuel_type, int release_year) { 
		this.model = model;
		this.plate = plate;
		this.fuel_type = fuel_type;
		this.release_year = release_year;
	}

	// define getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public String getVehicle_condition() {
		return vehicle_condition;
	}

	public void setVehicle_condition(String vehicle_condition) {
		this.vehicle_condition = vehicle_condition;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}
