package dao;
import java.sql.*;
import Connect.Connect;
import bean.Student;
import bean.Visit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class VisiterDao {
	public static ObservableList<Visit> getvisiterList(String ID,boolean id,boolean room) throws Exception{
		Connection conn=Connect.Connection();
		ObservableList <Visit> list=FXCollections.observableArrayList();
		try{
			Statement st = conn.createStatement();
			String contion="";
			if(id){
				contion="where id='"+ID+"'";
			}
			else if(room){				
				contion="where RoomID='"+ID+"'";
			}
			else{
				contion="";
			}
			String sql="select * from Visit "+contion;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Visit s=new Visit();
				s.setId(rs.getString("id"));
				s.setCome(rs.getString("come"));
				s.setLeave(rs.getString("leave"));
				s.setRoomID(rs.getString("RoomID"));
				s.setVisitedname(rs.getString("visitedname"));
				s.setVisitername(rs.getString("visitername"));
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
	public static Visit insertvisiter(Visit p) throws Exception{
		Connection conn=Connect.Connection();
		try{
			String sql="INSERT INTO Visit(id,visitername,visitedname,RoomID," +
					"leave,come) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);  
			ps.setString(1,p.getId());
			ps.setString(2, p.getVisitername());
			ps.setString(3, p.getVisitedname());
			ps.setString(4,p.getRoomID());
			ps.setString(5,p.getLeave());
			ps.setString(6,p.getCome());
			ps.executeUpdate();	
			ps.close();
			return p;
		}
		finally{
			conn.close();
		}		
	}
	//É¾³ý¶ÔÏó
		public static boolean deletevisiter(String id) throws Exception{
			Connection conn = Connect.Connection();
			try{
			String sql = "delete from Visit where id='"+id+"'";
			Statement ps = conn.createStatement();
			boolean b = ps.execute(sql);
			ps.close();
			return b;
			}
			finally{
				conn.close();
			}	
		}

}
