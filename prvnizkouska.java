class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 4);
        System.out.println(r.getArea());
    }
}


class Shape {
    private final float area;

    public Shape(float area) {
        this.area = area;
    }

    public float getArea() {
        return area;
    }
}

class Rectangle extends Shape {
    public Rectangle(float a, float b) {
        super(a * b);
    }
}

