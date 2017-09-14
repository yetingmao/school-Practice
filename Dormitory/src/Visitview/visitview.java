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
	Button b1=new Button("��ѯ");
	CheckBox c1=new CheckBox("֤����");
	CheckBox c2=new CheckBox("�����");
	HBox hbox = new HBox(15);
	TextField text=new TextField();
	Button b2=new Button("���");
	public visitview(){
		hbox.setPadding(new Insets(5,10,20,100));
		hbox.getChildren().addAll(text,b1,c1,c2);
		  TableColumn  id = new TableColumn("���֤��");  
	      TableColumn visitername = new TableColumn("����");
	      TableColumn visitedname = new TableColumn("����������"); 
	      TableColumn RoomID=new TableColumn("�����"); 
	      TableColumn come=new TableColumn("����ʱ��");
	      TableColumn leave=new TableColumn("�뿪ʱ��");
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
		    vbox1.getChildren().addAll(b2,new Label("������Ϣ"),table);
			BorderPane pane=new BorderPane();
			pane.setTop(hbox);
			pane.setCenter(vbox1);
			Scene scene=new Scene(pane,500,500);
			setTitle("�������ϵͳ������ѯ");
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
		setScene(new Scene(new Label("û��������ʣ���ѯʧ��!"),150,100));
		setTitle("�������ϵͳ");
		show();
	}

}
