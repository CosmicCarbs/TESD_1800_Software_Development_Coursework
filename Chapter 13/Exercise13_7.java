public class Exercise13_7 {
    public static void main(String[] args){

        Triangle[] arrayOfTriangles = new Triangle[5];
        arrayOfTriangles[0] = new Triangle(10, 10, 10, "red", true );
        arrayOfTriangles[1] = new Triangle(17, 22, 11, "orange", false );
        arrayOfTriangles[2] = new Triangle(8, 19, 12, "purple", true );
        arrayOfTriangles[3] = new Triangle(9, 12, 15, "green", false );
        arrayOfTriangles[4] = new Triangle(12, 12, 8, "blue", false );

        for(int x = 0; x < 5; x++){
            System.out.println("The area of triangle " + (x + 1) + " is: " + arrayOfTriangles[x].getArea());
            if(arrayOfTriangles[x].isFilled() == false)
                arrayOfTriangles[x].howToColor();
        }
    }
}
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
}

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "color: " + color + " and filled: " + filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
class Triangle extends GeometricObject implements Colorable {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){
    }
    public Triangle(double side1, double side2, double side3, String color, boolean filled){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setColor(color);
        setFilled(filled);
    }
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    public void setSide1(double side1){
        this.side1 = side1;
    }
    public void setSide2(double side2){
        this.side2 = side2;
    }
    public void setSide3(double side3){
        this.side3 = side3;
    }
    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public void howToColor(){
        System.out.println("Color all three sides");
    }
}
public interface Colorable{
    public void howToColor();
}