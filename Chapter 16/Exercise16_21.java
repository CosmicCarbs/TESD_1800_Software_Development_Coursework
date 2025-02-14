import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.media.Media;

public class Exercise16_21 extends Application {
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(100));
        Label enter = new Label("Enter an Integer: ");
        pane.setTop(enter);
        TextField input = new TextField();
        input.setAlignment(Pos.CENTER_RIGHT);
        pane.setCenter(input);
        Label invalid = new Label("Invalid Input");

        input.setOnAction(e -> {
            try {
                int[] number = {Integer.parseInt(input.getText())};
                Label newText = new Label(String.valueOf(number[0])); 
                pane.setCenter(newText);
                Timeline countDown = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
                    if (number[0] > 0) {
                        number[0]--; 
                        newText.setText(String.valueOf(number[0])); 
                    } else {
                        String media_url = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
                        Media media = new Media(media_url);
                        MediaPlayer sound = new MediaPlayer(media);
                        sound.play();
                    }
                }));
                countDown.setCycleCount(Timeline.INDEFINITE);
                countDown.play();
                
                if (number[0] != 0) {
                    pane.getChildren().removeAll(input, enter, invalid);  
                }
            } catch (NumberFormatException ex) {
                pane.setBottom(invalid);
            }
        });

        Scene scene = new Scene(pane, 400,300);
        primaryStage.setTitle("Exercise16_21"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }   
    public static void main(String[] args) {
        launch(args);
      }
}
