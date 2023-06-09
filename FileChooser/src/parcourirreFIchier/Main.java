package parcourirreFIchier;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

private double xOffset = 0;
private double yOffset = 0;
private FXMLLoader loader;

@Override
public void start(Stage stage) {
	try {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLparcourir.fxml"));
		stage.initStyle(StageStyle.TRANSPARENT);
		 root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
		root.setOnMouseDragged(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent event){
               stage.setX(event.getScreenX() - xOffset );
               stage.setY(event.getScreenY() - yOffset );
           }
       });
       Scene scene = new Scene(root);
       scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
       stage.setScene(scene);

       stage.show();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	//--module-path "C:\Program Files\Java\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml
}

public static void main(String[] args) {
	launch(args);
}
}
