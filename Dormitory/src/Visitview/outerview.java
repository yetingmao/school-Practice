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
	Button b1=new Button("ѧ�Ų�ѯ");
	Button b2=new Button("���");
	TextField text=new TextField();
	HBox hbox = new HBox(15);
	public outerview(){
		hbox.setPadding(new Insets(5,10,20,100));
		hbox.getChildren().addAll(text,b1);
		TableColumn  id = new TableColumn("ѧ��"); 
		TableColumn name = new TableColumn("����"); 
	    TableColumn RoomID=new TableColumn("�����");
	    TableColumn phone=new TableColumn("�绰");  
	    TableColumn subject=new TableColumn("רҵ");
	    TableColumn arrival=new TableColumn("������ʱ��");
	    TableColumn move=new TableColumn("������ʱ��");
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
		    vbox1.getChildren().addAll(b2,new Label("���ѧ����Ϣ"),table);
			BorderPane pane=new BorderPane();
			pane.setTop(hbox);
			pane.setCenter(vbox1);
			Scene scene=new Scene(pane,490,550);
			setTitle("�������ϵͳ������ѯ");
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
		setScene(new Scene(new Label("û�����ѧ����ѯʧ��!"),150,100));
		setTitle("�������ϵͳ");
		show();
	}
}
