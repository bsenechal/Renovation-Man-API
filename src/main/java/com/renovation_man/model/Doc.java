package com.renovation_man.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DOCUMENTS")
@SequenceGenerator(name = "DOC_SEQ", sequenceName = "DOC_SEQ")
public class Doc {
    @Transient
    private static final long serialVersionUID = -9002958958260404193L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOC_SEQ")
    @Column(name = "ID", precision = 12, scale = 0)
    private Integer id;
    
    @NotNull
    @Column(name = "VERSION_NUMBER", precision = 12, scale = 0)
    @Version
    private Integer versionNumber;
    
    @NotNull
    @Size(max = 2000)
    @Column(name = "TEXT", length = 2000)
    private String text;
    
    @NotNull
    @Column(name = "AUTHOR_ID", precision = 12, scale = 0)
    private Integer authorId;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the versionNumber
     */
    public Integer getVersionNumber() {
        return versionNumber;
    }

    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the authorId
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
