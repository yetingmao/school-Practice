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
	private	Button b1=new Button("ȷ��ɾ��");
	private Button b2=new Button("ȡ��");
	public delroom(){
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("ɾ��һ��������Ϣ");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		Text text1=new Text("ɾ������ĺ���");
		text1.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,15));
		pane.add(text, 1, 0);
		pane.add(text1, 0, 4);
		pane.add(RoomIDtf, 1, 4);
		pane.add(b2, 0, 10);
		pane.add(b1, 1, 10);
		group.getChildren().add(pane);
		Scene scene=new Scene(group,350,400);
		setTitle("�������ϵͳ");
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
				setScene(new Scene(new Label("����Ų���Ϊ�գ�ɾ��ʧ��!"),150,100));
				setTitle("�������ϵͳ");
				show();
			}
			private void Show2() {
				Stage stage=new Stage();
				setScene(new Scene(new Label("   ɾ���ɹ�!"),150,100));
				setTitle("�������ϵͳ");
				show();			
			}
			private void Show3() {
				Stage stage=new Stage();
				setScene(new Scene(new Label("û���������!"),150,100));
				setTitle("�������ϵͳ");
				show();
			}

}
