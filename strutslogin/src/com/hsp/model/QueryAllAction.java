package com.hsp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class QueryAllAction extends DatabaseAction {
  
  public List<Activity> queryAll() {
    return (List<Activity>) doSql(null);
  }

  @Override
  protected Object sqlAction(Connection conn, Object para) throws SQLException {
    // TODO Auto-generated method stub
    String sql = 
      "select * from activities " +
      "order by acttimebeg desc;";
    statement = conn.prepareStatement(sql);
    ResultSet result = statement.executeQuery();
    LinkedList<Activity> activities = new LinkedList<Activity>();
    while (result.next()) {
      Activity act = new Activity();
      act.setActivityName(result.getString(3));
      act.setStarttime(new Date(result.getTimestamp(8).getTime()));
      act.setMaxNumber(result.getInt(10));
      act.setDetail(result.getString(13));
      activities.add(act);
    }
    
    result.close();
    return activities;
  }

}
