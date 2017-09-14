package view;
import java.util.ArrayList;
import Studentview.Delstudent;
import Studentview.addStudentview;
import bean.Student;
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
import dao.StudentDao;
public class FindInformation extends Stage{
	static int i = 0;
	private final TableView<Student> table = new TableView(); 
	Button b1=new Button("��ѯ");
	HBox hbox = new HBox(15);
	TextField text=new TextField();
	CheckBox c1=new CheckBox("ѧ��");
	CheckBox c2=new CheckBox("����");
	Button b2=new Button("���");
	Button b3=new Button("ɾ��");
	public FindInformation(){
		hbox.setPadding(new Insets(5,10,20,183));
		hbox.getChildren().addAll(text,b1,c1,c2);	
      TableColumn  id = new TableColumn("ѧ��");  
      TableColumn name = new TableColumn("����");  
      TableColumn gender = new TableColumn("�Ա�");  
      TableColumn RoomID=new TableColumn("�����");
      TableColumn age=new TableColumn("����");
      TableColumn phone=new TableColumn("�绰");
      TableColumn address = new TableColumn("��ͥסַ");  
      TableColumn subject=new TableColumn("רҵ");
      TableColumn arrival=new TableColumn("��Уʱ��");
      TableColumn move=new TableColumn("��Уʱ��");
      id.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("id") );
       name.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("name") );
       gender.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("gender") );
       RoomID.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("RoomID") );
       age.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("age") );
       phone.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("phone") );
       address.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("address") );
       subject.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("subject") );
       arrival.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("arrival") );
       move.setCellValueFactory(
    		   new PropertyValueFactory<Student,String>("move") );
    
		table.getColumns().addAll(id,name,gender,RoomID,age,phone,subject,address,arrival,move);
		VBox vbox1=new VBox(); 
	    vbox1.setSpacing(10);  
	    if(i == 1){
	    	vbox1.getChildren().addAll(b2,new Label("ѧ����Ϣ"),table);
	    }	
	    else if(i == 2){
	    	vbox1.getChildren().addAll(b3,new Label("ѧ����Ϣ"),table);
	    }
	    else 
	    	vbox1.getChildren().addAll(new Label("ѧ����Ϣ"),table);
		BorderPane pane=new BorderPane();
		pane.setTop(hbox);
		pane.setCenter(vbox1);
		Scene scene=new Scene(pane,730,550);
		setTitle("�������ϵͳ������ѯ");
		setScene(scene);
		show();
			
			b1.setOnAction(e->{
				ObservableList <Student> ulist = null;
				String id1=new String("");
				String name1=new String("");
				if(c1.isSelected())
					id1=text.getText();
				if(c2.isSelected())
				   name1=text.getText();
				try{
					StudentDao sd = new StudentDao();
					ulist=sd.findStudentList(id1, name1);
				}catch(Exception e3)
				{
					e3.printStackTrace();
					Show1();
				}
				table.setItems(ulist);			
			});
			b2.setOnAction(E->{
				new addStudentview().start(new Stage());
			});
			b3.setOnAction(e->{
				new Delstudent().start(new Stage());;
			});
	}
		private void Show1() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("û�����ѧ����ѯʧ��!"),150,100));
			setTitle("�������ϵͳ");
			show();
		}

}