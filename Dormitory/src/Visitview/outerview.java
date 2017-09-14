package Visitview;
import java.util.ArrayList;
import bean.Outers;
import dao.outerDao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import view.DataInput;
import javafx.scene.text.*;
public class outerview extends Stage{
	private final TableView<Outers> table = new TableView();
	Button b1=new Button("学号查询");
	Button b2=new Button("添加");
	TextField text=new TextField();
	HBox hbox = new HBox(15);
	public outerview(){
		hbox.setPadding(new Insets(5,10,20,100));
		hbox.getChildren().addAll(text,b1);
		TableColumn  id = new TableColumn("学号"); 
		TableColumn name = new TableColumn("姓名"); 
	    TableColumn RoomID=new TableColumn("宿舍号");
	    TableColumn phone=new TableColumn("电话");  
	    TableColumn subject=new TableColumn("专业");
	    TableColumn arrival=new TableColumn("回宿舍时间");
	    TableColumn move=new TableColumn("离宿舍时间");
	      id.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("id") );
	      name.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("name") );

	      RoomID.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("RoomID") );

	      phone.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("phone") );

	      subject.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("subject") );
	      arrival.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("arrival") );
	      move.setCellValueFactory(
	    		   new PropertyValueFactory<Outers,String>("move") );
	    
			table.getColumns().addAll(id,name,RoomID,phone,subject,arrival,move);
			VBox vbox1=new VBox(); 
		    vbox1.setSpacing(10);  
		    vbox1.getChildren().addAll(b2,new Label("外出学生信息"),table);
			BorderPane pane=new BorderPane();
			pane.setTop(hbox);
			pane.setCenter(vbox1);
			Scene scene=new Scene(pane,490,550);
			setTitle("宿舍管理系统——查询");
			setScene(scene);
			show();
			b1.setOnAction(e->{
				ObservableList <Outers> ulist = null;
				String id1=text.getText().toString().trim();
				try{
					ulist=outerDao.getouterList(id1);
					
				}catch(Exception e3)
				{
					e3.printStackTrace();
					Show1();
				}
				table.setItems(ulist);					
			});
			b2.setOnAction(e->{
				new Gooutview();
			});
	}
	private void Show1() {
		Stage stage=new Stage();
		setScene(new Scene(new Label("没有这个学生查询失败!"),150,100));
		setTitle("宿舍管理系统");
		show();
	}
}
