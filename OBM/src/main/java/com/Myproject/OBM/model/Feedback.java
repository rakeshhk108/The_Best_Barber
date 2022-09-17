package com.Myproject.OBM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int feeedbackId;
	
	
	private String complaint;
	
	private int appRating;

	public int getFeeedbackId() {
		return feeedbackId;
	}

	public void setFeeedbackId(int feeedbackId) {
		this.feeedbackId = feeedbackId;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public int getAppRating() {
		return appRating;
	}

	public void setAppRating(int appRating) {
		this.appRating = appRating;
	}

	public Feedback(int feeedbackId, String complaint, int appRating) {
		super();
		this.feeedbackId = feeedbackId;
		this.complaint = complaint;
		this.appRating = appRating;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
