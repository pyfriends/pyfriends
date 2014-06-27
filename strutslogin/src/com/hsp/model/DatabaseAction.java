package com.hsp.model;

import java.sql.*;

import javax.sql.*;
import java.util.*;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.naming.*;

public abstract class DatabaseAction {

  private DataSource datasource;
  protected PreparedStatement statement;

  // Register the driver here.
  public DatabaseAction() {
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      datasource = (DataSource) envContext.lookup("jdbc/mydb1"); // "jdbc/mydb1" is user-defined
    } catch (NamingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  // para: parameters
  // action: subclass of SqlAction, to define different behaviours
  // return value: result
  public Object doSql(Object para) {
    Connection conn = null;
    SQLException sqlEx = null;
    Object ret = null;
    
    try {
      // Get connection from datasource.
      conn = datasource.getConnection();

      ret = sqlAction(conn, para);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      sqlEx = e;
    } finally {
      // Close connection and statement.
      if (null != statement) {
        try {
          statement.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          if (null == sqlEx) {
            sqlEx = e;
          }
        }
      }
      
      if (null != conn) {
        try {
          conn.close();
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          if (null == sqlEx) {
            sqlEx = e;
          }
        }
      }
      
      if (null != sqlEx) {
        throw new RuntimeException(sqlEx);
      }
    }
    
    return ret;
  }
  
  // Implements this method to execute different SQL.
  protected abstract Object sqlAction(Connection conn, Object para) throws SQLException;
}

