package Studentview;
import java.time.LocalDate;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import bean.Student;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.application.*;
import dao.RoomDao;
import dao.StudentDao;
public class addStudentview extends Application{
	private	TextField nametf=new TextField();
	private	TextField idtf=new TextField();
	private	ComboBox gendertf=new ComboBox();
	private	TextField agetf=new TextField();
	private	TextField phonetf=new TextField();
	private	TextField RoomIDtf=new TextField();
	private	TextField addresstf=new TextField();
	private	TextField subjecttf=new TextField();
	//private	TextField movetf=new TextField();
	//private	TextField arrivaltf=new TextField();
	private	Button b1=new Button("确认添加");
	private Button b2=new Button("取消");
	final DatePicker arrivaltf=new DatePicker();
	final DatePicker movetf=new DatePicker();
	public void start(Stage primaryStage){
		arrivaltf.setValue(LocalDate.now());
		arrivaltf.setShowWeekNumbers(true);
		movetf.setValue(LocalDate.now());
		movetf.setShowWeekNumbers(true);
		gendertf.getItems().addAll("男","女");
		gendertf.setValue("男");
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("添加一个学生信息表");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("姓名"), 0, 4);
		pane.add(nametf, 1, 4);
		pane.add(new Label("学号"), 0,3);
		pane.add(idtf, 1, 3);
		pane.add(new Label("性别"), 0,5);
		pane.add(gendertf, 1, 5);
		pane.add(new Label("年龄"), 0, 7);
		pane.add(agetf, 1, 7);
		pane.add(new Label("电话"), 0, 6);
		pane.add(phonetf, 1, 6);
		pane.add(new Label("宿舍号"), 0, 8);
		pane.add(RoomIDtf, 1, 8);
		pane.add(new Label("家庭地址"), 0, 9);
		pane.add(addresstf, 1, 9);
		pane.add(new Label("专业"), 0, 10);
		pane.add(subjecttf, 1, 10);
		pane.add(new Label("到校时间"), 0, 11);
		pane.add(arrivaltf, 1, 11);
		pane.add(new Label("离校时间"), 0, 12);
		pane.add(movetf, 1, 12);
		pane.add(b2, 0, 16);
		pane.add(b1, 1, 16);
		//Image image1=new Image("http://swysp.ayit.edu.cn/images/xyfg/1.jpg");
		group.getChildren().add(pane);
		Scene scene=new Scene(group,350,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("宿舍管理系统");
		primaryStage.setScene(scene);
		primaryStage.show();
		b2.setOnMouseClicked(E->{
			primaryStage.close();
		});
		b1.setOnMouseClicked(e->{
			if (nametf.getText().equals(""))
				{Show1();	return;}			
				try {
					String ROOM=RoomIDtf.getText();	
					String gender=gendertf.getValue().toString();
					String id=idtf.getText();
					if(StudentDao.findteacher1(id)){
						if(StudentDao.addroom(ROOM)){	
							if(StudentDao.findStudent(ROOM, gender)){
								insertStudent();
								initTxtField();}
							else
								{Show4();return;}}						 
						else
							{Show5();
							return;}
					}
					else
						{Show3();
						return;}
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
		});
	}
	// 插入学生对象
			public void insertStudent() {
				Student St = new Student();
				St = makeStudent();
				if (St != null) {
					try {
						StudentDao.insertStudent(St);
						Show2();					
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}	
			
		// 根据所填写信息组装成学生对象
		public Student makeStudent() {
			String name = nametf.getText();
			String id= idtf.getText();
			String gender = gendertf.getValue().toString();
			String age = agetf.getText();
			String phone = phonetf.getText();
			String RoomID = RoomIDtf.getText();
			String address = addresstf.getText();
			String subject = subjecttf.getText();
			String arrival = arrivaltf.getValue().toString();
			String move = movetf.getValue().toString();
			
			Student St=new Student();
			
			St.setAddress(address);
			St.setAge(age);
			St.setArrival(arrival);
			St.setGender(gender);
			St.setId(id);
			St.setMove(move);
			St.setName(name);
			St.setPhone(phone);
			St.setRoomID(RoomID);
			St.setSubject(subject);
			return St;
		}
		
		//清空并初始化文本框
		private void initTxtField()
		{
			
			nametf.setText("");
			
			idtf.setText("");
			//gendertf.setText("");
			agetf.setText("");
			phonetf.setText("");
			RoomIDtf.setText("");
			addresstf.setText("");
			subjecttf.setText("");
		}
		private void Show1() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("学生名不能为空，创建失败!"),150,100));
			stage.setTitle("宿舍管理系统");
			stage.show();
		}
		private void Show2() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("   添加成功!"),150,100));
			stage.setTitle("宿舍管理系统");
			stage.show();	
		}
		private void Show3() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  学号重复，请重新输入!"),200,200));
			stage.setTitle("宿舍管理系统");
			stage.show();	
		}
		private void Show4() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  你加入的宿舍性别不对!"),200,200));
			stage.setTitle("宿舍管理系统");
			stage.show();	
		}
		private void Show5() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  你加入的宿舍人数已满\n或者不存在!"),200,200));
			stage.setTitle("宿舍管理系统");
			stage.show();	
		}
}
