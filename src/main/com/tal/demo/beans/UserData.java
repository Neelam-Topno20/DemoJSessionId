package main.com.tal.demo.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserData {
	@Id
	private String emailId;
	private String firstName,lastName,password,mobile,city,state;
	
	public UserData() {
		super();
	}

	public UserData(String emailId, String firstName, String lastName, String password, String mobile, String city,
			String state) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
	}
	

	public UserData(String emailId, String firstName, String lastName, String mobile, String city, String state) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}