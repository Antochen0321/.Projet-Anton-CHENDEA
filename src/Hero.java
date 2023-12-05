import javafx.util.Duration;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class Hero extends AnimatedThing {
    private double speed;
    private double jump_capacity;
    private boolean is_jumping;
    private boolean is_shooting;
    private Rectangle hitbox;
    private boolean invincibility;
    public Hero(double x, double y){
        super("file:/Users/anaua/IdeaProjects/Projet Runner/img/heros.png", x, y, 6, 80, 98, 84, 82, 0, 0);
        this.speed = 5.0;
        this.jump_capacity = 55.0;
        this.invincibility = false;
        setY(y);
        this.setX(x);
        this.setY(y);
        this.is_jumping = false;
        this.is_shooting = false;
        if(is_jumping){
            is_jumping = false;
        }
        hitbox = new Rectangle(80, 98);
        hitbox.setX(x);
        hitbox.setY(y);
    }

    public void move(){
        setX(getX() + speed);
    }
    public void moveLeft(){
        setX(getX() - speed);
    }
    public void jump(){
        if(!is_jumping){
            setAttitude(1);
            setCurrentIndex(0);
            setMaxIndex(0);
            setWindowSizey(100);
            setWindowSizex(90);
            setFrameOffsetx(82);
            setFrameOffsety(82);
            setY(getY() - jump_capacity);
            is_jumping = true;
        }
    }
    public void shoot(){
        if(!is_shooting){
            setAttitude(2);
            setMaxIndex(6);
            setCurrentIndex(0);
            setWindowSizey(108);
            setWindowSizex(80);
            setFrameOffsetx(81);
            setFrameOffsety(82);
            is_shooting = true;
        }
    }
    public void jump_and_shoot() {
            setAttitude(3);
            setCurrentIndex(0);
            setMaxIndex(0);
            setWindowSizey(100);
            setWindowSizex(90);
            setFrameOffsetx(82);
            setFrameOffsety(82);
            setY(getY() - jump_capacity);
            is_jumping = true;
    }

    public void jumping_down() {
        setAttitude(1);
        setCurrentIndex(1);
        setMaxIndex(1);
        setWindowSizey(100);
        setWindowSizex(90);
        setFrameOffsetx(82);
        setFrameOffsety(82);
        setY(getY() + jump_capacity);
        is_jumping = false;
    }
    public void endJump() {
        if (is_jumping) {
            is_jumping = false;
            setAttitude(0);
            setCurrentIndex(0);
            setMaxIndex(6);
            setWindowSizey(105);
            setWindowSizex(90);
            setFrameOffsetx(84);
            setFrameOffsety(82);
            setFrameDuration(Duration.seconds(0.2));
            setY(getY() + jump_capacity);
        }
    }
    public void endShoot() {
        if (is_shooting) {
            is_shooting = false;
            setAttitude(0);
            setCurrentIndex(0);
            setMaxIndex(6);
            setWindowSizey(105);
            setWindowSizex(90);
            setFrameOffsetx(84);
            setFrameOffsety(82);
        }
    }
    public boolean getIsJumping(){
        return is_jumping;
    }
    public Bounds getBoundingBox() {
        return hitbox.getBoundsInLocal();
    }
    public boolean getInvicibility(){
        return this.invincibility;
    }

    public void setInvincibility(boolean newStatuts){
        this.invincibility = newStatuts;
    }
}
