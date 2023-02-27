// Author: Evie Welch
// date: 22/02/23

// Current moveLeft() and moveRight() don't work
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;

public class BallPane extends StackPane {
	public final double radius = 20;
	private double x = radius;
	private double y = radius;
	private HBox hBox = new HBox();
	private Button btUp = new Button("Up");
	private Button btDown = new Button("Down");
	private Button btLeft = new Button("Left");
	private Button btRight = new Button("Right");
	private Circle circle = new Circle(radius);

	public BallPane() {
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Pane holder = new Pane();
		holder.getChildren().add(circle);
		hBox.getChildren().addAll(btUp, btDown, btLeft, btRight);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.setSpacing(10);
		getChildren().addAll(holder, hBox);
		btUp.setOnAction(e -> System.out.println("wtf"));
		btUp.setOnAction(e -> this.moveBallUp());
		btDown.setOnAction(e -> this.moveBallDown());
		btLeft.setOnAction(e -> this.moveBallLeft());
		btRight.setOnAction(e -> this.moveballRight());

	}

	public double getRadius() {
		return radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getPaneCenterX() {
		return getWidth() / 2;
	}

	public double getPaneCenterY() {
		return getHeight() / 2;
	}

	public void setX(double x) {
		this.x = x;
		circle.setCenterX(this.x);
	}

	public void setY(double y) {
		this.y = y;
		circle.setCenterY(this.y);
	}

	public void centerBall() {
		x = getPaneCenterX();
		y = getPaneCenterY();
		circle.setCenterX(x);
		circle.setCenterY(y);
	}

	public void moveBallUp() {
		if (y > radius) {
			y = circle.getCenterY() - 5;
			setXY();
		} else {
			System.out.println("y: " + y);
			System.out.println("gh: " + (getHeight() - radius));
			System.out.println("Cant move up");
		}
	}

	public void moveBallDown() {
		if (y < getHeight() - radius) {
			y = circle.getCenterY() + 5;
			setXY();
		} else {
			System.out.println("y: " + y);
			System.out.println("radius: " + radius);
			System.out.println("Cant move down");
		}
	}

	public void moveBallLeft() {
		if (x > radius) {
			x -= 5;
			setXY();
		} else {
			System.out.println("x: " + x);
			System.out.println("radius: " + radius);
			System.out.println("Cant move left");
		}
	}

	public void moveballRight() {
		if (x < getWidth() - radius) {
			x += 5;
			setXY();
		} else {
			System.out.println("x: " + x);
			System.out.println("gw: " + (getWidth() - radius));
			System.out.println("Cant move right");
		}
	}

	public void setXY() {
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
}
