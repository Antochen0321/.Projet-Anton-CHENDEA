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
        GameScene scene = new GameScene(root, 0, 0);

        stage.setScene(scene);
        stage.show();

        Image spriteSheet = new Image("file:/Users/anaua/IdeaProjects/Projet Runner/img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);

        root.getChildren().add(sprite);
    }

    public static void  main(String[] args){
        launch(args);

    }
}
