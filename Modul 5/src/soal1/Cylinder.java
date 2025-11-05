package soal1;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double r, double h){
        super("Cylinder");
        this.radius = r;
        this.height = h;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        this.height = h;
    }

    public double area(){
        return Math.PI * (getRadius() * getRadius()) * getHeight();
    }

    public String toString(){
        return super.toString() + " of radius " + getRadius() + " and height " + getHeight();
    }
}