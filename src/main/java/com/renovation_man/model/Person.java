/**
 * 
 */
package com.renovation_man.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
public class Person extends User {
	@Transient
	private static final long serialVersionUID = -9002958958260404193L;

	@NotNull
	@Size(max=50)
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	
	@NotNull
	@Size(max=50)
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
