package view;
import Studentview.Delstudent;
import Studentview.addStudentview;
import Visitview.Gooutview;
import Visitview.addVisit;
import Visitview.outerview;
import Visitview.visitview;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import teacherview.teacherView;
import javafx.scene.image.*;
import javafx.scene.text.*;
import Roomview.addRoomview;
import Roomview.room;
import Roomview.roomview;

public class DataInput extends Application{
	    int i;
		public void start(Stage primaryStage){
		MenuBar menuBar=new MenuBar();
		Menu menuFile=new Menu("ѧ����Ϣ����");
		MenuItem add1=new MenuItem("����ѧ����Ϣ");
		MenuItem add2=new MenuItem("ɾ��ѧ����Ϣ");
		menuFile.getItems().addAll(add1,add2);
		Menu menuFile1=new Menu("������Ϣ����");
		MenuItem add3=new MenuItem("����������Ϣ");
		MenuItem add8=new MenuItem("ɾ��������Ϣ");
		//MenuItem add9=new MenuItem("�п�������Ϣ");
		MenuItem add10=new MenuItem("ȫ��������Ϣ");
		menuFile1.getItems().addAll(add3,add8,add10);
		Menu menuFile2=new Menu("����Ǽǹ���");
		MenuItem add4=new MenuItem("���ʵǼ���Ϣ");
		MenuItem add5=new MenuItem("����Ǽ���Ϣ");
		menuFile2.getItems().addAll(add4,add5);
		Menu menuFile3=new Menu("����Ա��Ϣ����");
		MenuItem add6=new MenuItem("�������Ա��Ϣ");
		menuFile3.getItems().addAll(add6);
		Menu menuFile4=new Menu("�˳�ϵͳ");
		MenuItem add7=new MenuItem("�ر�ϵͳ");
		menuFile4.getItems().add(add7);
		
		add1.setOnAction(e->{
			FindInformation.i = 1;
			new FindInformation();
		});	
		add2.setOnAction(e->{
			FindInformation.i = 2;
			new FindInformation();				
		});
		add3.setOnAction(e->{
			
			 new roomview(1);
		});
		add8.setOnAction(e->{
			 new roomview(2);
		});
	   add4.setOnAction(e->{
		   new visitview();
	   });
	   add5.setOnAction(e->{		  
		   new outerview();
	   });
		add6.setOnAction(e->{;
			new teacherView();
		});
		add7.setOnAction(e->{
			primaryStage.close();
		});
		//add9.setOnAction(e->{
		//	new roomview(3);
		//});
		add10.setOnAction(e->{
			try {
				new room();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	
		menuBar.getMenus().addAll(menuFile,menuFile1,menuFile2,menuFile3,menuFile4);
		menuBar.setStyle("-fx-background-color: #B9D3EE");
		VBox vbox = new VBox(15);
		vbox.setPadding(new Insets(10,50,20,0));
		vbox.getChildren().addAll(menuBar);
		Image image1=new Image("image/8.jpg");
		Pane pane=new Pane();
		pane.getChildren().add(new ImageView(image1));
		pane.getChildren().add(vbox);
		Scene scene=new Scene(pane,800,500);
		primaryStage.setTitle("�������ϵͳ��������¼��");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
