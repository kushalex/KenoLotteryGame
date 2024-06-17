
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;



public class Game extends Application {
	
	public boolean bc1 = false;
	public boolean bc2 = false;
	public boolean bc3 = false;
	public boolean bc4 = false;
	
	public boolean c1 = false;
	public boolean c4 = false;
	public boolean c8 = false;
	public boolean c10 = false;
	
	public int count = 0;
	public int randomNumber = 0;
	
	public int numCards = 0;
	public int totalWinnings = 0;
	public int i = 0;
	
	public int numMatched = 0;
	public int amountWonThisCard;
	public boolean randomSelected = false;
	
	public Color w = Color.web("#EC5A29");
	
	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Keno");
		
		Button backButton = new Button("BACK");
		Button playButton = new Button("Play Keno");
		playButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		playButton.setPrefSize(100, 20);
		BorderPane bPane = new BorderPane();
		Menu welcomeMenu = new Menu("Menu");
		MenuBar menuBar =  new MenuBar();
		MenuItem rules = new MenuItem("Rules");
		MenuItem odds = new MenuItem("Odds");
		MenuItem exit = new MenuItem("Exit");
		
		HBox playerChoices = new HBox();
		HBox betPlayChoices = new HBox();
		HBox randomNumChoices = new HBox();
		VBox playGridBox = new VBox();
		HBox gridChoice = new HBox();
		HBox drawBox = new HBox();
		
		Button betCardPlays1 = new Button("1");
		Button betCardPlays2 = new Button("2");
		Button betCardPlays3 = new Button("3");
		Button betCardPlays4 = new Button("4");
		
		Label userNumsRand = new Label("Your numbers are: ");
		
		Label spotChoice = new Label("How many spots would you like?");
		Label betCardChoice = new Label("How many cards would you like?");
		Label randomNumChoice = new Label("Choose numbers randomly?");
		
		ArrayList<Integer> randSelect = new ArrayList<>();
		ArrayList<Integer> winningNumbers = new ArrayList<>();
		
		Button beginDraw = new Button("Begin Drawing");
		
		welcomeMenu.getItems().add(rules);
		welcomeMenu.getItems().add(odds);
		welcomeMenu.getItems().add(exit);
		menuBar.getMenus().add(welcomeMenu);
		bPane.setTop(menuBar);
		bPane.setCenter(playButton);
		
		Image wImage = new Image("https://i.ytimg.com/vi/zwKLCvXCnN8/maxresdefault.jpg");
		BackgroundSize wSize = new BackgroundSize(BackgroundSize.AUTO, 
		        BackgroundSize.AUTO, 
		        false, 
		        false, 
		        true, 
		        false);
		
		Background wBackground = new Background(new BackgroundImage(wImage,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.CENTER,
		        wSize));
		bPane.setBackground(wBackground);
		
		
		Scene scene = new Scene(bPane, 700, 700);
		w = Color.web("#EC5A29");
		scene.setFill(w);
		
		//rules button
		BorderPane rPane = new BorderPane();
		Scene rulesScene = new Scene(rPane, 700, 700);
		
		rules.setOnAction((ActionEvent e) -> {
			rPane.setTop(menuBar);
			
			HBox rBox = new HBox();
			
			backButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
			backButton.setPrefSize(100, 20);
			rBox.getChildren().add(backButton);
			rBox.setAlignment(Pos.BOTTOM_CENTER);
			rPane.setLeft(rBox);
	
			
			Image rImage = new Image("https://nclottery.com/content/images/KenoPlaySlip2020.jpg");
			BackgroundSize rSize = new BackgroundSize(BackgroundSize.AUTO, 
			        BackgroundSize.AUTO, 
			        false, 
			        false, 
			        true, 
			        false);
			
			Background rBackground = new Background(new BackgroundImage(rImage,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundPosition.CENTER,
			        rSize));
			rPane.setBackground(rBackground);
			Color r = Color.web("#EC5A29");
			rulesScene.setFill(r);
			
			primaryStage.setScene(rulesScene);
		});
		
		//odds button
		BorderPane oPane = new BorderPane();
		Scene oddsScene = new Scene(oPane, 700, 700);
		
		odds.setOnAction((ActionEvent e) -> {
			oPane.setTop(menuBar);
			
			VBox oBox = new VBox();
			
			backButton.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
			backButton.setPrefSize(100, 20);
			oBox.getChildren().add(backButton);
			oBox.setAlignment(Pos.BOTTOM_CENTER);
			oPane.setLeft(oBox);
			
			Image oImage = new Image("https://nclottery.com/content/images/KenoPrizeChart2020.jpg");

			BackgroundSize oSize = new BackgroundSize(BackgroundSize.AUTO, 
			        BackgroundSize.AUTO, 
			        false, 
			        false, 
			        true, 
			        false);
			
			Background oBackground = new Background(new BackgroundImage(oImage,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundPosition.CENTER,
			        oSize));
			
			oPane.setBackground(oBackground);
			Color o = Color.web("#EC5A29");
			oddsScene.setFill(o);
			
			primaryStage.setScene(oddsScene);
		});
		
		//exit button
		exit.setOnAction((ActionEvent e) -> {
			System.exit(0);
		});
		
		//back button
		backButton.setOnAction((ActionEvent e) -> {
			bPane.setTop(menuBar);
			primaryStage.setScene(scene);
		});
		
		//play button
		BorderPane pPane = new BorderPane();
		Scene playScene = new Scene(pPane, 700, 700);
		Menu playMenu = new Menu("Menu");
		MenuItem nLook = new MenuItem("New Look");
		MenuBar playBar =  new MenuBar();
		GridPane playGrid = new GridPane();
		ArrayList<Button> numSelected = new ArrayList<Button>();
		Button randomNum = new Button("Yes");
		randomNum.setDisable(true);
		int nodeNum = 1;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 10; col++) {
				Button buttonNum = new Button(Integer.toString(nodeNum));
				buttonNum.setStyle("-fx-padding:5px; " + "-fx-background-color: #eee; " + "-fx-border-width: 1px; " +
							   "-fx-border-color: #ccc; " + "-fx-font-size: 14px; " + "-fx-alignment: center;");
				buttonNum.setOnAction((ActionEvent e) -> {
					buttonNum.setStyle("-fx-background-color: orange;");
					count++;
					if (numSelected.contains(buttonNum)) {
						count = count - 2;
						buttonNum.setStyle("-fx-padding:5px; " + "-fx-background-color: #eee; " + "-fx-border-width: 1px; " +
							   "-fx-border-color: #ccc; " + "-fx-font-size: 14px; " + "-fx-alignment: center;");
						numSelected.remove(buttonNum);
					}
					else {
						numSelected.add(buttonNum);
					}
					if (count == getNumSpots()) {
						disableButtons(playGrid);
					}
					randomNum.setDisable(true);
					randomSelected = false;
				});
				// start buttons as disabled until player decides how many spots to play
				buttonNum.setDisable(true);
				playGrid.add(buttonNum, col, row);
				nodeNum++;
			}
		}
		
		// new look button
		nLook.setOnAction((ActionEvent e) -> {
			playScene.setFill(Color.web("#ADD8E6"));
			randomNum.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18));
			beginDraw.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18));
			spotChoice.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18));
			betCardChoice.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18)); 
			randomNumChoice.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18));
		});

		// Choices for the number of spots user can choose.
		Button choseOne = new Button("1");
		Button choseFour = new Button("4");
		Button choseEight = new Button("8");
		Button choseTen = new Button("10");
		
		
		choseOne.setOnAction((ActionEvent e) -> {
			count = 0;
			c1 = true;
			c4 = false;
			c8 = false;
			c10 = false;
			choseOne.setStyle("-fx-background-color: orange;" + "fx-focus-color: transparent");
			choseFour.setStyle(null);
			choseEight.setStyle(null);
			choseTen.setStyle(null);
			enableButtons(playGrid);
			numSelected.clear();
			randomNum.setDisable(false);
			randSelect.clear();
			userNumsRand.setText("Your numbers are: ");
			playGridBox.getChildren().remove(userNumsRand);
			playGrid.setDisable(false);
		});
		
		choseFour.setOnAction((ActionEvent e) -> {
			count = 0;
			c1 = false;
			c4 = true;
			c8 = false;
			c10 = false;
			choseOne.setStyle(null);
			choseFour.setStyle("-fx-background-color: orange;");
			choseEight.setStyle(null);
			choseTen.setStyle(null);
			enableButtons(playGrid);
			numSelected.clear();
			randomNum.setDisable(false);
			randSelect.clear();
			userNumsRand.setText("Your numbers are: ");
			playGridBox.getChildren().remove(userNumsRand);
			playGrid.setDisable(false);
		});
		
		choseEight.setOnAction((ActionEvent e) -> {
			count = 0;
			c1 = false;
			c4 = false;
			c8 = true;
			c10 = false;
			choseOne.setStyle(null);
			choseFour.setStyle(null);
			choseEight.setStyle("-fx-background-color: orange;");
			choseTen.setStyle(null);
			enableButtons(playGrid);
			numSelected.clear();
			randomNum.setDisable(false);
			randSelect.clear();
			userNumsRand.setText("Your numbers are: ");
			playGridBox.getChildren().remove(userNumsRand);
			playGrid.setDisable(false);
		});
		
		choseTen.setOnAction((ActionEvent e) -> {
			count = 0;
			c1 = false;
			c4 = false;
			c8 = false;
			c10 = true;
			choseOne.setStyle(null);
			choseFour.setStyle(null);
			choseEight.setStyle(null);
			choseTen.setStyle("-fx-background-color: orange;");
			enableButtons(playGrid);
			numSelected.clear();
			randomNum.setDisable(false);
			randSelect.clear();
			userNumsRand.setText("Your numbers are: ");
			playGridBox.getChildren().remove(userNumsRand);
			playGrid.setDisable(false);
		});
		
		// number of drawings
		
		betCardPlays1.setOnAction((ActionEvent e) -> {
			bc1 = true;
			bc2 = false;
			bc3 = false;
			bc4 = false;
			betCardPlays1.setStyle("-fx-background-color: orange;");
			betCardPlays2.setStyle(null);
			betCardPlays3.setStyle(null);
			betCardPlays4.setStyle(null);
			beginDraw.setDisable(false);
		});
		betCardPlays2.setOnAction((ActionEvent e) -> {
			bc1 = false;
			bc2 = true;
			bc3 = false;
			bc4 = false;
			betCardPlays1.setStyle(null);
			betCardPlays2.setStyle("-fx-background-color: orange;");
			betCardPlays3.setStyle(null);
			betCardPlays4.setStyle(null);
			beginDraw.setDisable(false);
		});
		betCardPlays3.setOnAction((ActionEvent e) -> {
			bc1 = false;
			bc2 = false;
			bc3 = true;
			bc4 = false;
			betCardPlays1.setStyle(null);
			betCardPlays2.setStyle(null);
			betCardPlays3.setStyle("-fx-background-color: orange;");
			betCardPlays4.setStyle(null);
			beginDraw.setDisable(false);
		});
		betCardPlays4.setOnAction((ActionEvent e) -> {
			bc1 = false;
			bc2 = false;
			bc3 = false;
			bc4 = true;
			betCardPlays1.setStyle(null);
			betCardPlays2.setStyle(null);
			betCardPlays3.setStyle(null);
			betCardPlays4.setStyle("-fx-background-color: orange;");
			beginDraw.setDisable(false);
		});
		
				
		// select random numbers
		randomNum.setOnAction((ActionEvent e) -> {
			Random rand = new Random();
			int randomNumber = 0;
			
			for (int i = 0; i < getNumSpots(); i++) {
				randomNumber = rand.nextInt(80) + 1;
				randSelect.add(randomNumber);
				String randNum = String.valueOf(randomNumber);
				userNumsRand.setText(userNumsRand.getText() + " " + randNum);
			}
			playGridBox.getChildren().add(userNumsRand);
			playGridBox.setAlignment(Pos.CENTER);
			randomNum.setDisable(true);
			playGrid.setDisable(true);
			randomSelected = true;
		});
		
		// begin draw
		
		playButton.setOnAction((ActionEvent e) -> {
			choseOne.setFocusTraversable(false);
			choseFour.setFocusTraversable(false);
			choseEight.setFocusTraversable(false);
			choseTen.setFocusTraversable(false);
			betCardPlays1.setFocusTraversable(false);
			betCardPlays2.setFocusTraversable(false);
			betCardPlays3.setFocusTraversable(false);
			betCardPlays4.setFocusTraversable(false);
			randomNum.setFocusTraversable(false);
			beginDraw.setFocusTraversable(false);
			
			welcomeMenu.getItems().remove(rules);
			welcomeMenu.getItems().remove(odds);
			welcomeMenu.getItems().remove(exit);
			playMenu.getItems().add(rules);
			playMenu.getItems().add(odds);
			playMenu.getItems().add(nLook);
			playMenu.getItems().add(exit);
			playBar.getMenus().add(playMenu);
			pPane.setTop(playBar);
			
			
			playerChoices.getChildren().add(choseOne);
			playerChoices.getChildren().add(choseFour);
			playerChoices.getChildren().add(choseEight);
			playerChoices.getChildren().add(choseTen);
			playerChoices.setAlignment(Pos.CENTER);
			

			betPlayChoices.getChildren().add(betCardPlays1);
			betPlayChoices.getChildren().add(betCardPlays2);
			betPlayChoices.getChildren().add(betCardPlays3);
			betPlayChoices.getChildren().add(betCardPlays4);
			betPlayChoices.setAlignment(Pos.CENTER);
			
			
			randomNumChoices.getChildren().add(randomNum);
			randomNumChoices.setAlignment(Pos.CENTER);
						
			
			playGridBox.getChildren().add(playGrid);
			playGridBox.getChildren().add(spotChoice);
			playGridBox.getChildren().add(playerChoices);
			playGridBox.getChildren().add(betCardChoice);
			playGridBox.getChildren().add(betPlayChoices);
			playGridBox.getChildren().add(randomNumChoice);
			playGridBox.getChildren().add(randomNumChoices);
			playGridBox.setAlignment(Pos.CENTER);
			
			
			gridChoice.getChildren().add(playGridBox);
			gridChoice.setAlignment(Pos.CENTER);
			
			
			drawBox.getChildren().add(beginDraw);
			beginDraw.setDisable(true);
			drawBox.setAlignment(Pos.CENTER);
			
			pPane.setCenter(gridChoice);
			pPane.setBottom(drawBox);
			
			backButton.setOnAction((ActionEvent b) -> {
				bPane.setTop(menuBar);
				primaryStage.setScene(playScene);
			});
			primaryStage.setScene(playScene);
		});
		
		BorderPane dPane = new BorderPane();
		VBox dBox = new VBox();
		Scene drawScene = new Scene(dPane, 700, 700);
		Button newGame = new Button("New Game");
		
		Color d = Color.web("#EC5A29");
		drawScene.setFill(d);
		
		Label amountMatched = new Label("Number of Matching Numbers: ");
		Label matching = new Label("Matching Numbers: ");
		Label winnings = new Label("Winning from this Card: ");
		Label overallWinnings = new Label("Total Won so far: ");
		Label revealNumber = new Label("");
        revealNumber.setStyle("-fx-font-size: 32px;");
		//dBox.getChildren().add(newGame);
		//dBox.getChildren().add(revealNumber);
		VBox userInfo = new VBox();
		userInfo.setAlignment(Pos.CENTER);
		userInfo.getChildren().add(amountMatched);
		userInfo.getChildren().add(matching);
		userInfo.getChildren().add(winnings);
		userInfo.getChildren().add(overallWinnings);
		dBox.setAlignment(Pos.BOTTOM_CENTER);
        HBox numberBox = new HBox();
        numberBox.getChildren().add(revealNumber);
        numberBox.setAlignment(Pos.TOP_CENTER);
        dPane.setTop(numberBox);
        dPane.setBottom(dBox);
        Button nextDraw = new Button("Next Draw");
        dBox.getChildren().add(nextDraw);
        nextDraw.setDisable(true);
        
		
		beginDraw.setOnAction((ActionEvent e) -> {
			if (randomSelected == false) {
				revealNumber.setText("");
				randomNumber = 0;
				Random rand = new Random();
				i = 0;
				while(i < 20) {
					randomNumber = rand.nextInt(80) + 1;
					if (winningNumbers.contains(randomNumber)) {
						randomNumber = rand.nextInt(80) + 1;
					}
					else {
						String randNum = String.valueOf(randomNumber);
						revealNumber.setText(revealNumber.getText() + " " + randNum);
						winningNumbers.add(randomNumber);
						i++;
					}
				}
				numCards++;
				// compare to the user's numbers
				//amountMatched matching winnings
				ArrayList<Integer> matchingNums = new ArrayList<>();
				for (Button button : numSelected) {
					int userNum = Integer.parseInt(button.getText());
					for (int j = 0; j < winningNumbers.size(); j++) {
						if (userNum == winningNumbers.get(j)) {
							numMatched++;
							matchingNums.add(userNum);
							amountWonThisCard = calculateCardWinnings(numMatched, getNumSpots());
						}
					}
				}
				if (getNumBetCards() > 1 && numCards != getNumBetCards()) {
					nextDraw.setDisable(false);
					nextDraw.setOnAction(event -> {
						numMatched = 0;
						amountMatched.setText("Number of Matching Numbers: ");
						matching.setText("Matching Numbers: ");
						winnings.setText("Winning from this Card: ");
						overallWinnings.setText("Total Won so far: ");
						beginDraw.fire();
					});
				}
				amountMatched.setText(amountMatched.getText() + " " + Integer.toString(numMatched));
					for (int k = 0; k < matchingNums.size(); k++) {
						matching.setText(matching.getText() + " " + Integer.toString(matchingNums.get(k)));
					}
					winnings.setText(winnings.getText() + " " + Integer.toString(amountWonThisCard));
				totalWinnings += amountWonThisCard;
				overallWinnings.setText(overallWinnings.getText() + " " + Integer.toString(totalWinnings));
				winningNumbers.clear();
				matchingNums.clear();
				dPane.setCenter(userInfo);
				if (numCards == getNumBetCards()) {
					dBox.getChildren().remove(nextDraw);
					dBox.getChildren().add(newGame);
				}
				primaryStage.setScene(drawScene);
			}
			else
			{
				revealNumber.setText("");
				randomNumber = 0;
				Random rand = new Random();
				i = 0;
				while(i < 20) {
					randomNumber = rand.nextInt(80) + 1;
					if (winningNumbers.contains(randomNumber)) {
						randomNumber = rand.nextInt(80) + 1;
					}
					else {
						String randNum = String.valueOf(randomNumber);
						revealNumber.setText(revealNumber.getText() + " " + randNum);
						winningNumbers.add(randomNumber);
						i++;
					}
				}
				numCards++;
				// compare to the user's numbers
				//amountMatched matching winnings
				ArrayList<Integer> matchingNums = new ArrayList<>();
				for (int l = 0; l < randSelect.size(); l++) {
					int userNum = randSelect.get(l);
					for (int j = 0; j < winningNumbers.size(); j++) {
						if (userNum == winningNumbers.get(j)) {
							numMatched++;
							matchingNums.add(userNum);
							amountWonThisCard = calculateCardWinnings(numMatched, getNumSpots());
						}
					}
				}
				if (getNumBetCards() > 1 && numCards != getNumBetCards()) {
					nextDraw.setDisable(false);
					nextDraw.setOnAction(event -> {
						numMatched = 0;
						amountMatched.setText("Number of Matching Numbers: ");
						matching.setText("Matching Numbers: ");
						winnings.setText("Winning from this Card: ");
						overallWinnings.setText("Total Won so far: ");
						beginDraw.fire();
					});
				}
				amountMatched.setText(amountMatched.getText() + " " + Integer.toString(numMatched));
					for (int k = 0; k < matchingNums.size(); k++) {
						matching.setText(matching.getText() + " " + Integer.toString(matchingNums.get(k)));
					}
				winnings.setText(winnings.getText() + " " + Integer.toString(amountWonThisCard));
				totalWinnings += amountWonThisCard;
				overallWinnings.setText(overallWinnings.getText() + " " + Integer.toString(totalWinnings));
				winningNumbers.clear();
				matchingNums.clear();
				dPane.setCenter(userInfo);
				if (numCards == getNumBetCards()) {
					dBox.getChildren().remove(nextDraw);
					dBox.getChildren().add(newGame);
				}
				primaryStage.setScene(drawScene);
			}
		});
		
		newGame.setOnAction((ActionEvent e) -> {
			beginDraw.setDisable(true);
			numMatched = 0;
			amountMatched.setText("Number of Matching Numbers: ");
			matching.setText("Matching Numbers: ");
			winnings.setText("Winning from this Card: ");
			overallWinnings.setText("Total Won so far: ");
			dBox.getChildren().remove(newGame);
			dBox.getChildren().add(nextDraw);
			numCards = 0;
			pPane.setTop(playBar);
			c1 = false;
			c4 = false;
			c8 = false;
			c10 = false;
			choseOne.setStyle(null);
			choseFour.setStyle(null);
			choseEight.setStyle(null);
			choseTen.setStyle(null);
			bc1 = false;
			bc2 = false;
			bc3 = false;
			bc4 = false;
			betCardPlays1.setStyle(null);
			betCardPlays2.setStyle(null);
			betCardPlays3.setStyle(null);
			betCardPlays4.setStyle(null);
			playGridBox.getChildren().remove(userNumsRand);
			enableButtons(playGrid);
			disableButtons(playGrid);
			primaryStage.setScene(playScene);
		});
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private int getNumSpots() {
		if (c1 == true) {
			return 1;
		}
		if (c4 == true) {
			return 4;
		}
		if (c8 == true) {
			return 8;
		}
		if (c10 == true) {
			return 10;
		}
		return 0;
	}
	
	private int getNumBetCards() {
		if (bc1 == true) {
			return 1;
		}
		if (bc2 == true) {
			return 2;
		}
		if (bc3 == true) {
			return 3;
		}
		if (bc4 == true) {
			return 4;
		}
		return 0;
	}
	
	private int calculateCardWinnings(int numMatched, int numSpots) {
		// winnings for 1 spot game
		if (numSpots == 1) {
			if (numMatched == 1) {
				return 2;
			}
		}
		// winnings for 4 spot game
		else if (numSpots == 4) {
			if (numMatched == 2) {
				return 1;
			}
			else if (numMatched == 3) {
				return 5;
			}
			else if (numMatched == 4) {
				return 75;
			}
		}
		// winning for 8 spot game
		else if (numSpots == 8) {
			if (numMatched == 4) {
				return 2;
			}
			else if (numMatched == 5) {
				return 12;
			}
			else if (numMatched == 6) {
				return 50;
			}
			else if (numMatched == 7) {
				return 750;
			}
			else if (numMatched == 8) {
				return 10000;
			}
		}
		// winning for 10 spot game
		else if (numSpots == 10) {
			if (numMatched == 0) {
				return 5;
			}
			else if (numMatched == 5) {
				return 2;
			}
			else if (numMatched == 6) {
				return 15;
			}
			else if (numMatched == 7) {
				return 40;
			}
			else if (numMatched == 8) {
				return 450;
			}
			else if (numMatched == 9) {
				return 4250;
			}
			else if (numMatched == 10) {
				return 100000;
			}
		}
		// reaches here means user won no money
		return 0;
	}
	
	private void enableButtons(GridPane grid) {
		for (int i = 0; i < grid.getChildren().size(); i++) {
			Button button = (Button) grid.getChildren().get(i);
			button.setStyle("-fx-padding:5px; " + "-fx-background-color: #eee; " + "-fx-border-width: 1px; " +
							   "-fx-border-color: #ccc; " + "-fx-font-size: 14px; " + "-fx-alignment: center;");
			button.setDisable(false);
		}
	}
	
	private void disableButtons(GridPane grid) {
		for (int i = 0; i < grid.getChildren().size(); i++) {
			Button button = (Button) grid.getChildren().get(i);
			button.setDisable(true);
		}
	}
}
// test with mvn clean compile exec:java
