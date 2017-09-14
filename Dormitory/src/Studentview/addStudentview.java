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
	private	Button b1=new Button("ȷ�����");
	private Button b2=new Button("ȡ��");
	final DatePicker arrivaltf=new DatePicker();
	final DatePicker movetf=new DatePicker();
	public void start(Stage primaryStage){
		arrivaltf.setValue(LocalDate.now());
		arrivaltf.setShowWeekNumbers(true);
		movetf.setValue(LocalDate.now());
		movetf.setShowWeekNumbers(true);
		gendertf.getItems().addAll("��","Ů");
		gendertf.setValue("��");
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("���һ��ѧ����Ϣ��");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("����"), 0, 4);
		pane.add(nametf, 1, 4);
		pane.add(new Label("ѧ��"), 0,3);
		pane.add(idtf, 1, 3);
		pane.add(new Label("�Ա�"), 0,5);
		pane.add(gendertf, 1, 5);
		pane.add(new Label("����"), 0, 7);
		pane.add(agetf, 1, 7);
		pane.add(new Label("�绰"), 0, 6);
		pane.add(phonetf, 1, 6);
		pane.add(new Label("�����"), 0, 8);
		pane.add(RoomIDtf, 1, 8);
		pane.add(new Label("��ͥ��ַ"), 0, 9);
		pane.add(addresstf, 1, 9);
		pane.add(new Label("רҵ"), 0, 10);
		pane.add(subjecttf, 1, 10);
		pane.add(new Label("��Уʱ��"), 0, 11);
		pane.add(arrivaltf, 1, 11);
		pane.add(new Label("��Уʱ��"), 0, 12);
		pane.add(movetf, 1, 12);
		pane.add(b2, 0, 16);
		pane.add(b1, 1, 16);
		//Image image1=new Image("http://swysp.ayit.edu.cn/images/xyfg/1.jpg");
		group.getChildren().add(pane);
		Scene scene=new Scene(group,350,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("�������ϵͳ");
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
	// ����ѧ������
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
			
		// ��������д��Ϣ��װ��ѧ������
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
		
		//��ղ���ʼ���ı���
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
			stage.setScene(new Scene(new Label("ѧ��������Ϊ�գ�����ʧ��!"),150,100));
			stage.setTitle("�������ϵͳ");
			stage.show();
		}
		private void Show2() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("   ��ӳɹ�!"),150,100));
			stage.setTitle("�������ϵͳ");
			stage.show();	
		}
		private void Show3() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  ѧ���ظ�������������!"),200,200));
			stage.setTitle("�������ϵͳ");
			stage.show();	
		}
		private void Show4() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  �����������Ա𲻶�!"),200,200));
			stage.setTitle("�������ϵͳ");
			stage.show();	
		}
		private void Show5() {
			Stage stage=new Stage();
			stage.setScene(new Scene(new Label("  ������������������\n���߲�����!"),200,200));
			stage.setTitle("�������ϵͳ");
			stage.show();	
		}
}
