import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class ParkingSpace {
    double width;
    double length;
    double height;
    int rentYear;
    int rentMonth;
    int rentDay;
    long id;
    static List<ParkingSpace> listOfAllParkingSpaces = new ArrayList<>();
    public static final AtomicLong idCounter = new AtomicLong();
    LocalDate startRentSpace;
    boolean isRented;

    public ParkingSpace(double width, double length, double height, int rentYear, int rentMonth, int rentDay, long id,boolean isRented) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.rentYear = rentYear;
        this.rentMonth = rentMonth;
        this.rentDay = rentDay;
        startRentSpace = LocalDate.of(rentYear, rentMonth, rentDay);
        this.id = id;
        this.isRented = isRented;
    }


    public static void insertParkingSpaces() {
        ParkingSpace p1 = new ParkingSpace(2, 3, 5, 2021, 1, 10,idCounter.getAndIncrement(),false);
        ParkingSpace p2 = new ParkingSpace(4, 6, 3, 2021, 1, 13,idCounter.getAndIncrement(),false);
        ParkingSpace p3 = new ParkingSpace(1, 7, 3, 2021, 1, 19,idCounter.getAndIncrement(),false);
        ParkingSpace p4 = new ParkingSpace(6, 3, 5, 2021, 1, 10,idCounter.getAndIncrement(),false);
        ParkingSpace p5 = new ParkingSpace(9, 5, 3, 2021, 1, 25,idCounter.getAndIncrement(),false);
        listOfAllParkingSpaces.add(p1);
        listOfAllParkingSpaces.add(p2);
        listOfAllParkingSpaces.add(p3);
        listOfAllParkingSpaces.add(p4);
        listOfAllParkingSpaces.add(p5);
    }


    public static void rentParkingSpaceById(Scanner sc){
        System.out.println("Wybierz parking podając jego ID");
        for(int i=0;i<listOfAllParkingSpaces.size();i++){
            System.out.println(listOfAllParkingSpaces.get(i));
        }
        long id = sc.nextLong();
        for(ParkingSpace p: listOfAllParkingSpaces){
            if(p.id == id){
                System.out.println("dodaje miejsce parkingowe do listy");
                p.isRented = true;
            }
            else{
                System.out.println("Albo jednak nie dodaje do listy :>");
            }
        }
    }


    public static void checkIfDateExpired(){

    }

}
