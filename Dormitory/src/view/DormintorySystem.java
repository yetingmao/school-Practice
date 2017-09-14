package view;
import dao.StudentDao;
import dao.UserDao;
import dao.teacherDao;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import teacherview.addTeacher;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
public class DormintorySystem extends Application{
	public static void main(String[] args){
		Application.launch(args);
	}
	public void start(Stage primaryStage){		
		GridPane pane=new GridPane();
		pane.setPadding(new Insets(10,10,20,50));
		pane.setHgap(10);
		pane.setVgap(10);
		Group sumary = new Group();
		Image image1=new Image("image/4.jpg");		
		Image image2=new Image("image/5.jpg");
		Text text=new Text("宿舍管理系统");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,25));
		ImageView imageview=new ImageView(image2);
		ImageView imageview1=new ImageView(image1);
		imageview.setFitHeight(50);//设置图片的高
		imageview.setFitWidth(50);//设置图片的宽
		imageview1.setFitHeight(260);//设置图片的高
		imageview1.setFitWidth(350);
		Label label1=new Label("账号");
		Label label2=new Label("密码");
		TextField zh=new TextField();
		PasswordField mm=new PasswordField();
		RadioButton r1=new RadioButton("教师");
		RadioButton r2=new RadioButton("管理员");
		RadioButton r3=new RadioButton("学生");
		ToggleGroup t=new ToggleGroup();
		r1.setToggleGroup(t);
		r2.setToggleGroup(t);
		r3.setToggleGroup(t);
		Button DL=new Button("登录");
		Button ZC=new Button("注册");
		pane.add(imageview1, 0, 0);
		pane.add(text, 1, 0);
		pane.add(label1, 0,2);
		pane.add(zh, 1,2);
		pane.add(label2, 0, 4);
		pane.add(mm, 1, 4);
		pane.add(r1,1, 5);
		pane.add(r2,1, 6);
		pane.add(r3,1, 7);
		pane.add(ZC, 1, 8);
		pane.add(DL, 1, 8);
		pane.setHalignment(ZC,HPos.LEFT);
		pane.setHalignment(DL, HPos.RIGHT);	
		ZC.setOnAction(e->{
			new addTeacher();
		});
		DL.setAlignment(Pos.BASELINE_RIGHT);
		DL.setOnAction(e->{
			if(r1.isSelected()){
				boolean canLogin;	
				String id=zh.getText();
				String pass=mm.getText();
				try{
					canLogin=teacherDao.findteacher(id, pass);
					if (canLogin==true)  //能够登录信息
					{
						new Management(1);	
						primaryStage.close();
					}
					else
						show();					
				}
				catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
			else if(r2.isSelected()){
				boolean canLogin;	
				String id=zh.getText();
				String pass=mm.getText();
				try{
					canLogin=UserDao.findUsers(id, pass);
					if(canLogin==true){
						new Management(2);
						primaryStage.close();
						}
					else
						show();
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
			}
			else if(r3.isSelected()){
				boolean canLogin;	
				String id=zh.getText();
				String pass=mm.getText();
				try{
					canLogin=StudentDao.findteacher(id,pass);
					if(canLogin==true){
						new Management(0);
						primaryStage.close();
						}
					else
						show();
				}
				catch(Exception e3){
					e3.printStackTrace();				
				}
			}
			else 
				show1();
		});
		sumary.getChildren().add(imageview1);
		sumary.getChildren().add(pane);
		Scene scene=new Scene(sumary,350,260);
		primaryStage.setTitle("宿舍管理系统——登陆");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	public  void show(){
		Stage stage=new Stage();
		stage.setScene(new Scene(new Label("  账号或密码不正确，请重新输入!"),200,120));
		stage.show();
	}
	public  void show1(){
		Stage stage=new Stage();
		stage.setScene(new Scene(new Label("      请先选择用户!"),200,120));
		stage.show();
	}

}
