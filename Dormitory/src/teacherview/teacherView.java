package teacherview;
import bean.Teacher;
import dao.teacherDao;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class teacherView extends Stage{
	private final TableView<Teacher> table = new TableView(); 
	public teacherView(){
		  TableColumn  userid = new TableColumn("账号");  
	      TableColumn userpassdord = new TableColumn("密码"); 
	      TableColumn  teachername = new TableColumn("教师姓名");  
	      TableColumn phone = new TableColumn("电话号码"); 
	      userid.setCellValueFactory(
	      		   new PropertyValueFactory<Teacher,String>("userid") );
	      userpassdord.setCellValueFactory(
	      		   new PropertyValueFactory<Teacher,String>("userpassword") );
	      teachername.setCellValueFactory(
	         		   new PropertyValueFactory<Teacher,String>("teachername") );
	      phone.setCellValueFactory(
	         		   new PropertyValueFactory<Teacher,String>("phone") );
	         table.getColumns().addAll(userid, userpassdord, teachername, phone);
	 		BorderPane pane=new BorderPane();
	 		Label l=new Label("教师信息");
	 		Button b1=new Button("查看");
	 		VBox v=new VBox(10);
	 		v.setPadding(new Insets(5,10,20,150));
	 		v.getChildren().addAll(l,b1);
	 		pane.setTop(v);
	 		pane.setCenter(table);
	 		Scene scene=new Scene(pane,330,400);
	 		setTitle("宿舍管理系统——查询");
	 		setScene(scene);
	 		show();
	 		b1.setOnAction(E->{
				ObservableList <Teacher> ulist = null;
				
				try{
					ulist=teacherDao.FindTeacherList();
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				table.setItems(ulist);
			});
	}
}
