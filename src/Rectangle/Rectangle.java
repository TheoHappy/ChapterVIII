package Rectangle;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(){
        this(1,1);
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if ((length < 0) || (length > 20))
            throw new IllegalArgumentException("length must be 0.00-20.00");
            this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if ((width < 0) || (width > 20))
            throw new IllegalArgumentException("width must be 0.00-20.00");
        this.width = width;

    }

    public double getPerimeter(){
        return getLength()*2+getWidth()*2;
    }

    public double getArea(){
        return  getWidth()*getLength();
    }
}
