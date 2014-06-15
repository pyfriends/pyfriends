package com.hsp.actions;
//这是一个action(表示小队长)，需要继承Action
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hsp.domain.Users;
import com.hsp.forms.UserForm;
import com.hsp.service.UsersService;
import com.hsp.utils.SqlUtil;

public class LoginAction extends Action {

	//private int num=0;
	//我们需要重写一个方法：execute会被自动调用
	//有点类似servlet/service
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//num++;
		//System.out.println("num="+num);
		//把form转换成userform
		UserForm userForm=(UserForm) form;
		//System.out.println("用户名："+userForm.getUsername());
		/*使用士兵（service）到数据库中进行验证*/
		UsersService userService = new UsersService();
		Users user = new Users();
		
		user.setUseremail(userForm.getUseremail());
		user.setPassword(userForm.getPassword());
		user.setRegistermail(userForm.getRegistermail());
		user.setRegisterpassword(userForm.getRegisterpassword());
		
		System.out.println("登陆的submit为："+userForm.getRegistermail());
		
		if(userForm.getLoginsubmit()==null){
			if(userService.regCheck(user)){	
				//
				return  mapping.findForward("reg_err");
			}else{
				userService.addUser(user);
				System.out.println("注册部分：");
		    	return  mapping.findForward("reg");
			}
		}else{
			
			if(userService.checkUser(user)){
				return mapping.findForward("ok");
			}else{
				return mapping.findForward("err");
			}
			//userService.addUser(user);
			
		}
		//System.out.println("邮件为："+userForm.getUseremail());
		/*
		if(userService.checkUser(user)){
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("err");
		}
		*/
		//return null;
		//return super.execute(mapping, form, request, response);
	}
	
	
}
