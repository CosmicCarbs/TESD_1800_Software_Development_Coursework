public class Exercise9_1 {
    public static void main(String[] args){

        Rectangle rectangle1 = new Rectangle(40, 4);
            System.out.println("The Width is: " + rectangle1.width + " The height is: " + rectangle1.height);
            System.out.println("The Area is: " + rectangle1.getArea() + " The Perimeter is: " + rectangle1.getPerimeter());

        Rectangle rectangle2 = new Rectangle(35.9, 3.5);
        System.out.println("The Width is: " + rectangle2.width + " The height is: " + rectangle2.height);
        System.out.println("The Area is: " + rectangle2.getArea() + " The Perimeter is: " + rectangle2.getPerimeter());    
    }
}
class Rectangle{
    double height;
    double width;

    Rectangle(){
        height= 1;
        width = 1;
    }
    Rectangle(double newHeight, double newWidth){
        width = newWidth;
        height = newHeight;
    }
    double getArea(){
        return height * width;
    }
    double getPerimeter(){
        return 2 * (height + width);
    }
}