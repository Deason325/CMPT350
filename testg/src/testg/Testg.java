package testg;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Testg extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane drawingPane = new Pane();
        drawingPane.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(drawingPane, 800, 800, Color.WHITE);

        scene.setOnScroll(e -> {
            drawingPane.setTranslateX(drawingPane.getTranslateX() + e.getDeltaX());
            drawingPane.setTranslateY(drawingPane.getTranslateY() + e.getDeltaY());
        });
        scene.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                Point2D center = drawingPane.sceneToLocal(new Point2D(e.getX(), e.getY()));
                Circle c = new Circle(center.getX(), center.getY(), 25, Color.CORNFLOWERBLUE);
                drawingPane.getChildren().add(c);
            }
        });
        Circle c = new Circle(50, 50, 25, Color.CORNFLOWERBLUE);
        drawingPane.getChildren().add(c);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}