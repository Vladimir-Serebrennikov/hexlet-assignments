package exercise;

// BEGIN
public class Flat implements Home, Comparable<Home> {

    private double area;
    private double balconyArea;
    private int floor;
    public Flat(double area, double balconyArea, int floor){
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    };

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public String toString() {
        String result = "Квартира площадью " + getArea() + " метров на " +
                this.floor + " этаже";
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


}
// END
