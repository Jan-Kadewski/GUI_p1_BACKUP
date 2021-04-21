import java.util.ArrayList;
import java.util.List;

public class Item {
    String name;
    double width;
    double length;
    double height;
    Double volume;
    Person owner;

    public Item(String name, double width, double length, double height, Person owner) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = width * length * height;
        this.owner = owner;
    }

    public Item(String name, double volume, Person owner) {
        this.name = name;
        this.volume = volume;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", volume=" + volume +
                '}';
    }
}
