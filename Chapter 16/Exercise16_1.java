
// author: Evie Welch
// date: 28/02/23
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Exercise16_1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane display = new BorderPane();

		// Create text
		Text text = new Text(20, 40, "Programin is fun");
		text.setStyle("-fx-font-size: 20");
		Pane textPane = new Pane();
		textPane.getChildren().add(text);
		textPane.setStyle("-fx-border-color: black white black white");
		display.setCenter(textPane);

		// Create RadioButtons and their container
		HBox radioHolder = new HBox(15);
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		radioHolder.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		display.setTop(radioHolder);
		radioHolder.setAlignment(Pos.TOP_CENTER);
		// Add them to toggle group so only one can be selected
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		// add functionality
		rbRed.setOnAction(e -> {
			System.out.println("okay");
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		rbBlack.setOnAction(e -> {
			if (rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		rbOrange.setOnAction(e -> {
			if (rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});

		// Make buttons and container
		HBox buttonHolder = new HBox(10);
		buttonHolder.setPadding(new Insets(5, 5, 5, 5));
		Button lButton = new Button("<=");
		Button rButton = new Button("=>");
		buttonHolder.getChildren().addAll(lButton, rButton);
		display.setBottom(buttonHolder);
		buttonHolder.setAlignment(Pos.BOTTOM_CENTER);
		// add button functionality
		lButton.setOnAction(e -> {
			if (!(text.getX() - 10 < 0)) {
				double currentX = text.getX();
				text.setX(currentX - 10);
			}
		});
		rButton.setOnAction(e -> {
			if (!(text.getX() + text.getBoundsInParent().getWidth() + 10 > display.getWidth())) {
				double currentX = text.getX();
				text.setX(currentX + 10);
			}
		});

		Scene scene = new Scene(display, 450, 175);
		primaryStage.setTitle("Exercise 16-1");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
