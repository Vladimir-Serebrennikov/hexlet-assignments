package exercise;

// BEGIN
public interface Home extends Comparable<Home> {
    double getArea();

    @Override
    default int compareTo(Home another) {
        double thisArea = this.getArea();
        double anotherArea = another.getArea();

        if (thisArea < anotherArea) {
            return -1;
        } else if (thisArea > anotherArea) {
            return 1;
        } else {
            return 0;
        }
    }
}
// END
