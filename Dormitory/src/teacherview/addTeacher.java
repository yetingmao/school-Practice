package teacherview;
import bean.Room;
import bean.Teacher;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import dao.RoomDao;
import dao.StudentDao;
import dao.teacherDao;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
public class addTeacher extends Stage{
	private	TextField useridtf=new TextField();
	private	TextField userpasswordtf=new TextField();
	private	TextField Teachernametf=new TextField();
	private	TextField phonetf=new TextField();
	private	Button b1=new Button("确认添加");
	private Button b2=new Button("取消");
	public addTeacher(){
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("添加一个信息表");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("账号"), 0, 4);
		pane.add(useridtf, 1, 4);
		pane.add(new Label("密码"), 0,5);
		pane.add(userpasswordtf, 1, 5);
		pane.add(new Label("姓名"), 0, 6);
		pane.add(Teachernametf, 1, 6);
		pane.add(new Label("电话"), 0,7);
		pane.add(phonetf, 1, 7);
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
				if (useridtf.getText().equals("")){
				Show1();
				return;
				}
				insertTeacher();
			});
		}
		public void insertTeacher() {
			Teacher St = new Teacher();
			St = makeTeacher();
			if (St != null) {
				try {
					teacherDao.insertTeacher(St);
					Show2();					
				} 
				catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
		public Teacher makeTeacher() {
			String userid = useridtf.getText();
			String userpassword = userpasswordtf.getText();	
			String Teachername = Teachernametf.getText();
			String phone = phonetf.getText();
			Teacher St=new Teacher();		
			St.setPhone(phone);
			St.setTeachername(Teachername);
			St.setUserid(userid);
			St.setUserpassword(userpassword);
			return St;
		}
		private void initTxtField(){
			useridtf.setText("");
			userpasswordtf.setText("");
			Teachernametf.setText("");
			phonetf.setText(null);
		}
		private void Show1() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("账号号不能为空，创建失败!"),150,100));
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
