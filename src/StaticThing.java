import javax.swing.text.Element;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class StaticThing {
    private final double sizeX;
    private final double sizeY;
    private double x;
    private double y;
    private final ImageView img;
    private Rectangle hitbox;
    private String fileName;

    public StaticThing(String fileName, double sizeX, double sizeY, double x, double y){
        this.fileName = fileName;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Image image = new Image(fileName);
        this.img = new ImageView(image);
        img.setFitWidth(sizeX);
        img.setFitHeight(sizeY);
        img.setX(x);
        img.setY(y);
        hitbox = new Rectangle(sizeX, sizeY);
        hitbox.setX(x);
        hitbox.setY(y);
    }
    public Bounds getBoundingBox() {
        return hitbox.getBoundsInLocal();
    }
    public ImageView getImg(){
        return img;
    }
    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public void setX(double x) {this.x=x;}
    public void setHitbox(double nx, double ny){
        hitbox.setY(nx);
        hitbox.setX(ny);
    }
    public void setImg(String newfilename){
        this.fileName = newfilename;
    }
}
