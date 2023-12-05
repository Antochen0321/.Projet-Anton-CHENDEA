import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;

public class HelloWorld extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world");
        Group root = new Group();
        Camera camera = new Camera(100, 250);
        GameScene scene = new GameScene(root, 800, 400, 1000, 400);
        if(scene.getNumberOfLives() < 3){
            root.getChildren().remove(root);
        }
        stage.setScene(scene);
        stage.show();
        if (scene.getNumberOfLives() == 0) {
            root.getChildren().removeAll();
            GameOverScene gameOverScene = new GameOverScene(new Group(), 800, 400);
            stage.setScene(gameOverScene);
        }
    }

    public static void  main(String[] args){
        launch(args);

    }
}
