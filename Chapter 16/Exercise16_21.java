// Author: Evie Welch
// date: 28/02/23


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");
		TextField tf = new TextField();
		
		// create the animation
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
			tf.setText(String.valueOf(Integer.valueOf(tf.getText()) - 1));
		}));
		// create the media
		Media media = new Media(MEDIA_URL);
		MediaPlayer mp = new MediaPlayer(media);
		// make the media loop
		mp.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				mp.seek(Duration.ZERO);
				mp.play();
			}		
		});
		// make pressing enter start the animation
		tf.setOnAction(e -> {
			animation.setCycleCount(Integer.valueOf(tf.getText()));
			animation.play();
			// when animation is over start playing the song
			animation.setOnFinished(es -> {
				mp.play();
			});
		});
		pane.getChildren().add(tf);	

		Scene scene = new Scene(pane, 75, 75);
		primaryStage.setTitle("Exercise 16-21");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
