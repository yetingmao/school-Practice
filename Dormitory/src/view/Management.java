package view;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.paint.*;
public class Management extends Stage{
	public Management(int i){
		Pane pane=new Pane();
		Group sumary = new Group();
		ImageView imageview1=new ImageView("image/1.png");
		ImageView imageview2=new ImageView("image/2.png");
		ImageView imageview3=new ImageView("image/3.png");
		PathTransition pt1=new PathTransition(Duration.millis(10000),new Line(0,100,800,100),imageview1);
		if(i>0)
			pane.getChildren().add(imageview1);
		pt1.setCycleCount(Timeline.INDEFINITE);
		pt1.play();
		imageview1.setOnMouseClicked(e->{
		new DataInput().start(new Stage());;
		close();
			});
		imageview1.setOnMouseEntered(e->{
			pt1.pause();
		});
		imageview1.setOnMouseExited(e->{
			pt1.play();
		});
		PathTransition pt2=new PathTransition(Duration.millis(9000),new Line(0,200,800,200),imageview2);
		if(i>=0)
			pane.getChildren().add(imageview2);
		pt2.setCycleCount(Timeline.INDEFINITE);
		pt2.play();
		imageview2.setOnMouseClicked(e->{
			FindInformation FI=new FindInformation();
			close();
			
		});	
		imageview2.setOnMouseEntered(e->{
			pt2.pause();
		});
		imageview2.setOnMouseExited(e->{
			pt2.play();
		});
		PathTransition pt3=new PathTransition(Duration.millis(8000),new Line(0,300,800,300),imageview3);
		if(i>1)
			pane.getChildren().add(imageview3);
		pt3.setCycleCount(Timeline.INDEFINITE);
		pt3.play();
		imageview3.setOnMouseClicked(e->{
			systemMaintenance sM=new systemMaintenance();
			close();		
		});	
		imageview3.setOnMouseEntered(e->{
			pt3.pause();
		});
		imageview3.setOnMouseExited(e->{
			pt3.play();
		});
		DormintorySystem D=new DormintorySystem();
		Image image1=new Image("image/10.jpg");
		sumary.getChildren().add(new ImageView(image1));
		sumary.getChildren().add(pane);
		Scene scene=new Scene(sumary,800,500);
		setTitle("宿舍管理系统");
		setScene(scene);
		show();
	}
}
