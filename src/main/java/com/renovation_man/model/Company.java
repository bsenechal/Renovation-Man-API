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

}
