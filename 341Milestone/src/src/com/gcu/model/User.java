package src.com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User 
{
	private int id;
	//Data Validation Annotations
	@NotNull(message="First Name cannot be null.")
	@Size(min=2, max=30, message="First Name must be between 2 and 30 characters.")
	private String firstName;

	//Data Validation Annotations
	@NotNull(message="Last Name cannot be null.")
	@Size(min=2, max=30, message="Last Name must be between 2 and 30 characters.")
	private String lastName;
	
	//Data Validation Annotations
	@NotNull(message="Email cannot be null.")
	@Size(min=2, max=30, message="Email must be between 2 and 30 characters.")
	private String email;
	
	//Data Validation Annotations
	@NotNull(message="Phone Number cannot be null.")
	@Size(min=2, max=30, message="Phone Number must be between 2 and 30 characters.")
	private String phoneNumber;
	
	//Data Validation Annotations
	@NotNull(message="UserName cannot be null.")
	@Size(min=2, max=30, message="UserName must be between 2 and 30 characters.")
	private String username;
	
	//Data Validation Annotations
	@NotNull(message="Password cannot be null.")
	@Size(min=2, max=30, message="Password must be between 2 and 30 characters.")
	private String password;
	
	public User(int id,String firstName, String lastName, String email, String phoneNumber, String userName, String password) 
	{
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = userName;
		this.password = password;
	}
	public User(String userName, String password) 
	{
		this.username = userName;
		this.password = password;
	}
	public User()
	{
		this.setId(-1);
		this.username = "";
		this.password = "";
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password +"]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
