import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameScene extends Scene {
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private double cameraPositionX;
    private double cameraPositionY;
    private Camera camera;

    public GameScene(Group root, int x, int y){
        super(root, 0, 0);
        this.camera = new Camera(x,y);
        leftBackground = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/desert.png", 0, 0);
        rightBackground = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/desert.png", 800, 0);
        root.getChildren().addAll(leftBackground.getImg(), rightBackground.getImg());
    }
    public void render(){
        double cameraPositionX = camera.getX();
        double cameraPositionY = camera.getY();
        leftBackground.getImg().setX(cameraPositionX - 400);
        leftBackground.getImg().setY(cameraPositionY - 300);
        rightBackground.getImg().setX(cameraPositionX);
        rightBackground.getImg().setY(cameraPositionY - 300);
    }
    public void start(Stage primaryStage){
        primaryStage.setTitle("Le Jeu");
        Group root = new Group();
        GameScene gameScene = new GameScene(root, 400, 600);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

}
