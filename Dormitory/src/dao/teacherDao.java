package dao;
import java.sql.*;
import Connect.Connect;
import bean.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class teacherDao {
	public static Teacher insertTeacher(Teacher p) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="INSERT INTO Teacher(userid,userpassword,Teachername,phone) VALUES(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);  
			ps.setString(1,p.getUserid());
			ps.setString(2,p.getUserpassword());
			ps.setString(3,p.getTeachername());
			ps.setString(4,p.getPhone());
			ps.executeUpdate();	
			ps.close();
			return p;
		}
		finally{
			conn.close();
		}		
	}
	//删除
	public static boolean deleteTeacher(String getUserid) throws Exception{
		Connection conn = Connect.Connection();
		try{
		String sql = "delete from Teacher where getUserid='"+getUserid+"'";
		Statement ps = conn.createStatement();
		boolean b = ps.execute(sql);
		ps.close();
		return b;
		}
		finally{
			conn.close();
		}	
	}
	//取得查询列表
	public static ObservableList <Teacher> FindTeacherList() throws Exception{
		Connection conn=Connect.Connection();
		ObservableList <Teacher> ulist=FXCollections.observableArrayList();
		try{
			Statement st = conn.createStatement();
			String sql="select * from Teacher ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Teacher s=new Teacher();
				s.setUserid(rs.getString("userid"));
				s.setUserpassword(rs.getString("userpassword"));
				s.setTeachername(rs.getString("teachername"));
				s.setPhone(rs.getString("phone"));
				ulist.add(s);
			}
			rs.close();
			st.close();
			return ulist;
		}
		finally{
			conn.close();
		}
	}
	public static  boolean findteacher(String usid,String uspsd) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*) from Teacher where userid='" +usid+"' and userpassword='"+uspsd+"'";
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
