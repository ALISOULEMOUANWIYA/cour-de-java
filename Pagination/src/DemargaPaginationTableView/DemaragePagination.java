package DemargaPaginationTableView;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class DemaragePagination extends Application {
	private double xOffset = 0;
    private double yOffset = 0;
    
	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FichierFXML/PaginationBox.fxml"));
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		//fx:controller="ControllerFXML.ListeController"
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}