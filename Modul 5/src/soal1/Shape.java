package soal1;

public abstract class Shape {
    protected String shapeName;

    public Shape(String name) {
        this.shapeName = name;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String name) {
        this.shapeName = name;
    }

    public abstract double area();

    public String toString(){
        return getShapeName();
    }
}