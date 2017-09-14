package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Connect.Connect;
import bean.Outers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class outerDao {
	public static ObservableList <Outers> getouterList(String id) throws Exception{
		Connection conn=Connect.Connection();
		ObservableList <Outers> list=FXCollections.observableArrayList();
		try{
			Statement st = conn.createStatement();
			String sql="select * from Outers where id='"+id+"'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Outers s=new Outers();
				s.setId(rs.getString("id"));
				s.setMove(rs.getString("move"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getString("phone"));
				s.setRoomID(rs.getString("RoomID"));
				s.setSubject(rs.getString("subject"));
				s.setArrival(rs.getString("arrival"));
				list.add(s);
			}
			rs.close();
			st.close();
			return list;
		}
		finally{
			conn.close();
		}
	}
	//≤Â»Î”√ªß
		public static Outers insertStudent(Outers p) throws Exception{
			Connection conn=Connect.Connection();
			try{
				String sql="INSERT INTO Outers(id,name,phone,RoomID," +
						"subject,move,arrival) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);  
				ps.setString(1,p.getId());
				ps.setString(2,p.getName());			
				ps.setString(3,p.getPhone());
				ps.setString(4,p.getRoomID());
				ps.setString(5,p.getSubject());
				ps.setString(6,p.getMove());
				ps.setString(7,p.getArrival());
				ps.executeUpdate();	
				ps.close();
				return p;
			}
			finally{
				conn.close();
			}		
		}
}
