package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connect.Connect;
import bean.User;
//用户类的数据访问对象，此类把用户对象与数据库隔离开来，在此类中实现用户对象的创建、修改、插入、增加，从数据库取得用户信息建立用户列表，为了方便使用
public class UserDao {
	
	//插入用户对象
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
