package com.hsp.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AddActivityAction extends DatabaseAction {

  public void addActivity(Activity act) {
    doSql(act);
  }
  
  @Override
  protected Object sqlAction(Connection conn, Object para) throws SQLException {
    // TODO Auto-generated method stub
    Activity locact = (Activity) para;
    
    String str =
      "insert into activities values(" +
      "?," + // activityid
      "?," + // userid
      "?," + // activityname
      "?," + // activityowner
      "?," + // activitycontact
      "?," + // activitytype
      "?," + // activitypos
      "?," + // acttimebeg
      "?," + // acttimeend
      "?," + // actmaxnumber
      "?," + // acttakenumber
      "?," + // activityrange
      "?"  + // activitydetail 
      ");";
    statement = conn.prepareStatement(str);
    
    statement.setString(1, null);      // activityid
    statement.setInt(2, 1);            // userid, cannot be acquired now, so use fix value 1.
    statement.setString(3, locact.getActivityName());// activityname
    statement.setString(4, locact.getOrganizer());// activityowner
    statement.setString(5, locact.getContact());// activitycontact
    statement.setString(6, locact.getActivityClass());// activitytype
    statement.setString(7, locact.getActivityPlace());// activitypos
    statement.setTimestamp(8, new Timestamp(locact.getStarttime().getTime()));// acttimebeg
    statement.setTimestamp(9, new Timestamp(locact.getEndtime().getTime()));// acttimeend
    statement.setInt(10, locact.getMaxNumber());// actmaxnumber
    statement.setInt(11, 1);            // acttakenumber, at first, only the organizer
    statement.setString(12, locact.getRange());// activityrange
    statement.setString(13, locact.getDetail());// activitydetail 
    
    statement.executeUpdate();
    
    return null;
  }
}
