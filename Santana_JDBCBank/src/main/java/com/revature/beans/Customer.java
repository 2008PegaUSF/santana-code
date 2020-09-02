package com.revature.beans;
/*Java Bean
 * private fields
 * No args and w/fields constructors
 * getters and setters
 * toString method override
 * */
public class Customer {
	private int customerId;
	private int userId;
	private String lastName;
	private String firstName;
	private String customerType;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private int accountId;
	private int jointId;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, int userId, String lastName, String firstName, String customerType, String address,
			String city, String state, String zipCode, String phone, int accountId, int jointId) {
		super();
		this.customerId = customerId;
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.customerType = customerType;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.accountId = accountId;
		this.jointId = jointId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getJointId() {
		return jointId;
	}

	public void setJointId(int jointId) {
		this.jointId = jointId;
	}

	@Override
	public String toString() {
		return " Customer Id: " + customerId + ",\n UserId: " + userId + ",\n Name: " + firstName + " " + lastName 
				+",\n Account Type: " + address + ",\n Address: " + customerType + ",\n City: " + city + ",\n State: "
				+ state + ",\n Zip Code: " + zipCode + ",\n Phone: " + phone + ",\n Account Id: " + accountId;
	}
	
	

}
