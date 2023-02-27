// author: Evie Welch
// date 22/02/23

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class BallController extends Application {
	@Override
	public void start(Stage primaryStage) {
		BallPane ball = new BallPane();
		Scene scene = new Scene(ball, 250, 175);
		ball.centerBall();
		primaryStage.setTitle("Exercise 15 - Listeners: Implementation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
