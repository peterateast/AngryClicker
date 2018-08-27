

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.*;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ArrayList;

import javafx.scene.media.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Tetris2 extends Application {
	
	private final int WIDTH = 1920;
	private final int HEIGHT = 1000;
	private static boolean timing = false;
	private static int timeCounter = 0;
	private static boolean gameLoss = false;
	
	private static Integer lives = 3;
	private static Integer startTime = 30;
	private static Integer seconds = startTime;
	private static Integer enemies=20;
	private static boolean zclicked = false;
	private static boolean lclicked = false;
	private static boolean sclicked = false;
	private static boolean tclicked = false;
	private static boolean iclicked = false;

	private static boolean ea = false;
	private static boolean no = false;
	private static boolean ha = false;
	private static boolean im = false;
	
	private static int count1 = 0;
	private static int count2 = 17;
	Label healthbars[];

	
	/*BorderPane has 5 regions:
	 * Top, Center, Left, Right, Bottom
	 * Menu should be in Center
	
	 *Stackpanes for different scenes and stages
	 */
	
	BorderPane bp = new BorderPane();
	StackPane sp = new StackPane();
	StackPane sp2 = new StackPane();
	StackPane g = new StackPane();
	StackPane g2 = new StackPane();
	StackPane g3 = new StackPane();
	StackPane diff = new StackPane();
	StackPane v1 = new StackPane();
	StackPane v2 = new StackPane();
	StackPane loss = new StackPane();
	StackPane loss2 = new StackPane();
 	StackPane in2 = new StackPane();
 	StackPane v3 = new StackPane();
	
	
	//main menu buttons,
	Button Start = new Button("Start");
	Button Instructions = new Button("Instructions");
	Button Mute = new Button("Tetris Music?");
	Button Exit = new Button("Quit");
//	Button Options = new Button("Options");
	
	//Instructions page 1 menu
	Button Back = new Button("Back");
	Button Next = new Button("Next");
	
	//Instructions page 2 menu
	Button Back2 = new Button("Back");
	Button Start2= new Button("Start");
	
	//Difficulty Buttons
	Button easy = new Button("Easy");
	Button normal = new Button("Normal");
	Button hard = new Button("Hard");
	Button impossible = new Button("Impossible?");
	
	//Game Over Buttons
	Button retry = new Button("Restart");
	Button quit = new Button("Quit");
	
	Button retry2 = new Button("Retry this Level");
	Button quit2 = new Button("Quit");
	
	Button restart = new Button("Replay!");
	Button quitf = new Button("Quit");

	
	//winscreen buttons
	Button cont = new Button("Continue");
	Button nextL = new Button("Next Level");
	Button end = new Button("CLICK TO FIND YOUR DESTINY!");
	//labels for level 1
	Label timer = new Label("");
	Label lives1 = new Label("Lives Left: _");
	Label points = new Label("Enemies Left Until Next Level: "+enemies.toString());
	//enemies for level 1
	Label square = new Label("");
	Label iblock = new Label("");
	Label t = new Label("");
	Label l = new Label("");
	Label z = new Label("");
	//label level 2
	Label timer2 = new Label("");
	Label lives2 = new Label("Lives Left: _");
	
	//background images:
	Image tetris = new Image(new File("img/tetrishome.png").toURI().toString());
	Image info = new Image(new File("img/instructions.png").toURI().toString());
	Image info2 = new Image(new File("img/instructions2.png").toURI().toString());
	Image gBackground1 = new Image(new File("img/matrix.jpg").toURI().toString());
	Image quitBackground = new Image(new File("img/GiveUp.png").toURI().toString());
	Image con1 = new Image(new File("img/win1.png").toURI().toString());
	Image con2 = new Image(new File("img/instruct2.png").toURI().toString());
	Image vback = new Image(new File("img/vback.png").toURI().toString());
	Image quitB2 = new Image(new File("img/GiveUp2.png").toURI().toString());
	Image win2 = new Image(new File("img/win2.png").toURI().toString());
	Image win3 = new Image(new File("img/winscreen.png").toURI().toString());
	
	
	//enemy images:
	Image squareblock = new Image(new File("img/squareblock.png").toURI().toString());
	Image longblock = new Image(new File("img/longblock.png").toURI().toString());
	Image tblock = new Image(new File("img/tblock.png").toURI().toString());
	Image lblock = new Image(new File("img/lblock.png").toURI().toString());
	Image zblock = new Image(new File("img/zblock.png").toURI().toString());
	
	//label level 2:
	Label h1 = new Label("");
	Label h2 = new Label("");
	Label h3 = new Label("");
	Label h4 = new Label("");
	Label h5 = new Label("");
	Label h6 = new Label("");
	Label h7 = new Label("");
	Label h8 = new Label("");
	Label h9 = new Label("");
	Label h10 = new Label("");
	Label h11 = new Label("");
	Label h12 = new Label("");
	Label h13 = new Label("");
	Label h14 = new Label("");
	Label h15 = new Label("");
	Label h16 = new Label("");
	Label h17 = new Label("");
	Label h18 = new Label("");
	Label h19 = new Label("");
	Label h20 = new Label("");
	Label h21= new Label("");
	Label h22 = new Label("");
	Label h23 = new Label("");
	Label h24 = new Label("");
	Label h25 = new Label("");
	Label h26 = new Label("");
	Label h27 = new Label("");
	Label h28 = new Label("");
	Label h29 = new Label("");
	Label h30 = new Label("");
	Label h31 = new Label("");
	Label h32 = new Label("");
	Label h33 = new Label("");
	Label h34 = new Label("");
	
	Label hb = new Label("");
	Label hb2 = new Label("");
	Label hb3 = new Label("");
	Label hb4 = new Label("");


	Label voidb = new Label("");
	Label voidb2 = new Label("");
	Label voidb3 = new Label("");
	Label voidb4 = new Label("");
	Label voidb5 = new Label("");
	Label voidb6 = new Label("");
	Label voidb7 = new Label("");
	Label voidb8 = new Label("");
	
	Label ventity = new Label("");
	Label hcreate = new Label("");
	
	//enemy images level 2
	Image vbullet = new Image(new File("img/voidbullet - Copy.png").toURI().toString());
	Image vbullet2 = new Image(new File("img/vbullet2.png").toURI().toString());
	Image vbullet3 = new Image(new File("img/vbullet3.png").toURI().toString());
	Image vbullet4 = new Image(new File("img/vbullet4.png").toURI().toString());
	Image vbullet5 = new Image(new File("img/vbullet5.png").toURI().toString());
	Image vbullet6 = new Image(new File("img/vbullet6png").toURI().toString());
	Image vbullet7 = new Image(new File("img/vbullet7.png").toURI().toString());
	Image vbullet8 = new Image(new File("img/vbullet8.png").toURI().toString());
	
	Image hbullet = new Image(new File("img/horrificbullet.png").toURI().toString());
	Image hbullet2 = new Image(new File("img/hbullet2.png").toURI().toString());
	Image hbullet3 = new Image(new File("img/hbullet3.png").toURI().toString());
	Image hbullet4 = new Image(new File("img/hbullet4.png").toURI().toString());

	Image abomination = new Image(new File("img/void monster.png").toURI().toString());
	Image voidentity = new Image(new File("img/horrific.png").toURI().toString());
	Image hp1 = new Image(new File("img/hp1.png").toURI().toString());
	Image hp2 = new Image(new File("img/hp2.png").toURI().toString());
	Image hp3 = new Image(new File("img/hp3.png").toURI().toString());
	Image hp4 = new Image(new File("img/hp4.png").toURI().toString());
	Image hp5 = new Image(new File("img/hp5.png").toURI().toString());
	Image hp6 = new Image(new File("img/hp6.png").toURI().toString());
	Image hp7 = new Image(new File("img/hp7.png").toURI().toString());
	Image hp8 = new Image(new File("img/hp8.png").toURI().toString());
	Image hp9 = new Image(new File("img/hp9.png").toURI().toString());
	Image hp10 = new Image(new File("img/hp10.png").toURI().toString());
	Image hp11 = new Image(new File("img/hp11.png").toURI().toString());
	Image hp12 = new Image(new File("img/hp12.png").toURI().toString());
	Image hp13 = new Image(new File("img/hp13.png").toURI().toString());
	Image hp14 = new Image(new File("img/hp14.png").toURI().toString());
	Image hp15 = new Image(new File("img/hp15.png").toURI().toString());
	Image hp16 = new Image(new File("img/hp16.png").toURI().toString());
	Image hp17 = new Image(new File("img/hp17.png").toURI().toString());
	
	Image hp18 = new Image(new File("img/hp1 - Copy.png").toURI().toString());
	Image hp19 = new Image(new File("img/hp2 - Copy.png").toURI().toString());
	Image hp20 = new Image(new File("img/hp3 - Copy.png").toURI().toString());
	Image hp21 = new Image(new File("img/hp4 - Copy.png").toURI().toString());
	Image hp22 = new Image(new File("img/hp5 - Copy.png").toURI().toString());
	Image hp23 = new Image(new File("img/hp6 - Copy.png").toURI().toString());
	Image hp24 = new Image(new File("img/hp7 - Copy.png").toURI().toString());
	Image hp25 = new Image(new File("img/hp8 - Copy.png").toURI().toString());
	Image hp26 = new Image(new File("img/hp9 - Copy.png").toURI().toString());
	Image hp27 = new Image(new File("img/hp10 - Copy.png").toURI().toString());
	Image hp28 = new Image(new File("img/hp11 - Copy.png").toURI().toString());
	Image hp29 = new Image(new File("img/hp12 - Copy.png").toURI().toString());
	Image hp30 = new Image(new File("img/hp13 - Copy.png").toURI().toString());
	Image hp31 = new Image(new File("img/hp14 - Copy.png").toURI().toString());
	Image hp32 = new Image(new File("img/hp15 - Copy.png").toURI().toString());
	Image hp33 = new Image(new File("img/hp16 - Copy.png").toURI().toString());
	Image hp34 = new Image(new File("img/hp17 - Copy.png").toURI().toString());
	
	public void shuffle() {
		g2.setMargin(voidb, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb2, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb3, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb4, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb5, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb6, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb7, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb8, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(hb, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb2, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb3, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb4, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(ventity, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hcreate, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
	
	}
	
	//enemy images level 3
	
	
	/*
	 * Vbox in Center for buttons:
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {

		Stage instructions = new Stage();
		instructions.setTitle("Instructions");
		instructions.setResizable(false);
		
		Stage instructions2 = new Stage();
		instructions2.setTitle("Instructions");
		instructions2.setResizable(false);
		
		Stage instructions3 = new Stage();
		instructions3.setTitle("Congratulations");
		instructions3.setResizable(false);
		Scene win1 = new Scene(in2, 1200, 800);
		BackgroundSize bSize7 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		in2.setBackground(new Background(new BackgroundImage(con2,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize7)));
		in2.getChildren().addAll(nextL);
		instructions3.setScene(win1);
		in2.setMargin(nextL, new Insets(500,0,0,0));
		nextL.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		//instructions3.show();
		
		
		Stage instructions4 = new Stage();
		instructions4.setTitle("Congratulations");
		instructions4.setResizable(false);
		
		Stage finalVictory = new Stage();
		finalVictory.setTitle("YOU HAVE WON!");
		finalVictory.setResizable(false);
		Scene vic3 = new Scene(v3, 1920, 1000);
		finalVictory.setScene(vic3);
		BackgroundSize bSize12 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		v3.setBackground(new Background(new BackgroundImage(win3,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize12)));
		v3.getChildren().addAll(restart,quitf);
		v3.setMargin(restart, new Insets(700,0,0,-700));
		v3.setMargin(quitf, new Insets(700,0,0,700));
		
		
		
		Stage victory2 = new Stage();
		victory2.setTitle("Congratulations!");
		victory2.setResizable(false);
		Scene vic2 = new Scene(v2, 800, 500);
		victory2.setScene(vic2);
		BackgroundSize bSize11 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		v2.setBackground(new Background(new BackgroundImage(win2,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize11)));
		v2.getChildren().addAll(end);
		restart.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		quitf.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		
		end.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 600px; -fx-pref-height: 100px; -fx-font-size: 32;");
		v2.setMargin(end, new Insets(125,0,0,0));
	//	victory2.show();
		
		Stage lose2 = new Stage();
		lose2.setTitle("Game Over");
		lose2.setResizable(false);
		Scene loseScene2 = new Scene(loss2, 1000,1000);
		lose2.setScene(loseScene2);
		loss2.getChildren().addAll(retry2,quit2);
		BackgroundSize bSize9 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);	
		loss2.setBackground(new Background(new BackgroundImage(quitB2,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize9)));
		
		retry2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		quit2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		loss2.setMargin(retry2, new Insets(250,0,0,0));
		loss2.setMargin(quit2, new Insets(500,0,0,0));
		//lose2.show();
		
		Stage victory1 = new Stage();
		victory1.setTitle("Congratulations!");
		victory1.setResizable(false);
		Scene vic1 = new Scene(v1, 800, 500);
		victory1.setScene(vic1);
		BackgroundSize bSize6 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);	
		v1.setBackground(new Background(new BackgroundImage(con1,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize6)));
		v1.getChildren().addAll(cont);
		v1.setMargin(cont, new Insets(300,0,0,0));
		cont.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		Stage game1 = new Stage();
		game1.setTitle("Angery Clicker Level 1");
		game1.setResizable(false);
		Scene gameScreen1 = new Scene(g, 1920, 1000);
		Scene instruct2 = new Scene(sp2, 1200, 800);
		Scene instruct = new Scene(sp, 1200, 800);

		Stage game2 = new Stage();
		game2.setTitle("Angery Clicker Level 2");
		game2.setResizable(false);
		Scene gameScreen2 = new Scene(g2, 1920, 1000);
		game2.setScene(gameScreen2);
		BackgroundSize bSize8 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);	
		g2.setBackground(new Background(new BackgroundImage(vback,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize8)));
		g2.getChildren().addAll(timer2,lives2,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14
				,h15,h16,h17,h18,h19,h20,h21,h22,h23,h24,h25,h26,h27,h28,h29,h30,
				h31,h32,h33,h34,hcreate, ventity, hb, voidb, voidb2, voidb3, voidb4, voidb5,voidb6,voidb7,voidb8,hb2,hb3,hb4);
		
		ArrayList<Label> hname = new ArrayList<Label>();
		hname.add(h1);hname.add(h2);hname.add(h3);hname.add(h4);hname.add(h5);hname.add(h6);hname.add(h7);hname.add(h8);hname.add(h9);hname.add(h10);hname.add(h11);hname.add(h12);hname.add(h13);hname.add(h14);hname.add(h15);	hname.add(h16);	hname.add(h17);	hname.add(h18);	hname.add(h19);	hname.add(h20);
		hname.add(h21);	hname.add(h22);	hname.add(h23);	hname.add(h24);	hname.add(h25);
		hname.add(h26);	hname.add(h27);	hname.add(h28);	hname.add(h29);	hname.add(h30);	hname.add(h31);	hname.add(h32);hname.add(h33);hname.add(h34);
		//game2.show();

		g2.setMargin(timer2, new Insets(-750,0,0,1200));
		g2.setMargin(lives2, new Insets(-750,0,0,-1500));
		g2.setMargin(hcreate, new Insets(-250,0,0,-1000));
		g2.setMargin(ventity, new Insets(-250,0,0, 1000));
		timer2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		lives2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 150px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		//game2.show();
		
	
		
		h1.setGraphic(new ImageView(hp1));
		h2.setGraphic(new ImageView(hp2)); h2.setVisible(false);
		h3.setGraphic(new ImageView(hp3)); h3.setVisible(false);
		h4.setGraphic(new ImageView(hp4)); h4.setVisible(false);
		h5.setGraphic(new ImageView(hp5)); h5.setVisible(false);
		h6.setGraphic(new ImageView(hp6)); h6.setVisible(false);
		h7.setGraphic(new ImageView(hp7)); h7.setVisible(false);
		h8.setGraphic(new ImageView(hp8)); h8.setVisible(false);
		h9.setGraphic(new ImageView(hp9)); h9.setVisible(false);
		h10.setGraphic(new ImageView(hp10)); h10.setVisible(false);
		h11.setGraphic(new ImageView(hp11)); h11.setVisible(false);
		h12.setGraphic(new ImageView(hp12)); h12.setVisible(false);
		h13.setGraphic(new ImageView(hp13)); h13.setVisible(false);
		h14.setGraphic(new ImageView(hp14)); h14.setVisible(false);
		h15.setGraphic(new ImageView(hp15)); h15.setVisible(false);
		h16.setGraphic(new ImageView(hp16)); h16.setVisible(false);
		h17.setGraphic(new ImageView(hp17)); h17.setVisible(false);
		h18.setGraphic(new ImageView(hp18)); 
		h19.setGraphic(new ImageView(hp19)); h19.setVisible(false);
		h20.setGraphic(new ImageView(hp20)); h20.setVisible(false);
		h21.setGraphic(new ImageView(hp21)); h21.setVisible(false);
		h22.setGraphic(new ImageView(hp22)); h22.setVisible(false);
		h23.setGraphic(new ImageView(hp23)); h23.setVisible(false);
		h24.setGraphic(new ImageView(hp24)); h24.setVisible(false);
		h25.setGraphic(new ImageView(hp25)); h25.setVisible(false);
		h26.setGraphic(new ImageView(hp26)); h26.setVisible(false);
		h27.setGraphic(new ImageView(hp27)); h27.setVisible(false);
		h28.setGraphic(new ImageView(hp28)); h28.setVisible(false);
		h29.setGraphic(new ImageView(hp29)); h29.setVisible(false);
		h30.setGraphic(new ImageView(hp30)); h30.setVisible(false);
		h31.setGraphic(new ImageView(hp31)); h31.setVisible(false);
		h32.setGraphic(new ImageView(hp32)); h32.setVisible(false);
		h33.setGraphic(new ImageView(hp33)); h33.setVisible(false);
		h34.setGraphic(new ImageView(hp34)); h34.setVisible(false);
		
		hcreate.setGraphic(new ImageView(abomination));
		ventity.setGraphic(new ImageView(voidentity));
		
		g2.setMargin(hb, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb2, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb3, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		g2.setMargin(hb4, new Insets(Math.random()*-400+(Math.random()*900+1),0,0,Math.random()*-1400+Math.random()*1500+1));
		
		g2.setMargin(h18, new Insets(600,0,0,0));
		g2.setMargin(h19, new Insets(600,0,0,0));
		g2.setMargin(h20, new Insets(600,0,0,0));
		g2.setMargin(h21, new Insets(600,0,0,0));
		g2.setMargin(h22, new Insets(600,0,0,0));
		g2.setMargin(h23, new Insets(600,0,0,0));
		g2.setMargin(h24, new Insets(600,0,0,0));
		g2.setMargin(h25, new Insets(600,0,0,0));
		g2.setMargin(h26, new Insets(600,0,0,0));
		g2.setMargin(h27, new Insets(600,0,0,0));
		g2.setMargin(h28, new Insets(600,0,0,0));
		g2.setMargin(h29, new Insets(600,0,0,0));
		g2.setMargin(h30, new Insets(600,0,0,0));
		g2.setMargin(h31, new Insets(600,0,0,0));
		g2.setMargin(h32, new Insets(600,0,0,0));
		g2.setMargin(h33, new Insets(600,0,0,0));
		g2.setMargin(h34, new Insets(600,0,0,0));
		g2.setMargin(h1, new Insets(800,0,0,0));
		g2.setMargin(h2, new Insets(800,0,0,0));
		g2.setMargin(h3, new Insets(800,0,0,0));
		g2.setMargin(h4, new Insets(800,0,0,0));
		g2.setMargin(h5, new Insets(800,0,0,0));
		g2.setMargin(h6, new Insets(800,0,0,0));
		g2.setMargin(h7, new Insets(800,0,0,0));
		g2.setMargin(h8, new Insets(800,0,0,0));
		g2.setMargin(h9, new Insets(800,0,0,0));
		g2.setMargin(h10, new Insets(800,0,0,0));
		g2.setMargin(h11, new Insets(800,0,0,0));
		g2.setMargin(h12, new Insets(800,0,0,0));
		g2.setMargin(h13, new Insets(800,0,0,0));
		g2.setMargin(h14, new Insets(800,0,0,0));
		g2.setMargin(h15, new Insets(800,0,0,0));
		g2.setMargin(h16, new Insets(800,0,0,0));
		g2.setMargin(h17, new Insets(800,0,0,0));
		
		hb.setGraphic(new ImageView(hbullet));
		hb2.setGraphic(new ImageView(hbullet2));
		hb3.setGraphic(new ImageView(hbullet3));
		hb4.setGraphic(new ImageView(hbullet4));
	
		voidb.setGraphic(new ImageView(vbullet));
		voidb2.setGraphic(new ImageView(vbullet2));
		voidb3.setGraphic(new ImageView(vbullet3));
		voidb4.setGraphic(new ImageView(vbullet4));
		voidb5.setGraphic(new ImageView(vbullet5));
		voidb6.setGraphic(new ImageView(vbullet6));
		voidb7.setGraphic(new ImageView(vbullet7));
		voidb8.setGraphic(new ImageView(vbullet8));

		g2.setMargin(voidb, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb2, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb3, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb4, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb5, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb6, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb7, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g2.setMargin(voidb8, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));

		Stage game3 = new Stage();
		game3.setTitle("Angery Clicker Last Level");
		game3.setResizable(false);
		Scene gameScreen3 = new Scene(g3, 1920, 1000);
		
		Stage lose = new Stage();
		lose.setTitle("Game Over");
		Scene loseScene = new Scene(loss, 1000,1000);
		lose.setScene(loseScene);
		loss.getChildren().addAll(retry,quit);
		BackgroundSize bSize5 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);	
		loss.setBackground(new Background(new BackgroundImage(quitBackground,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize5)));
		
		retry.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		quit.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		loss.setMargin(retry, new Insets(150,0,0,0));
		loss.setMargin(quit, new Insets(450,0,0,0));
		
		Stage diffChooser = new Stage();
		diffChooser.setTitle("Choose a Difficulty:");
		diffChooser.setResizable(false);
		diff.getChildren().addAll(easy,normal,hard,impossible);
		diff.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
		Scene choice = new Scene(diff,500, 800);
		
		diffChooser.setScene(choice);
		diff.setMargin(easy, new Insets(-500,0,0,0));
		diff.setMargin(normal, new Insets(-200,0,0,0));
		diff.setMargin(hard, new Insets(100,0,0,0));
		diff.setMargin(impossible, new Insets(400,0,0,0));
		
		easy.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		normal.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		hard.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		impossible.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		//Game level 1
		BackgroundSize bSize3 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);	
		g.setBackground(new Background(new BackgroundImage(gBackground1,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize3)));
		g.getChildren().addAll(timer,lives1,points, square, iblock, l, t, z);
		points.setAlignment(Pos.CENTER);
		timer.setAlignment(Pos.CENTER);
		lives1.setAlignment(Pos.CENTER);
		points.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 400px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		timer.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		lives1.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 150px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		g.setMargin(timer, new Insets(-750,0,0,0));
		g.setMargin(points, new Insets(-750,0,0,1250));
		g.setMargin(lives1, new Insets(-750,0,0,-1500));
		g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
		
		//graphics for level 1:
		square.setGraphic(new ImageView(squareblock));
		iblock.setGraphic(new ImageView(longblock));
		l.setGraphic(new ImageView(lblock));
		t.setGraphic(new ImageView(tblock));
		z.setGraphic(new ImageView(zblock));
		
		//Instructions Page 1
		BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);		
		sp.setBackground(new Background(new BackgroundImage(info ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize)));
		sp.getChildren().addAll(Back, Next);
		Back.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		Next.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		sp.setMargin(Back, new Insets(500,0,0,-400));
		sp.setMargin(Next, new Insets(500,0,0,400));
		
		
		//Instructions Page 2
		BackgroundSize bSize4 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);		
		sp2.setBackground(new Background(new BackgroundImage(info2 ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize4)));
		sp2.getChildren().addAll(Back2, Start2);
		sp2.setMargin(Back2, new Insets(500,0,0,-400));
		sp2.setMargin(Start2, new Insets(500,0,0,400));
		Back2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		Start2.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		
		//music theme: option of music on/music off
	
		Media realm = new Media(new File("music/Realm of the Mad God Soundtrack - Title BGM (Download Link).mp3").toURI().toString());
		Media hit = new Media(new File("music/Original Tetris theme (Tetris Soundtrack).mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(hit);

		MediaPlayer song = new MediaPlayer(realm);
		Media newWorld = new Media(new File("music/New World Symphony - 4th Movement.mp3").toURI().toString());
		MediaPlayer endingsong = new MediaPlayer(newWorld);
		mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
		mediaPlayer.play();
		song.setCycleCount(AudioClip.INDEFINITE);
		endingsong.setCycleCount(AudioClip.INDEFINITE);
		
		//vbox in the center pane of a borderpane
		VBox vb = new VBox();
		
		Start.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt;");
		Mute.setStyle("-fx-background-color: #00ffff;-fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt; ");
		Exit.setStyle("-fx-background-color: #00ffff;-fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt; ");
	//	Options.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px ");
		Instructions.setStyle("-fx-background-color: #00ffff; -fx-pref-width: 300px; -fx-pref-height: 50px; -fx-font-size: 16pt; ");
		

		Mute.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            if (Mute.getText().equals("Tetris Music?")) {
	                mediaPlayer.pause();
	                song.play();
	                Mute.setText("Angery Clicker Music");
	            } else if (Mute.getText().equals("Angery Clicker Music")){
	                song.pause();
	                Mute.setText("Music Off");
	            } else if(Mute.getText().equals("Music Off")) {
	            	mediaPlayer.play();
	            	Mute.setText("Tetris Music?");
	            }
	        }
	    });
		
		Exit.setOnAction(e -> Platform.exit());
		

		
		instructions.setScene(instruct);
		Instructions.setOnMouseClicked((event) -> {
			instructions.show();
		});
		
		Back.setOnMouseClicked((event)->{
			instructions.hide();
		});
		Back2.setOnMouseClicked((event)->{
			instructions.show();
			instructions2.hide();
		});
		instructions2.setScene(instruct2);
		Next.setOnMouseClicked((event)->{
			instructions.hide();
			instructions2.show();
		});
		
		game1.setScene(gameScreen1);
		Start.setOnMouseClicked((event)->{
			diffChooser.show();
		});
		
		Start2.setOnMouseClicked((event)->{
			diffChooser.show();
			instructions2.hide();
		});
		easy.setOnMouseClicked((event)->{
			game1.show();	
			instructions2.hide();
			diffChooser.hide();
			seconds = 60;
			doTime();
			timeCounter++;
			timing = true;
			lives = 3;
			ea = true;
			lives1.setText("Lives Left: "+lives.toString());
			enemies = 20;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
		    timer.setText("Seconds Left: "+seconds.toString());
		});
		
		//victory2.show();
		
		end.setOnMouseClicked((event)->{
			finalVictory.show();
			victory2.hide();
			game2.hide();
		});
		normal.setOnMouseClicked((event)->{
			game1.show();	
			instructions2.hide();
			diffChooser.hide();
			seconds = 30;
			no = true;
			doTime();
			timeCounter++;
			timing = true;
			lives = 3;
			lives1.setText("Lives Left: "+lives.toString());
			enemies = 20;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
		    timer.setText("Seconds Left: "+seconds.toString());
			
		});
		
		hard.setOnMouseClicked((event)->{
			game1.show();	
			instructions2.hide();
			diffChooser.hide();
			seconds = 20;
			ha = true;
			doTime();
			timeCounter++;
			timing = true;
			lives = 3;
			lives1.setText("Lives Left: "+lives.toString());
			enemies = 20;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
		    timer.setText("Seconds Left: "+seconds.toString());
		});
		impossible.setOnMouseClicked((event)->{
			game1.show();	
			instructions2.hide();
			diffChooser.hide();
			seconds = 15;
			doTime();
			timeCounter++;
			im = true;
			timing = true;
			lives = 3;
			lives1.setText("Lives Left: "+lives.toString());
			enemies = 20;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
		    timer.setText("Seconds Left: "+seconds.toString());
		});
		
		quit.setOnMouseClicked((event)->{
			game1.hide();
			gameLoss = true;
			lose.hide();
		});
		
		retry.setOnMouseClicked((event)->{
			game1.hide();
			lose.hide();
			diffChooser.show();
			timing = true;
			gameLoss = true;
		});
		retry2.setOnMouseClicked((event)->{
			game2.hide();
			lose2.hide();
			gameLoss = true;
			lives = 3;
			lives2.setText("Lives Left: "+lives.toString());
			if (ea) {
				seconds = 120;
			}else if (no) {
				seconds = 90;
			}else if (ha) {
				seconds = 60;
			}else if (im) {
				seconds = 30;
			}
			timing = true;
			game2.show();
			doTime();
			for (int u  = 1; u < 17; u++) {
				hname.get(u).setVisible(false);
			}
			hname.get(0).setVisible(true);
			hname.get(17).setVisible(true);
			for(int o = 18; o < 34; o++) {
				hname.get(o).setVisible(false);
			}
			count1 = 0;
			count2 = 17;
			hcreate.setVisible(true);
			ventity.setVisible(true);
			
		});
		
		quit2.setOnMouseClicked((event)->{
			gameLoss = true;
			timing = true;
			game2.hide();
			lose2.hide();
		});
		square.setOnMouseClicked((event)->{
			g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			enemies--;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
			if(seconds == 0) {
				lose.show();
			}
			if (enemies == 0) {
				victory1.show();
			}
			sclicked = true;
		});
		iblock.setOnMouseClicked((event)->{
			g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			enemies--;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());

			if(seconds == 0) {
				lose.show();
			}
			if (enemies == 0) {
				victory1.show();
			}
			iclicked = true;
		});
		t.setOnMouseClicked((event)->{
			g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			enemies--;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());

			if(seconds == 0) {
				lose.show();
			}
			if (enemies == 0) {
				victory1.show();
			}
			tclicked = true;
			
		});
		nextL.setOnMouseClicked((event)->{
			gameLoss = true;
			timing = true;
			game2.show();
			instructions3.hide();
			lives = 3;
			if (ea) {
				seconds = 120;
			}else if (no) {
				seconds = 90;
			}else if (ha) {
				seconds = 60;
			}else if (im) {
				seconds = 30;
			}
			timing = true;
			doTime();
		});
		
		l.setOnMouseClicked((event)->{
			g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			enemies--;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());

			if(seconds == 0) {
				lose.show();
			}
			if (enemies == 0) {
				victory1.show();
			}
			lclicked = true;
		});
		z.setOnMouseClicked((event)->{
			g.setMargin(square, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(iblock, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(l, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(t, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			g.setMargin(z, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			enemies--;
			points.setText("Enemies Left Until Next Level: "+ enemies.toString());
			if(seconds == 0) {
				lose.show();
			}
			if (enemies == 0) {
				victory1.show();
			}
			zclicked = true;
		});
		
		gameScreen1.setOnMouseClicked((event)->{
			if (!(((zclicked == true)||(tclicked == true)||(sclicked == true)||(iclicked == true)||(lclicked == true)))) {
				lives--;
			}
			zclicked = false;
			sclicked = false;
			iclicked = false;
			lclicked = false;
			tclicked = false;
			lives1.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose.show();
			}
		});
		
		cont.setOnMouseClicked((event)->{
			instructions3.show();
			victory1.hide();
			game1.hide();
		});
		hb.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		hb2.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		hb3.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		hb4.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb2.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb3.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb4.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb5.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb6.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb7.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		voidb8.setOnMouseClicked((event)->{
			lives--;
			lives2.setText("Lives Left: "+lives.toString());
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		
		ventity.setOnMouseClicked((event)->{
			g2.setMargin(ventity, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			count1++;
			if((count1==16)&&(count2==33)) {
				victory2.show();
				endingsong.play();
				song.pause();
				mediaPlayer.pause();
			}
			hname.get(count1).setVisible(true);
			hname.get(count1-1).setVisible(false);
			if(count1 == 16) {
				ventity.setVisible(false);
			}
			lives = lives + 0;
			lives2.setText("Lives Left: "+lives.toString());
			if(seconds==0) {
				lose2.show();
			}
			shuffle();
		});
		hcreate.setOnMouseClicked((event)->{
			g2.setMargin(hcreate, new Insets(Math.random()*-500+(Math.random()*800+1),0,0,Math.random()*-1500+Math.random()*1500+1));
			count2++;
			if ((count1 == 16)&&(count2 == 33)) {
				victory2.show();
				endingsong.play();
				song.pause();
				mediaPlayer.pause();
			}
			hname.get(count2).setVisible(true);
			hname.get(count2-1).setVisible(false);
			if(count2 == 33) {
				hcreate.setVisible(false);
			}
			lives = lives + 0;
			lives2.setText("Lives Left: "+lives.toString());
			if(seconds==0) {
				lose2.show();
			}
			shuffle();
		});
		gameScreen2.setOnMouseClicked((event)->{
			if((lives == 0)||(seconds == 0)) {
				lose2.show();
			}
			shuffle();
		});
		restart.setOnMouseClicked((event)->{
			endingsong.pause();
			finalVictory.hide();
			primaryStage.show();
			mediaPlayer.play(); 
			Mute.setText("Tetris Music?");
		});
		quitf.setOnAction(e -> Platform.exit());
		//victory1.show();
		/*	
		Instructions.setOnMouseClicked((event) -> {
		    try {
		        FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("NewWindow.fxml"));
		        /* 
		         * if "fx:controller" is not set in fxml
		         * fxmlLoader.setController(NewWindowController);
		         
		        Scene scene =s new Scene(fxmlLoader.load(), 600, 400);
		        Stage stage = new Stage();
		        stage.setTitle("New Window");
		        stage.setScene(scene);
		        stage.show();
		    } catch (IOException e) {
		        
		    }
		});
	*/	
		BackgroundSize bSize2 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		bp.setBackground(new Background(new BackgroundImage(tetris,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize)));

		primaryStage.setResizable(false);
			
		//bp.setTop(tetrisView);
		vb.getChildren().addAll(Start,Mute,Instructions, Exit);
		vb.setMargin(Start, new Insets(300,200,0,820));
		//vb.setMargin(Options, new Insets(100, 0,0,820));
		vb.setMargin(Mute, new Insets(100,200,0,820));
		vb.setMargin(Instructions, new Insets(100,200,0,820));
		vb.setMargin(Exit, new Insets(100,200,0,820));
		
		bp.setTop(vb);
		
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Tetris");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/*
	private VBox getVBox() {
		
		vb.setPadding(new Insets(10,10,10,10));
		vb.getChildren().addAll(Start,Options,Mute,Exit);
		vb.setMargin(Start, new Insets(0,0,0,15));
		vb.setMargin(Options, new Insets(0,0,0,15));
		vb.setMargin(Mute, new Insets(0,0,0,15));
		vb.setMargin(Exit, new Insets(0,0,0,15));
		vb.

	}
	*/
	 private void doTime() {
		 
		 
		  Timeline time= new Timeline();
		  
		  
		  KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

		   @Override
		   
		   public void handle(ActionEvent event) {
				  
		    
		    seconds--;
		   // seconds+=(timeCounter-1);
		    timer.setText("Seconds Left: "+seconds.toString());
		    if(seconds<=0){
		     time.stop();
		    }
		    
		    if((timing = true)&&(gameLoss == true)) {
		    	time.stop();
		    	gameLoss = false;
		    }
		    timer2.setText("Seconds Left: "+seconds.toString());
		    if(seconds<=0){
		     time.stop();
		    }
		    
		    if((timing = true)&&(gameLoss == true)) {
		    	time.stop();
		    	gameLoss = false;
		    }
		   
		   
		   }
		   
		   
		   
		  });
		
		  time.setCycleCount(Timeline.INDEFINITE);
		  time.getKeyFrames().add(frame);
		/*
		  if(time!=null){
		   time.stop();
		  }
		  */
		  time.play();
		  
		  
		 } 
	public static void main(String[] args) {
		launch(args);
	}
}
