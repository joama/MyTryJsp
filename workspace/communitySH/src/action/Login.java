package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login extends ActionSupport{

	// 定義業務邏輯處理介面，裡面封裝了驗證使用者合法性的方法
	private IUserService userService;
	
	// 定義userName 屬性用以接收使用者輸入的使用者名稱，此處的屬性名稱必須和login.jsp頁面中登錄框的name屬性相同
	private String userName;
	
	// 定義 password屬性用以接收使用者輸入的密碼，此處的屬性名稱必須和login.jsp頁面中密碼框的name屬性相同
	private String password;
	
	@Override
	public String execute() throws Exception{
		if(userService.validateUser(userName, password) != null){
			ActionContext context = ActionContext.getContext();
			String userId = userService.getUserIdByName(userName);
			// 獲取request物件
			HttpServletRequest request = ServletActionContext.getRequest();
			// 獲取response物件
			HttpServletResponse response = ServletActionContext.getResponse();
			// 獲取application物件
			ServletContext application = ServletActionContext.getServletContext();
			// 獲取session物件
			HttpSession session = request.getSession();
			// 獲取使用者編號
			// String userId = userService.getUserIdByName(userName);
			// 把使用者偏好寫入工作階段
			session.setAttribute("userId", userId);
			application.setAttribute("userId", userId);
			return SUCCESS;
		}else{
			addFieldError("password", "密碼不正確!");
			return ERROR;
		}
	}
	public void setUserService(IUserService userServices, IUserService userService){
		this.userService = userService;
	}
	
	public void setUserName(String userName){
		this.userName = userName; 
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
}
