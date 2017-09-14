package Visitview;
import java.util.ArrayList;
import bean.Visit;
import dao.VisiterDao;
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
public class visitview extends Stage{
	private final TableView<Visit> table = new TableView();
	Button b1=new Button("查询");
	CheckBox c1=new CheckBox("证件号");
	CheckBox c2=new CheckBox("宿舍号");
	HBox hbox = new HBox(15);
	TextField text=new TextField();
	Button b2=new Button("添加");
	public visitview(){
		hbox.setPadding(new Insets(5,10,20,100));
		hbox.getChildren().addAll(text,b1,c1,c2);
		  TableColumn  id = new TableColumn("身份证号");  
	      TableColumn visitername = new TableColumn("姓名");
	      TableColumn visitedname = new TableColumn("访问人名字"); 
	      TableColumn RoomID=new TableColumn("宿舍号"); 
	      TableColumn come=new TableColumn("访问时间");
	      TableColumn leave=new TableColumn("离开时间");
	       id.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("id") );
	       visitername.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("visitername") );
	       visitedname.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("visitedname") );
	       RoomID.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("RoomID") );
	       leave.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("leave") );
	      come.setCellValueFactory(
	    		   new PropertyValueFactory<Visit,String>("come") );
	      table.getColumns().addAll(id,visitername,visitedname,RoomID,leave,come);
	      VBox vbox1=new VBox(); 
		    vbox1.setSpacing(10);  
		    vbox1.getChildren().addAll(b2,new Label("访问信息"),table);
			BorderPane pane=new BorderPane();
			pane.setTop(hbox);
			pane.setCenter(vbox1);
			Scene scene=new Scene(pane,500,500);
			setTitle("宿舍管理系统——查询");
			setScene(scene);
			show();
			b1.setOnAction(e->{
				String ID=text.getText().toString().trim();
				ObservableList <Visit> ulist = null;
							
				try{
					
					VisiterDao v=new VisiterDao();	
					ulist=v.getvisiterList(ID,c1.isSelected(),c2.isSelected());
					table.setItems(ulist);
				}
				catch(Exception e1){
					e1.printStackTrace();
					Show1();
				}
				
			});
			b2.setOnAction(e->{
				new addVisit();
			});	
	}
	private void Show1() {
		Stage stage=new Stage();
		setScene(new Scene(new Label("没有这个访问，查询失败!"),150,100));
		setTitle("宿舍管理系统");
		show();
	}

}
