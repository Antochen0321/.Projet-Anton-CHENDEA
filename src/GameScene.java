import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private StaticThing leftBackground;
    private StaticThing rightBackground;
    private double cameraPositionX;
    private final Camera camera;

    public GameScene(int x, int y){
        super(new Group());
        this.camera = new Camera(x,y);
    }
    public void initGS(){
        StaticThing fondg = new StaticThing("fondg.png", 800, 600);
        StaticThing fondd = new StaticThing("fondg.png", 800, 600);
    }
}
