package com.hello.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class HelloWorldAction implements Action {
	
	// 定義消息變數
	private String message;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		// Action 執行後給消息變數設值
		this.message="Hello,World!";
		
		// 在 Action 中獲取工作階段
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		
		//　把消息變數放入工作階段
		session.put("message", message);
		
		// 傳回字串結果
		return SUCCESS;
	}

}
