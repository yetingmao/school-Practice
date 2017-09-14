package Visitview;
import bean.Visit;
import dao.VisiterDao;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
public class addVisit extends Stage {
	private	TextField visiternametf=new TextField();
	private	TextField idtf=new TextField();
	private	TextField RoomIDtf=new TextField();
	private	TextField cometf=new TextField();
	private	TextField leavetf=new TextField();
	private	TextField visitednametf=new TextField();	
	private	Button b1=new Button("确认添加");
	private Button b2=new Button("取消");
	public addVisit(){
		Group group=new Group();
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,10,10,30));
		pane.setHgap(5);
		pane.setVgap(10);
		Text text=new Text("访问登记信息表");
		text.setFont(Font.font("Rod",FontWeight.BOLD,FontPosture.ITALIC,20));
		pane.add(text, 1, 0);
		pane.add(new Label("姓名"), 0, 4);
		pane.add(visiternametf, 1, 4);
		pane.add(new Label("学号"), 0,3);
		pane.add(idtf, 1, 3);
		pane.add(new Label("访问人"), 0,5);
		pane.add(visitednametf, 1, 5);
		pane.add(new Label("到来时间"), 0, 7);
		pane.add(cometf, 1, 7);
		pane.add(new Label("离开时间"), 0, 6);
		pane.add(leavetf, 1, 6);
		pane.add(new Label("宿舍号"), 0, 8);
		pane.add(RoomIDtf, 1, 8);
		pane.add(b2, 0, 12);
		pane.add(b1, 1, 12);
		//Image image1=new Image("http://swysp.ayit.edu.cn/images/xyfg/1.jpg");
				group.getChildren().add(pane);
				Scene scene=new Scene(group,350,600);
				setTitle("宿舍管理系统");
				setScene(scene);
				show();
				b2.setOnMouseClicked(E->{
					close();
				});
				b1.setOnMouseClicked(e->{
					if (visiternametf.getText().equals(""))
					 {
						Show1();
						return;
					 }
					insertVisiter();
					initTxtField();
				});
			}
		public void insertVisiter() {
			Visit St = new Visit();
			St = makeVisiter();
			if (St != null) {
				try {
					VisiterDao.insertvisiter(St);
					Show2();					
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public Visit makeVisiter(){
			
			String visitername = visiternametf.getText();
			String id= idtf.getText();
			String visitedname = visitednametf.getText();
			String come = cometf.getText();
			String RoomID = RoomIDtf.getText();
			String leave = leavetf.getText();	
			
			Visit St=new Visit();
			
			
			St.setId(id);
			St.setCome(come);
			St.setLeave(leave);
			St.setVisitedname(visitedname);
			St.setVisitername(visitername);
			St.setRoomID(RoomID);
		
			return St;
		}
		
		//清空并初始化文本框
		private void initTxtField()
		{
			
			visiternametf.setText("");
			visitednametf.setText("");
			idtf.setText("");
			leavetf.setText("");
			cometf.setText("");
			RoomIDtf.setText("");

		}
		private void Show1() {
			Stage stage=new Stage();
			setScene(new Scene(new Label("访问人名字不能为空，创建失败!"),200,100));
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


