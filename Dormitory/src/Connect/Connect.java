package Connect;
import java.sql.*;
public class Connect {
	public static Connection Connection(){
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=MyData";
		  String userName="sa";
		  String userPwd="123";
		  Connection Conn=null;
		 try
		{
			Class.forName(driverName);
			Conn=DriverManager.getConnection(dbURL,userName,userPwd);
		}
		 catch(Exception e){
			e.printStackTrace();
		 }
		 return Conn;
	}
	/*
	 * 关闭结果集
	 */
	public static void closeResultSet(ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}	
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	/*
	 * 关闭对象
	 */
	public static void closeStatement(PreparedStatement pStmt){
		/*
		 * 如果使用的是statement对象相应参数改为statement；
		 */
		try{
			if(pStmt!=null){
				pStmt.close();
				pStmt=null;
			}
		}catch(SQLException e2){
			e2.printStackTrace();
		}
	}
	/*
	 * 关闭数据库连接
	 */
	public static void closeConnection(Connection conn){
		try{
			if(conn!=null&&(!conn.isClosed())){
				conn.close();
			}
		}catch(SQLException e3){
			e3.printStackTrace();
		}
	}
	public static void main(String []args)
	{
	try{
	Connection conn=Connect.Connection();
	   if (conn!=null)
	   System.out.println("connect the database!");
	   else
	   System.out.println("sorry!");
	   conn.close();
	}catch(Exception e)
	{
	e.printStackTrace();
	}
	}
}
