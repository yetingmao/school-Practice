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
		Menu menuFile=new Menu("学生信息管理");
		MenuItem add1=new MenuItem("增加学生信息");
		MenuItem add2=new MenuItem("删除学生信息");
		menuFile.getItems().addAll(add1,add2);
		Menu menuFile1=new Menu("宿舍信息管理");
		MenuItem add3=new MenuItem("增加宿舍信息");
		MenuItem add8=new MenuItem("删除宿舍信息");
		//MenuItem add9=new MenuItem("有空寝室信息");
		MenuItem add10=new MenuItem("全部宿舍信息");
		menuFile1.getItems().addAll(add3,add8,add10);
		Menu menuFile2=new Menu("出入登记管理");
		MenuItem add4=new MenuItem("访问登记信息");
		MenuItem add5=new MenuItem("外出登记信息");
		menuFile2.getItems().addAll(add4,add5);
		Menu menuFile3=new Menu("管理员信息管理");
		MenuItem add6=new MenuItem("管理管理员信息");
		menuFile3.getItems().addAll(add6);
		Menu menuFile4=new Menu("退出系统");
		MenuItem add7=new MenuItem("关闭系统");
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
		primaryStage.setTitle("宿舍管理系统——数据录入");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
