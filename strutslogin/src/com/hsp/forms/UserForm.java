package com.hsp.forms;
//这是一个用户表单，用于填充数据，来自jsp提交的数据
import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {

	//定义属性[属性名字最好和jsp页面的控件名字一致]
	//只要保证set、get方法名字和控件名一致setXXX即可
	private String useremail;
	private String password;
	private String loginsubmit;
	

	private String registermail;
	private String registerpassword;
	private String repeatpassword;
	
	
	public String getLoginsubmit() {
		return loginsubmit;
	}
	public void setLoginsubmit(String loginsubmit) {
		this.loginsubmit = loginsubmit;
	}
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistermail() {
		return registermail;
	}
	public void setRegistermail(String registermail) {
		this.registermail = registermail;
	}
	public String getRegisterpassword() {
		return registerpassword;
	}
	public void setRegisterpassword(String registerpassword) {
		this.registerpassword = registerpassword;
	}
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	
}
