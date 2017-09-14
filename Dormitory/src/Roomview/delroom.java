package Roomview;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import bean.Room;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import dao.RoomDao;
public class delroom extends Stage{
	private	TextField RoomIDtf=new TextField();
	private	Button b1=new Button("确认删除");
	private Button b2=new Button("取消");
	public delroom(){
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("删除一个宿舍信息");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		Text text1=new Text("删除宿舍的号码");
		text1.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,15));
		pane.add(text, 1, 0);
		pane.add(text1, 0, 4);
		pane.add(RoomIDtf, 1, 4);
		pane.add(b2, 0, 10);
		pane.add(b1, 1, 10);
		group.getChildren().add(pane);
		Scene scene=new Scene(group,350,400);
		setTitle("宿舍管理系统");
		setScene(scene);
		show();
		b2.setOnMouseClicked(E->{
			close();
		});
		b1.setOnAction(e->{
				if (RoomIDtf.getText().equals(""))
				 {
					Show1();
					return;
				 }
				delRoom() ;
		});
	}
		public void delRoom(){
			String s=RoomIDtf.getText();
			if(s!=null){
				try{
					RoomDao.deleteRoom(s);
					Show2();
				}
				catch(Exception e){
					e.printStackTrace();
					Show3();
			}
		}
	}
			private void Show1() {
				Stage stage=new Stage();
				setScene(new Scene(new Label("宿舍号不能为空，删除失败!"),150,100));
				setTitle("宿舍管理系统");
				show();
			}
			private void Show2() {
				Stage stage=new Stage();
				setScene(new Scene(new Label("   删除成功!"),150,100));
				setTitle("宿舍管理系统");
				show();			
			}
			private void Show3() {
				Stage stage=new Stage();
				setScene(new Scene(new Label("没有这个宿舍!"),150,100));
				setTitle("宿舍管理系统");
				show();
			}

}
