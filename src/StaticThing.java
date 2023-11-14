import javax.swing.text.Element;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private final double sizeX;
    private final double sizeY;
    private final ImageView img;

    public StaticThing( String fileName, double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Image image = new Image(fileName);
        this.img = new ImageView(image);
        img.setFitWidth(sizeX);
        img.setFitHeight(sizeY);
    }
    public ImageView getImg(){
        return img;
    }
}
