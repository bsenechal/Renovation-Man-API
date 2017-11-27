package com.renovation_man.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Person.class, name = "PERSON"),
    @JsonSubTypes.Type(value = Company.class, name = "COMPANY")})
@MappedSuperclass
public abstract class User implements Serializable {
    @Transient
    private static final long serialVersionUID = 2162192344911028801L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", allocationSize=1, sequenceName = "USER_SEQ")
    @Column(name = "ID", precision = 12, scale = 0)
    private Integer id;

    @NotNull
    @Size(max = 50)
    @Column(name = "TYPE", length = 30)
    private String type;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
