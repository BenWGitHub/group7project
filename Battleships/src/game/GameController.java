package game;

import java.util.Random;

import game.Board.Cell;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

	private Scene scene = new Scene(addScene());
	private Stage stage = new Stage();
	private EventHandler<ActionEvent> onCloseEvent;
	
    private boolean inGame = false;
    private Board enemyBoard, playerBoard;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();
   
    public GameController(EventHandler<ActionEvent> onCloseEvent) {
    		this.onCloseEvent = onCloseEvent;
    }
    
    public Scene getScene() {
    		return scene;
    }

    private Parent addScene() 
    {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);

        enemyBoard = new Board(true, event -> {
            if (!inGame) {
                return;
            }

            Cell cell = (Cell) event.getSource();
            //If a call has been shot at twice do nothing
            if (cell.wasShot) 
            {
                return;
            }

            enemyTurn = !cell.shoot();

            if (enemyBoard.ships == 0) 
            {
                printGameResult(Result.WIN);
            }

            if (enemyTurn) 
            {
            		while (enemyTurn) 
            		{
                    int x = random.nextInt(10);
                    int y = random.nextInt(10);

                    Cell c = playerBoard.getCell(x, y);
                    if (c.wasShot)
                        continue;

                    enemyTurn = c.shoot();

                    if (playerBoard.ships == 0) 
                    {
                    		printGameResult(Result.LOSE);
                    }
                }
            }
        });

        playerBoard = new Board(false, event -> {
            if (inGame)
                return;

            Cell cell = (Cell) event.getSource();

            // if event.getButton() == MouseButton.PRIMARY (left click) !(event.getButton() == MouseButton.PRIMARY) (right click)
            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });
        
		Button exitBtn = new Button("Exit");
		exitBtn.setOnMouseClicked(event -> {
			Stage stage = new Stage();
		
			VBox layout = new VBox(10);
			layout.setAlignment(Pos.CENTER);
			Label question = new Label("Are You Sure You Want to Exit?");
		
			Button yesBtn = new Button("Yes");
			yesBtn.setOnAction(onCloseEvent);
			
			Button noBtn = new Button("No");
		
			noBtn.setOnAction(noEvent -> {
				stage.close();
			});
			
			HBox buttonBox = new HBox(10);
			buttonBox.setAlignment(Pos.CENTER);
		
			buttonBox.getChildren().addAll(yesBtn, noBtn);
			layout.getChildren().addAll(question, buttonBox);
		
			Scene resultScene = new Scene(layout, 200, 100);
		
			stage.setTitle("Exit");
			stage.setScene(resultScene);
			stage.show();
		});

        String intro = "Welcome to Battleships sailor!\nTo place your ships, left click a cell for vertical placement and right click for horizontal.";
        
        Text gameText = new Text(intro);
        gameText.setFill(Color.BLACK);
        
        VBox left = new VBox(50, enemyBoard, playerBoard);
        left.setAlignment(Pos.CENTER);
        VBox right = new VBox(50, gameText);
        right.setAlignment(Pos.CENTER);
        
        HBox top = new HBox(50, left, right);
        HBox bottom = new HBox(50, exitBtn, new Button("Hi"));
        bottom.setAlignment(Pos.CENTER);
        
        VBox vbox = new VBox(50, top, bottom);
        vbox.setAlignment(Pos.CENTER);

        vbox.setPadding(new Insets (50,50,50,50));
        
        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(vbox);
        
        root.setCenter(mainPane);

        return root;
    }

    enum Result 
    {
    		WIN, LOSE;
    }

    //Opens a small popup window which displays if you won or lost the match
    private void printGameResult(Result r) {

    	Label label = new Label();
    		if(r.equals(Result.WIN)) {
    			label.setText("YOU WIN!");
    		} else {
    			label.setText("YOU LOSE");
    		}
    		StackPane layout = new StackPane();
    		layout.getChildren().add(label);
    		
    		Scene resultScene = new Scene(layout, 200, 100);
    		
    		
    		stage.setTitle("Good Game!");
    		stage.setScene(resultScene);
    		stage.show(); 
    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
        		//The computer places a random ship on the enemies gameboard.
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyBoard.placeShip(new Ship(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        inGame = true;
    }
    
    private String enemyResponse() 
    {
		String response = "";
    		Random rnd = new Random();
    		String[] hitResponses = new String[10];
    		
    		hitResponses[0] = "Take that!";
    		hitResponses[1] = "You're finished!";
    		hitResponses[2] = "Get fucked cunt!"; //dont leave this 
    		hitResponses[3] = "I'll end you!";
    		hitResponses[4] = "*Teleports onto ship* Nothing personal kid!";
    		hitResponses[5] = "I attack your life points directly!";
    		hitResponses[6] = "Null pointer error, remains of your ego not found.";
    		
    		response = hitResponses[rnd.nextInt(hitResponses.length-1)];
    		
    		return response;
   
    }

    
}