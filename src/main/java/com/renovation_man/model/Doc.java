package com.renovation_man.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Version;

@Entity
@Table(name = "DOCUMENTS")
@SequenceGenerator(name = "DOC_SEQ", sequenceName = "DOC_SEQ")
@IdClass(Doc.class)
public class Doc implements Serializable {
    @Transient
    private static final long serialVersionUID = -9002958958260404193L;

    @NotNull
    @Column(name = "AUTHOR_ID", precision = 12, scale = 0)
    private Integer authorId;

    @Id
    @Column(name = "ID", precision = 12, scale = 0)
    private Integer id;

    @Size(max = 2000)
    @Column(name = "TEXT", length = 2000)
    private String text;

    @Id
    @Column(name = "VERSION_NUMBER", precision = 12, scale = 0)
    @Version
    private Integer versionNumber;

    public Doc() {
    }

    public Doc(final Doc doc) {
        super();
        this.id = doc.getId();
        this.versionNumber = doc.getVersionNumber();
        this.text = doc.getText();
        this.authorId = doc.getAuthorId();
    }

    public Doc(final Integer id, final Integer versionNumber, final String text, final Integer authorId) {
        super();
        this.id = id;
        this.versionNumber = versionNumber;
        this.text = text;
        this.authorId = authorId;
    }

    public Doc(final Integer id, final String text, final Integer authorId) {
        super();
        this.id = id;
        this.text = text;
        this.authorId = authorId;
    }

    public Doc(final String text, final Integer authorId) {
        super();
        this.text = text;
        this.authorId = authorId;
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
        final Doc other = (Doc) obj;
        if (authorId == null) {
            if (other.authorId != null) {
                return false;
            }
        }
        else if (!authorId.equals(other.authorId)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        }
        else if (!id.equals(other.id)) {
            return false;
        }
        if (text == null) {
            if (other.text != null) {
                return false;
            }
        }
        else if (!text.equals(other.text)) {
            return false;
        }
        if (versionNumber == null) {
            if (other.versionNumber != null) {
                return false;
            }
        }
        else if (!versionNumber.equals(other.versionNumber)) {
            return false;
        }
        return true;
    }

    /**
     * @return the authorId
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the versionNumber
     */
    public Integer getVersionNumber() {
        return versionNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + (authorId == null ? 0 : authorId.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (text == null ? 0 : text.hashCode());
        result = prime * result
                + (versionNumber == null ? 0 : versionNumber.hashCode());
        return result;
    }

    /**
     * @param authorId
     *            the authorId to set
     */
    public void setAuthorId(final Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * @param versionNumber
     *            the versionNumber to set
     */
    public void setVersionNumber(final Integer versionNumber) {
        this.versionNumber = versionNumber;
    }
}
