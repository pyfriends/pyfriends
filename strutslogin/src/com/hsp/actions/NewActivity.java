package com.hsp.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.model.Activity;
import com.hsp.model.DatabaseAction;

/**
 * Servlet implementation class NewActivity
 */
@WebServlet("/new-activity.do")
public class NewActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String retUrl = "/strutslogin/eating/eating.jsp";
	
	
	private Activity act = new Activity();
	private HttpServletRequest request;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  this.request = request;
	  getAllPara();
	  new AddActivityAction().doSql(act);
	  response.sendRedirect(retUrl);
	}
	
	
	private void getAllPara() {
	  act.setActivityName(getPara("activity_name"));
	  act.setOrganizer(getPara("organizer"));
	  act.setContact(getPara("contact"));
	  act.setActivityClass(getPara("activity_class"));
	  act.setActivityAbstract(request.getParameter("activity_abstract")); // Can be null
	  act.setActivityPlace(getPara("activity_place"));
	  act.setStarttime(getTime("start"));
	  act.setEndtime(getTime("end"));
	  act.setMaxNumber(Integer.parseInt(getPara("maxnumber")));
	  act.setRange(getPara("range"));
	  act.setDetail(getPara("detail"));
  }
	
	private String getPara(String name) {
	  String ret = request.getParameter(name);
	  if (null == ret) {
	    throw new RuntimeException();
	  }
	  return ret;
	}
	
	private Date getTime(String prefix) {
	  String year = getPara(prefix + "year");
	  String month = getPara(prefix + "month");
	  String day = getPara(prefix + "day");
	  String hour = getPara(prefix + "hour");
	  String minute = getPara(prefix + "minute");
	  
	  // System.out.println(prefix);
	  // System.out.println(year);
	  // System.out.println(month);
	  // System.out.println(day);
	  // System.out.println(hour);
	  // System.out.println(minute);
	  
	  Calendar cal = Calendar.getInstance();
	  cal.set(
	    Integer.parseInt(year),
	    Integer.parseInt(month),
	    Integer.parseInt(day),
	    Integer.parseInt(hour),
	    Integer.parseInt(minute)
	  );
	  
	  return cal.getTime();
	}
	
	private class AddActivityAction extends DatabaseAction {

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

}
