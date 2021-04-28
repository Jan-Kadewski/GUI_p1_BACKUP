import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Person choosenPerson = null;

    public static void main(String[] args) throws NeverRentException {
        Person.insertSampleOfData();
        ConsumerWarehouse.insertSampleOfConsumerWarehouse();
        ParkingSpace.insertParkingSpaces();
        CarServiceSpot.sampleCarServiceSpots();
        Menu.showMainMenu();

    }
}
