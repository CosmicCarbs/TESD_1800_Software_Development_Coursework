import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Chapter15_Animation extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

		Rectangle rectangle = new Rectangle(200,200,100, 100);
		rectangle.setFill(Color.BLUE);

        Polygon pentagon = new Polygon();
		pentagon.setFill(Color.WHITE);
		pentagon.setStroke(Color.BLACK);
		pentagon.setOpacity(0.1);
		pentagon.getPoints().addAll(200.0, 50.0, 57.0, 154.0, 112.0, 321.0, 288.0, 321.0, 343.0, 154.0);

        pane.getChildren().addAll(pentagon, rectangle);

		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.play();

		FadeTransition ft = new FadeTransition(Duration.millis(2000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.setInterpolator(Interpolator.LINEAR);
		ft.play();

		 RotateTransition rt = new RotateTransition(Duration.millis(2000), rectangle);
     	rt.setByAngle(360);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setInterpolator(Interpolator.LINEAR);
 		rt.play();

		pentagon.setOnMouseClicked(e ->{
			if(ft.getStatus() == Animation.Status.PAUSED){
				ft.play();
				pt.play();
				rt.play();
			}
			else{
				ft.pause();
				pt.pause();
				rt.pause();
			}
			});

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Chapter15_Animation");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

	public static void main(String[] args) {
        launch(args);
    }
}