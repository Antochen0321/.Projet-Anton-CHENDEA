public class Camera {
    private double x;
    private double y;
    public Camera(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double nx){this.x = nx;}
    public void setY(double ny){this.y = ny;}
    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        return String.valueOf(x + " , " + y);
    }
}
