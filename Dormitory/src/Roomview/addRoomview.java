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

public class addRoomview extends Stage {
		private	TextField RoomIDtf=new TextField();
		private	TextField numbertf=new TextField();
		private	ComboBox gendertf=new ComboBox();
		private	Button b1=new Button("确认添加");
		private Button b2=new Button("取消");
	
	public addRoomview(){
		gendertf.getItems().addAll("男","女");
		gendertf.setValue("男");
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("添加一个宿舍信息表");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("宿舍号"), 0, 4);
		pane.add(RoomIDtf, 1, 4);
		pane.add(new Label("房间人数"), 0,5);
		pane.add(numbertf, 1, 5);
		pane.add(new Label("性别"), 0, 6);
		pane.add(gendertf, 1, 6);
		pane.add(b2, 0, 10);
		pane.add(b1, 1, 10);
		Image image1=new Image("http://swysp.ayit.edu.cn/images/xyfg/1.jpg");
		group.getChildren().add(pane);
		Scene scene=new Scene(group,350,500);
		setTitle("宿舍管理系统");
		setScene(scene);
		show();
			b2.setOnMouseClicked(E->{
				close();
			});
			b1.setOnMouseClicked(e->{
				if (RoomIDtf.getText().equals("")){
				Show1();
				return;
				}
				insertRoom();
			});
		}
		public void insertRoom() {
			Room St = new Room();
			St = makeRoom();
			if (St != null) {
				try {
					RoomDao.insertRoom(St);
					Show2();					
				} 
				catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
		public Room makeRoom() {
			String RoomID = RoomIDtf.getText();
			String number = numbertf.getText();
			String gender = gendertf.getValue().toString();
			Room St=new Room();		
			St.setNumber(Integer.valueOf(number));
			St.setRoomID(RoomID);
			St.setGender(gender);
			return St;
		}
		private void initTxtField(){
			RoomIDtf.setText("");
			numbertf.setText("");
		}
		private void Show1() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("宿舍号不能为空，创建失败!"),150,100));
			setTitle("宿舍管理系统");
			show();
		}
		private void Show2() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("   添加成功!"),150,100));
			setTitle("宿舍管理系统");
			show();	
		}
}

		
