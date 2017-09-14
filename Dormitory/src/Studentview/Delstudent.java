//bukeyong

package Studentview;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import bean.Student;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import dao.StudentDao;
public class Delstudent extends Application{
	private	TextField idtf=new TextField();
	private	Button b1=new Button("确认删除");
	private Button b2=new Button("取消");
	
	public void start(Stage primaryStage) {
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("删除一个学生信息");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		Text text1=new Text("删除学生的学号");
		text1.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,10));
		pane.add(text, 1, 0);
		pane.add(text1, 0, 4);
		pane.add(idtf, 1, 4);
		pane.add(b2, 0, 10);
		pane.add(b1, 1, 10);
		group.getChildren().add(pane);
		Scene scene=new Scene(group,300,300);
		Stage stage=new Stage( );
		stage.setTitle("宿舍管理系统");
		stage.setScene(scene);
		stage.show();
		b2.setOnMouseClicked(E->{
			primaryStage.close();
		});
		b1.setOnMouseClicked(e->{
			if (idtf.getText().equals(""))
			 {
				Show1();
				return;
			 }
			delStudent() ;
			
			});
	
	}
	public void delStudent() {
		String id= idtf.getText();
		if (id != null) {
			try {
				StudentDao.deleteStudent(id);
				Show2();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void Show1() {
		Stage stage=new Stage();
		stage.setScene(new Scene(new Label("学号不能为空，删除失败!"),150,100));
		stage.setTitle("宿舍管理系统");
		stage.show();
	}
	private void Show2() {
		Stage stage=new Stage();
		stage.setScene(new Scene(new Label("   删除成功!"),150,100));
		stage.setTitle("宿舍管理系统");
		stage.show();	
	}
}
