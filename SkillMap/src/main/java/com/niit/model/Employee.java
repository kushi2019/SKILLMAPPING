package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
    
	private String firstName;
	private String lastName;
    @NonNull

	private String emailId;
	private String contactNo;
	@NonNull
	private String gender;
    @NonNull
	private String role;
    @Transient
    private String errorCode;
    @Transient
    private String message;
    @NonNull
	private String password;
    @NonNull
	private String certification;
    @NonNull
	private String skill;
	private boolean active;
	private String image;
	private String proLocation;
	private int experience;
	@NonNull
	private int noOfStudentPlaced;
	@NonNull
	private int noOfStudentTaught;
	private int rating;
	@NonNull
	private Date date_of_joining;

	public int getEmpId() {
		return empId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public int getNoOfStudentPlaced() {
		return noOfStudentPlaced;
	}

	public void setNoOfStudentPlaced(int noOfStudentPlaced) {
		this.noOfStudentPlaced = noOfStudentPlaced;
	}

	public int getNoOfStudentTaught() {
		return noOfStudentTaught;
	}

	public void setNoOfStudentTaught(int noOfStudentTaught) {
		this.noOfStudentTaught = noOfStudentTaught;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProLocation() {
		return proLocation;
	}

	public void setProLocation(String proLocation) {
		this.proLocation = proLocation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

}
