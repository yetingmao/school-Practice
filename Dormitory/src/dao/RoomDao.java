package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connect.Connect;
import bean.Room;
import bean.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class RoomDao {
	//插入用户
		public static Room insertRoom(Room p) throws Exception{
			Connection conn=Connect.Connection();
			try{
				String sql="INSERT INTO Room(RoomID,number,gender) VALUES(?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);  
				ps.setString(1,p.getRoomID());
				ps.setInt(2,p.getNumber());
				ps.setString(3, p.getGender());
				ps.executeUpdate();	
				ps.close();
				return p;
			}
			finally{
				conn.close();
			}		
		}
		//更新
		public static Room updateRoom(Room p) throws Exception{
			Connection conn=Connect.Connection();
			try{
				String sql="UPDATE Room set RoomID=?,number=?,gender=?";
				PreparedStatement ps=conn.prepareStatement(sql);  
				ps.setString(1,p.getRoomID());
				ps.setInt(2,p.getNumber());
				ps.setString(3, p.getGender());
				ps.executeUpdate();	
				ps.close();
				return p;
			}
			finally{
				conn.close();
			}		
		}
		//删除
		public static boolean deleteRoom(String RoomID) throws Exception{
			Connection conn = Connect.Connection();
			try{
			String sql = "delete from Room where RoomID='"+RoomID+"'";
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
		public static ObservableList <Room> FindRoomList(String RoomID) throws Exception{
			Connection conn=Connect.Connection();
			ObservableList <Room> ulist=FXCollections.observableArrayList();
			try{
				Statement st = conn.createStatement();
				String condion="";
				if(RoomID.equalsIgnoreCase(""))
					condion="";
				else
					condion="where RoomID='"+RoomID+"'";
				String sql="select * from Room "+condion;
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Room s=new Room();
					s.setNumber(rs.getInt("number"));
					s.setRoomID(rs.getString("RoomID"));
					s.setGender(rs.getString("gender"));
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
		public static ObservableList <Room> FindRoom() throws Exception{
			Connection conn=Connect.Connection();
			ObservableList <Room> ulist=FXCollections.observableArrayList();
			try{
				Statement st = conn.createStatement();
				String sql="select * from Room  where RoomID IN "
						+ "(select RoomID from Student GROUP by RoomID HAVING count(*)<6  )";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					Room s=new Room();
					s.setNumber(rs.getInt("number"));
					s.setRoomID(rs.getString("RoomID"));
					s.setGender(rs.getString("gender"));
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
