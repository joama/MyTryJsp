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

	// �w�q�~���޿�B�z�����A�̭��ʸˤF���ҨϥΪ̦X�k�ʪ���k
	private IUserService userService;
	
	// �w�quserName �ݩʥΥH�����ϥΪ̿�J���ϥΪ̦W�١A���B���ݩʦW�٥����Mlogin.jsp�������n���ت�name�ݩʬۦP
	private String userName;
	
	// �w�q password�ݩʥΥH�����ϥΪ̿�J���K�X�A���B���ݩʦW�٥����Mlogin.jsp�������K�X�ت�name�ݩʬۦP
	private String password;
	
	@Override
	public String execute() throws Exception{
		if(userService.validateUser(userName, password) != null){
			ActionContext context = ActionContext.getContext();
			String userId = userService.getUserIdByName(userName);
			// ���request����
			HttpServletRequest request = ServletActionContext.getRequest();
			// ���response����
			HttpServletResponse response = ServletActionContext.getResponse();
			// ���application����
			ServletContext application = ServletActionContext.getServletContext();
			// ���session����
			HttpSession session = request.getSession();
			// ����ϥΪ̽s��
			// String userId = userService.getUserIdByName(userName);
			// ��ϥΪ̰��n�g�J�u�@���q
			session.setAttribute("userId", userId);
			application.setAttribute("userId", userId);
			return SUCCESS;
		}else{
			addFieldError("password", "�K�X�����T!");
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
