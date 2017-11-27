package com.renovation_man.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COMPANY")
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
public class Company extends User{
    @Transient
    private static final long serialVersionUID = -9002958958260404193L;
    
    public Company() {
	}
    
    public Company(Integer id, String type, String name, String businessEntityType) {
    	super.setId(id);
    	super.setType(type);
		this.name = name;
		this.businessEntityType = businessEntityType;
	}
    
    public Company(String type, String name, String businessEntityType) {
    	super.setType(type);
		this.name = name;
		this.businessEntityType = businessEntityType;
	}
    
    public Company(Company company) {
    	super.setId(company.getId());
    	super.setType(company.getType());
		this.name = company.getName();
		this.businessEntityType = company.getBusinessEntityType();
	}

	@NotNull
    @Size(max = 50)
    @Column(name = "NAME", length = 50)
    private String name;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "BUSINESS_ENTITY_TYPE", length = 50)
    private String businessEntityType;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the businessEntityType
     */
    public String getBusinessEntityType() {
        return businessEntityType;
    }

    /**
     * @param businessEntityType the businessEntityType to set
     */
    public void setBusinessEntityType(String businessEntityType) {
        this.businessEntityType = businessEntityType;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((businessEntityType == null) ? 0 : businessEntityType
						.hashCode());
		result = prime
				* result
				+ ((super.getId() == null) ? 0 : super.getId()
						.hashCode());
		result = prime
				* result
				+ ((super.getType() == null) ? 0 : super.getType()
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (super.getId()!= other.getId())
			return false;
		if (super.getType() == null) {
			if (other.getType() != null)
				return false;
		} else if (!super.getType().equals(other.getType()))
			return false;
		if (businessEntityType == null) {
			if (other.businessEntityType != null)
				return false;
		} else if (!businessEntityType.equals(other.businessEntityType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

    
    
}
