package com.hsp.forms;
//����һ���û���������������ݣ�����jsp�ύ������
import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {

	//��������[����������ú�jspҳ��Ŀؼ�����һ��]
	//ֻҪ��֤set��get�������ֺͿؼ���һ��setXXX����
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
