package Roomview;
import bean.Room;
import dao.RoomDao;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class room extends Stage{
	private final TableView<Room> table = new TableView(); 
	private TextField text=new TextField();
	public room() {
		  TableColumn  userid = new TableColumn("寝室号");  
	      TableColumn userpassdord = new TableColumn("性别"); 
	      TableColumn  teachername = new TableColumn("可住人数");  
	      TableColumn  teachername1 = new TableColumn("现有人数"); 
	      userid.setCellValueFactory(
	      		   new PropertyValueFactory<Room,String>("RoomID") );
	      userpassdord.setCellValueFactory(
	      		   new PropertyValueFactory<Room,String>("gender") );
	      teachername.setCellValueFactory(
	         		   new PropertyValueFactory<Room,String>("number") );
	         table.getColumns().addAll(userid, userpassdord, teachername);
	 		BorderPane pane=new BorderPane();
	 		Label l=new Label("寝室信息");
	 		Button b1=new Button("查看");
	 		HBox h=new HBox(5);
	 		h.setPadding(new Insets(5,10,20,5));
	 		h.getChildren().addAll(text,b1);
	 		VBox v=new VBox(10);
	 		v.setPadding(new Insets(5,10,20,80));
	 		v.getChildren().addAll(l,h);
	 		pane.setTop(v);
	 		pane.setCenter(table);
	 		Scene scene=new Scene(pane,330,400);
	 		setTitle("宿舍管理系统——查询");
	 		setScene(scene);
	 		show();
	 		b1.setOnAction(E->{
				ObservableList <Room> ulist = null;
				String s=text.getText();
				try{
					ulist=RoomDao.FindRoomList(s);
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
				table.setItems(ulist);
			});
	}
}