package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import teacherview.delTeacher;
import javafx.scene.image.*;
import javafx.scene.text.*;
public class systemMaintenance extends Stage{
	public systemMaintenance(){
		//Label lab1=new Label("用户管理");
		//lab1.setFont(Font.font("宋体",FontWeight.BOLD,15));
		Button b1=new Button("删除教师信息");
		//Button b2=new Button("增加管理员信息");
		HBox vbox = new HBox(15);
		vbox.setPadding(new Insets(10,50,20,0));
		vbox.getChildren().addAll(b1);
		Image image1=new Image("image/7.jpg");
		Pane pane=new Pane();
		pane.getChildren().add(new ImageView(image1));
		pane.getChildren().add(vbox);
		Scene scene=new Scene(pane,800,500);
		setTitle("宿舍管理系统");
		setScene(scene);
		show();
		b1.setOnAction(e->{
			new delTeacher();
		});
	}
}

