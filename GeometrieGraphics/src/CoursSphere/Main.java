package CoursSphere;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;


public class Main extends Application {
	
	private final static int longueur = 1400;
	private final static int largeur = 800;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Sphere sphere = new Sphere(50);
			
			
			Group group = new Group();
			group.getChildren().add(sphere);
			
			sphere.translateXProperty().set(longueur/2);
			sphere.translateYProperty().set(largeur/2);
			
			
			Camera camera = new PerspectiveCamera();
			
			Scene scene = new Scene(group,longueur,largeur);
			scene.setFill(Color.SILVER);
			scene.setCamera(camera);
			
			
			primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
				switch(event.getCode()) {
					case A:
						sphere.translateZProperty().set(sphere.getTranslateZ() + 100);
					break;
					case E:
						sphere.translateZProperty().set(sphere.getTranslateZ() - 100);
					break;
					case S:
						sphere.translateXProperty().set(sphere.getTranslateX() + 100);
					break;
					case Q:
						sphere.translateXProperty().set(sphere.getTranslateX() - 100);
					break;
					case W:
						sphere.translateYProperty().set(sphere.getTranslateY() + 100);
					break;
					case Z:
						sphere.translateYProperty().set(sphere.getTranslateY() - 100);
					break;
					default: 
						break;
				}
			});
			
			
			primaryStage.setTitle("Sphere 3D");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
