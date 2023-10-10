package exercise;

// BEGIN
public class Cottage implements Home, Comparable<Home> {
    private double area;
    private int floorCount;
    
    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        String result = this.floorCount + " этажный коттедж площадью " + this.area + " метров";
        return result;
    }

    @Override
    public int compareTo(Home another) {
        double diff = this.getArea() - another.getArea();

        if (diff > 0) {
            return 1; 
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public double getArea() {
        return this.area;
    }

    public static void main(String[] args) {
        Home cottage = new Cottage(135, 2);
        double area = cottage.getArea();
        System.out.println(area);
        System.out.println(cottage.toString());
    }
}
// END
