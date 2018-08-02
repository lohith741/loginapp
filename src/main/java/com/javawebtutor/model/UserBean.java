package com.javawebtutor.model;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;



@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	protected String firstName;
	protected String lastName;
	protected Date dob;
	protected String loginid;
	protected String password;
	protected String confpassword;
	protected String email;

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

	public String getloginid() {
		return loginid;
	}

	public void setloginid(String loginid) {
		this.loginid = loginid;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getconfpassword() {
		return confpassword;
	}

	public void setconfpassword(String confpassword) {
		this.confpassword = confpassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid email address");
			throw new ValidatorException(message);
		}
	}
	

	public void validatePassword(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String confirmPassword = (String) value;
		UIInput passwordInput = (UIInput) toValidate.findComponent("passcode");
		String password= (String) passwordInput.getLocalValue();
		
		
		if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
			FacesMessage error= new FacesMessage("password doesn't match");
			throw new ValidatorException(error);
		}
	 }


}
