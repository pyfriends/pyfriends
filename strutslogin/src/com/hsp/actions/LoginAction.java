package com.hsp.actions;
//����һ��action(��ʾС�ӳ�)����Ҫ�̳�Action
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
	//������Ҫ��дһ��������execute�ᱻ�Զ�����
	//�е�����servlet/service
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//num++;
		//System.out.println("num="+num);
		//��formת����userform
		UserForm userForm=(UserForm) form;
		//System.out.println("�û�����"+userForm.getUsername());
		/*ʹ��ʿ����service�������ݿ��н�����֤*/
		UsersService userService = new UsersService();
		Users user = new Users();
		
		user.setUseremail(userForm.getUseremail());
		user.setPassword(userForm.getPassword());
		user.setRegistermail(userForm.getRegistermail());
		user.setRegisterpassword(userForm.getRegisterpassword());
		
		System.out.println("��½��submitΪ��"+userForm.getRegistermail());
		
		if(userForm.getLoginsubmit()==null){
			if(userService.regCheck(user)){	
				//
				return  mapping.findForward("reg_err");
			}else{
				userService.addUser(user);
				System.out.println("ע�Ჿ�֣�");
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
		//System.out.println("�ʼ�Ϊ��"+userForm.getUseremail());
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
