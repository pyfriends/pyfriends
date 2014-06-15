package com.hsp.service;

import java.sql.*;
import java.util.ArrayList;
import com.hsp.utils.*;
import com.hsp.domain.Users;

public class UsersService {

		public boolean checkUser (Users user){
			
			String sql="select * from pyfriends where usermail=? and password=?";
			String [] parameters={user.getUseremail(),user.getPassword()};
			SqlUtil  sqlUtil= new SqlUtil();
			System.out.println("” œ‰£∫"+user.getUseremail());
			System.out.println("√‹¬Î£∫"+user.getPassword());
			
			ArrayList al=sqlUtil.executeQuery2(sql,parameters);
			System.out.println("al.length="+al.size());
			if(al.size()==1){
				
				return true;
			}else{
				return false;
			}		
		}
		
		public boolean regCheck (Users user){
					
			String sql="select * from pyfriends where usermail=?";
			String [] parameters={user.getRegistermail()};
			SqlUtil  sqlUtil= new SqlUtil();
			System.out.println("” œ‰£∫"+user.getUseremail());
			System.out.println("√‹¬Î£∫"+user.getPassword());
			
			ArrayList al=sqlUtil.executeQuery2(sql,parameters);
			System.out.println("al.length="+al.size());
			if(al.size()==1||user.getRegistermail()==""){
				return true;
			}else{
				return false;
			}		
		}
				

		public void addUser (Users user){
			String sql="insert into pyfriends values(?,?,?)";
			String [] parameters={null,user.getRegistermail(),user.getRegisterpassword()};
			System.out.println("” œ‰£∫"+user.getRegistermail());
			System.out.println("√‹¬Î£∫"+user.getRegisterpassword());
			
			SqlUtil  sqlUtil= new SqlUtil();
			sqlUtil.excuteUpdate(sql,parameters);
		}
}
