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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @NotNull
    @Size(max = 50)
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    public Person() {
    }

    public Person(final Integer id, final String type, final String firstName, final String lastName, final Date dateOfBirth) {
        super.setId(id);
        super.setType(type);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(final Person person) {
        super.setId(person.getId());
        super.setType(person.getType());
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.dateOfBirth = person.getDateOfBirth();
    }

    public Person(final String type, final String firstName, final String lastName, final Date dateOfBirth) {
        super.setType(type);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (super.getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        }
        else if (!super.getId().equals(other.getId())) {
            return false;
        }
        if (super.getType() == null) {
            if (other.getType() != null) {
                return false;
            }
        }
        else if (!super.getType().equals(other.getType())) {
            return false;
        }
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null) {
                return false;
            }
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        }
        else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        }
        else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result
                + (super.getId() == null ? 0 : super.getId().hashCode());
        result = prime * result
                + (super.getType() == null ? 0 : super.getType().hashCode());
        result = prime * result
                + (dateOfBirth == null ? 0 : dateOfBirth.hashCode());
        result = prime * result
                + (firstName == null ? 0 : firstName.hashCode());
        result = prime * result
                + (lastName == null ? 0 : lastName.hashCode());
        return result;
    }

    /**
     * @param dateOfBirth
     *            the dateOfBirth to set
     */
    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
