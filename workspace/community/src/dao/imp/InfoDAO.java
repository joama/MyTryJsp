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

		System.out.println("sql�y�y  " + sql);
		try {
			// ����SQL�y�y
			myDB.executeSQL(sql);
		}
		// �B�zSQL�y�y����L�{���i�ಣ�ͪ����`
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
				
				// �]�m�H������H���Τ�r�q��
				information.setPublishiuser(mySet.getString("PublishingUser"));
				// �]�m�H������H����x�����r�q��
				information.setType(mySet.getString("Type"));
				// ��H������H�[�J��^�ƾڶ���
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
