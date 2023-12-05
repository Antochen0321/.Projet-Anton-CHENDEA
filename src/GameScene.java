import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;
public class GameScene extends Scene {
    private static StaticThing leftBackground;
    private static StaticThing middleBackground;
    private static StaticThing rightBackground;
    private StaticThing heart;
    private double cameraPositionX;
    private double cameraPositionY;
    private Camera camera;
    private Hero hero;
    private int numberOfLives;
    private Timeline backgroundLoop;
    private StaticThing obstacle1;
    private StaticThing obstacle2;
    private StaticThing obstacle3;
    int compt = 0;
    double speed = 4.0;
    private Rectangle heroHitbox;
    private Rectangle obstacle1hitbox;
    private Rectangle obstacle2hitbox;
    private Rectangle obstacle3hitbox;
    public GameScene(Group root, int x, int y, int windowWidth, int windowHeight) {
        super(root, windowWidth, windowHeight);
        this.camera = new Camera(x, y);
        leftBackground = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/desert.png", 800, 400, -400, 0);
        middleBackground = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/desert.png", 800, 400, 400, 0);
        rightBackground = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/desert.png", 800, 400, 1200, 0);
        root.getChildren().addAll(leftBackground.getImg(), middleBackground.getImg(), rightBackground.getImg());
        hero = new Hero(300, 250);
        heroHitbox = new Rectangle(hero.getX() + 15, hero.getY() + 15, 60, 70);
        heroHitbox.setFill(null);
        heroHitbox.setStroke(Color.RED);
        this.numberOfLives = 3;
        for (int i = 0; i < numberOfLives; i++) {
            heart = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/heart.png", 40, 40, 0, 0);
            heart.getImg().setX(i * 50);
            heart.getImg().setY(10);
            root.getChildren().add(heart.getImg());
        }
        obstacle1 = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/cactus.png", 100, 100, 800, 280);
        obstacle2 = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/cactus.png", 100, 100, -400, 280);
        obstacle3 = new StaticThing("file:/Users/anaua/IdeaProjects/Projet Runner/img/pigeon.png", 100, 100, -400, 120);

        root.getChildren().addAll(obstacle1.getImg(), obstacle2.getImg(), obstacle3.getImg());
        obstacle1hitbox = new Rectangle(810, 290, 70, 70);
        obstacle1hitbox.setFill(null);
        obstacle1hitbox.setStroke(Color.BLUE);
        obstacle2hitbox = new Rectangle(-410, 290, 70, 70);
        obstacle2hitbox.setFill(null);
        obstacle2hitbox.setStroke(Color.GREEN);
        obstacle3hitbox = new Rectangle(810, 140, 70, 70);
        obstacle3hitbox.setFill(null);
        obstacle3hitbox.setStroke(Color.YELLOW);
        hero.getImageView().setPreserveRatio(true);
        root.getChildren().addAll(hero.getImageView());

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                KeyCode keyPressed = event.getCode();
                if (keyPressed == KeyCode.SPACE){
                    hero.jump();
                } else if (keyPressed == KeyCode.X) {
                    hero.shoot();
                    root.getChildren().add(obstacle1hitbox);
                    root.getChildren().add(obstacle2hitbox);
                    root.getChildren().add(obstacle3hitbox);
                    root.getChildren().add(heroHitbox);
                }
            }
        });
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                KeyCode keyReleased = event.getCode();
                if (keyReleased == KeyCode.SPACE) {
                    hero.endJump();
                } else if (keyReleased == KeyCode.X) {
                    hero.endShoot();
                    root.getChildren().remove(obstacle1hitbox);
                    root.getChildren().remove(obstacle2hitbox);
                    root.getChildren().remove(obstacle3hitbox);
                    root.getChildren().remove(heroHitbox);
                }
            }
        });
        backgroundLoop = new Timeline(new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateBackground();
            }
        }));
        backgroundLoop.setCycleCount(Timeline.INDEFINITE);
        backgroundLoop.play();
    }

    public void stopBackgroundLoop() {
        backgroundLoop.stop();
    }

    private void updateBackground() {
        double x1 = leftBackground.getX();
        double x2 = middleBackground.getX();
        double x3 = rightBackground.getX();
        double x4 = obstacle1.getX();
        double x5 = obstacle2.getX();
        double x6 = obstacle3.getX();
        if (x1 < 400) {
            leftBackground.getImg().setX(1200);
            leftBackground.setX(1200);
            middleBackground.getImg().setX(400);
            middleBackground.setX(400);
            rightBackground.getImg().setX(-400);
            rightBackground.setX(-400);
        } else {
            leftBackground.getImg().setX(x1 - speed);
            leftBackground.setX((x1 - speed));
            middleBackground.getImg().setX(x2 - speed);
            middleBackground.setX((x2 - speed));
            rightBackground.getImg().setX(x3 - speed);
            rightBackground.setX((x3 - speed));
        }
        if(hero.getInvicibility() & x4 < 200){
            hero.setInvincibility(false);
        }
        if (x4 < -200){
            Random random = new Random();
            int ran1 = random.nextInt(3);;
            obstacle1.getImg().setX(1500 + ran1 * 10);
            obstacle1.setX(1500 + ran1 * 10);

        } else {
            obstacle1.getImg().setX(x4 - speed);
            obstacle1.setX((x4 - speed));
            if(x5 < -100 & x4 < 1000){
                Random random = new Random();
                int ran2 = random.nextInt(9);
                if(ran2 == 0){
                    obstacle2.getImg().setX(1500);
                    obstacle2.setX(1500);
                }
            }else{
                obstacle2.getImg().setX(x5 - speed);
                obstacle2.setX((x5 - speed));
            }
        }
        if(x6<=-200 & x4 <= 1200 & x5 <= 1200){
            Random random = new Random();
            int ran1 = random.nextInt(3);;
            obstacle3.getImg().setX(1500 + ran1 * 10);
            obstacle3.setX(1500 + ran1 * 10);
        }else{
            obstacle3.getImg().setX(x6 - speed);
            obstacle3.setX((x6 - speed));
        }
        heroHitbox.setX(hero.getX() + 15);
        heroHitbox.setY(hero.getY() + 15);
        obstacle1hitbox.setX(obstacle1.getX() + 10);
        obstacle1hitbox.setY(290);
        obstacle2hitbox.setX(obstacle2.getX() + 10);
        obstacle2hitbox.setY(290);
        obstacle3hitbox.setX(obstacle3.getX() + 10);
        obstacle3hitbox.setY(140);
        if ((heroHitbox.getBoundsInLocal().intersects(obstacle1hitbox.getBoundsInLocal()) || heroHitbox.getBoundsInLocal().intersects(obstacle2hitbox.getBoundsInLocal()) || (heroHitbox.getBoundsInLocal().intersects(obstacle3hitbox.getBoundsInLocal()))) & !hero.getInvicibility()){
            if (numberOfLives > 0) {
                numberOfLives--;
                hero.setInvincibility(true);
                System.out.println("Collision avec l'obstacle. Vies restantes : " + numberOfLives);
                if(numberOfLives == 0){
                    stopBackgroundLoop();
                    hero.setMaxIndex(0);
                    hero.setX(300);
                    hero.setY(250);
                }
            }
    }
    }
    public int getNumberOfLives(){
        return this.numberOfLives;
    }
}
