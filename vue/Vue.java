package vue;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.Modele;

public class Vue {

	Modele modele;
	ArrayList<Circle> points;
	ArrayList<Line> segments;
	public Stage primaryStage = new Stage();
	public BorderPane root = new BorderPane();
	public Scene scene = new Scene(root, 800, 600);

	public Vue(Modele m) {
		modele = m;
		points = new ArrayList<Circle>();
		segments = new ArrayList<Line>();
		root.setStyle("-fx-padding: 10;");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Vue Generale");
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
}
