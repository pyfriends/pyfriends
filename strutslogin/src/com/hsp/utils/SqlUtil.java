package com.hsp.utils;

import java.sql.*;
import java.util.ArrayList;

//import com.hsp.utils.*;

public class SqlUtil {

		private static Connection ct=null;
		private static Statement sm=null;
		private static PreparedStatement ps=null;//��ֹSQLע��©��
		private static ResultSet rs=null;
		private static CallableStatement cs=null;
		private static ArrayList al=null;
		
		private static String driver="com.mysql.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/mydb1?useUnicode=true&amp;characterEncoding=UTF-8";
		private static String username="root";
		private static String password="liutao0161";
		
		public static Connection getConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				ct=DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ct;
		}
		
		//����OK
		public  ResultSet executeQuery(String sql, String [] parameters){
			
			try {
				
				ct=getConnection();
				ps=ct.prepareStatement(sql);
				if(parameters!=null && !parameters.equals("")){
					for (int i = 0; i < parameters.length; i++) {
						ps.setString(i+1, parameters[i]);
					}
					
				}
				rs=ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
				// TODO: handle exception
			}finally{
				
				close(rs, ps, ct);
			}
			return rs;
		}
		
		public ArrayList executeQuery2(String sql , String [] parameters){
			
			ct=getConnection();
			ArrayList al =new ArrayList();
			try {
				
				ps=ct.prepareStatement(sql);
				if(parameters!=null){
					for (int i = 0; i < parameters.length; i++) {
						ps.setString(i+1, parameters[i]);
					}
				}
				rs=ps.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int colum = rsmd.getColumnCount();
				while(rs.next()){
					//System.out.println("array��out:"+rs.getString("useremail")+"  "+rs.getInt("password"));
					//System.out.println("array��clomu:"+colum);
					Object[] ob = new Object[colum];
					for (int i = 1; i <=colum; i++) {
						ob[i-1]=rs.getObject(i);
					}
					al.add(ob);
				}
				//rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				try {
					close(rs, ps, ct);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					throw new RuntimeException("executeQuery����"+e2.getMessage());
				}
			}
			return al;
	}
		
		//����update,select,insert���
		//sql��ʽ�� update ���� set �ֶ���=? where �ֶ���=?
		
		public  void excuteUpdate2(String sql){
			
			//����һ��ps
			ct=getConnection();
			try {
				
				ps=ct.prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//�׳������쳣
				throw new RuntimeException("sqlִ�д���"+e.getMessage());
			}finally{
				
				//�ر���Դ
				close(rs,ps,ct);
			}
		}
		//����update,select,insert���
		//sql��ʽ�� update ���� set �ֶ���=? where �ֶ���=?
		
		public  void excuteUpdate(String sql, String [] parameters){
			
			//����һ��ps
			ct=getConnection();
			try {
				
				ps=ct.prepareStatement(sql);
				if(parameters!=null){
					for(int i=0;i<parameters.length;i++){
							ps.setString(i+1, parameters[i]);
					}
				}
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//�׳������쳣
				throw new RuntimeException(e.getMessage());
			}finally{
				
				//�ر���Դ
				close(rs,ps,ct);
			}
		}
		
		public void close(ResultSet rs,Statement ps,Connection ct){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps=null;
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ct=null;
			}
		}	

}
