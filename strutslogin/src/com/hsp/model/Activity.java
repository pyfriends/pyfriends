package com.hsp.model;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable{

	private String activityName = null;
	private String organizer = null;
	private String contact = null;
	private String activityClass = null;
  private String activityAbstract = null;
	private String activityPlace = null;
	private Date starttime = null;
	private Date endtime = null;
	private String range = null;
	private int maxNumber = 0;
	private String detail = null;

	public Activity() {
    // TODO Auto-generated constructor stub
  }

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public String getActivityName() {
    return activityName;
  }

  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  public String getOrganizer() {
    return organizer;
  }

  public void setOrganizer(String organizer) {
    this.organizer = organizer;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getActivityClass() {
    return activityClass;
  }

  public void setActivityClass(String activityClass) {
    this.activityClass = activityClass;
  }

  public String getActivityAbstract() {
    return activityAbstract;
  }

  public void setActivityAbstract(String activityAbstract) {
    this.activityAbstract = activityAbstract;
  }

  public String getActivityPlace() {
    return activityPlace;
  }

  public void setActivityPlace(String activityPlace) {
    this.activityPlace = activityPlace;
  }

  public Date getStarttime() {
    return starttime;
  }

  public void setStarttime(Date starttime) {
    this.starttime = starttime;
  }

  public Date getEndtime() {
    return endtime;
  }

  public void setEndtime(Date endtime) {
    this.endtime = endtime;
  }

  public int getMaxNumber() {
    return maxNumber;
  }

  public void setMaxNumber(int maxNumber) {
    this.maxNumber = maxNumber;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
	
}
