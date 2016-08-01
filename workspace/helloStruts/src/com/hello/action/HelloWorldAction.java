package com.hello.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class HelloWorldAction implements Action {
	
	// �w�q�����ܼ�
	private String message;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		// Action ����ᵹ�����ܼƳ]��
		this.message="Hello,World!";
		
		// �b Action ������u�@���q
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		
		//�@������ܼƩ�J�u�@���q
		session.put("message", message);
		
		// �Ǧ^�r�굲�G
		return SUCCESS;
	}

}
