package com.hsp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class SqlHelper {

		//定义需要的变量
		private static Connection ct=null;
		private static Statement sm=null;
		private static PreparedStatement ps=null;//防止SQL注入漏洞
		private static ResultSet rs=null;
		private static CallableStatement cs=null;

		//连接数据库的参数
		
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
		//加载驱动，只需一次
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
				throw new RuntimeException("驱动加载失败"+e.getMessage());
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
		
		//得到连接
		public static Connection getConnection(){
			try {
				ct=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ct;
		}
		
		//有返回值的存储过程
		//call(???)
		//out 是输出结果用
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
		
		//分页问题
		//调用存储过程(不考虑事务)
		//调用存储过程的sql语句 {call 过程名(?,?,?)}
		//在使用本函数调用存储过程前，需在mysql中定义存储过程，详情参考日志文档2014/6/2
		public  void callPro1(String sql, String [] parameters){
			
			try {
				ct=getConnection();
				cs=ct.prepareCall(sql);
				//给call的？赋值
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
		
		
		//统一的select
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
		//多个update,select,insert语句，需要考虑事务
		public  void excuteUpdate2(String [] sql, String [][] parameters){
			try {
				
				//1.获得连接
				ct=getConnection();
				//此时传入的Sql有可能是多个sql语句
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
		//单个update,select,insert语句
		//sql格式： update 表名 set 字段名=? where 字段名=?
		
		public  void excuteUpdate(String sql, String [] parameters){
			
			//创建一个ps
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
				//抛出运行异常
				throw new RuntimeException(e.getMessage());
			}finally{
				
				//关闭资源
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
