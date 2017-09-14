package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connect.Connect;
import bean.User;
//�û�������ݷ��ʶ��󣬴�����û����������ݿ���뿪�����ڴ�����ʵ���û�����Ĵ������޸ġ����롢���ӣ������ݿ�ȡ���û���Ϣ�����û��б�Ϊ�˷���ʹ��
public class UserDao {
	
	//�����û�����
		public static User InsertUser(User p) throws Exception{
			Connection conn=Connect.Connection();
			try{
				String sql="INSERT INTO Users (userid,userpassword) VALUES(?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);  
				ps.setString(1,p.getUserid());		
				ps.setString(2,p.getUserpassword());
				ps.executeUpdate();	
				ps.close();
				return p;
			}
			finally{
				conn.close();
			}		
		}
	public static  boolean findUsers(String usid,String uspsd) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*) from Users where userid='" +usid+"' and userpassword='"+uspsd+"'";
			//String sql="select count(*) from User where userid='" +usid+"' and userpassword='"+uspsd+"'";
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); 
			int num=rs.getInt(1);
			rs.close();
			st.close();
			if (num==0)
				return false;
			else
				return true;
									
		}finally
		{
			conn.close();
		}
	}

}
