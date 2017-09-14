package Visitview;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import bean.Outers;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import dao.outerDao;
public class Gooutview extends Stage{
	private	TextField nametf=new TextField();
	private	TextField idtf=new TextField();
	private	TextField phonetf=new TextField();
	private	TextField RoomIDtf=new TextField();
	private	TextField movetf=new TextField();
	private	TextField arrivaltf=new TextField();
	private TextField subjecttf=new TextField();
	private	Button b1=new Button("确认添加");
	private Button b2=new Button("取消");
	public Gooutview(){
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("学生外出登记表");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("姓名"), 0, 4);
		pane.add(nametf, 1, 4);
		pane.add(new Label("证件号"), 0,3);
		pane.add(idtf, 1, 3);
		pane.add(new Label("电话"), 0, 6);
		pane.add(phonetf, 1, 6);
		pane.add(new Label("宿舍号"), 0, 8);
		pane.add(RoomIDtf, 1, 8);
		pane.add(new Label("专业"),0, 9);
		pane.add(subjecttf, 1, 9);
		pane.add(new Label("回宿舍时间"), 0, 11);
		pane.add(arrivaltf, 1, 11);
		pane.add(new Label("离宿舍时间"), 0, 12);
		pane.add(movetf, 1, 12);
		pane.add(b2, 0, 16);
		pane.add(b1, 1, 16);
		Image image1=new Image("http://swysp.ayit.edu.cn/images/xyfg/1.jpg");
				group.getChildren().add(pane);
				Scene scene=new Scene(group,350,600);
				setTitle("宿舍管理系统");
				setScene(scene);
				show();
				b2.setOnMouseClicked(E->{
					close();
				});
				b1.setOnMouseClicked(e->{
					if (nametf.getText().equals(""))
					 {
						Show1();
						return;
					 }
					insertStudent();
					initTxtField();
				});
			}
			public void insertStudent() {
				Outers St = new Outers();
				St = makeStudent();
				if (St != null) {
					try {
						outerDao.insertStudent(St);
						Show2();					
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}	
			
		// 根据所填写信息组装成学生对象
		public Outers makeStudent() {
			String name = nametf.getText();
			String id= idtf.getText();
			String phone = phonetf.getText();
			String RoomID = RoomIDtf.getText();
			String arrival = arrivaltf.getText();
			String move = movetf.getText();	
			String subject=subjecttf.getText();
			Outers St=new Outers();
				
			St.setArrival(arrival);	
			St.setId(id);
			St.setMove(move);
			St.setSubject(subject);
			St.setName(name);
			St.setPhone(phone);
			St.setRoomID(RoomID);
			return St;
		}
		
		//清空并初始化文本框
		private void initTxtField()
		{
			nametf.setText("");
			arrivaltf.setText("");
			idtf.setText("");
			phonetf.setText("");
			RoomIDtf.setText("");
			movetf.setText("");
			subjecttf.setText("");
		}
		private void Show1() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("学生名不能为空，创建失败!"),150,100));
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
