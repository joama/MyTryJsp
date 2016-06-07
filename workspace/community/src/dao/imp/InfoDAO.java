package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.IInfoDAO;
import domain.Information;
import domain.User;

public class InfoDAO implements IInfoDAO{

	public InfoDAO(){
		
	}
	
	public void addInfo(Information information){
		
		//String format=("yyyy-MM-dd hh:mm:ss");
		
		//SimpleDateFormat myTime =new SimpleDateFormat(format);
		//format(information.getPublishingtime());
		
		DatabaseDAO myDB = new DatabaseDAO();
		
		String sql = "insert into information"
				+ "(Title,Content,PublishingTime,PublishingUser,Type) values('"
				+ information.getTitle() + "','" + information.getContent()
				+ "','" + information.getPublishingtime() + "','"
				+ information.getPublishiuser() + "','" + information.getType()
				+ "')";

		System.out.println("sql語句  " + sql);
		try {
			// 執行SQL語句
			myDB.executeSQL(sql);
		}
		// 處理SQL語句執行過程中可能產生的異常
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}
	}

	@Override
	public List<Information> getAllInfo() {
		// TODO Auto-generated method stub
		
		String sql = "select * from information";
		
		return getInfoBySqlString(sql);
	}

	public List<Information> getInfoBySqlString(String sql) {
		// TODO Auto-generated method stub
		
		DatabaseDAO myDB =new DatabaseDAO();
		
		List<Information> list = new ArrayList<Information>();
		
		try{
			
			ResultSet mySet = myDB.getResultSet(sql);
			
			while(mySet.next()){
				
				Information information = new Information();
				
				information.setId(mySet.getString("Id"));
				
				information.setTitle(mySet.getString("Title"));
				
				information.setContent(mySet.getString("Content"));
				
				information.setPublishingtime(mySet.getString("Publishingtime"));
				
				//User user = new User();
				
				//user.setUserName(mySet.getString("PublicshingUser"));
				
				// 設置信息類對象的用戶字段值
				information.setPublishiuser(mySet.getString("PublishingUser"));
				// 設置信息類對象的日誌類型字段值
				information.setType(mySet.getString("Type"));
				// 把信息類對象加入返回數據集中
				list.add(information);
				
			}
		}catch(ClassNotFoundException cnfEx){
			cnfEx.printStackTrace();
		}catch(SQLException sqlEx){
			sqlEx.printStackTrace();
		}finally{
			try{
				myDB.releaseConnection();
			}catch(SQLException sqlEx){
				sqlEx.printStackTrace();
			}
		}
		 
		return list;
	}


}
