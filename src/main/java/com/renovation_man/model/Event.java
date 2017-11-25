package com.renovation_man.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LIMA_REPORTING")
@SequenceGenerator(name = "SEQ_LIMA_REPORTING", sequenceName = "SEQ_LIMA_REPORTING")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIMA_REPORTING")
    @Column(name = "ID_REPORTING", precision = 12, scale = 0)
    private Integer idEvent;

    @Column(name = "CD_TYPE", length = 1)
    private String cdType;
    
    @Column(name = "ID_SRC", length = 5)
    private String source;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_MOIS_POS")
    private Date moisPosition;
    
    @Column(name = "ACTION", length = 200)
    private String action;
    
    @Column(name = "STATE", length = 15)
    private String state;
    
    @Column(name = "MADE_BY", length = 50)
    private String madeBy;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPECTED_DATE")
    private Date expectedDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "MADE_ON")
    private Date madeOn;


	/**
	 * @return the id
	 */
	public Integer getIdEvent() {
		return idEvent;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer idEvent) {
		this.idEvent = idEvent;
	}

	/**
	 * @return the cdType
	 */
	public String getCdType() {
		return cdType;
	}

	/**
	 * @param cdType the cdType to set
	 */
	public void setCdType(String cdType) {
		this.cdType = cdType;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the moisPosition
	 */
	public Date getMoisPosition() {
		return moisPosition;
	}

	/**
	 * @param moisPosition the moisPosition to set
	 */
	public void setMoisPosition(Date moisPosition) {
		this.moisPosition = moisPosition;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the madeBy
	 */
	public String getMadeBy() {
		return madeBy;
	}

	/**
	 * @param madeBy the madeBy to set
	 */
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	/**
	 * @return the expectedDate
	 */
	public Date getExpectedDate() {
		return expectedDate;
	}

	/**
	 * @param expectedDate the expectedDate to set
	 */
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	/**
	 * @return the madeOn
	 */
	public Date getMadeOn() {
		return madeOn;
	}

	/**
	 * @param madeOn the madeOn to set
	 */
	public void setMadeOn(Date madeOn) {
		this.madeOn = madeOn;
	}
    
    
}
