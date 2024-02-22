	package com.car.poolingSystem.entityPack;
	
	import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
	@Entity
	public class UserDetails  {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int userId;
		@Email
		@Column(name = "email")
		private String email;
		@Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
		private String phoneNumber;
		@NotBlank
		private String firstName;
		@NotBlank
		private String lastName;
		
		private int  age;
		

		@NotBlank
		private String role;
		
		private String password;
		
		@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name="documents",
		joinColumns= {@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="DocumentId")}
		) 
		private Set<DriverDocuments> driverDocuments;
		
		@JsonBackReference
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="carID")
		private CarDetails carDetails;
	
		@JsonManagedReference("tripdetails")
		@OneToMany(mappedBy="userdetails",cascade = CascadeType.PERSIST)
		private List<TripDetails> tripdetails ;


		public List<TripDetails> getTripdetails() {
			return tripdetails;
		}

		public void setTripdetails(List<TripDetails> tripdetails) {
			this.tripdetails = tripdetails;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
	
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
		public String getRole() {
			return role;
		}
	
		public void setRole(String role) {
			this.role = role;
		}
		

		public CarDetails getCarDetails() {
			return carDetails;
		}

		public void setCarDetails(CarDetails carDetails) {
			this.carDetails = carDetails;
		}
		

		public Set<DriverDocuments> getDriverDocuments() {
			return driverDocuments;
		}

		public void setDriverDocuments(Set<DriverDocuments> driverDocuments) {
			this.driverDocuments = driverDocuments;
		}

		@Override
		public String toString() {
			return "UserDetails [userId=" + userId + ", email=" + email + ", phoneNumber=" + phoneNumber
					+ ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", role=" + role
					+ ", password=" + password + ", carDetails=" + carDetails + ", tripdetails=" + tripdetails + "]";
		}

		

	
	
	
	}
