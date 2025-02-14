import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class Exercise16_1 extends Application{
    @Override
    public void start(Stage primaryStage){

        Text text = new Text(170, 75, "Programming is Fun!");
        text.setStroke(Color.BLACK);
        text.setStrokeWidth(0.3);
        Pane textPane = new Pane(text);

        HBox buttonPane = new HBox(20);
        Button left = new Button("<=");
        Button right = new Button("=>");
        buttonPane.getChildren().addAll(left, right);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setStyle("-fx-border-color: black");

        HBox radioPane = new HBox(20);
        radioPane.setAlignment(Pos.CENTER);
        radioPane.setStyle("-fx-border-color: black");
        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton black = new RadioButton("Black");
        RadioButton orange = new RadioButton("Orange");
        RadioButton green = new RadioButton("Green");
        radioPane.getChildren().addAll(red, yellow, black, orange, green);

        ToggleGroup group = new ToggleGroup();
        red.setToggleGroup(group);
        yellow.setToggleGroup(group);
        black.setToggleGroup(group);
        orange.setToggleGroup(group);
        green.setToggleGroup(group);

        red.setOnAction(e -> {
            if(red.isSelected())
                text.setFill(Color.RED);
        });
        yellow.setOnAction(e -> {
            if(yellow.isSelected())
                text.setFill(Color.YELLOW);
        });
        black.setOnAction(e -> {
            if(black.isSelected())
                text.setFill(Color.BLACK);
        });
        orange.setOnAction(e -> {
            if(orange.isSelected())
                text.setFill(Color.ORANGE);
        });
        green.setOnAction(e -> {
            if(green.isSelected())
                text.setFill(Color.GREEN);
        });

        BorderPane mainPane = new BorderPane();
        mainPane.setBottom(buttonPane);
        mainPane.setTop(radioPane);
        mainPane.setCenter(textPane);

        left.setOnAction(e -> text.setX(text.getX() > 0 ? text.getX() - 10 : + 0));
        right.setOnAction(e -> text.setX(text.getX() < mainPane.getWidth() - 110 ? text.getX() + 10 : mainPane.getWidth() - 110));

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Exercise16_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
