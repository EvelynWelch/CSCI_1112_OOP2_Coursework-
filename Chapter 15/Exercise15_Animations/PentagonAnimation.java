// Author: Evelyn Welch
// date: 02/27/23

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.FadeTransition;

public class PentagonAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Pentagon pentagon = new Pentagon();
		// Create a scene and place it in the stage
		Scene scene = new Scene(pentagon, 400, 400);
		primaryStage.setTitle("ShowPolygon"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

class Pentagon extends Pane {
	boolean playing = true;

	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// Make the points for the pentagon
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}
		setRotate(18);
		
		// make the rectangle
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.CYAN);

		// Add the fade transition to the rectangle
		FadeTransition ft = new FadeTransition(Duration.millis(4000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play(); // Start animation

		// Add the movement animation to the rectangle
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(polygon);
		getChildren().clear();
		getChildren().addAll(polygon, rectangle);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();

		// Add mouse event.
		setOnMouseClicked(e -> {
			if (playing) {
				pt.pause();
				ft.pause();
				playing = false;
			} else {
				pt.play();
				ft.play();
				playing = true;
			}
		});
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}