package com.automation.asmt.utils;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
	
	@JsonProperty("AccommodationFactor")
	private String accommodationFactor;
	
	@JsonProperty("FirstName")
	private String FirstName;
	
	@JsonProperty("MiddleName")
	private String MiddleName;
	
	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("Email")
	private String Email;
	
	@JsonProperty("Password")
	private String Password;
	
	@JsonProperty("Street")
	private String Street;
	
	@JsonProperty("Street2")
	private String Street2;
	
	@JsonProperty("Street3")
	private String Street3;
	
	@JsonProperty("City")
	private String City;
	
	@JsonProperty("StateID")
	private String StateID;
	
	@JsonProperty("Zip")
	private String Zip;
	
	@JsonProperty("CountryID")
	private int CountryID;
	
	@JsonProperty("Phone")
	private String Phone;
	
	@JsonProperty("ApplicationID")
	private int ApplicationID;
	
	@JsonProperty("RoleID")
	private int RoleID;
	
	@JsonProperty("SecurityAnswers")
	private List<SecurityAnswers> securityAnswers;
	
	public List<SecurityAnswers> getSecurityAnswers() {
		return securityAnswers;
	}
	
	@JsonProperty("InstitutionID")
	private int InstitutionID;
	
	@JsonProperty("Credentials")
	private String Credentials;
	
	@JsonProperty("StudentID")
	private String StudentID;
	
	@JsonProperty("IsNonDegreeSeeking")
	private boolean IsNonDegreeSeeking;
	
	@JsonProperty("IsOptInCommunication")
	private boolean IsOptInCommunication;
	
	@JsonProperty("RaceIDs")
	private int[] RaceIDs;
	
	@JsonProperty("LanguageID")
	private int LanguageID;
	
	@JsonProperty("Gender")
	private String Gender;
	
	@JsonProperty("ExpectedGraduationDate")
	private String ExpectedGraduationDate;
	
	@JsonProperty("Username")
	private String Username;
	
	@JsonProperty("DateOfBirth")
	private String DateOfBirth;
	
	
	public void setAccommodationFactor(String AccFact) {
		accommodationFactor = AccFact;
	}
	
/*	public String getFirstName() {
		return FirstName;
	}
*/	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/*public String getMiddleName() {
		return MiddleName;
	}*/
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	/*public String getLastName() {
		return LastName;
	}*/
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/*public String getEmail() {
		return Email;
	}*/
	public void setEmail(String email) {
		Email = email;
	}
	/*public String getPassword() {
		return Password;
	}*/
	public void setPassword(String password) {
		Password = password;
	}
	/*public String getStreet() {
		return Street;
	}*/
	public void setStreet(String street) {
		Street = street;
	}
	/*public String getStreet2() {
		return Street2;
	}*/
	public void setStreet2(String street2) {
		Street2 = street2;
	}
	/*public String getStreet3() {
		return Street3;
	}*/
	public void setStreet3(String street3) {
		Street3 = street3;
	}
	/*public String getCity() {
		return City;
	}*/
	public void setCity(String city) {
		City = city;
	}
	/*public String getStateID() {
		return StateID;
	}*/
	public void setStateID(String stateID) {
		StateID = stateID;
	}
	/*public String getZip() {
		return Zip;
	}*/
	public void setZip(String zip) {
		Zip = zip;
	}
	/*public int getCountryID() {
		return CountryID;
	}*/
	public void setCountryID(int countryID) {
		CountryID = countryID;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public void setApplicationID(int applicationID) {
		ApplicationID = applicationID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	
	public void setInstitutionID(int institutionID) {
		InstitutionID = institutionID;
	}
	public void setCredentials(String credentials) {
		Credentials = credentials;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public void setIsNonDegreeSeeking(boolean isNonDegreeSeeking) {
		IsNonDegreeSeeking = isNonDegreeSeeking;
	}
	public void setIsOptInCommunication(boolean isOptInCommunication) {
		IsOptInCommunication = isOptInCommunication;
	}
	
	public void setLanguageID(int languageID) {
		LanguageID = languageID;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public void setExpectedGraduationDate(String expectedGraduationDate) {
		ExpectedGraduationDate = expectedGraduationDate;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public void setSecurityAnswers(List<SecurityAnswers> securityAnswers) {
		this.securityAnswers = securityAnswers;
	}
	public void setRaceIDs(int[] raceIDs) {
		RaceIDs = raceIDs;
	}
		
}
