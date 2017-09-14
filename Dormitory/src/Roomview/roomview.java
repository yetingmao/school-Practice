package Roomview;
import java.util.ArrayList;
import Studentview.Delstudent;
import Studentview.addStudentview;
import bean.Room;
import bean.Student;
import dao.RoomDao;
import dao.StudentDao;
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
import javafx.scene.text.*;
public class roomview extends Stage{
	private Label label=new Label("�����");
	private final TableView<Student> table = new TableView(); 
	private final TableView<Room> table1 = new TableView(); 
	Button b1=new Button("��ѯ");
	HBox hbox = new HBox(15);
	TextField text=new TextField();
	Button b2=new Button("���");
	Button b3=new Button("ɾ��");
	Button b4=new Button("�п�������Ϣ");
	Button b5=new Button("��ѯ");
	public roomview(int i){
		hbox.setPadding(new Insets(5,10,20,40));
		hbox.getChildren().addAll(label,text);
		 TableColumn  id = new TableColumn("ѧ��");  
	      TableColumn name = new TableColumn("����");  
	      TableColumn gender = new TableColumn("�Ա�");  
	      TableColumn RoomID=new TableColumn("�����");
	      TableColumn RoomID1=new TableColumn("�����");
	      TableColumn number=new TableColumn("����");
	      TableColumn gender1=new TableColumn("�Ա�");
	      id.setCellValueFactory(
	    		   new PropertyValueFactory<Student,String>("id") );
	       name.setCellValueFactory(
	    		   new PropertyValueFactory<Student,String>("name") );
	       gender.setCellValueFactory(
	    		   new PropertyValueFactory<Student,String>("gender") );
	       RoomID.setCellValueFactory(
	    		   new PropertyValueFactory<Student,String>("RoomID") );
	       number.setCellValueFactory(
	    		   new PropertyValueFactory<Room,String>("number") );
	       RoomID1.setCellValueFactory(
	    		   new PropertyValueFactory<Room,String>("RoomID") );
	       gender1.setCellValueFactory(
	    		   new PropertyValueFactory<Room,String>("gender") );
      table.getColumns().addAll(RoomID,id,name,gender);
      table1.getColumns().addAll(RoomID1, gender1, number);
      VBox vbox1=new VBox(); 
	    vbox1.setSpacing(10);  
	    if(i==1)
	    	vbox1.getChildren().addAll(b1,b2,new Label("������Ϣ"),table);
	    else if(i==2)
	    	vbox1.getChildren().addAll(b1,b3,new Label("������Ϣ"),table);
	    else if(i==3)
	    	vbox1.getChildren().addAll(b5,b4,new Label("������Ϣ"),table1,table);	
	    //table.setVisible(false);
		BorderPane pane=new BorderPane();
		pane.setTop(hbox);
		pane.setCenter(vbox1);
		Scene scene=new Scene(pane,400,400);
		setTitle("�������ϵͳ������ѯ");
		setScene(scene);
		show();
		b1.setOnAction(E->{
			ObservableList <Student> ulist = null;
			String s=text.getText();
			try{
				ulist=StudentDao.findroom(s);
			}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
			table.setItems(ulist);
		});
		b2.setOnAction(e->{
			new addRoomview();
		});
		b3.setOnAction(e->{
			new delroom();
		});
		b4.setOnAction(e->{
			table1.setVisible(true);
			table.setVisible(false);
			ObservableList <Room> ulist = null;
			String s=text.getText();
			try{
				ulist=RoomDao.FindRoom();
			}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
			table1.setItems(ulist);
		});
		b5.setOnAction(E->{
			table.setVisible(true);
			table1.setVisible(false);
			ObservableList <Student> ulist = null;
			String s=text.getText();
			try{
				ulist=StudentDao.findroom(s);
			}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
			table.setItems(ulist);
		});
	}
}
