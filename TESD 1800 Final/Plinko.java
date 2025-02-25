import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.Node; 
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Plinko extends Application {

    Circle puck = new Circle();
    private double puckX = 200;
    private double puckY = 20; 
    private double puckVelocityX = 0;
    private double puckVelocityY = 0;
    private double puckAccelerationX = 0;
    private double puckAccelerationY = 0.5;
    int x = 0;
    int y = 0;
    int i = 0;
    int l = 0;
    int w = 0;
    Rectangle lose = new Rectangle();
    Rectangle win = new Rectangle();

    private Circle cursor = new Circle(200, 20, 8);

    @Override
    public void start(Stage primaryStage) {
        cursor.setFill(Color.RED);

        BorderPane game = new BorderPane();
        Pane board = new Pane();
        game.setCenter(board);

        HBox rules = new HBox();
        StackPane ui = new StackPane();
        game.setTop(ui);

        Text rulesText = new Text("Use arrow keys to move. Press Space to drop");
        rules.getChildren().add(rulesText);
        rules.setAlignment(Pos.CENTER);
        ui.getChildren().add(rules);

        for (int x = -5; x < 400; x += 50) {
            for (int y = 50; y < 450; y += 50) {
                Rectangle peg = peg();
                peg.setX(x);
                peg.setY(y);
                board.getChildren().add(peg);
            }
        }
        for (int x = 20; x < 400; x += 50) {
            for (int y = 75; y < 450; y += 50) {
                Rectangle peg = peg();
                peg.setX(x);
                peg.setY(y);
                board.getChildren().add(peg);
            }
        }
        for(int a = -1; a < 401; a += 50){
            Rectangle pockets = pockets();
            pockets.setX(a);
            pockets.setY(460);
            board.getChildren().add(pockets);
        }

        board.getChildren().add(cursor);

        cursor.setFocusTraversable(true);  
        cursor.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT: if(cursor.getCenterX() < 20) break; cursor.setCenterX(cursor.getCenterX() - 10); break;
                case RIGHT: if(cursor.getCenterX() > 380) break; cursor.setCenterX(cursor.getCenterX() + 10); break;
                case SPACE: dropPuck(board); break;
                default: break;
            }
        });

        Scene scene = new Scene(game, 400, 500);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Plinko");
        primaryStage.setScene(scene);
        primaryStage.show();

        cursor.requestFocus();  
    }

    private void dropPuck(Pane board) {
        if (i == 1) return;

        puckX = cursor.getCenterX();  
        puckY = cursor.getCenterY();
        puck = new Circle(puckX, puckY, 8);
        puck.setFill(Color.BLUE); 
        board.getChildren().add(puck);

        List<Rectangle> pegs = new ArrayList<>();
        for (Node node : board.getChildren()) {
            if (node instanceof Rectangle && node != cursor && node != win && node != lose) {
                pegs.add((Rectangle) node);
            }
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            puckVelocityY += puckAccelerationY;
            puckY += puckVelocityY;

            puckVelocityX += puckAccelerationX;
            puckX += puckVelocityX;

            if (puckY + puck.getRadius() > 485) {
                puckY = 485 - puck.getRadius(); 
                puckVelocityY = 0; 
                puckVelocityX = 0;
            }

            for (Rectangle peg : pegs) {
                double pegX = peg.getX();
                double pegY = peg.getY();
                double pegWidth = peg.getWidth();
                double pegHeight = peg.getHeight();

                if (puckX + puck.getRadius() > pegX && puckX - puck.getRadius() < pegX + pegWidth &&
                    puckY + puck.getRadius() > pegY && puckY - puck.getRadius() < pegY + pegHeight) {
                    if (puckX < pegX + pegWidth / 2 || puckX < 8 || puckX > 392) {
                        puckVelocityX = -1.2;
                    } else {
                        puckVelocityX = 1.2;
                    }

                    if (puckY < pegY + pegHeight / 2) {
                        puckVelocityY = -.5;
                    } else {
                        puckVelocityY = .5;
                    }
                }
            }
            if(puckX < 8)
                puckVelocityX = 1.2;
            if(puckX > 392)
                puckVelocityX = -1.2;

            puck.setCenterY(puckY);
            puck.setCenterX(puckX);

            if(l < 1){
            if(puck.getCenterY() > 475){
                if (puck.getCenterX() > 50 && puck.getCenterX() < 100 || puck.getCenterX() > 150 && puck.getCenterX() < 200 || puck.getCenterX() > 250 && puck.getCenterX() < 300 || puck.getCenterX() > 350 && puck.getCenterX() < 400){
                    Label loseScreen = new Label("LOSE");
                    loseScreen.setFont(Font.font("Comic Sans", FontWeight.BOLD, 100));
                    loseScreen.setTextFill(Color.RED);
                    loseScreen.setLayoutX(80); 
                    loseScreen.setLayoutY(150); 
                    board.getChildren().add(loseScreen);

                }
                    l++;
                }
            }
            if(w < 1){
            if(puck.getCenterY() > 475){
                if(puck.getCenterX() > 0 && puck.getCenterX() < 50 || puck.getCenterX() > 100 && puck.getCenterX() < 150 || puck.getCenterX() > 200 && puck.getCenterX() < 250 || puck.getCenterX() > 300 && puck.getCenterX() < 350){
                    Label winScreen = new Label("WIN");
                    winScreen.setFont(Font.font("Comic Sans", FontWeight.BOLD, 100));
                    winScreen.setTextFill(Color.GREEN);
                    winScreen.setAlignment(Pos.CENTER);
                    winScreen.setLayoutX(95); 
                    winScreen.setLayoutY(150); 
                    board.getChildren().add(winScreen);

                }
                    w++;
                }
            }  
        }));
        puck.setCenterY(puck.getCenterY());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        i++;

        for (int w = 1; w < 400; w += 100){
            win = new Rectangle(48, 100, Color.GREEN);
            win.setX(w);
            win.setY(475);
            board.getChildren().add(win);
        }
        for (int l = 51; l < 400; l += 100){
            lose = new Rectangle(48,100, Color.RED);
            lose.setX(l);
            lose.setY(475);
            board.getChildren().add(lose);
        }
    }
    
    private Rectangle peg() {
        Rectangle peg = new Rectangle(10, 10);
        peg.setFill(Color.BLACK);
        peg.setRotate(45);
        return peg;
    }
    private Rectangle pockets(){
        Rectangle pockets = new Rectangle(2,200);
        pockets.setFill(Color.BLACK);
        return pockets;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
