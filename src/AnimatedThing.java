import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView imageView;
    private int attitude;
    private int currentIndex;
    Duration frameDuration;
    private int maxIndex;
    private double windowSizex;
    private double windowSizey;
    private double frameOffsetx;
    private double frameOffsety;
    private Runnable onGameOver;
    final private Timeline animationTimeline;
    public AnimatedThing(String fileName, double x, double y, int maxIndex, double windowSizex, double windowSizey, double frameOffsetx, double frameOffsety, int attitude, int currentIndex) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.frameDuration = Duration.seconds(0.05);
        this.maxIndex = maxIndex;
        this.windowSizey = windowSizey;
        this.windowSizex = windowSizex;
        this.frameOffsetx = frameOffsetx;
        this.frameOffsety = frameOffsety;

        Image spriteSheet = new Image(fileName);

        this.imageView = new ImageView(spriteSheet);

        this.imageView.setViewport(new Rectangle2D(x, y, windowSizex, windowSizey));

        this.animationTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> updateFrame()),
                new KeyFrame(Duration.seconds(0.004 / frameDuration.toSeconds()), event -> updateFrame())
        );
        this.animationTimeline.setCycleCount(Animation.INDEFINITE);
        this.animationTimeline.play();
        updateFrame();
    }

    public ImageView getImageView() {
        return imageView;
    }

    private void updateFrame() {
        double xOffset = (currentIndex - 1) * frameOffsetx / 2;
        double yOffset = 2 * attitude * frameOffsety;
        imageView.setViewport(new Rectangle2D(xOffset, yOffset, windowSizex, windowSizey));
        if(currentIndex > maxIndex){
            currentIndex = 0;
        }else{
            currentIndex = currentIndex + 1;
        }
    }
    public void setX(double x) {
        this.x = x;
        imageView.setX(x);
    }
    public double getX() {
        return x;
    }
    public void setY(double y) {
        this.y = y;
        imageView.setY(y);
    }
    public double getY() {
        return y;
    }
    public void setAttitude(int newAttitude){
        this.attitude = newAttitude;
    }
    public int getAttitude(){
        return attitude;
    }
    public int getMaxIndex(){
        return maxIndex;
    }
    public int getCurrentIndex(){
        return currentIndex;
    }

    public void setMaxIndex(int newMaxIndex){
        this.maxIndex = newMaxIndex;
    }
    public void setCurrentIndex(int newCurrentIndex){
        this.currentIndex = newCurrentIndex;
    }
    public void setWindowSizey(double newSetWindowsSizey){
        this.windowSizey = newSetWindowsSizey;
    }
    public void setWindowSizex(double newSetWindowsSizex){
        this.windowSizex = newSetWindowsSizex;
    }
    public void setFrameOffsetx(double newFrameOffsetx){
        this.frameOffsetx = newFrameOffsetx;
    }
    public void setFrameOffsety(double newFrameOffsety){
        this.frameOffsety = newFrameOffsety;
    }

    void setFrameDuration(Duration newFrameDuration){
        this.frameDuration = newFrameDuration;
    }
    public ImageView getImg(){
        return imageView;
    }


}
