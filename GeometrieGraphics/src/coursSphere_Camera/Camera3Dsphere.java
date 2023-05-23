package coursSphere_Camera;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Camera3Dsphere extends Application{
	
	private final static int longueur = 1400;
	private final static int largeur = 800;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Sphere sphere = new Sphere(50);
			
			
			Group group = new Group();
			group.getChildren().add(sphere);
			
			//sphere.translateXProperty().set(longueur/2);
			//sphere.translateYProperty().set(largeur/2);
			
			
			
			Camera camera = new PerspectiveCamera(true);
			
			camera.setNearClip(1);
			camera.setFarClip(1000);
			
			camera.translateZProperty().set(-500);
			
			Scene scene = new Scene(group,longueur,largeur);
			scene.setFill(Color.SILVER);
			scene.setCamera(camera);
			
			
			primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
				switch(event.getCode()) {
					case A:
						camera.translateZProperty().set(camera.getTranslateZ() + 100);
					break;
					case E:
						camera.translateZProperty().set(camera.getTranslateZ() - 100);
					break;
					case Q:
						camera.translateXProperty().set(camera.getTranslateX() + 100);
					break;
					case S:
						camera.translateXProperty().set(camera.getTranslateX() - 100);
					break;
					case Z:
						camera.translateYProperty().set(camera.getTranslateY() + 100);
					break;
					case W:
						camera.translateYProperty().set(camera.getTranslateY() - 100);
					break;
					default: 
						break;
				}
			});
			
			
			primaryStage.setTitle("Camera 3D");
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
