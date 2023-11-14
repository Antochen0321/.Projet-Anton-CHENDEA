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
        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.show();

        Image spriteSheet = new Image("file:/Users/anaua/IdeaProjects/Projet Runner/img/heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);

        root.getChildren().add(sprite);

        GameScene gameScene = new GameScene(150, 200);


    }

    public static void  main(String[] args){
        launch(args);
        Camera cam1 = new Camera(5, 10);
        System.out.println("La Caméra est placée aux coordonés " + cam1);
        System.out.println("La coordonnée x a pour valeur " + cam1.getX());
        System.out.println("La coordonnée y a pour valeur " + cam1.getY());

    }
}
