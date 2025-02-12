import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Chapter15_Listeners extends Application {

    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(20);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        BorderPane pane = new BorderPane();
        pane.setPrefSize(400, 300);
        pane.setTop(circle);

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");

        HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hBox);

        btUp.setOnAction((ActionEvent e) -> {
            circle.setTranslateY(circle.getTranslateY() > 10 ? circle.getTranslateY() - 5 : 0);
        });

        btDown.setOnAction((e) -> {
            circle.setTranslateY(circle.getTranslateY() < pane.getHeight() - 40 ? circle.getTranslateY() + 5 : pane.getHeight() - 40);
        });

        btLeft.setOnAction(e -> {
            circle.setTranslateX(circle.getTranslateX() > 0 ? circle.getTranslateX() - 5 : 0);
        });

        btRight.setOnAction(e -> {
            circle.setTranslateX(circle.getTranslateX() < pane.getWidth() - 40 ? circle.getTranslateX() + 5 : pane.getWidth() - 40);
        });

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Chapter15_Listeners");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
