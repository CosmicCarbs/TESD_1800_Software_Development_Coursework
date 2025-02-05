public class Exercise13_11 {
    public static void main(String[] args){
    Octagon octagon1 = new Octagon(12.0, "purple", true);
    Octagon octagon2 = (Octagon)octagon1.clone();
    System.out.println(octagon1.compareTo(octagon2));
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
class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    private double sides = 1;

    public Octagon(){
    }
    public Octagon(double sides, String color, boolean filled){
        this.sides = sides;
        setColor(color);
        setFilled(filled);
    }
    public double getSides(){
        return sides;
    }
    public void setSides(double sides){
        this.sides = sides;
    }
    public double getArea(){
        return (2 + (4 / (Math.pow(2, 0.5)))) * sides * sides;
    }
    public double getPerimeter(){
        return sides * 8;
    }
    public Object clone(){
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException ex){
            return null;
        }
    }
    public int compareTo(Octagon o){
        if(getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
}