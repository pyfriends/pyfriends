package com.hsp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class SqlHelper {

		//������Ҫ�ı���
		private static Connection ct=null;
		private static Statement sm=null;
		private static PreparedStatement ps=null;//��ֹSQLע��©��
		private static ResultSet rs=null;
		private static CallableStatement cs=null;

		//�������ݿ�Ĳ���
		
		private static String driver="com.mysql.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/mydb1?useUnicode=true&amp;characterEncoding=UTF-8";
		private static String username="root";
		private static String password="liutao0161";
		/*
		private static String driver="";
		private static String url="";
		private static String username="";
		private static String password="";
		*/
		static Properties pp=null;
		static FileInputStream fis=null;
		
		
		public static Connection getCt() {
			return ct;
		}
		public static PreparedStatement getPs() {
			return ps;
		}
		public static ResultSet getRs() {
			return rs;
		}
		//����������ֻ��һ��
		static{
			try {
				/*
				pp=new Properties();
				fis=new FileInputStream("dbinfo.properties");
				pp.load(fis);
				url=pp.getProperty("url");
				username=pp.getProperty("username");
				driver=pp.getProperty("driver");
				password=pp.getProperty("password");
				*/
				Class.forName(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��������ʧ��"+e.getMessage());
			}finally{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fis=null;
			}
		}
		
		//�õ�����
		public static Connection getConnection(){
			try {
				ct=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ct;
		}
		
		//�з���ֵ�Ĵ洢����
		//call(???)
		//out ����������
		public   CallableStatement callPro2(String sql,String [] inparameters,Integer [] outparameters){
			
			try {
				ct=getConnection();
				cs=ct.prepareCall(sql);
				if(inparameters!=null){
					for (int i = 0; i < inparameters.length; i++) {
						cs.setObject(i+1, inparameters[i]);
					}
				}
				
				if(outparameters!=null){
					for (int i = 0; i < outparameters.length; i++) {
						cs.registerOutParameter(inparameters.length+1+i, outparameters[i]);
					}
				}
				cs.execute();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				
				//
			}
			return cs;
		}
		
		//��ҳ����
		//���ô洢����(����������)
		//���ô洢���̵�sql��� {call ������(?,?,?)}
		//��ʹ�ñ��������ô洢����ǰ������mysql�ж���洢���̣�����ο���־�ĵ�2014/6/2
		public  void callPro1(String sql, String [] parameters){
			
			try {
				ct=getConnection();
				cs=ct.prepareCall(sql);
				//��call�ģ���ֵ
				if(parameters!=null){
					for (int i = 0; i < parameters.length; i++) {
						cs.setObject(i+1, parameters[i]);
					}
				}
				cs.execute();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				
				close(rs, cs, ct);
			}
		}
		
		
		//ͳһ��select
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
				
			}
			return rs;
		}
		//���update,select,insert��䣬��Ҫ��������
		public  void excuteUpdate2(String [] sql, String [][] parameters){
			try {
				
				//1.�������
				ct=getConnection();
				//��ʱ�����Sql�п����Ƕ��sql���
				ct.setAutoCommit(false);
				//....
				for(int i=0;i<sql.length;i++){
					if(parameters[i]!=null){
						ps=ct.prepareStatement(sql[i]);
						for(int j=0;j<parameters[i].length;j++){
							ps.setString(j+1,parameters[i][j]);
						}
						ps.executeUpdate();
					}
				}
				
				ct.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				try {
					ct.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				throw new RuntimeException(e.getMessage());
			}finally{
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
