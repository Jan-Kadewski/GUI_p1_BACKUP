import java.util.concurrent.atomic.AtomicLong;

public class IndependentCarServiceSpot {
    public static final AtomicLong idCounter = new AtomicLong();
    double width;
    double length;
    double height;
    double price;
    long id;

    public IndependentCarServiceSpot(double width, double length, double height, double price,long id) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
        this.id = id;
    }


}
