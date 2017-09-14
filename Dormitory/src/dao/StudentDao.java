package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connect.Connect;
import bean.Student;
import bean.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class StudentDao {
	//查找学生，是否存在
	public static  boolean findteacher(String usid,String uspsd) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*) from Student where id='" +usid+"' and phone='"+uspsd+"'";
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
	public static  boolean addroom(String RoomID) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*)from Room where RoomID='"+RoomID+"'and numbER >"
					+ "(SELECT COUNT(rOOMid) from Student where roomId='"+RoomID+"')";				
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
	public static  boolean findteacher1(String usid) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*) from Student where id='" +usid+"' ";
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next(); 
			int num=rs.getInt(1);
			rs.close();
			st.close();
			if (num==0)
				return true;
			else
				return false;
									
		}finally
		{
			conn.close();
		}
	}
	
	//插入用户
	public static Student insertStudent(Student p) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="INSERT INTO Student(id,name,gender,phone,RoomID," +
					"address,subject,arrival,move,age) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);  
			ps.setString(1,p.getId());
			ps.setString(2,p.getName());			
			ps.setString(3,p.getGender());
			ps.setString(4,p.getPhone());
			ps.setString(5,p.getRoomID());
			ps.setString(6,p.getAddress());
			ps.setString(7,p.getSubject());
			ps.setString(8,p.getArrival());
			ps.setString(9,p.getMove());
			ps.setString(10,p.getAge());
			ps.executeUpdate();	
			ps.close();
			return p;
		}
		finally{
			conn.close();
		}		
	}
	//更新用户，根据用户名
	public static Student updateBook(Student p) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="UPDATE  Student set id=?,name=?,gender=?,phone=?"
					+",RoomID=?,address=?,subject=?,arrival=?,move=?,age=?";
			PreparedStatement ps=conn.prepareStatement(sql);  
			ps.setString(1,p.getId());
			ps.setString(2,p.getName());			
			ps.setString(3,p.getGender());
			ps.setString(4,p.getPhone());
			ps.setString(5,p.getRoomID());
			ps.setString(6,p.getAddress());
			ps.setString(7,p.getSubject());
			ps.setString(8,p.getArrival());
			ps.setString(9,p.getMove());
			ps.setString(10,p.getAge());
			ps.executeUpdate();	
			ps.close();
			return p;
		}
		finally{
			conn.close();
		}		
	}
	//删除对象
	public static boolean deleteStudent(String id) throws Exception{
		Connection conn = Connect.Connection();
		try{
		String sql = "delete from Student where id='"+id+"'";
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
	/*public static  boolean findteacher(String usid,String uspsd) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="select count(*) from Student where id='" +usid+"' and phone='"+uspsd+"'";
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
	}*/
	public static boolean findStudent(String RoomID,String gender) throws Exception{
		Connection conn = Connect.Connection();
		try{
		String sql = "select count(*) from Room where Roomid='"+RoomID+"' and gender='"+gender+"'";
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
	
	
	//取得查询全体对象
	public ObservableList <Student> findStudentList(String id,String name) throws Exception{
		Connection conn=Connect.Connection();
		ObservableList <Student> ulist=FXCollections.observableArrayList();
		try{
			Statement st = conn.createStatement();
			String condition="";
			if (id.equalsIgnoreCase(""))
				if (name.equalsIgnoreCase(""))
					condition="";
				else
					condition="where name='"+name+"'";
			else
				if (name.equalsIgnoreCase(""))
					condition="where id='"+id+"'";
				else
					condition="where name='"+name+"' and id='"+id+"'";
			String sql="select * from Student "+condition;
			ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Student s=new Student();
					s.setAddress(rs.getString("address"));
					s.setAge(rs.getString("age"));
					s.setArrival(rs.getString("arrival"));
					s.setGender(rs.getString("gender"));
					s.setId(rs.getString("id"));
					s.setMove(rs.getString("move"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getString("phone"));
					s.setRoomID(rs.getString("RoomID"));
					s.setSubject(rs.getString("subject"));	
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
	public  static ObservableList <Student> findroom(String RoomID) throws Exception{
		Connection conn=Connect.Connection();
		ObservableList <Student> ulist=FXCollections.observableArrayList();
		try{
			Statement st = conn.createStatement();
			String sql="select * from Student WHERE RoomID='"+RoomID+"'";
			ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Student s=new Student();
					s.setAddress(rs.getString("address"));
					s.setAge(rs.getString("age"));
					s.setArrival(rs.getString("arrival"));
					s.setGender(rs.getString("gender"));
					s.setId(rs.getString("id"));
					s.setMove(rs.getString("move"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getString("phone"));
					s.setRoomID(rs.getString("RoomID"));
					s.setSubject(rs.getString("subject"));	
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
}

